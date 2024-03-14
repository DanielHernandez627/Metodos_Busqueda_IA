
package com.uc.metodos_busqueda.Controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ControladorGenetico {
    
    private static final int TAMANO_POBLACION = 100;
    private static final int MAX_GENERACIONES = 100000;
    private static final double TASA_MUTACION = 0.1;
    private static final int TAMANO_TORNEO = 5;
    
    public void resolverPuzzle8(int[][] estadoInicial, int[][] estadoMeta) {
        // Crear población inicial
        List<int[]> poblacion = generarPoblacionInicial(TAMANO_POBLACION, estadoInicial);
        int numeroGeneraciones = 0;

        while (numeroGeneraciones < MAX_GENERACIONES) {
            // Calcular fitness de la población
            List<Integer> valoresFitness = calcularFitness(poblacion, estadoMeta);

            // Verificar si se ha encontrado la solución
            if (valoresFitness.contains(0)) {
                int indiceSolucion = valoresFitness.indexOf(0);
                System.out.println("Éxito - Se encontró la solución en la generación " + numeroGeneraciones);
                System.out.println("Solución: " + Arrays.toString(poblacion.get(indiceSolucion)));
                imprimirMatriz(convertir1Da2D(poblacion.get(indiceSolucion)));
                return;
            }

            // Seleccionar nueva generación
            List<int[]> nuevaPoblacion = new ArrayList<>();
            for (int i = 0; i < TAMANO_POBLACION; i++) {
                int[] padre1 = seleccionPorTorneo(poblacion, valoresFitness);
                int[] padre2 = seleccionPorTorneo(poblacion, valoresFitness);
                int[] hijo = cruzamiento(padre1, padre2);
                mutacion(hijo);
                nuevaPoblacion.add(hijo);
            }
            poblacion = nuevaPoblacion;
            numeroGeneraciones++;
        }

        System.out.println("Fracaso - No se encontró la solución después de " + MAX_GENERACIONES + " generaciones.");
    }
    
    private List<int[]> generarPoblacionInicial(int tamano, int[][] estadoInicial) {
        List<int[]> poblacion = new ArrayList<>();
        for (int i = 0; i < tamano; i++) {
            int[] individuo = array2DTo1D(estadoInicial);
            mezclarArray(individuo);
            poblacion.add(individuo);
        }
        return poblacion;
    }
    
    private void mezclarArray(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int indice = rnd.nextInt(i + 1);
            int temp = array[indice];
            array[indice] = array[i];
            array[i] = temp;
        }
    }
    
    private List<Integer> calcularFitness(List<int[]> poblacion, int[][] estadoMeta) {
        List<Integer> valoresFitness = new ArrayList<>();
        for (int[] individuo : poblacion) {
            // Calcular la diferencia entre el individuo y el estado meta
            int fitness = 0;
            for (int i = 0; i < individuo.length; i++) {
                if (individuo[i] != estadoMeta[i / estadoMeta.length][i % estadoMeta.length]) {
                    fitness++;
                }
            }
            valoresFitness.add(fitness);
        }
        return valoresFitness;
    }
    
    private int[] seleccionPorTorneo(List<int[]> poblacion, List<Integer> valoresFitness) {
        List<int[]> torneo = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < TAMANO_TORNEO; i++) {
            int indice = random.nextInt(poblacion.size());
            torneo.add(poblacion.get(indice));
        }
        int mejorFitness = Integer.MAX_VALUE;
        int mejorIndice = -1;
        for (int i = 0; i < torneo.size(); i++) {
            int fitness = valoresFitness.get(i);
            if (fitness < mejorFitness) {
                mejorFitness = fitness;
                mejorIndice = i;
            }
        }
        int[] mejorIndividuo = torneo.get(mejorIndice);
        imprimirMatriz(convertir1Da2D(mejorIndividuo));
        return mejorIndividuo;
    }
    
    
    private int[] cruzamiento(int[] padre1, int[] padre2) {
        int[] hijo = new int[padre1.length];
        Random random = new Random();
        int puntoCruzamiento = random.nextInt(padre1.length);
        for (int i = 0; i < padre1.length; i++) {
            if (i < puntoCruzamiento) {
                hijo[i] = padre1[i];
            } else {
                hijo[i] = padre2[i];
            }
        }
        return hijo;
    }
    
    private void mutacion(int[] individuo) {
        Random random = new Random();
        if (random.nextDouble() < TASA_MUTACION) {
            int indice1 = random.nextInt(individuo.length);
            int indice2 = random.nextInt(individuo.length);
            int temp = individuo[indice1];
            individuo[indice1] = individuo[indice2];
            individuo[indice2] = temp;
        }
    }
    
    
    private int[] array2DTo1D(int[][] array2D) {
        int rows = array2D.length;
        int cols = array2D[0].length;
        int[] array1D = new int[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array1D[i * cols + j] = array2D[i][j];
            }
        }
        return array1D;
    }

    private int[][] convertir1Da2D(int[] array1D) {
        int size = (int) Math.sqrt(array1D.length);
        int[][] array2D = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array2D[i][j] = array1D[i * size + j];
            }
        }
        return array2D;
    }
    
    
    private void imprimirMatriz(int[][] matriz) {
        System.out.println("Matriz:");
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }
        System.out.println();
    }
}
