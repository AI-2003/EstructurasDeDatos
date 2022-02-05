package poo;

/*
* Armando Ibarraran
* 04/Feb/2022
* Esta clase modela un alumno
* Está hecha conforma las indicaciones de la maesra Silvia Guardati
*/

public class Alumno {
    private static int serie=100;
    private int claveUnica;
    private String nombreAlum;
    private double[] califMateriasAprob;
    private int totalCalif;
    private final int MAX_CALIF=50;
    
    public Alumno(String Alum){
        claveUnica=serie;
        serie++;
        totalCalif=0;
        califMateriasAprob=new double[MAX_CALIF];
        this.nombreAlum=nombreAlum;
    }
    
    public boolean altaCalificación(double calif){
        boolean res;
        
        if(totalCalif<MAX_CALIF && calif>=6 && calif<=10){
            califMateriasAprob[totalCalif]=calif;
            totalCalif++;
            res=true;
        }else
            res=false;
        return res;
    }

    public String getNombreAlum() {
        return nombreAlum;
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
        final Alumno other = (Alumno) obj;
        return this.claveUnica == other.claveUnica;
    }
    
    public int compareTo(Alumno otro){
        int res;
        
        if(nombreAlum.equals(otro.nombreAlum))
            res=0;
        else
            if(nombreAlum.compareTo(otro.nombreAlum)>0)
                res=1212;
            else
                res=-1212;
        return res;
    }

    public String toString(){
        StringBuilder str=new StringBuilder();
        
        str.append("\n              Alumno con clave única: ");
        str.append(claveUnica);
        str.append("\n                              nombre: ");
        str.append(nombreAlum);
        str.append("\ncalificaciones de materias aprobadas: [");
        for(int i=0; i<totalCalif; i++){
            str.append("\n\t");
            str.append(califMateriasAprob);
        }
        str.append("\n]");
        return str.toString();
    }
    
    public double calculaPromedio(){
        double res=0;

        if(totalCalif>0){
            for(int i=0; i<totalCalif; i++)
                res+=califMateriasAprob[i];
            res/=totalCalif;
        }
        return res;
    }
}
