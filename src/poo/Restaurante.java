package poo;

import java.util.Objects;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumMesas() {
        return numMesas;
    }
    
    public int compareTo(Restaurante otro) {
        int res;
        
        if(nombre.equals(otro.nombre))
            res=0;
        else
            if(nombre.compareTo(otro.nombre)>0)
                res=123;
            else
                res=-321;
        return res;
    }
    
    public String toString(){
        StringBuilder str=new StringBuilder();
        
        str.append("\nRestaurante con nombre: ");
        str.append(nombre);
        str.append("\n       numero de mesas: ");
        str.append(numMesas);
        str.append("\nnúmero máximo de mesas: ");
        str.append(MAX_MESAS);
        str.append("\n                 mesas: [");
        for(int i=0; i<numMesas; i++)
            str.append(mesas[i].toString());
        str.append("\n]");
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Restaurante other = (Restaurante) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    public double metrosCuadradosTela() {
        double res=0;
        
        for(int i=0; i<numMesas; i++)
            res+=mesas[i].calculaArea();
        return res;
    }
    
    public double metrosPuntilla() {
        double res=0;
        
        for(int i=0; i<numMesas; i++)
            res+=mesas[i].calculaPerimetro();
        return res;
    }
}
