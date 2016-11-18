package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Carlos_Aguirre.
 */
public class Dibujo extends Canvas{
    
    int tamaño;
    int tipo;
    int a[]=new int[50];
    int b[]=new int[50];
    int dato[]=new int[50];
    int alto[]=new int[50];
    int ancho[]=new int[50];
    int numeros[]=new int[10];
    Nodo raiz;
    Nodo actual;
    Nodo borrar;
    
    void repintar(Nodo raiz){
        this.raiz=raiz;
    }  
    
    public void paint(Graphics g){
        actual=raiz;
        g.setColor(Color.BLACK);
        g.drawString(""+raiz.dato, raiz.posX, raiz.posY-5 );
        g.setColor(Color.green);
        g.drawOval(raiz.posX-15, raiz.posY-27, 30, 30);
        porIzq(g,raiz);
        porDer(g,raiz);
    }
      
    private void porIzq(Graphics g,Nodo actual) {
        try{
            if(actual.nodoIzq!=null){
                g.setColor(Color.BLACK);
                g.drawString(""+actual.nodoIzq.dato, actual.nodoIzq.posX, actual.nodoIzq.posY);
                g.setColor(Color.red);
                g.drawLine(actual.posX, actual.posY+3, actual.nodoIzq.posX+10, actual.nodoIzq.posY-3);
                actual=actual.nodoIzq;
                if(actual.nodoIzq!=null)
                    porIzq(g,actual);
                }
            if(actual.nodoDer!=null){
                porDer(g,actual);
            }
        }catch(Exception e){}
    }

    private void porDer(Graphics g,Nodo actual){
        try{
            if(actual.nodoDer!=null){
                g.setColor(Color.BLACK);
                g.drawString(""+actual.nodoDer.dato, actual.nodoDer.posX, actual.nodoDer.posY);
                g.setColor(Color.blue);
                g.drawLine(actual.posX, actual.posY+3, actual.nodoDer.posX, actual.nodoDer.posY-3);
                actual=actual.nodoDer;
                if(actual.nodoDer!=null)
                    porDer(g,actual);
            }
            if(actual.nodoIzq!=null){
                porIzq(g,actual);
            }
        }catch(Exception e){}
    }
}
