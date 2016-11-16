package main;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos_Aguirre.
 */
public class Arbol {
    private Nodo raiz;
    private ArrayList arrayInorden;
    private ArrayList arrayPreorden;
    private ArrayList arrayPostOrden;
    private ArrayList arrayPorNiveles;
    private String arreglo = "";
    private int contador;

    public Arbol() {
        contador=1;
        raiz = null;
        arrayInorden = new ArrayList();
        arrayPreorden = new ArrayList();
        arrayPostOrden = new ArrayList();
        arrayPorNiveles = new ArrayList <String>();
    }
    
    public void insertar(int n){
        if(raiz==null){
        raiz = new Nodo(n);
        }else{
            Nodo p = raiz;
            while(p!=null){
                if(p.getInfo() == n){
                    JOptionPane.showMessageDialog(null,n+" ya se encuentra en el arbol.");
                    break;
                }else if(p.getInfo()<n){
                    if(p.getNodoDer()!=null){

                         p = p.getNodoDer();
                    }else{
                        p.setNodoDer(new Nodo(n));
                        break;
                    }
                }else if(p.getInfo()>n){
                    if(p.getNodoIzq()!=null){
                        p = p.getNodoIzq();
                    }else{
                        p.setNodoIzq(new Nodo(n));
                        break;
                    }
                }
            }
        }
    }
 
    public Nodo eliminar(int n,Nodo p){

        if(p!=null){
            if( n == p.getInfo() ){
                if(p.getNodoDer()==null&&p.getNodoIzq()==null){
                    if(p==raiz){
                        raiz = null;
                        arrayPreorden.remove(arrayPreorden.indexOf(p.getInfo()));
                        return null;
                    }else if(p!=raiz){
                        arrayPreorden.remove(arrayPreorden.indexOf(p.getInfo()));
                        asignarNuevaRaiz(arrayPreorden); 
                        return raiz;
                    }
                }else if( p.getNodoIzq()!=null&&p.getNodoDer() == null){
                    arrayPreorden.remove(arrayPreorden.indexOf(p.getInfo()));
                    asignarNuevaRaiz(arrayPreorden); 
                    return raiz;
                }else if( p.getNodoIzq() == null&&p.getNodoDer() != null ){
                    arrayPreorden.remove(arrayPreorden.indexOf(p.getInfo()));
                    asignarNuevaRaiz(arrayPreorden); 
                    return raiz;
                }else if( p.getNodoIzq() != null&&p.getNodoDer() != null ){
                    arrayPreorden.remove(arrayPreorden.indexOf(p.getInfo()));
                    asignarNuevaRaiz(arrayPreorden); 
                    return raiz;
                              
                }
            }else if( n < p.getInfo() ){
                if( p.getNodoIzq() == null ){
                    JOptionPane.showMessageDialog(null, "El elemento no fue encontrado." );
                }else{
                    p.setNodoIzq(eliminar( n, p.getNodoIzq() ));
                    return raiz;
                }
            }else if( n > p.getInfo() ){
                if( p.getNodoDer() == null ){
                    JOptionPane.showMessageDialog(null, "El elemento no fue encontrado." );
                }else{
                    p.setNodoDer(eliminar( n, p.getNodoDer() ));
                    return raiz;
                }
            }    
        }
        return raiz;
    }
    
    public void asignarNuevaRaiz(ArrayList preor){
        raiz = new Nodo((int) preor.get(0));
        raiz.setNodoIzq(null);
        raiz.setNodoDer(null);
        preor.remove(0);
        do{
            insertar((int) preor.get(0));
            preor.remove(0);
        }while(preor.size()>0);
    }
    
    public boolean buscar(int n, Nodo p){
        if(p!=null){
            if(p.getInfo() == n){
                return true;
            }
            if(n<p.getInfo()){
                return buscar(n,p.getNodoIzq());
            }else{
                return buscar(n,p.getNodoDer());
            }
        }
        return false; 
    }
    
    public Nodo retornarNodo(int n, Nodo p){
        if(p!=null){
            if(p.getInfo() == n){
                return p;
            }
            if(n<p.getInfo()){
                return retornarNodo(n,p.getNodoIzq());
            }else{
                return retornarNodo(n,p.getNodoDer());
            }
        }
        return null; 
    }
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    public void setRaiz(Nodo raiz){
        this.raiz = raiz;
    }

