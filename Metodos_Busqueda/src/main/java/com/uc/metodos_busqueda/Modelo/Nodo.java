package com.uc.metodos_busqueda.Modelo;

/**
 *
 * @author pillo
 */
public class Nodo {
    private int[][] estado;
    private Nodo padre;
    private int profundida;

    public Nodo(int[][] estado, Nodo padre, int profundida) {
        this.estado = estado;
        this.padre = padre;
        this.profundida = profundida;
    }

    public int[][] getEstado() {
        return estado;
    }

    public int getProfundida() {
        return profundida;
    }

    public Nodo getPadre() {
        return padre;
    }
    
    
}
