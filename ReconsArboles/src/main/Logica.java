package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author Carlos_Aguirre.
 */
public class Logica{
    
    Menu menu;
    int cantPre = 0;
    int cantIn = 0;
    int cantPos = 0;
    Dibujo dibujo;
    JFrame ventana;
    int[] preorden;
    int[] inorden;
    int[] auxIn;
    int[] posorden;
    Nodo raiz;
    Nodo actual;
    int pos = 0;
    boolean existe;
    boolean iguales;
    
    public Logica(Menu menu){
        this.menu = menu;
        dibujo=new Dibujo();
        this.ventana = new JFrame();
        ventana.setSize(800,500);
        auxIn = new int[30];
    }

    public void insertarPre(){
        cantPre = 0;
        preorden = new int[30];
        menu.getLblPreorden().setText("{}");
        String c = "";
        while(c!=null){
            existe=false;
            c=JOptionPane.showInputDialog("Ingrese un numero", null);
            for(int i=0;i<cantPre;i++){
                try{if(preorden[i]==Integer.parseInt(c)){
                    JOptionPane.showMessageDialog(null, "Error");
                    existe = true;
                }}catch(Exception e){}
            }
            if((c!=null)&&(existe==false)){
                preorden[cantPre]=Integer.parseInt(c);
            cantPre++;
           // menu.getLblPreorden().setText(menu.getLblPreorden().getText()+c+",");
            if( menu.getLblPreorden().getText().length()!=2){
                    menu.getLblPreorden().setText(menu.getLblPreorden().getText().substring(0,menu.getLblPreorden().getText().length()-1)+","+c+"}");
                }else{
                    menu.getLblPreorden().setText(menu.getLblPreorden().getText().substring(0,menu.getLblPreorden().getText().length()-1)+c+"}"); 
                }
            }
        }
        raiz=new Nodo(preorden[0],400,50,1);
        for(int i=1;i<cantPre;i++){
            actual=raiz;
            insertarAl(i);
        }
    }
    
    public void insertarIn(){
        cantIn=0;
        inorden=new int[30];
        menu.getLblInorden().setText("{}");
        String c="";
        while(c!=null){
            existe=false;
            c=JOptionPane.showInputDialog("Inserte un numero", null);
            for(int i=0;i<cantPre;i++){
                try{if(inorden[i]==Integer.parseInt(c)){
                    JOptionPane.showMessageDialog(null, "Error");
                    existe=true;
                }}catch(Exception e){}
            }
            if((c!=null)&&(existe==false)){
            inorden[cantIn]=Integer.parseInt(c);
            cantIn++;
            //text="{"+arbol.getArreglo().substring(0,arbol.getArreglo().length()-1)+"}";
                if( menu.getLblInorden().getText().length()!=2){
                    menu.getLblInorden().setText(menu.getLblInorden().getText().substring(0,menu.getLblInorden().getText().length()-1)+","+c+"}");
                }else{
                    menu.getLblInorden().setText(menu.getLblInorden().getText().substring(0,menu.getLblInorden().getText().length()-1)+c+"}"); 
                }
            }
        }
    }
    
    public void insertarPos(){
        cantPos=0;
        posorden=new int[30];
        menu.getLblPosorden().setText("{}");
        String c="";
        while(c!=null){
            existe=false;
            c=JOptionPane.showInputDialog("Inserte un numero", null);
            for(int i=0;i<cantPre;i++){
                try{if(posorden[i]==Integer.parseInt(c)){
                    JOptionPane.showMessageDialog(null, "Error");
                    existe=true;
                }}catch(Exception e){}
            }
            if((c!=null)&&(existe==false)){
                posorden[cantPos]=Integer.parseInt(c);
            cantPos++;
           // menu.getLblPosorden().setText(menu.getLblPosorden().getText()+c+",");
             if( menu.getLblPosorden().getText().length()!=2){
                    menu.getLblPosorden().setText(menu.getLblPosorden().getText().substring(0,menu.getLblPosorden().getText().length()-1)+","+c+"}");
                }else{
                    menu.getLblPosorden().setText(menu.getLblPosorden().getText().substring(0,menu.getLblPosorden().getText().length()-1)+c+"}"); 
                }
            }
        }
        
        raiz=new Nodo(posorden[cantPos-1],400,50,1);
        for(int i=(cantPos-2);i>=0;i--){
            actual=raiz;
            insertarpos(i);
        }
    }
    
