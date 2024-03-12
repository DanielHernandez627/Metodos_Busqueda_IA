package com.uc.metodos_busqueda.Controlador;

import com.uc.metodos_busqueda.Modelo.Nodo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author pillo
 */
public class ControladorBpp {
    private Queue<Nodo> cola = new LinkedList<>();
    private Set<String> visitados = new HashSet<>();
    private Nodo nodoInicial;
    private Nodo nodoMeta;
    private int nProf;
    private int nodosGenerados;
    private String movimientosRealizados;
    private StringBuilder matricesAcumuladas = new StringBuilder();


    public ControladorBpp(Nodo nodoInicial, Nodo nodoMeta, int nProf) {
        this.nodoInicial = nodoInicial;
        this.nodoMeta = nodoMeta;
        this.nProf = nProf;
        this.nodosGenerados = 0;
    }

    public ControladorBpp() {
    }
    
    public int[][] resolverPuzzle() {
        Queue<Nodo> abierto = new LinkedList<>();
        Set<String> cerrado = new HashSet<>();
        int[][] ultimaMatrizAlcanzada = null;

        abierto.offer(nodoInicial);

        while (!abierto.isEmpty()) {
            Nodo nodoActual = abierto.poll();
            ultimaMatrizAlcanzada = nodoActual.getEstado();
            nodosGenerados++;

            if (nodoActualEsMeta(nodoActual)) {
                imprimirTrayectoria(nodoActual);
                imprimirMovimientos(nodoActual);
                return ultimaMatrizAlcanzada;
            }

            String claveEstado = Arrays.deepToString(ultimaMatrizAlcanzada);
            if (!cerrado.contains(claveEstado) && nodoActual.getProfundida()< nProf) {
                cerrado.add(claveEstado);

                List<Nodo> sucesores = expandirNodo(nodoActual);
                if (!sucesores.isEmpty()) {
                    for (Nodo sucesor : sucesores) {
                        abierto.offer(sucesor);
                    }
                }
            }
        }

        System.out.println("No se encontró una solución.");
        System.out.println("Nodos generados: " + nodosGenerados);
        return ultimaMatrizAlcanzada;
    }
    
    private boolean nodoActualEsMeta(Nodo nodo) {
        return Arrays.deepEquals(nodo.getEstado(), nodoMeta.getEstado());
    }
     
    private List<Nodo> expandirNodo(Nodo nodo) {
        List<Nodo> sucesores = new ArrayList<>();
        int filaEspacio = -1;
        int columnaEspacio = -1;

        outerloop:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (nodo.getEstado()[i][j] == 0) {
                    filaEspacio = i;
                    columnaEspacio = j;
                    break outerloop;
                }
            }
        }

        int[][] movimientos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] movimiento : movimientos) {
            int nuevaFila = filaEspacio + movimiento[0];
            int nuevaColumna = columnaEspacio + movimiento[1];

            if (esMovimientoValido(nuevaFila, nuevaColumna)) {
                int[][] nuevoEstado = clonarMatriz(nodo.getEstado());
                intercambiarPosiciones(nuevoEstado, filaEspacio, columnaEspacio, nuevaFila, nuevaColumna);

                if (!posicionYaVisitada(nuevoEstado)) {
                    Nodo nuevoNodo = new Nodo(nuevoEstado, nodo, nodo.getProfundida()+ 1);
                    sucesores.add(nuevoNodo);
                }
            }
        }

        return sucesores;
    }
    
    
    private boolean posicionYaVisitada(int[][] estado) {
        return visitados.contains(Arrays.deepToString(estado));
    }
    
    private boolean esMovimientoValido(int fila, int columna) {
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3;
    }

    private int[][] clonarMatriz(int[][] matriz) {
        int[][] nuevaMatriz = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(matriz[i], 0, nuevaMatriz[i], 0, 3);
        }
        return nuevaMatriz;
    }

    private void intercambiarPosiciones(int[][] matriz, int fila1, int columna1, int fila2, int columna2) {
        int temp = matriz[fila1][columna1];
        matriz[fila1][columna1] = matriz[fila2][columna2];
        matriz[fila2][columna2] = temp;
    }
    

    public int contarNodosGenerados() {
        return nodosGenerados;
    }
     
    private void imprimirTrayectoria(Nodo nodoMeta) {
        Stack<Nodo> trayectoria = new Stack<>();
        Nodo nodo = nodoMeta;

        while (nodo != null) {
            trayectoria.push(nodo);
            nodo = nodo.getPadre();
        }

        int paso = 0;
        while (!trayectoria.isEmpty()) {
            Nodo pasoActual = trayectoria.pop();
            System.out.println("Paso " + paso + ":");
            imprimirEstado(pasoActual.getEstado());

            if (nodoActualEsMeta(pasoActual)) {
                System.out.println("¡Nodo Meta Alcanzado!");
            }

            System.out.println("Profundidad: " + pasoActual.getProfundida());
            System.out.println("-------------------");
            paso++;
        }
    }
    
    private void imprimirEstado(int[][] estado) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matricesAcumuladas.append(estado[i][j]).append(" ");
            }
            matricesAcumuladas.append("\n");
        }
        matricesAcumuladas.append("\n");
        
        guardarMatricesEnArchivo("matricesBPP.txt");
    }
    
    public void guardarMatricesEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(obtenerMatricesAcumuladas());
        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción según tus necesidades
        }
    }
    
    public String obtenerMatricesAcumuladas() {
        return matricesAcumuladas.toString();
    }
    
    private void imprimirMovimientos(Nodo nodoMeta) {
        Stack<String> movimientos = new Stack<>();
        Nodo nodo = nodoMeta;

        while (nodo != null && nodo.getPadre() != null) {
            int[][] estadoPadre = nodo.getPadre().getEstado();
            int[][] estadoActual = nodo.getEstado();

            int filaEspacioPadre = -1;
            int columnaEspacioPadre = -1;
            int filaEspacioActual = -1;
            int columnaEspacioActual = -1;

            // Encontrar la posición del espacio en el estado padre
            outerloop:
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (estadoPadre[i][j] == 0) {
                        filaEspacioPadre = i;
                        columnaEspacioPadre = j;
                        break outerloop;
                    }
                }
            }

            // Encontrar la posición del espacio en el estado actual
            outerloop:
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (estadoActual[i][j] == 0) {
                        filaEspacioActual = i;
                        columnaEspacioActual = j;
                        break outerloop;
                    }
                }
            }

            // Determinar el movimiento realizado
            int filaMovimiento = filaEspacioPadre - filaEspacioActual;
            int columnaMovimiento = columnaEspacioPadre - columnaEspacioActual;

            String direccionMovimiento = "";
            if (filaMovimiento == 1) {
                direccionMovimiento = "Arriba";
            } else if (filaMovimiento == -1) {
                direccionMovimiento = "Abajo";
            } else if (columnaMovimiento == 1) {
                direccionMovimiento = "Izquierda";
            } else if (columnaMovimiento == -1) {
                direccionMovimiento = "Derecha";
            }

            movimientos.push(direccionMovimiento);

            nodo = nodo.getPadre();
        }

        StringBuilder movimientosConcatenados = new StringBuilder();
        int paso = 0;
        while (!movimientos.isEmpty()) {
            movimientosConcatenados.append("Paso ").append(paso).append(": Mover ").append(movimientos.pop()).append("\n");
            paso++;
        }

        movimientosRealizados = movimientosConcatenados.toString();
    }
    
    public void guardarMovimientosEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(movimientosGlobal());
        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción según tus necesidades
        }
    }
    
    public String movimientosGlobal() {
        return movimientosRealizados;
    }
}
