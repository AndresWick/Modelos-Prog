package arbolgrafico;
/**
 *  Clase nodo para el arbol AVL.
 * @author Carlos_Aguirre.
 */
public class Nodo {
    public Comparable dato;      	 
    public Nodo izquierdo;            
    public Nodo derecho;             
    public int altura;                   

    public Nodo(Comparable dato) {
        this(dato, null, null);
    }

    public Nodo(Comparable dato, Nodo izq, Nodo der) {
        this.dato = dato;
        this.izquierdo = izq;
        this.derecho = der;
        altura = 0;               
    }

    public int getDato() {
        return (int) dato;
    }

    public boolean esHoja() {
        return derecho == null && izquierdo == null;
    }

    public Nodo getHijoIzq() {
        return izquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.izquierdo = hijoIzquierdo;
    }

    public Nodo getHijoDer() {
        return derecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.derecho = hijoDerecho;
    }
    
    int subizq = 0;
    int subder = 0;
     public int getBalance() {
         subizq = 0;
         subder = 0;

        Balance(this, true, 0);
        return (subizq - subder);
    }

    public void Balance(Nodo reco, boolean lado, int i) {

        if (reco != null) {

            if (reco.getHijoDer() == null && reco.getHijoIzq() == null) {
                if (lado) {
                    subder = (i > subder) ? i : subder;
                } else {
                    subizq = (i > subizq) ? i : subizq;
                }
            }

            Balance(reco.getHijoDer(), lado, i + 1);
            if (i == 0) {
                lado = false;
            }
            Balance(reco.getHijoIzq(), lado, i + 1);
        }

    }
}
