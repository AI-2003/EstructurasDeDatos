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
    
    private static String intToBin(int num){
        String res;
        PilaA pila;
        
        res="";
        pila=new PilaA();
        while(num>0){
            pila.push(num%2);
            num/=2;
        }
        while(!pila.isEmpty())
            res+=pila.pop();
        return res;
    }
    
    public static boolean esPalindromo(String s){
        PilaA pila1, pila2;
        boolean res;
        
        pila1=new PilaA();
        pila2=new PilaA();
        for(int i=0; i<s.length()/2; i++){
            pila1.push(s.charAt(i));
            pila2.push(s.charAt(s.length()-1-i));
        }
        res=pila1.equals(pila2);
        return res;
    }
    
     public static void main(String[] args){
        System.out.println(esPalindromo("reconocer"));
    }
     
     
}
