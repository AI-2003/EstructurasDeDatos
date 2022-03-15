package recursivos;

/**
 *
 * @author Armando Ibarrarán
 */
public class ArregloGenerico <T> {
    private T[] arreglo;
    private int total;
    private final int MAXIMO=10;
    
    public ArregloGenerico(){
        arreglo=(T[]) new Object[MAXIMO];
        total=0;
    }
    
    public ArregloGenerico(int max){
        arreglo=(T[]) new Object[max];
        total=0;
    }
    
    public boolean agrega(T elem){
        boolean res;
        
        if(total<arreglo.length){
            arreglo[total]=elem;
            total++;
            res=true;
        }
        else
            res=false;
        return res;
    }
    
    public String toString(){
        
        return toString(new StringBuilder(), 0);
    }
    
    private String toString(StringBuilder str, int i){
        return "Pendiente";
    }
}
