/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uc.metodos_busqueda.Modelo;

import java.util.ArrayList;
import java.util.List;

public class NodoA {
    
    private int[][] estado;
    private int costo; // Acumular distancias de información + distancia heurística
    private NodoA padre;
    private String movimiento; // Movimiento realizado desde el padre a este nodo
    private int distanciaManhattan; // Distancia de Manhattan desde este nodo al estado meta

    public NodoA(int[][] estado) {
        this.estado = estado;
        this.costo = 0;
        this.padre = null;
        this.movimiento = "";
        this.distanciaManhattan = calcularDistanciaManhattan();
    }

    public NodoA(int[][] estado, int costo, NodoA padre, String movimiento) {
        this.estado = estado;
        this.costo = costo;
        this.padre = padre;
        this.movimiento = movimiento;
        this.distanciaManhattan = calcularDistanciaManhattan();
    }

    public int[][] getEstado() {
        return estado;
    }

    public int getCosto() {
        return costo;
    }

    public NodoA getPadre() {
        return padre;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public int getDistanciaManhattan() {
        return distanciaManhattan;
    }

    // Método para calcular la distancia de Manhattan desde este nodo al estado meta
    private int calcularDistanciaManhattan() {
        int distancia = 0;
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado[i].length; j++) {
                if (estado[i][j] != 0) {
                    int valor = estado[i][j];
                    int filaMeta = (valor - 1) / estado.length;
                    int columnaMeta = (valor - 1) % estado.length;
                    distancia += Math.abs(i - filaMeta) + Math.abs(j - columnaMeta);
                }
            }
        }
        return distancia;
    }

    // Método para expandir el nodo y obtener sus sucesores
    public List<NodoA> expandir() {
        List<NodoA> sucesores = new ArrayList<>();
        int filaVacia = 0;
        int columnaVacia = 0;

        // Encontrar la posición del espacio vacío en la matriz
        outerloop:
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado[i].length; j++) {
                if (estado[i][j] == 0) {
                    filaVacia = i;
                    columnaVacia = j;
                    break outerloop;
                }
            }
        }

        // Movimientos válidos: arriba, abajo, izquierda, derecha, arriba-izquierda, arriba-derecha, abajo-izquierda, abajo-derecha
        int[] movFila = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] movColumna = {0, 0, -1, 1, -1, 1, -1, 1};
        String[] movNombre = {"Arriba", "Abajo", "Izquierda", "Derecha", "Arriba-Izquierda", "Arriba-Derecha", "Abajo-Izquierda", "Abajo-Derecha"};

        for (int i = 0; i < 8; i++) {
            int nuevaFila = filaVacia + movFila[i];
            int nuevaColumna = columnaVacia + movColumna[i];

            // Verificar si el movimiento es válido
            if (esMovimientoValido(nuevaFila, nuevaColumna)) {
                int[][] nuevoEstado = new int[estado.length][estado[0].length];
                for (int j = 0; j < estado.length; j++) {
                    nuevoEstado[j] = estado[j].clone();
                }
                nuevoEstado[filaVacia][columnaVacia] = nuevoEstado[nuevaFila][nuevaColumna];
                nuevoEstado[nuevaFila][nuevaColumna] = 0;
                sucesores.add(new NodoA(nuevoEstado, costo + 1, this, movNombre[i]));
            }
        }
        return sucesores;
    }

    // Método para verificar si un movimiento es válido
    private boolean esMovimientoValido(int fila, int columna) {
        return fila >= 0 && fila < estado.length && columna >= 0 && columna < estado[0].length;
    }
    
}
