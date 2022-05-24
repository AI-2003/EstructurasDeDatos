package listas;

/**
 *
 * @author Armando IBarrarán
 */
public class ListaOrdenada  <T extends Comparable<T>> extends Lista<T> implements ListaOrdenadaADT<T> {
    
    public ListaOrdenada(){
        super();
    }
    
    public void agrega(T dato){
        NodoDoble<T> nuevo, act;
        
        if(dato==null)
            throw new RuntimeException("Valor nulo.");
        nuevo=new NodoDoble(dato);
        if(isEmpty()){
            primero=nuevo;
            ultimo=nuevo;
        }else{
            if(dato.compareTo(ultimo.getDato())>0){
                ultimo.setSiguiente(nuevo);
                nuevo.setAnterior(ultimo);
                ultimo=nuevo;
            }else{
                if(dato.compareTo(primero.getDato())<0){
                    primero.setAnterior(nuevo);
                    nuevo.setSiguiente(primero);
                    primero=nuevo;
                }else{
                    act=primero;
                    while(act.getDato().compareTo(dato)<0)
                        act=act.getSiguiente();
                    nuevo.setSiguiente(act);
                    nuevo.setAnterior(act.getAnterior());
                    act.getAnterior().setSiguiente(nuevo);
                    act.setAnterior(nuevo);
                }
            }
        }
    }
    
    public boolean contiene(T dato){
        
        return contiene(primero, dato);
    }
    
    private boolean contiene(NodoDoble<T> act, T dato){
        boolean res;
        
        if(act==null)
            res=false;
        else
            if(act.getDato().equals(dato))
                res=true;
            else
                if(act.getDato().compareTo(dato)>0)
                    res=false;
                else
                    res=contiene(act.getSiguiente(), dato);
        return res;
    }
    
    public T quita(T dato){
        T res;
        NodoDoble<T> aux;
        
        res=null;
        if(!isEmpty() && (dato.compareTo(primero.getDato())>=0 && dato.compareTo(ultimo.getDato())<=0)){
            if(primero.getDato().equals(dato))
                res=quitaPrimero();
            else{
                if(ultimo.getDato().equals(dato))
                    res=quitaUltimo();
                else{
                    aux=primero.getSiguiente();
                    while(aux.getDato().compareTo(dato)<=0)
                        aux = aux.getSiguiente();
                    if(aux.getDato().equals(dato)){
                        res=aux.getDato();
                        aux.getAnterior().setSiguiente(aux.getSiguiente());
                        aux.getSiguiente().setAnterior(aux.getAnterior());
                        aux.setSiguiente(null);
                        aux.setAnterior(null);
                    }
                }
            }   
        }
        return res;
    }
    
}
