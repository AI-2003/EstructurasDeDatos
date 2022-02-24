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
}
