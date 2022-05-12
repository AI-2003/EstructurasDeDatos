package enlazadas;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Armando Ibarraran
 */
public class IteradorEE<T> implements Iterator<T>{
    private Nodo<T> actual;
    
    public IteradorEE(Nodo<T> actual){
        this.actual=actual;
    }
    
    public boolean hasNext() {
        return actual != null;
    }

    public T next() {
        T res;
        
        if(!hasNext())
            throw new NoSuchElementException();
        res=actual.getDato();
        actual=actual.getDir();
        return res;
    }
    
    
}
