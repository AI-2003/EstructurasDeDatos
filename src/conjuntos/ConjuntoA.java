package conjuntos;

import java.util.Iterator;

/**
 *
 * @author Armando Ibarrarán
 */
public class ConjuntoA <T> implements ConjuntoADT<T>{
    private int cardinalidad;
    private T[] coleccion;
    private final int MAX=20;
    
    
    
    public ConjuntoA(){
        coleccion = (T[]) new Object[MAX];
        cardinalidad = 0;
    }
    
    public ConjuntoA(int max){
        coleccion = (T[]) new Object[max];
        cardinalidad = 0;
    }
    
    public int getCardinalidad(){
        
        return cardinalidad;
    }
    
    public boolean estaVacio() {
        
        return cardinalidad == 0;
    }
    
    public boolean contiene(T dato){
        
        //Con recursividad
        //return contiene(dato, 0);
        return busSec(dato)>0;
    }
    
    private int busSec(T dato){
        int i;
        
        i=0;
        while(i<cardinalidad && !coleccion[i].equals(dato))
            i++;
        if(i==cardinalidad)
            i=-1;
        return i;
    }
    
    //Con recursividad
    private boolean contiene(T dato, int indx){
        if(indx == cardinalidad)
            return false;
        else
            if(coleccion[indx].equals(dato))
                return true;
            else
                return contiene(dato, indx+1);
    }
    
    public boolean agrega(T dato){
        boolean res;
        
        res=contiene(dato);
        if(!res){
            if(cardinalidad == coleccion.length)
                expande();
            coleccion[cardinalidad]=dato;
            cardinalidad++;
        }
        return res;
    }
    
    private void expande(){
        T[] aux;
        
        aux = (T[]) new Object[coleccion.length*2];
        
        //Con recursividad
        //expande(aux, 0);
        for(int i=0; i<cardinalidad; i++)
            aux[i]=coleccion[i];
        coleccion=aux;
    }
    
    //Con recursividad
    private void expande(T[] arr, int indx){
        if(indx<cardinalidad){
            arr[indx]=coleccion[indx];
            expande(arr, indx+1);
        }
    }

    @Override
    public ConjuntoADT<T> union(ConjuntoADT<T> otro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
