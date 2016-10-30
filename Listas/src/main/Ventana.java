package main;
import javax.swing.JFrame;

/**
 *
 * @author Carlos
 */
public class Ventana extends JFrame{
   public Ventana(Lista l, int orden){
   setResizable(false);
    
    if(orden==0){
         add(new Dibujo(l,Dibujo.CRECIENTE));
         setSize(600,250);
    }else if(orden==1){
         add(new Dibujo(l,Dibujo.DECRECIENTE));
         setSize(600,250);
    }else if(orden==2){
         add(new Dibujo(l,Dibujo.INSERTADO));
         setSize(600,250);
    }
    setVisible(true);
   // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
