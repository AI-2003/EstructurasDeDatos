package pilas;

/*
* Armando Ibarraran
* 21/Feb/2022
* Esta clase maneja cadenas con pilas
*/

public class RevisorCadenas {
    
    public static boolean analisisParentesis(String cadena){
        PilaA pila;
        boolean res;
        int i;
        
        pila=new PilaA();
        res=true;
        i=0;
        while(i<cadena.length() && res){
            if(cadena.charAt(i)=='(')
                pila.push('(');
            else
                if(cadena.charAt(i)==')')
                    if(pila.isEmpty())
                        res=false;
                    else
                        pila.pop();
            i++;
        }
        return res && pila.isEmpty();
    }
    
    public static String invierteCadena(String cadenaInicial){
        PilaA pila;
        StringBuilder cadenaInvertida;
        
        pila=new PilaA();
        cadenaInvertida=new StringBuilder();
        for(int i=0; i<cadenaInicial.length(); i++)
            pila.push(cadenaInicial.charAt(i));
        while(!pila.isEmpty())
            cadenaInvertida.append(pila.pop());
        return cadenaInvertida.toString();
    }
}