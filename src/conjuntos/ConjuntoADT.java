package conjuntos;

import java.util.Iterator;

/**
 *
 * @author Armando Ibarrarán
 */
public interface ConjuntoADT <T> {
    
    public boolean agrega(T dato);
    public T elimina(T dato);
    public boolean contiene(T dato);
    public int getCardinalidad();
    public boolean estaVacio();
    public String toString();
    public ConjuntoADT<T> union(ConjuntoADT<T> otro);
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro);
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro);
    public Iterator<T> iterator();
    
    //Faltan métodos
}
