package listas;

/**
 *
 * @author Armando Ibarrarán
 */
public interface ListaOrdenadaADT <T extends Comparable<T>> extends ListaADT<T>{
    public void agrega(T dato);
    public T quita(T dato);
    public boolean contiene(T dato);
}
