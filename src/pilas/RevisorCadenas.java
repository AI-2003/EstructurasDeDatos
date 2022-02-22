package pilas;

/*
* Armando Ibarraran
* 21/Feb/2022
* Esta clase confirma que una cadena tenga el mismo número de paréntesis que abren y cierran
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
    
    public static void main(String[] args){
        
        System.out.println(analisisParentesis("(((("));
    }
}