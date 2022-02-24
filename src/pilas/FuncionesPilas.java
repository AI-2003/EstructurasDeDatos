package pilas;

import java.util.ArrayList;

/*
* Armando Ibarraran
* 23/Feb/2022
* Esta clase contiene métodos que funcionan con pilas
*/
public class FuncionesPilas {
    
    public static int length(PilaA pila){
        PilaA helper;
        int len;
        
        helper=new PilaA();
        len=0;
        while(!pila.isEmpty()){
            helper.push(pila.pop());
            len++;
        }
        while(!helper.isEmpty())
            pila.push(helper.pop());
        return len;
    }
    
    public static <T> void invierte(PilaA<T> pila){
        ArrayList <T> elementos = new ArrayList(); 
        
        while(!pila.isEmpty())
            elementos.add(pila.pop());
        for(int i=0; i<elementos.size(); i++)
            pila.push(elementos.get(i));        
    }
    
    public static <T> void quitaRepetidos(PilaA<T> pila){
        T[] arr;
        T obj;
        int cantObj, i;
        
        arr=(T[]) new Object[length(pila)];
        cantObj=0;
        while(!pila.isEmpty()){
            obj=pila.pop();
            i=0;
            while(i<arr.length && !obj.equals(arr[i]))
                i++;
            if(i==arr.length){
                arr[cantObj]=obj;
                cantObj++;
            }
        }
        for(int j=cantObj-1; j>0; j--)
            pila.push(arr[j]);
    }
    
    public static <T> void quitaRepetidosConsecutivos(PilaA<T> pila){
        int cantObj, pilaLength;
        T[] arr;
        T obj;
        
        cantObj=0;
        pilaLength=length(pila);
        arr=(T[]) new Object[pilaLength];
        for(int i=0; i<pilaLength-2; i++){
            obj=pila.pop();
            if(!obj.equals(pila.peek())){
                arr[cantObj]=obj;
                cantObj++;
            }
        }
        for(int i=0; i<cantObj; i++)
            pila.push(arr[i]);
    }
    
    public static void main(String[] args){
        PilaA p=new PilaA();
        
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(1);
        p.push(5);
        p.push(6);
        p.push(3);
        p.push(7);
        p.push(2);
        
        System.out.println(length(p));
        quitaRepetidos(p);
        System.out.println(length(p));
        System.out.println(p.peek());
        
    }
}
