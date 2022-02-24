package pilas;
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
    
    public static void invierte(PilaA pila){
        PilaA helper1, helper2;
        
        helper1=new PilaA();
        helper2=new PilaA();
        while(!pila.isEmpty())
            helper1.push(pila.pop());
        while(!helper1.isEmpty())
            helper2.push(helper1.pop());
        while(!helper2.isEmpty())
            pila.push(helper2.pop());
    }
}
