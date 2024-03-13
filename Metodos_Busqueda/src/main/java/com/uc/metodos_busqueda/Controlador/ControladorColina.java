package com.uc.metodos_busqueda.Controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ControladorColina {
    
    private int[][] nodoInicial;
    private int[][] nodoMeta;
    private List<int[][]> ABIERTO;
    private List<int[][]> CERRADO;
    private List<String> movimientosRealizados;
    private int nodosGenerados;
    private StringBuilder matricesAcumuladas = new StringBuilder();

    public ControladorColina(int[][] nodoInicial, int[][] nodoMeta) {
        this.ABIERTO = new ArrayList<>();
        this.CERRADO = new ArrayList<>();
        this.nodoInicial = nodoInicial;
        this.nodoMeta = nodoMeta;
        this.movimientosRealizados = new ArrayList<>();
        this.nodosGenerados = 0;
    }
    
    
    public int[][] resolver() {
        ABIERTO.add(nodoInicial);
        int[][] ultimaMatrizGenerada = null;

        while (!ABIERTO.isEmpty()) {
            int[][] nodoActual = ABIERTO.remove(0);

            if (!CERRADO.contains(Arrays.deepToString(nodoActual))) {
                CERRADO.add(nodoActual);
                
                mostrarMatriz(nodoActual);

                ultimaMatrizGenerada = nodoActual;

                List<int[][]> sucesores = expandirNodo(nodoActual);

                if (!sucesores.isEmpty()) {
                    nodosGenerados += sucesores.size();

                    Collections.sort(sucesores, (n1, n2) -> calcularDistanciaHeuristica(n1) - calcularDistanciaHeuristica(n2));
                    ABIERTO.addAll(0, sucesores);

                    if (esNodoMeta(sucesores)) {
                        int[][] nodoMeta = sucesores.stream().filter(this::esNodoMeta).findFirst().orElse(null);
                        System.out.println("¡Éxito!");
                        mostrarMatriz(nodoMeta);
                        System.out.println("Cantidad de nodos generados: " + nodosGenerados);
                        return nodoMeta;
                    }
                }
            }
        }

        System.out.println("Fracaso");
        //System.out.println("Cantidad de nodos generados: " + nodosGenerados);
        return ultimaMatrizGenerada;
    }
    
    private List<int[][]> expandirNodo(int[][] nodo) {
        List<int[][]> sucesores = new ArrayList<>();
        int filaCero = -1;
        int columnaCero = -1;

        // Encontrar la posición de la ficha vacía (representada por 0)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (nodo[i][j] == 0) {
                    filaCero = i;
                    columnaCero = j;
                    break;
                }
            }
        }

        // Generar sucesores intercambiando la ficha vacía con sus vecinos
        int[][] movimientos = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        String[] direccion = { "Arriba", "Abajo", "Izquierda", "Derecha" };
        for (int i = 0; i < movimientos.length; i++) {
            int filaVecino = filaCero + movimientos[i][0];
            int columnaVecino = columnaCero + movimientos[i][1];

            if (filaVecino >= 0 && filaVecino < 3 && columnaVecino >= 0 && columnaVecino < 3) {
                int[][] sucesor = new int[3][3];
                for (int j = 0; j < 3; j++) {
                    sucesor[j] = Arrays.copyOf(nodo[j], 3);
                }
                sucesor[filaCero][columnaCero] = sucesor[filaVecino][columnaVecino];
                sucesor[filaVecino][columnaVecino] = 0;

                // Verificar si el movimiento es válido
                if (!esNodoRepetido(sucesor)) {
                    sucesores.add(sucesor);
                    movimientosRealizados.add(direccion[i]);
                }
            }
        }

        return sucesores;
    }
    
        
    private int calcularDistanciaHeuristica(int[][] nodo) {
        int distancia = 0;
        for (int i = 0; i < nodo.length; i++) {
            for (int j = 0; j < nodo[i].length; j++) {
                if (nodo[i][j] != 0) {
                    int valor = nodo[i][j];
                    int filaMeta = (valor - 1) / nodo.length;
                    int columnaMeta = (valor - 1) % nodo.length;
                    distancia += Math.abs(i - filaMeta) + Math.abs(j - columnaMeta);
                }
            }
        }
        return distancia;
    }
    
    private boolean esNodoMeta(List<int[][]> nodos) {
        for (int[][] nodo : nodos) {
            if (Arrays.deepEquals(nodo, nodoMeta)) {
                return true;
            }
        }
        return false;
    }

    private boolean esNodoMeta(int[][] nodo) {
        return Arrays.deepEquals(nodo, nodoMeta);
    }
    
    private boolean esNodoRepetido(int[][] nodo) {
        for (int[][] cerrado : CERRADO) {
            if (Arrays.deepEquals(nodo, cerrado)) {
                return true;
            }
        }
        return false;
    }
    
    private void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matricesAcumuladas.append(matriz[i][j]).append(" ");
            }
            matricesAcumuladas.append("\n");
        }
        matricesAcumuladas.append("\n");
        
        guardarMatricesEnArchivo("matricesColina.txt");
    }
    
    private void guardarMatricesEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(obtenerMatricesAcumuladas());
        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción según tus necesidades
        }
    }
    
    public String obtenerMatricesAcumuladas() {
        return matricesAcumuladas.toString();
    }
    
    public void guardarMovimientosEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String movimiento : movimientosRealizados) {
                writer.write(movimiento + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción según tus necesidades
        }
    }
    
    public int cantidadNodosGenerados(){
        return nodosGenerados;
    }
    
}
