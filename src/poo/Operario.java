package poo;

/*
* Armando Ibarraran
* 09/Feb/2022
* Esta es una clase para representar un operario heredero de un empleado
*/

public class Operario extends Empleado{
    private int horasExtra;

    public Operario() {
        super();
    }
    
    public Operario(int clave){
        super(clave);
    }

    public Operario(String nombreEmpleado, double sueldoBase, int horasExtra) {
        super(nombreEmpleado, sueldoBase);
        this.horasExtra=horasExtra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Operario{");
        sb.append("horasExtra=").append(horasExtra);
        sb.append('}');
        return sb.toString();
    }

    public double calculaSalario(double prestac, double deduc, double precioHE) {
        return sueldoBase+prestac+horasExtra*precioHE-deduc;
    }

    @Override
    public double calculaSalario(double prestac, double deduc) {
        return sueldoBase+prestac-deduc;
    }
    
}
