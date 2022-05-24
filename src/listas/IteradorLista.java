package listas;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Armando Ibarrarán
 */
public class IteradorLista<T> implements Iterator<T> {
    private NodoDoble<T> actual;

    public IteradorLista(NodoDoble<T> actual) {
        this.actual = actual;
    }
    
    public boolean hasNext() {
        return actual != null;
    }
    
    public T next() {
        T dato;
        
        if(!hasNext())
            throw new NoSuchElementException();
        dato = actual.getDato();
        actual = actual.getSiguiente();
        return dato;
    }
    
    
}
