package main;
/**
 *
 * @author Carlos_Aguirre.
 */
public class Nodo {
    private int info;
    int posX;
    int posY;
    private Nodo nodoIzq;
    private Nodo nodoDer;

    public Nodo(int info) {
        this.info = info;
        this.nodoIzq = null;
        this.nodoDer = null;
    }
    
    public Nodo getNodoIzq(){
        return nodoIzq;
    }
    
    public int getInfo(){
        return info;
    }
 
    public Nodo getNodoDer(){
        return nodoDer;
    }
 
    public void setNodoDer(Nodo nodoDer){
        this.nodoDer = nodoDer;
    }
 
    public void setNodoIzq(Nodo nodoIzq){
        this.nodoIzq = nodoIzq;
    }

    public void setInfo(int info){
        this.info = info;
    }
    
}
