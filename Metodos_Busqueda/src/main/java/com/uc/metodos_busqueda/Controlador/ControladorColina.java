package com.uc.metodos_busqueda.Controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ControladorColina {
    
    private int[][] nodoInicial;
    private int[][] nodoMeta;
    private List<int[][]> ABIERTO;
    private List<int[][]> CERRADO;

    public ControladorColina(int[][] nodoInicial, int[][] nodoMeta) {
        this.ABIERTO = new ArrayList<>();
        this.CERRADO = new ArrayList<>();
        this.nodoInicial = nodoInicial;
        this.nodoMeta = nodoMeta;
    }
    
    
   public void resolver() {
        ABIERTO.add(nodoInicial);

        while (!ABIERTO.isEmpty()) {
            int[][] nodoActual = ABIERTO.remove(0);

            if (!CERRADO.contains(Arrays.deepToString(nodoActual))) {
                CERRADO.add(nodoActual);

                List<int[][]> sucesores = expandirNodo(nodoActual);

                if (!sucesores.isEmpty() && !esNodoMeta(sucesores)) {
                    Collections.sort(sucesores, (n1, n2) -> calcularDistanciaHeuristica(n1) - calcularDistanciaHeuristica(n2));
                    ABIERTO.addAll(0, sucesores);
                }
            }
            
            mostrarMatriz(nodoActual);

            if (esNodoMeta(nodoActual)) {
                System.out.println("Éxito");
                return;
            }
        }

        System.out.println("Fracaso");
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
        for (int[] movimiento : movimientos) {
            int filaVecino = filaCero + movimiento[0];
            int columnaVecino = columnaCero + movimiento[1];

            if (filaVecino >= 0 && filaVecino < 3 && columnaVecino >= 0 && columnaVecino < 3) {
                int[][] sucesor = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    sucesor[i] = Arrays.copyOf(nodo[i], 3);
                }
                sucesor[filaCero][columnaCero] = sucesor[filaVecino][columnaVecino];
                sucesor[filaVecino][columnaVecino] = 0;

                // Verificar si el movimiento ya se realizó antes de agregar el sucesor
                if (!CERRADO.contains(Arrays.deepToString(sucesor))) {
                    sucesores.add(sucesor);
                }
            }
        }

        return sucesores;
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
    
    
    private int calcularDistanciaHeuristica(int[][] nodo) {
        int distancia = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (nodo[i][j] != nodoMeta[i][j]) {
                    distancia++;
                }
            }
        }
        return distancia;
    }
    
    private void mostrarMatriz(int[][] matriz) {
        System.out.println("Matriz Generada:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
