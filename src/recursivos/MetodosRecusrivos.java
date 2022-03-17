package recursivos;

/**
 *
 * @author Armando Ibarrarán
 */
public class MetodosRecusrivos {
    
    //Mi versión
    public static int calcFactorial(int n){
        int res;
        
        if(n<0)
            throw new RuntimeException("Valor de factorial "+n+" inválido");
        if(n>1)
            res=n*(calcFactorial(n-1));
        else
            res=1;
        return res;
    }
    
    //Versión de la maestra
    public static int calcFactorialMaestra(int n){
        if(n==0||n==1)
            return 1;
        else
            return n*calcFactorialMaestra(n-1);
    }
    
    //Mi versión
    public static int sumaArreglo(int[] arr, int n){
        int res;
        
        res=arr[n-1];
        if(n!=1)
            res+=sumaArreglo(arr,n-1);
        return res;
    }
    
    //Versión de la maestra
    public static int sumaArregloMaestra(int[] arr, int n){
        
        if(n==0)
            return 0;
        else
            return arr[n-1]+sumaArregloMaestra(arr,n-1);
    }
    
    //Normalmente se evita utilizar prints
    //Aquí son utilizados para forzosamente usar recursividad
    public static void imprimeElemDI(int[] e, int n){
        
        if(n>0){
            System.out.print(e[n-1]+" ");
            imprimeElemDI(e, n-1);
        }
    }
    
    public static void imprimeElemID(int[] e, int n){
        
        if(n>0){
            imprimeElemID(e, n-1);
            System.out.print(e[n-1]+" ");
        }
    }
    
    
    
    public static void main(String[] args){
        System.out.println(calcFactorial(5));
        System.out.println(calcFactorialMaestra(5));
        
        int[] arr={5,10,15,20,25};
        System.out.println(sumaArreglo(arr, 5));
        System.out.println(sumaArregloMaestra(arr, 5));
        
        imprimeElemDI(arr,5);
        System.out.println();
        imprimeElemID(arr,5);
        System.out.println();
    }
}
