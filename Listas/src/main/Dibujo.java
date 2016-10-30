package main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Carlos
 */
public class Dibujo extends Canvas{
    private int contador;
    private int x;
    private int y;
    private int w;
    private int h;
    private Lista lista;
    private int orden;
    public static final int CRECIENTE = 0;
    public static final int DECRECIENTE = 1;
    public static final int INSERTADO = 2;
    
    public Dibujo(Lista lista, int orden){
        this.lista = lista;
        this.orden = orden;
        this.x = 20;
        this.y = 30;
        this.w = 50;
        this.h = 20;
        this.contador = 0;
    }
    
    public void paint(Graphics g){
        contador = 0;
        setSize(600,250);
        setBackground(Color.LIGHT_GRAY);
        g.setColor(Color.red);
        Nodo p = lista.cab;
        x=20;
        y=30;
        w=50;
        h=20;
        if(orden == CRECIENTE){
            g.drawRect(x,y,10,10);
            g.drawString("CAB",x,y-5);
            g.drawLine(x+10,y+5,x+20,y+5);
            g.drawLine(x+18,y+3,x+20,y+5);
            g.drawLine(x+18,y+7,x+20,y+5);
            x+=30;
            while(p!=null){
                g.setColor(Color.blue);
                if(contador%9==0){
                    y+=(30*(contador/9));
                    x=40;
                }
                g.drawRect(x,y,w,h);
                g.drawRect(x,y,w-10,h);
                g.drawString(""+p.getInfo(),x+10,y+15);
                if(p.sig!=null){
                    g.drawLine(x+45,y+10,x+60,y+10);
                    g.drawLine(x+58,y+8,x+60,y+10);
                    g.drawLine(x+58,y+12,x+60,y+10);
                }
                x+=(w+10);
                contador++;
                p=p.getSig();
            }
        }else if(orden == DECRECIENTE){
            listarInversa(g,lista.cab);
        }else if(orden == INSERTADO){
            g.drawRect(x,y,10,10);
            g.drawString("CAB",x,y-5);
            if(p==lista.cab&&p.getInfo()==lista.getPib()){
                g.drawLine(x+10,y+5,x+20,y-5);
                g.drawLine(x+18,y-7,x+20,y-5);
                g.drawLine(x+18,y-3,x+20,y-5);
                x+=30;
            }else{
                g.drawLine(x+10,y+5,x+20,y+5);
                g.drawLine(x+18,y+3,x+20,y+5);
                g.drawLine(x+18,y+7,x+20,y+5);
                x+=30;
            }
            while(p!=null){
                g.setColor(Color.blue);
                if(contador%9==0){
                    y+=(50*(contador/9));
                    x=40;
                }
                if(p==lista.cab&&p.getInfo()==lista.getPib()){
                    g.setColor(Color.red);
                    g.drawRect(x,y-10,w,h);
                    g.drawRect(x,y-10,w-10,h);
                    g.drawString(""+p.getInfo(),x+10,y+5);
                    if(p.sig!=null){
                        g.drawLine(x+45,y,x+60,y+10);
                        g.drawLine(x+58,y+8,x+60,y+10);
                        g.drawLine(x+58,y+12,x+60,y+10);
                    }
                    x+=(w+10);
                    contador++;
                    p=p.getSig();
                    g.setColor(Color.blue);
                }else if(p.getInfo()==lista.getPib()){
                    g.setColor(Color.red);
                    g.drawRect(x,y-10,w,h);
                    g.drawRect(x,y-10,w-10,h);
                    g.drawString(""+p.getInfo(),x+10,y+5);
                    if(p.sig!=null){
                        g.drawLine(x+45,y,x+60,y+10);
                        g.drawLine(x+58,y+8,x+60,y+10);
                        g.drawLine(x+58,y+12,x+60,y+10);
                    }
                    x+=(w+10);
                    contador++;
                    p=p.getSig();
                    g.setColor(Color.blue);
                }else if(p.getSig()!=null&&p.getSig().getInfo()==lista.getPib()){
                    g.drawRect(x,y,w,h);
                    g.drawRect(x,y,w-10,h);
                    g.drawString(""+p.getInfo(),x+10,y+15);
                    if(p.sig!=null){
                        g.drawLine(x+45,y+10,x+60,y);
                        g.drawLine(x+58,y+2,x+60,y);
                        g.drawLine(x+58,y-2,x+60,y);
                    }
                    x+=(w+10);
                    contador++;
                    p=p.getSig();
                }else{
                    g.drawRect(x,y,w,h);
                    g.drawRect(x,y,w-10,h);
                    g.drawString(""+p.getInfo(),x+10,y+15);
                    if(p.sig!=null){
                        g.drawLine(x+45,y+10,x+60,y+10);
                        g.drawLine(x+58,y+8,x+60,y+10);
                        g.drawLine(x+58,y+12,x+60,y+10);
                    }
                    x+=(w+10);
                    contador++;
                    p=p.getSig();
                }
            }
        }
     }
    
    void listarInversa(Graphics g,Nodo cab){
        Nodo p = cab;
        if(p != null){
            listarInversa(g,p.sig);
            g.setColor(Color.blue);
                if(contador%9==0){
                    y+=(30*(contador/9));
                    x=40;
                }
                g.drawRect(x,y,w,h);
                g.drawRect(x,y,w-10,h);
                g.drawString(""+p.getInfo(),x+10,y+15);
                if(p == lista.cab){
                    g.setColor(Color.red);
                    g.drawRect(x+20,y+h+10,10,10);
                    g.drawString("CAB",x,y+h+15);
                    g.drawLine(x+25,y+h+10,x+25,y+h);
                    g.drawLine(x+23,y+h+2,x+25,y+h);
                    g.drawLine(x+27,y+h+2,x+25,y+h);
                }else{
                    g.drawLine(x+45,y+10,x+60,y+10);
                    g.drawLine(x+47,y+8,x+45,y+10);
                  //g.drawLine(x+58,y+8,x+60,y+10);
                    g.drawLine(x+47,y+12,x+45,y+10);
                  //g.drawLine(x+58,y+12,x+60,y+10);
                }
                x+=(w+10);
                contador++;
        }
    }
    
}