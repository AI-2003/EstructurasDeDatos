package enlazadas;

import java.util.Iterator;

/**
 *
 * @author Armando Ibarrarán
 */
public class EstructurasEnlazadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int suma;
        EE<Integer> e1;
        boolean may20, esta18;
        Iterator<Integer> it;
        
        e1 = new EE();
        System.out.println("EE vacia: "+e1);
        e1.agregaInicio(12);
        e1.agregaInicio(3);
        e1.agregaInicio(10);
        e1.agregaInicio(43);
        System.out.println("\nEE con 4 datos: \n"+e1);
        
        suma=0;
        for(Integer num: e1) //Posible gracias al iterator
            suma+=num;
        System.out.println("\nLa suma es: "+suma);
        
        e1.agregaFinal(3333);
        System.out.println("\nEE luego de agregar al final: \n"+e1);
        
        may20=false;
        it=e1.iterator();
        while(it.hasNext() && !may20)
            may20=it.next()>20;
        if(may20)
            System.out.println("\nSí hay algún dato mayor a 20");
        
        
        esta18=false;
        it=e1.iterator();
        while(it.hasNext() && !esta18)
            esta18=it.next()==18;
        if(esta18)
            System.out.println("\nSí está el 18");
        else
            System.out.println("\nNo está el 18");
    }
    
    
}
