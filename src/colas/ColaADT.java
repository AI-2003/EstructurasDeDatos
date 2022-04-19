package colas;

/**
 *
 * @author Armando Ibarrarán
 */
public interface ColaADT <T>{
    public void agrega(T dato);
    public T quita(T dato);
    public boolean estaVacia();
    public T consultaPrimero();
}
