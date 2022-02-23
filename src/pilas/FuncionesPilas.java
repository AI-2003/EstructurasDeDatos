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
    
    public static PilaA invierte(PilaA pila){
        PilaA invertida;
        
        invertida=new PilaA();
        while(!pila.isEmpty())
            invertida.push(pila.pop());
        return invertida;
    }
}
