package conjuntos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Armando Ibarrarán
 */
public class IteradorArreglo <T> implements Iterator<T> {
    private T[] datos;
    private int total;
    private int actual;

    public IteradorArreglo(T[] datos, int total) {
        this.datos=datos;
        this.total=total;
        actual=0;
    }
    
    public boolean hasNext(){
        
        return actual<total;
    }

    public T next() {
        
        if(!hasNext())
            throw new NoSuchElementException();
        return datos[actual++];
    }
    
}
