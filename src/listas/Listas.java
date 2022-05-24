package listas;

/**
 *
 * @author Armando Ibarrarán
 */
public class Listas {
    
    
    public static void main(String[] args){
        ListaOrdenada<Integer> l1;
        
        l1=new ListaOrdenada();
        
        System.out.println("\nLista vacía:\n"+l1);
        l1.agrega(20);
        System.out.println("\nLista:\n"+l1);
        l1.agrega(15);
        System.out.println("\nLista:\n"+l1);
        l1.agrega(23);
        System.out.println("\nLista:\n"+l1);
        l1.agrega(19);
        System.out.println("\nLista:\n"+l1);
        
        int sum=0;
        for(Integer elem: l1)
            sum+=elem;
        System.out.println("\nSuma:\n"+sum);
    }
}