     private void insertarAl(int j){
        int x=100;
        if(preorden[j]==0){
 //           System.out.println("si el"+j);
        }
        if(j==0){
//            System.out.println("si el"+j);
        }else{
        if(preorden[j]>actual.dato){
            if(preorden[j]<raiz.dato){
                while((actual.dato>preorden[j])&&(actual.nodoIzq!=null)){
                    actual=actual.nodoIzq;
 //                   System.out.println("entre1");
                }
            }
            if(actual.nodoDer==null){
                actual.nodoDer=new Nodo(preorden[j],actual.posX+200,actual.posY+50,(actual.posY+50)/50);
                if(actual.posY>=100){
                    actual.nodoDer.posX=actual.posX+x-((actual.posY/50)*10);
                }
 //               System.out.println("pord");
            }else{
                actual=actual.nodoDer;
                insertarAl(j);
            }
        }
        if(preorden[j]<actual.dato){
            if(preorden[j]>raiz.dato){
                //actual=raiz;
                while((actual.dato<preorden[j])&&(actual.nodoDer!=null)){
                    actual=actual.nodoDer;
 //                   System.out.println("entre2");
                }
            }
            if(actual.nodoIzq==null){
                actual.nodoIzq=new Nodo(preorden[j],actual.posX-200,actual.posY+50,(actual.posY+50)/50);
                if(actual.posY>=100){
                    actual.nodoIzq.posX=actual.posX-x+((actual.posY/50)*10);
                }
//                System.out.println("pori");
            }else{
                actual=actual.nodoIzq;
                insertarAl(j);
            }
        }
        }
    }
     
    private void insertarpos(int j){
        int x=100;
 //       System.out.println(posorden[j]);
        if(posorden[j]==0){
  //          System.out.println("si el"+j);
        }
        if(j==0){
  //          System.out.println("si el"+j);
        }
        if(posorden[j]>actual.dato){
            if(posorden[j]<raiz.dato){
                //actual=raiz;
                while((actual.dato>posorden[j])&&(actual.nodoIzq!=null)){
                    actual=actual.nodoIzq;
  //                  System.out.println("entre1");
                }
            }
            if(actual.nodoDer==null){
                actual.nodoDer=new Nodo(posorden[j],actual.posX+200,actual.posY+50,(actual.posY+50)/50);
                if(actual.posY>=100){
                    actual.nodoDer.posX=actual.posX+x-((actual.posY/50)*10);
                }
 //               System.out.println("pord");
                
            }else{
                actual=actual.nodoDer;
                insertarpos(j);
            }
        }
        if(posorden[j]<actual.dato){
            if(posorden[j]>raiz.dato){
                while((actual.dato<posorden[j])&&(actual.nodoDer!=null)){
                    actual=actual.nodoDer;
  //                  System.out.println("entre2");
                }
            }
            if(actual.nodoIzq==null){
                actual.nodoIzq=new Nodo(posorden[j],actual.posX-200,actual.posY+50,(actual.posY+50)/50);
                if(actual.posY>=100){
                    actual.nodoIzq.posX=actual.posX-x+((actual.posY/50)*10);
                }
 //               System.out.println("pori");
            }else{
                actual=actual.nodoIzq;
                insertarpos(j);
            }
        }
    }
     
    public void imprimir(){
        if(inorden==null){ 
        dibujo.repintar(raiz);
        ventana.setVisible(true);
        ventana.add(dibujo);
        }else{
            if(preorden!=null){
                if(cantPre!=cantIn){
                    JOptionPane.showMessageDialog(null, "Error no coincide el tamaño");
                }else{
                    iguales=true;
                    inorden(raiz);
                    for(int i=0;i<cantIn;i++){
                        if(inorden[i]!=auxIn[i]){
                            JOptionPane.showMessageDialog(null, "Error no coincide el valor");
                            iguales=false;
                            break;
                        }
                    }
                    if(iguales==true){
                        dibujo.repintar(raiz);
                        ventana.setVisible(true);
                        ventana.add(dibujo);
                    }
                }
            }
            if(posorden!=null){
                if(cantPos!=cantIn){
                    JOptionPane.showMessageDialog(null, "Error no coincide el tamaño");
                }else{
                    iguales=true;
                    inorden(raiz);
                    for(int i=0;i<cantIn;i++){
                        if(inorden[i]!=auxIn[i]){
                            JOptionPane.showMessageDialog(null, "Error no coincide el valor");
                            iguales=false;
                            break;
                        }
                    }
                    if(iguales==true){
                        dibujo.repintar(raiz);
                        ventana.setVisible(true);
                        ventana.add(dibujo);
                    }
                }
                
            }
        }
    }

    public void borrarPre(){
        menu.getLblPreorden().setText("");
        preorden=null;
        cantPre=0;
    }
    
    public void borrarIn(){
        menu.getLblInorden().setText("");
        inorden=null;
        cantIn=0;
    }
    
    public void borrarPos(){
        menu.getLblPosorden().setText("");
        posorden=null;
        cantPos=0;
    }
    
    public void inorden(Nodo actual){
        if(actual!=null){
            inorden(actual.nodoIzq);
            auxIn[pos]=actual.dato;
            pos++;            
            inorden(actual.nodoDer);
        }
    }
}
