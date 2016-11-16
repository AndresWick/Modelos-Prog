package main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Carlos_Aguirre.
 */
public class Dibujo extends Canvas{
    private int y;
    private int w;
    private Arbol arbol;
    
    public Dibujo(Arbol arbol){
        this.arbol = arbol;
        this.y = 30;
        setSize(1060,430);
    }
    
    public void paint(Graphics g){
        g.clearRect(0, 0,this.WIDTH, this.HEIGHT);
        setBackground(Color.LIGHT_GRAY);
        g.setColor(Color.black);
        Nodo p = arbol.getRaiz();
        y=30;
        w=1060;
        if(arbol.getRaiz()!=null){
            g.drawString(""+arbol.getRaiz().getInfo(),(w/2),y+15);
            g.setColor(Color.green);
            g.drawOval ((w/2)-12, y-2, 30, 30);
            recorrer(g,arbol.getRaiz().getNodoDer(),"derecha",y+30,(w/2)+15,w-15);
            recorrer(g,arbol.getRaiz().getNodoIzq(),"izquierda",y+30,15,(w/2)-15);
        } 
    }
    
    public void recorrer(Graphics g,Nodo raiz,String posicion,int y,int inicio, int tope){
        if(raiz!=null){
            g.setColor(Color.black);
            g.drawString(""+raiz.getInfo(),(inicio+((tope-inicio)/2)),y+15);
            if(posicion=="derecha"){
                g.setColor(Color.blue);
                g.drawLine((inicio+(tope-inicio)/2)+5,y+5,inicio+5,y-15);
            }else if(posicion=="izquierda"){
                g.setColor(Color.red);
                g.drawLine((inicio+(tope-inicio)/2),y+5,tope,y-15);
            }
            recorrer(g,raiz.getNodoDer(),"derecha",y+30,inicio+(tope-inicio)/2,tope);
            recorrer(g,raiz.getNodoIzq(),"izquierda",y+30,inicio,tope-(tope-inicio)/2);
        }
    }
    
    public Arbol getArbol(){
        return arbol;
    }
    
    public void setArbol(Arbol arbol){
        this.arbol=arbol;
    }
}
     
    

    
