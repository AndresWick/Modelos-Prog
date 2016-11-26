package arbolgrafico;

import javax.swing.JOptionPane;

/**
 * 
 * @author Carlos_Aguirre.
 */
public class Arbol {

    private Nodo raiz;
    private int rotacionSimpleDerecha=0;
    private int rotacionSimpleIzquierda=0;
    private int rotacionDobleDerecha=0;
    private int rotacionDobleIzquierda=0;
    private int numNodo;

    

    public void insertar(Comparable x) {
        numNodo = (int) x;
  
        raiz = insertar(x, raiz);
    }
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    
    private Nodo insertar(Comparable x, Nodo t) {
        if (t == null) {
            t = new Nodo(x, null, null);
        }
        //si x es menor devuelve -1
        else if (x.compareTo(t.dato) < 0) {
            t.izquierdo = insertar(x, t.izquierdo);
            if (altura(t.izquierdo) - altura(t.derecho) == 2) {
                if (x.compareTo(t.izquierdo.dato) < 0) {
                    rotacionSimpleDerecha = rotacionSimpleDerecha + 1;
                    System.out.println("rotacionSimpleDerecha");
                    t = rotacionSimpleDerecha(t);
                    /* Caso 1:
                     p==2 y q == 1
                     */
                } else {
                    rotacionDobleDerecha = rotacionDobleDerecha + 1;
                    System.out.println("rotacionDobleDerecha");
                    t = rotacionDobleDerecha(t);
                    /* Caso 2 :
                     p==2 y q==-1
                     */
                }
            }
        } else if (x.compareTo(t.dato) > 0) {
            t.derecho = insertar(x, t.derecho);
            if (altura(t.derecho) - altura(t.izquierdo) == 2) {
                if (x.compareTo(t.derecho.dato) > 0) {
                    rotacionSimpleIzquierda = rotacionSimpleIzquierda + 1;
                    System.out.println("rotacionSimpleIzquierda");
                    t = rotacionSimpleIzquierda(t);
                    /* Caso 4:
                     p==-2 y q ==-1
                     */
                } else {
                    rotacionDobleIzquierda = rotacionDobleIzquierda + 1;
                    System.out.println("rotacionDobleIzquierda");
                    t = rotacionDobleIzquierda(t);
                    /* Caso 3 :
                     p==-2 y q == 1
                     */
                }
            }
        } else; // Duplicado--- no hago nada
        t.altura = max(altura(t.izquierdo), altura(t.derecho)) + 1;
        return t;
    }

    private static int max(int alturaHijoIzquierdo, int alturaHijoDerecho) {
        return alturaHijoIzquierdo > alturaHijoDerecho ? alturaHijoIzquierdo : alturaHijoDerecho;
    }

    private static Nodo rotacionSimpleDerecha(Nodo k2) {
        Nodo k1 = k2.izquierdo;
        k2.izquierdo = k1.derecho;
        k1.derecho = k2;
        k2.altura = max(altura(k2.izquierdo), altura(k2.derecho)) + 1;
        k1.altura = max(altura(k1.izquierdo), k2.altura) + 1;
        return k1;
    }

    private static Nodo rotacionSimpleIzquierda(Nodo k1) {
        Nodo k2 = k1.derecho;
        k1.derecho = k2.izquierdo;
        k2.izquierdo = k1;
        k1.altura = max(altura(k1.izquierdo), altura(k1.derecho)) + 1;
        k2.altura = max(altura(k2.derecho), k1.altura) + 1;
        return k2;
    }

    private static Nodo rotacionDobleDerecha(Nodo k3) {
        k3.izquierdo = rotacionSimpleIzquierda(k3.izquierdo);
        return rotacionSimpleDerecha(k3);
    }

    private static Nodo rotacionDobleIzquierda(Nodo k1) {
        k1.derecho = rotacionSimpleDerecha(k1.derecho);
        return rotacionSimpleIzquierda(k1);
    }

    private static int altura(Nodo t) {
        return t == null ? -1 : t.altura;
    }

    /*
     * Imprime el arbol con el recorrido InOrden
     */
    public void imprimir() {
        imprimir(raiz);
    }

    private void imprimir(Nodo nodo) {
        if (nodo != null) {
            imprimir(nodo.derecho);
            System.out.println("[" + nodo.dato + "]");
            imprimir(nodo.izquierdo);
        }
    }

    /*
     * Obtiene la altura del arbol AVL
     */
    public int calcularAltura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(Nodo actual) {
        if (actual == null) {
            return -1;
        } else {
            return 1 + Math.max(calcularAltura(actual.izquierdo), calcularAltura(actual.derecho));
        }
    }

    public int darNumeroNodo() {
        return numNodo;
    }

    public int darRotacionSimpleDerecha() {
        return rotacionSimpleDerecha;
    }

    public int darRotacionSimpleIzquierda() {
        return rotacionSimpleIzquierda;
    }

    public int darRotacionDobleDerecha() {
        return rotacionDobleDerecha;
    }

    public int darRotacionDobleIzquierda() {
        return rotacionDobleIzquierda;
    }

    
}
