/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Olixer
 */
public class Nodo {
    
    int info;
    Nodo sig;

    public Nodo(int info) {
        this.info = info;
        this.sig = null;
    }
    
 public Nodo getSig(){
    return sig;
 }
 public int getInfo(){
    return info;
 }
 
 public void setSig(Nodo sig){
 this.sig = sig;
 }
    
}
