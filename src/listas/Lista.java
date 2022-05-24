/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

import java.util.Iterator;

/**
 *
 * @author Armando Ibarrarán
 */
public abstract class Lista <T> implements ListaADT<T>{
    protected NodoDoble<T> primero;
    protected NodoDoble<T> ultimo;

    public Lista() {
        primero = null;
        ultimo = null;
    }
    
    public Iterator<T> iterator(){
        return new IteradorLista(primero);
    }
    
    public boolean isEmpty(){
        return primero == null;
    }
    
    public String toString(){
        return toString(primero, new StringBuilder());
    }
    
    private String toString(NodoDoble<T> actual, StringBuilder sB){
        if(actual == null)
            return sB.toString();
        else{
            sB.append(actual.getDato()).append("\n");
            return toString(actual.getSiguiente(),sB);
        }
    }

    
    public boolean contiene(T dato){
        return contiene(ultimo,dato);
    }
    
    private boolean contiene(NodoDoble<T> actual, T dato){
        if (actual == null)
            return false;
        else{
            if(actual.getDato().equals(dato))
                return true;
            else
                return contiene(actual.getAnterior(), dato);
        }
    }
    
    public T quitaPrimero(){
        T resultado = null;
        
        if(!isEmpty()){
            resultado = primero.getDato();
            primero = primero.getSiguiente();
            if(primero == null) // Había un solo nodo
                ultimo = null; // Indica la lista quedó vacía
            else{
                primero.getAnterior().setSiguiente(null);
                primero.setAnterior(null);
            }
        }
    return resultado;
    }
    
    public T quitaUltimo(){
        T resultado = null;
        
        if(!isEmpty()){
            resultado = ultimo.getDato();
            ultimo = ultimo.getAnterior();
            if(ultimo == null) // Había un solo nodo
                primero = null; // Indica la lista quedó vacía
            else{
                ultimo.getSiguiente().setAnterior(null);
                ultimo.setSiguiente(null);
            }
        }
    return resultado;
    }
    
    public T quita(T dato){
        T quitado = null;
        NodoDoble<T> aux;
        
        if(!isEmpty()){
            if(primero.getDato().equals(dato))
                quitado = quitaPrimero();
            else{
                if(ultimo.getDato().equals(dato))
                    quitado = quitaUltimo();
                else{
                    aux = primero.getSiguiente();
                    while(aux != null && aux.getDato().equals(dato))
                        aux = aux.getSiguiente();
                    if(aux != null){
                        quitado = aux.getDato();
                        aux.getAnterior().setSiguiente(aux.getSiguiente());
                        aux.getSiguiente().setAnterior(aux.getAnterior());
                        aux.setSiguiente(null);
                        aux.setAnterior(null);
                    }
                }
            }   
        }
        return quitado;
    }
    
    public int calculaTamaño(){
        return calculaTamaño(primero,0);
    }
    
    private int calculaTamaño(NodoDoble<T> actual, int cont){
        if(actual == null)
            return cont;
        else
            return calculaTamaño(actual.getSiguiente(),cont+1);
    }
    
    public T consultaPrimero(){
        T res;
        
        res=null;
        if(!this.isEmpty())
            res=primero.getDato();
        return res;
    }
    
    public T consultaUltimo(){
        T res;
        
        res=null;
        if(!this.isEmpty())
            res=ultimo.getDato();
        return res;
    }
    
    
}
