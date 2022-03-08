package poo;

/*
* Armando Ibarraran
* 09/Feb/2022
* Esta es una clase para representar una empresa con distintos tipos de empleados
*/

public class Empresa {
    private String nombre;
    private String nombreDueño;
    private Empleado[] empleados;
    private int numEmpleados;
    private int maxEmpleados;
    
    public Empresa(int maxEmpleados){
        numEmpleados=0;
        empleados=new Empleado[maxEmpleados];
        this.maxEmpleados=maxEmpleados;
    }

    public Empresa(String nombre, String nombreDueño, int maxEmpleados) {
        this(maxEmpleados);
        this.nombre = nombre;
        this.nombreDueño = nombreDueño;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }
    
    private boolean altaEmpleado(Empleado e){
        boolean res;
        
        if(numEmpleados<maxEmpleados){
            empleados[numEmpleados]=e;
            numEmpleados++;
            res=true;
        }else
            res=false;
        return res;
    }
    
    public boolean altaEmpleado(String nombreEmpleado, double sueldoBase, String departamento, String teléfono){
        
        return altaEmpleado(new Administrativo(nombreEmpleado, sueldoBase, departamento, teléfono));
    }
    
    public boolean altaEmpleado(String nombreEmpleado, double sueldoBase, int horasExtra){
        
        return altaEmpleado(new Operario(nombreEmpleado, sueldoBase, horasExtra));
    }
    
    private String reporteEmp(String tipoEmp){
        StringBuilder str=new StringBuilder();
        
        for(int i=0; i<numEmpleados; i++){
            if(empleados[i].getClass().getSimpleName().equals(tipoEmp)){
                str.append("\n");
                str.append(empleados[i].getNombreEmpleado());
                str.append("\t");
                str.append(empleados[i].getSueldoBase());
            }
        }
        if(str.isEmpty()){
            str.append("No se encontró ningún ");
            str.append(tipoEmp);
        }
        return str.toString();
    }
    
    public String reporteAdmins(){
        
        return reporteEmp("Administrativo");
    }
    
    public String reporteOperarios(){
        
        return reporteEmp("Operario");
    }
    
    //Pendiente
    /* private int buscaEmpleado(Empleado e){
        int ini, fin, pos;
        
        ini=0;
        fin=numEmpleados-1;
        pos=(fin+ini)/2;
        while(ini<=fin && !empleados[pos].equals(e)){
            
        }
        
    }
    
    public boolean aumentoAdmin(int clave, double porcentajeAumento){
        boolean res;
        int pos;
        
        pos=buscaEmpleado(new Administrativo(clave));
        if(pos>=0){
            empleados[pos].sueldoBase*=porcentajeAumento/100;
            res=true;
        }else
            res=false;
        return res;
    } */
    
    
}
