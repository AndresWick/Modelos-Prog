/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Olixer
 */
public class Lista {
    Nodo cab;
    int pib;
    public Lista() {
        cab = null;
    }
    
    void Insertar(int n){
        pib=n;
        int aux = 0;
        Nodo p, q;
        p = cab;
        q = p;
        if(cab == null){
           cab = new Nodo(n);
        }else{ 
            if(n< p.info){
                Nodo nuevo = new Nodo(n);
                nuevo.sig = cab;
                cab = nuevo;
            }else{
                while(p != null && aux==0){
                    if(n>p.info){
                        q = p;
                        p = p.sig; 
                    }else{
                        if(n == p.info){
                            JOptionPane.showMessageDialog(null,"El número ya se encuentra en la lista.");   
                            aux=2; 
                        }else{
                            if(n<p.info){
                                aux=1;
                            }
                        }
                    }
                }    
                if(aux==2){
                }else{
                    Nodo nuevo = new Nodo(n);
                    nuevo.sig = p;
                    q.sig= nuevo;
                }
            }
        }
    }
    
    public int getPib(){
        return pib;
    }
    
    void Listar(){
        Nodo p = cab;
        String i = "";
        while(p != null){
            i=i+" , "+p.info;
            p = p.sig;
        }
        JOptionPane.showMessageDialog(null,"Lista: "+i);
    }
    
     ArrayList arregloCreciente(){
        Nodo p = cab;
        ArrayList listado = new ArrayList();
        int j = 0;
        for(;p != null;){
            listado.add(p.info);
            p = p.sig;
        }
        return listado;
    }
    
 
   
    public void eliminar(int referencia){
        if (buscar(referencia)) {
            if (cab.getInfo() == referencia) {
                cab = cab.getSig();
                JOptionPane.showMessageDialog(null,referencia+" se ha eliminado de la lista.");
            } else{
                Nodo aux = cab;
                while(aux.getSig().getInfo() != referencia){
                    aux = aux.getSig();
                }
                Nodo siguiente = aux.getSig().getSig();
                aux.setSig(siguiente); 
                JOptionPane.showMessageDialog(null,referencia+" se ha eliminado de la lista.");
            }
        }else{
            JOptionPane.showMessageDialog(null,referencia+" no se encuentra en la lista."); 
        }
    }
    
    public boolean buscar(int referencia){
        Nodo aux = cab;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (referencia == aux.getInfo()){
                encontrado = true;
            }
            else{
                aux = aux.getSig();
            }
        }
        return encontrado;
    }
    
    
    void ListarInversa(Nodo cab){
        Nodo p = cab;
        if(p != null){
            ListarInversa(p.sig);
            System.out.println(p.info);
        }
    }
    
     ArrayList arregloDecreciente(){
        ArrayList listado = new ArrayList();
        listado = arregloCreciente();
        Collections.reverse(listado);
        return listado;
    }
    
}
