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
    
    public void agregaInicio(T dato){
        Nodo<T> nodo;
        
        nodo = new Nodo(dato);
        nodo.setDir(primero);
        primero = nodo;
    }
    
    
    public void agregaFinal(T dato){
        Nodo<T> nodo, temp;
        
        nodo = new Nodo(dato);
        if(this.isEmpty()){
            primero=nodo;
        }
        else{
            temp = primero;
            while(temp.getDir() != null){
                temp = temp.getDir();        
            }
            temp.setDir(nodo);
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
    
    public void mezclaNodos(EE otra){
        Nodo<T> act1, act2, aux1, aux2;
        
        if(otra==null)
            throw new EmptyCollectionException("Parámetros incorrectos");
        if(this.isEmpty())
            primero=otra.primero;
        else{
            act1=primero;
            act2=otra.primero;
            aux1=act1.getDir();
            aux2=act2.getDir();
            while(aux1!=null && act2!=null){
                aux1=act1.getDir();
                aux2=act2.getDir();
                act1.setDir(act2);
                act2.setDir(aux1);
                act1.setDir(aux1);
                act2.setDir(aux2);
            }
            if(aux1==null){
                act1.setDir(act2);
            }
        }
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
