package poo;

/*
* Armando Ibarraran
* 30/Ene/2022
* Esta clase modela un restaurante
*/

public class Restaurante {
    private String nombre;
    private int numMesas;
    private Cuadrado[] mesas;
    private final int MAX_MESAS=25;

    public Restaurante() {
        mesas=new Cuadrado[MAX_MESAS];
        numMesas=0;
    }
    
    public Restaurante(String nombre){
        this();
        this.nombre=nombre;
    }
    
    public boolean altaMesa(double lado){
        boolean res;
        
        if(numMesas<MAX_MESAS){
            mesas[numMesas]=new Cuadrado(lado);
            numMesas++;
            res=true;
        }else
            res=false;
        return res;
    }
    
    
    
    
}
