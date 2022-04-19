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
        
        //Con recursividad: 
        //  return contiene(dato, 0);
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
    
    public T elimina(T dato){
        T res;
        int pos;
        
        pos=busSec(dato);
        if(pos>=0){
            res=coleccion[pos];
            corrimientoIzq(pos);
            cardinalidad--;
        }else
            res=null;
        return res;
    }
    
    private void corrimientoIzq(int pos){
        
        for(int i=pos; i<cardinalidad-1; i++)
            coleccion[i]=coleccion[i+1];
    }
    
    private void expande(){
        T[] aux;
        
        aux = (T[]) new Object[coleccion.length*2];
        
        //Con recursividad:
        //  expande(aux, 0);
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
    
    public String toString(){
        StringBuilder str;
        
        str=new StringBuilder();    
        return toString(0, str);
    }
    
    private String toString(int indx, StringBuilder str){
        if(indx<cardinalidad){
            str.append(coleccion[indx]).append("\n");
            return toString(indx+1,str);
        }
        else
            return str.toString();
    }

    public ConjuntoADT<T> union(ConjuntoADT<T> otro) {
        ConjuntoA<T> conjUnion = new ConjuntoA(this.cardinalidad);
        
        copiaArreglo(0, conjUnion);
        Iterator<T> it=otro.iterator();
        while(it.hasNext())
            conjUnion.agrega(it.next());
        return conjUnion;
    }
    
    private void copiaArreglo(int i, ConjuntoA<T> conjUnion) {
        
        if(i<cardinalidad){
            conjUnion.coleccion[i]=coleccion[i];
            copiaArreglo(i+1, conjUnion);
        }
    }
    
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro){
        ConjuntoA<T> conjInter;
        
        if(this.cardinalidad<otro.getCardinalidad()){
            conjInter=new ConjuntoA(this.cardinalidad);
            interseccion(this.iterator(), otro, conjInter);
        }else{
            conjInter=new ConjuntoA(otro.getCardinalidad());
            interseccion(otro.iterator(), this, conjInter);
        }
        return conjInter;
    }
    
    private void interseccion(Iterator<T> it, ConjuntoADT<T> conj, ConjuntoA<T> conjInter){
        T obj;
        int i;
        
        i=0;
        while(it.hasNext()){
            obj=it.next();
            if(conj.contiene(obj)){
                conjInter.coleccion[i]=obj;
                i++;
            }
        }
        conjInter.cardinalidad = i;
    }
    
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro){
        ConjuntoA<T> conjDif = new ConjuntoA(this.cardinalidad);
        
        diferencia(0, otro, conjDif);
        return conjDif;
    }
    
    private void diferencia(int i, ConjuntoADT<T> otro, ConjuntoA<T> conjDif){
        
        if(i<cardinalidad){
            if(!otro.contiene(this.coleccion[i])){
                conjDif.coleccion[conjDif.cardinalidad]=this.coleccion[i];
                conjDif.cardinalidad++;
            }
            diferencia(i+1, otro, conjDif);
        }
    }

    public Iterator<T> iterator() {
        return new IteradorArreglo(coleccion, cardinalidad);
    }
}
