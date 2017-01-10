package arbolAVL;
/**
 *  Clase nodo para el arbol AVL.
 * @author Carlos_Aguirre.
 */
public class NodoAVL {
    public Comparable dato;      	 
    public NodoAVL izquierdo;            
    public NodoAVL derecho;             
    public int altura;                   

    public NodoAVL(Comparable dato) {
        this(dato, null, null);
    }

    public NodoAVL(Comparable dato, NodoAVL izq, NodoAVL der) {
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

    public NodoAVL getHijoIzq() {
        return izquierdo;
    }

    public void setHijoIzquierdo(NodoAVL hijoIzquierdo) {
        this.izquierdo = hijoIzquierdo;
    }

    public NodoAVL getHijoDer() {
        return derecho;
    }

    public void setHijoDerecho(NodoAVL hijoDerecho) {
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

    public void Balance(NodoAVL reco, boolean lado, int i) {

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
