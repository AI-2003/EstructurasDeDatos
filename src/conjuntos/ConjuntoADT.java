package conjuntos;

import java.util.Iterator;

/**
 *
 * @author Armando Ibarrarán
 */
public interface ConjuntoADT <T> {
    
    public boolean agrega(T dato);
    public boolean contiene(T dato);
    public int getCardinalidad();
    public boolean estaVacio();
    public String toString();
    public ConjuntoADT<T> union(ConjuntoADT<T> otro);
    public Iterator<T> iterator();
    
    //Faltan métodos
}
