package colas;

/**
 *
 * @author Armando Ibarrarán
 */
public class ColaA <T> implements ColaADT<T>{
    
    private T[] cola;
    private int inicio;
    private int fin;
    private final int MAX=20;
    
    public ColaA() {
        cola = (T[]) new Object[MAX];
        inicio=-1;
        fin=-1;
    }
    
    public ColaA(int max) {
        cola = (T[]) new Object[max];
        inicio=-1;
        fin=-1;
    }

    public void agrega(T dato) {
        if(estaVacia())
            inicio=0;
        else
            if((fin+1)%cola.length == inicio)
                expande();
        fin=(fin+1)%cola.length;
        cola[fin]=dato;
    }
    
    private void expande(){
        int tam;
        T[] masGrande;
        
        tam=cola.length;
        masGrande=(T[]) new Object[tam*2];
        for(int i=0; i<tam; i++)
            masGrande[i]=cola[(inicio+i)%tam];
        cola=masGrande;
        inicio=0;
        fin=tam-1;
        
    }

    public T quita(T dato) {
        T res;
        
        if(estaVacia())
            throw new RuntimeException("La cola está vacía");
        res=cola[fin];
        if(inicio==fin){
            inicio=-1;
            fin=-1;
        }else
            inicio=(inicio+1)%cola.length;
        return res;
    }

    public boolean estaVacia() {
        
        return fin==-1;
    }

    public T consultaPrimero() {
        
        if(estaVacia())
            throw new RuntimeException("La cola está vacía");
        return cola[inicio];
    }
    
    public String toString(){
        String res="";
        
        return res;
    }
}
