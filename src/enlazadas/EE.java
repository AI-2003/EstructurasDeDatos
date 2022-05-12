package enlazadas;

import java.util.Iterator;

/**
 *
 * @author Armando Ibarrarán
 */
public class EE <T> implements Iterable<T>{
    private Nodo<T> primero;

    public EE() {
        primero = null;
    }
    
    public boolean isEmpty(){
        return primero == null;
    }
    
    public void agregaInicio(T nuevoDato){
        Nodo<T> nuevoNodo = new Nodo(nuevoDato);
        nuevoNodo.setDir(primero);
        primero = nuevoNodo;
    }
    
    
    public void agregaFinal(T nuevoDato){
        Nodo<T> nuevoNodo = new Nodo(nuevoDato);
        if(this.isEmpty()){
            primero=nuevoNodo;
        }
        else{
            Nodo<T> temporal = primero;
            while(temporal.getDir() != null){
                temporal = temporal.getDir();        
            }
            temporal.setDir(nuevoNodo);
        }
    }
    
//    public String toString (){
//        StringBuilder sb = new StringBuilder();
//        Nodo<T> temporal = primero;
//        while(temporal != null){
//            sb.append(temporal.getDato()).append("\n");
//            temporal = temporal.getDir();  
//        }
//        return sb.toString();
//    }
    
    public T quitaPrimero(){
        T quitado;
        
        if(this.isEmpty())
            throw new EmptyCollectionException("La estructura está vacía.");
        quitado=primero.getDato();
        if(primero.getDir()==null)
            primero=null;
        else
            primero=primero.getDir();
        return quitado;
    }
    
    public T quitaFinal() {
        T quitado;
        Nodo<T> aux;
        
        if(this.isEmpty())
            throw new EmptyCollectionException("La estructura está vacía.");
        aux=primero;
        if(aux.getDir()==null){
            quitado=primero.getDato();
            primero=null;
        }else{
            while(aux.getDir().getDir()!=null)
                aux=aux.getDir();
            quitado=aux.getDir().getDato();
            aux.setDir(null);
        }
        return quitado;
    }
    
    public boolean buscaDato(T dato){
        Nodo<T> aux;
        
        if(this.isEmpty())
            throw new EmptyCollectionException("La estructura está vacía.");
        aux=primero;
        while(aux.getDir()!=null && !aux.getDato().equals(dato))
            aux=aux.getDir();
        return aux.getDato().equals(dato);
    }
    
    public T quitaDato(T dato){
        Nodo<T> aux, temp;
        T res;
        
        if(this.isEmpty())
            throw new EmptyCollectionException("La estructura está vacía.");
        aux=primero;
        res=null;
        if(primero.getDato().equals(dato)){
            res=primero.getDato();
            primero=primero.getDir();
            aux.setDir(null);
        }else{
            while(aux.getDir()!=null && !aux.getDir().equals(dato))
                aux=aux.getDir();
            if(aux.getDir()!=null){
                temp=aux.getDir();
                res=temp.getDato();
                aux.setDir(temp.getDir());
                temp.setDir(null);
            }
        }
        return res;
    }
    
    public boolean eliminaSiguienteDe(T dato){
        Nodo<T> aux, temp;
        boolean res;
        
        if(this.isEmpty())
            throw new EmptyCollectionException("La estructura está vacía.");
        aux=primero;
        while(aux.getDir()!=null && !aux.getDato().equals(dato))
            aux=aux.getDir();
        if(aux.getDato().equals(dato)){
            temp=aux.getDir();
            aux.setDir(temp.getDir());
            temp.setDir(null);
            res=true;
        }else
            res=false;
        return res;
    }
    
    public boolean eliminaAnteriorDe(T dato){
        Nodo<T> aux, temp;
        boolean res;
        
        if(this.isEmpty())
            throw new EmptyCollectionException("La estructura está vacía.");
        aux=primero;
        res=false;
        if(aux.getDir()!=null){
            if(aux.getDir().getDato().equals(dato)){
                primero=aux.getDir();
                aux.setDir(null);
                res=true;
            }else{
                while(aux.getDir().getDir()!=null && !aux.getDir().getDir().getDato().equals(dato))
                    aux=aux.getDir();
                if(aux.getDir().getDir()!=null){
                    temp=aux.getDir();
                    aux.setDir(temp.getDir());
                    temp.setDir(null);
                    res=true;
                }
            }
        }
        return res;
    }
    
    public String toString(){
        return toString(primero, new StringBuilder());
    }
    private String toString(Nodo<T> actual, StringBuilder sb){
        if(actual==null){
            return sb.toString();
        }
        else{
            sb.append(actual.getDato()).append("\n");
            return toString(actual.getDir(),sb);
        }
    }

    public Iterator<T> iterator() {
        return new IteradorEE(primero);
    }
     
    
}
