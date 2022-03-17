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
    
    public int busSec(T x){
        
        return busSec(total, x);
    }
    
    private int busSec(int n, T x){
        int res;
        
        if(arreglo[n-1].equals(x))
            res=n-1;
        else
            if(n==1)
                res=-1;
            else
                res=busSec(n-1,x);
        return res;
    }
    
    public static <Comparable <T>> int busBin(T x){
        
        return busBin(0,total,x);
    }
    
    private static <Comparable <T>> int busBin(int ini, int fin, T x){
        int pos,res;
        
        
        if(inicio<fin){
            pos=(fin+ini)/2;
            if(a[pos].equals(x))
                res=pos;
            else
                if(a[pos].compareTo(x)>0)
                    busBin(ini,pos,x);
                else
                    busBin(pos,fin,x);
        }else
            res=-inicio-1;
        return res;
    }
}
