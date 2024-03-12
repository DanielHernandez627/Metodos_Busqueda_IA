package com.uc.metodos_busqueda.Controlador;

import com.uc.metodos_busqueda.Modelo.NodoA;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ControladorA {
    
    private NodoA nodoInicial;
    private NodoA nodoMeta;
    private int nodosGenerados;
    private StringBuilder matricesAcumuladas = new StringBuilder();
    private Stack<String> movimientos = new Stack<>();

    public ControladorA(int[][] estadoInicial, int[][] estadoMeta) {
        nodoInicial = new NodoA(estadoInicial);
        nodoMeta = new NodoA(estadoMeta);
        nodosGenerados = 0;
    }

    // Método para resolver el problema usando el algoritmo A*
    public int[][] resolverProblema() {
        List<NodoA> abierto = new ArrayList<>();
        Set<NodoA> cerrado = new HashSet<>();
        abierto.add(nodoInicial);

        while (!abierto.isEmpty()) {
            nodosGenerados++; // Incrementar la cantidad de nodos generados
            Collections.sort(abierto, Comparator.comparingInt(n -> n.getCosto() + n.getDistanciaManhattan()));
            NodoA actual = abierto.remove(0);

            imprimirMatriz(actual.getEstado(), actual.getMovimiento()); // Imprimir el estado actual y el movimiento realizado

            if (Arrays.deepEquals(actual.getEstado(), nodoMeta.getEstado())) {
                System.out.println("Se encontró la matriz meta.");
                System.out.println("Cantidad de nodos generados: " + nodosGenerados);
                imprimirMovimientos(actual,"movimientosAasterisco.txt");
                return actual.getEstado();
            }

            cerrado.add(actual);
            List<NodoA> sucesores = actual.expandir();
            for (NodoA sucesor : sucesores) {
                if (!cerrado.contains(sucesor) && !abierto.contains(sucesor)) {
                    abierto.add(sucesor);
                }
            }
        }

        System.out.println("No se encontró la matriz meta.");
        System.out.println("Cantidad de nodos generados: " + nodosGenerados);
        return null;
    }
        
    private void imprimirMovimientos(NodoA nodo, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("Movimientos realizados:\n");

            while (nodo.getPadre() != null) {
                // Verificar si el nodo actual es el nodo inicial
                if (nodo.getPadre().getPadre() != null) {
                    movimientos.push(nodo.getMovimiento());
                }
                nodo = nodo.getPadre();
            }

            while (!movimientos.isEmpty()) {
                String movimiento = movimientos.pop();
                writer.write(movimiento + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción según tus necesidades
        }
    }
    
    // Método para obtener la cantidad de nodos generados
    public int getNodosGenerados() {
        return nodosGenerados;
    }

    // Método para imprimir una matriz y el movimiento realizado
    public void imprimirMatriz(int[][] matriz, String movimiento) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                matricesAcumuladas.append(valor).append(" ");
            }
            matricesAcumuladas.append("\n");
        }
        matricesAcumuladas.append("\n");
        guardarMatricesEnArchivo("matricesAasterisco.txt");
    }
    
    public String obtenerMatricesAcumuladas() {
        return matricesAcumuladas.toString();
    }
    
    public void guardarMatricesEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(obtenerMatricesAcumuladas());
        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción según tus necesidades
        }
    }
    
}
