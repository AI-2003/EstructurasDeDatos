package poo;

/*
* Armando Ibarraran
* 09/Feb/2022
* Esta es una clase abstracta para representar un empleado
*/

public abstract class Empleado {
    
    private static int serie  = 100;
    private int claveEmpleado;
    private String nombreEmpleado;
    protected double sueldoBase;
    
    protected Empleado() {
        claveEmpleado=serie;
        serie++;
    }
    
    protected Empleado(int clave){
        claveEmpleado=clave;
    }
    
    protected Empleado(String nombreEmpleado, double sueldoBase) {
        this();
        this.nombreEmpleado=nombreEmpleado;
        this.sueldoBase=sueldoBase;
    }
    
    public double getSueldoBase() {
        return sueldoBase;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        
        str.append("\nEmpleado con clave: ");
        str.append(claveEmpleado);
        str.append("\n            nombre: ");
        str.append(nombreEmpleado);
        str.append("\n            sueldo: ");
        str.append(sueldoBase);
        return str.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean res;
    
        if(obj!=null && obj instanceof Empleado)
            res=this.claveEmpleado==((Empleado)obj).claveEmpleado;
        else
            res=false;
        return res;
    }
    
    public abstract double calculaSalario(double prestac, double deduc); 
}