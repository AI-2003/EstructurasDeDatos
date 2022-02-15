package poo;

/*
* Armando Ibarraran
* 09/Feb/2022
* Esta es una clase para representar un administrativo heredero de un empleado
*/

public class Administrativo extends Empleado{
    private String departamento;
    private String teléfono;

    public Administrativo() {
        super();
    }
    
    public Administrativo(int clave){
        super(clave);
    }

    public Administrativo(String nombreEmpleado, double sueldoBase, String departamento, String teléfono) {
        super(nombreEmpleado, sueldoBase);
        this.departamento=departamento;
        this.teléfono=teléfono;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Administrativo{");
        sb.append("departamento=").append(departamento);
        sb.append(", tel\u00e9fono=").append(teléfono);
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public double calculaSalario(double prestac, double deduc){
        
        return sueldoBase+(sueldoBase*prestac/100)-(sueldoBase*deduc/100);
    }
}
