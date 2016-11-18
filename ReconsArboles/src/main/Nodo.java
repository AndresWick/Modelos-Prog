package main;

/**
 * 
 * @author Carlos_Aguirre.
 */
public class Nodo {
    Nodo nodoDer;
    Nodo nodoIzq;
    Nodo raiz;
    int dato;
    int posX;
    int posY;
    int nivel;
     
    public Nodo(int dato,int x,int y,int niv) {
        this.dato = dato;
        this.posX = x;
        this.posY = y;
        this.nodoDer = null;
        this.nodoIzq = null;
        this.raiz = null;
        this.nivel = niv;
    }
}
