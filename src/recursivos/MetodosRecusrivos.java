package recursivos;

import java.util.ArrayList;

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
    
    public static double sumaPorRenglon(double[][] mat, int n, int ren){
        
        if(n-1<0)
            return 0;
        else
            return mat[ren][n-1]+sumaPorRenglon(mat, n-1, ren);
    }
    
    public static <T> String toString(T[][] mat, int m, int n){
        
        return toString(mat, 0, 0, m, n);
    }
    
    private static <T> String toString(T[][] mat, int m, int n, int totR, int totC) {
        if(m==totR)
            return "";
        else
            if(n==totC)
                return "\n"+toString(mat,m+1,0,totR,totC);
            else
                return mat[m][n]+toString(mat,m,n+1,totR,totC)+" ";
    }
    
    public static int fib(int n){
        int[] fibs;
        
        fibs=new int[n+1];
        fibs[0]=0;
        fibs[1]=1;
        return fib(fibs, n);
    }
    
    private static int fib(int[] fibs, int n){
        if(fibs[n]==0&&n!=0)
            return fib(fibs, n-1) + fib(fibs, n-2);
        else
            return fibs[n];
    }
    
    public static <T> ArrayList primerosN(T[] arr, int tot, int n){
        ArrayList list;
        
        if(arr.length==0 || tot<0 || n<0){
            throw new RuntimeException("Parámetros inválidos");
        }
        list=new ArrayList();
        return primerosN(arr, tot, n-1, list);
    }
    
    private static <T> ArrayList primerosN(T[] arr, int tot, int n, ArrayList list) {
        if(n==0)
            list.add(arr[n]);
        else{
            primerosN(arr, tot, n-1, list);
            list.add(arr[n]);
        }
        return list;
    }
    
    
    
    public static void main(String[] args){
        Integer[] arr={1,2,3,4,5,6,7,8,9,10};
        
        System.out.println(primerosN(arr, 10, 8).toString());
    }
}
