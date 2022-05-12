package enlazadas;

/**
 *
 * @author Armando Ibarrarán
 */
public class Nodo <T> {
    private T dato; 
    private Nodo<T> dir;

    public Nodo() {
        this.dir=null;
    }

    public Nodo(T dato) {
        this.dato = dato;
        this.dir=null;
    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> getDir() {
        return dir;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setDir(Nodo<T> dir) {
        this.dir = dir;
    }
    
    
    
    
    
    
    
    
    
}
