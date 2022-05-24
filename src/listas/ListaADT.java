package listas;

import java.util.Iterator;

/**
 *
 * @author Armando Ibarrarán
 */
public interface ListaADT <T> extends Iterable<T>{
    public Iterator<T> iterator();
    public boolean isEmpty();
    public T quitaPrimero();
    public T quitaUltimo();
    public T quita(T dato);
    public String toString();
    public boolean contiene(T dato);
    public int calculaTamaño();
    public T consultaPrimero();
    public T consultaUltimo();
    
    
}