    public void inOrden(Nodo p){
        if(p!=null){
            inOrden(p.getNodoIzq());
            arrayInorden.add(p.getInfo());
            arreglo=arreglo+(""+p.getInfo())+",";
            inOrden(p.getNodoDer());
        }
    }

    public void preOrden(Nodo p){
        if(p!=null){
            arrayPreorden.add(p.getInfo());
            arreglo=arreglo+(""+p.getInfo())+",";
            preOrden(p.getNodoIzq());
            preOrden(p.getNodoDer());
        }
    }
    
    public void posOrden(Nodo p){
        if(p!=null){
            posOrden(p.getNodoIzq());
            posOrden(p.getNodoDer());
             arreglo=arreglo+(""+p.getInfo())+",";
            arrayPostOrden.add(p.getInfo());
        }
    }
     
       public void porNiveles(Nodo p){
         if(p!=null){
            if(p==raiz){
                arreglo+=(""+p.getInfo())+",";
                arrayPorNiveles.add("Nivel "+contador+": "+p.getInfo());
            }
            contador++;

            if(p.getNodoIzq()!=null){
                arreglo+=(""+p.getNodoIzq().getInfo())+",";
                for(int i=0;i<arrayPorNiveles.size();i++){
                    if(arrayPorNiveles.get(i).toString().indexOf("Nivel "+contador+": ")!=-1){
                        if(arrayPorNiveles.get(i).toString().indexOf("Nivel "+contador+": "+p.getNodoIzq().getInfo())==-1){
                            String a = (String) arrayPorNiveles.get(i)+","+p.getNodoIzq().getInfo();
                            arrayPorNiveles.set(i,a);
                        }
                    break;
                    }else if(i==arrayPorNiveles.size()-1){
                        arrayPorNiveles.add("Nivel "+contador+": "+p.getNodoIzq().getInfo());
                    }
                }
            }
            if(p.getNodoDer()!=null){
                arreglo+=(""+p.getNodoDer().getInfo())+",";
                for(int i=0;i<arrayPorNiveles.size();i++){
                    if(arrayPorNiveles.get(i).toString().indexOf("Nivel "+contador+": ")!=-1){
                        if(arrayPorNiveles.get(i).toString().indexOf("Nivel "+contador+": "+p.getNodoDer().getInfo())==-1){
                            String a = (String)arrayPorNiveles.get(i)+","+p.getNodoDer().getInfo();
                            arrayPorNiveles.set(i,a);
                        }
                    break;
                    }else  if(i==arrayPorNiveles.size()-1){
                        arrayPorNiveles.add("Nivel "+contador+": "+p.getNodoDer().getInfo());
                    }
                }
            }
            
            porNiveles(p.getNodoIzq());
            porNiveles(p.getNodoDer());
            contador--;
        
         }
    }
    
    
    public void setArrayPreorden(ArrayList arrayPreorden){
        this.arrayPreorden = arrayPreorden;
    }
    
    public ArrayList getArrayPreorden(){
        return arrayPreorden;
    }
    
    public void setArrayInorden(ArrayList arrayInorden){
        this.arrayInorden = arrayInorden;
    }
    
    public ArrayList getArrayInorden(){
        return arrayInorden;
    }
    
    public void setArrayPostOrden(ArrayList arrayPostOrden){
        this.arrayPostOrden = arrayPostOrden;
    }
    
    public ArrayList getArrayPostOrden(){
        return arrayPostOrden;
    }
    
    public void setArrayPorNiveles (ArrayList arrayPorNiveles){
        this.arrayPorNiveles = arrayPorNiveles;
    }
    
    public ArrayList getArrayPorNiveles(){
        return arrayPorNiveles;
    }
    
    public String getArreglo(){
        return arreglo;
    }

    public void setArreglo(String arreglo){
        this.arreglo = arreglo;
    }
    
     public void resetContador(){
         contador=1;
     }
    
    public void dibujarAleatorios(ArrayList a){
        this.raiz = null;
        insertar((int) a.get(0));
        insertar((int) a.get(1));
        insertar((int) a.get(2));
        insertar((int) a.get(3));
        insertar((int) a.get(4));
    }
      
}
