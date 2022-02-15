package poo;

import java.util.Objects;

/*
* Armando Ibarraran
* 04/Feb/2022
* Esta clase modela una escuela con un arreglo de alumnos
*/

public class Escuela {
    private String nombre;
    private String dirección;
    private int numAlumnos;
    private Alumno[] alumnos;
    private final int MAX_ALUMNOS=50;
    
    public Escuela() {
        numAlumnos=0;
        alumnos=new Alumno[MAX_ALUMNOS];
    }
    
    public Escuela(String nombre, String dirección) {
        this();
        this.nombre=nombre;
        this.dirección=dirección;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public int getMAX_ALUMNOS() {
        return MAX_ALUMNOS;
    }

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
        final Escuela other = (Escuela) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
    
    public int compareTo(Escuela otra){
        int res;
        
        if(nombre.equals(otra.nombre))
            res=0;
        else
            if(nombre.compareTo(otra.nombre)>0)
                res=1212;
            else
                res=-1212;
        return res;
    }
    
    public String toString() {
        StringBuilder str=new StringBuilder();
        
        str.append("\n      Escuela con nombre: ");
        str.append(nombre);
        str.append("\n               dirección: ");
        str.append(dirección);
        str.append("\nnúmero máximo de alumnos: ");
        str.append(MAX_ALUMNOS);
        str.append("\nnúmero actual de alumnos: ");
        str.append(numAlumnos);
        str.append("\n                 alumnos: [");
        for(int i=0; i<numAlumnos; i++)
            str.append(alumnos[i].toString());
        str.append("\n ]");
        return str.toString();
    }
}
