package poo;

import java.util.Scanner;

/*
* Armando Ibarraran
* 15/Feb/2022
* Esta clase prueba la interface FigGeométricas
*/


public class Figuras {
    
    public static void main(String[] args){
        FigGeométrica[] figs;
        int numFigs, maxFigs, indMax, cantCuads, opt;
        double max;
        boolean askAgain;
        Scanner lec;
        
        maxFigs=10;
        figs=new FigGeométrica[maxFigs];
        
        /*figs[0]=new Cuadrado(10);
        figs[1]=new Rectangulo(16,9);
        figs[2]=new Triángulo(5,3,4);
        figs[3]=new Círculo(1/Math.sqrt(Math.PI));
        figs[4]=new Cuadrado(5);
        figs[5]=new Triángulo(5,5,5);
        figs[6]=new Círculo(3/Math.sqrt(Math.PI));
        figs[7]=new Rectangulo(10,19);
        figs[8]=new Círculo(2/Math.sqrt(Math.PI));
        figs[9]=new Triángulo(4,4,4);
        numFigs=10;*/
        
        //Menú para el usuario
        askAgain=true;
        lec=new Scanner(System.in);
        numFigs=0;
        while(askAgain && numFigs<maxFigs){
            System.out.println("\nInserte el número de la figura que quiere registrar: ");
            System.out.println("1) Cuadrado \n2) Rectángulo \n3) Triángulo \n4) Círculo");
            opt=lec.nextInt();
            switch (opt){
                case 1:
                    System.out.println("\nInserte la medida de los lados: ");
                    figs[numFigs]=new Cuadrado(lec.nextDouble());
                    numFigs++;
                    break;
                case 2:
                    System.out.println("\nInserte la medida de los lados: ");
                    figs[numFigs]=new Rectangulo(lec.nextDouble(), lec.nextDouble());
                    numFigs++;
                    break;
                case 3:
                    System.out.println("\nInserte la medida de los lados: ");
                    figs[numFigs]=new Triángulo(lec.nextDouble(), lec.nextDouble(), lec.nextDouble());
                    numFigs++;
                    break;
                case 4:
                    System.out.println("\nInserte la medida del radio: ");
                    figs[numFigs]=new Círculo(lec.nextDouble());
                    numFigs++;
                    break;
            }
            System.out.println("\n¿Registrar otra figura? (y/n)");
            if(!lec.next().equals("y"))       
                askAgain=false;
        }
        
        //Imrpime el tipo y el área de cada figura
        System.out.println("");
        for(int i=0; i<numFigs; i++)
            System.out.println(+i+": "+figs[i].getClass().getSimpleName()+" con área "+figs[i].calculaÁrea());
        
        //Encuentra el círculo más grande
        max=0;
        indMax=0;
        for(int i=0; i<numFigs; i++)
            if(figs[i] instanceof Círculo)
                if(figs[i].calculaPerím()>max){
                    max=figs[i].calculaPerím();
                    indMax=i;
                }
        if(max>0)
            System.out.println("\n"+indMax+": "+((Círculo)figs[indMax]).toString());
        
        //Cuenta cuantos cuadrados hay
        cantCuads=0;
        for(int i=0; i<numFigs; i++)
            if(figs[i] instanceof Cuadrado)
                cantCuads++;
        System.out.println("\nCantidad de cuadrados: "+cantCuads);
        
        //Elimina triángulos equiláteros
        for(int i=0; i<numFigs; i++)
            if(figs[i] instanceof Triángulo && ((Triángulo)figs[i]).esEquilátero()){
                System.out.println("Borrando: "+((Triángulo)figs[i]).toString());
                for(int k=i; k<numFigs-1; k++){
                    figs[k]=figs[k+1];
                }
                figs[numFigs-1]=null;
                numFigs--;
            }
         
        //Imprime otra vez las áreas
        System.out.println("");
        for(int i=0; i<numFigs; i++)
            System.out.println(+i+": "+figs[i].getClass().getSimpleName()+" con área "+figs[i].calculaÁrea());      
        
        //Usar tantos for-loops es inefciente, pero el fin de este main es unicamente probar, no ser una solución
    }
    
}
