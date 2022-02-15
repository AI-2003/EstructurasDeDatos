package poo;


/*
* Armando Ibarraran
* 12/Feb/2022
* Esta clase modela un círculo
*/

public class Círculo implements FigGeométrica{
    private double radio;

    public Círculo() {
    }

    public Círculo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res;
        
        if(obj!=null && obj instanceof Círculo && ((Círculo)obj).radio==this.radio)
            res=true;
        else
            res=false;
        return res;
    }

    @Override
    public double calculaÁrea() {
        
        return Math.PI*radio*radio;
    }

    @Override
    public double calculaPerím() {
        
        return Math.PI*2*radio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("C\u00edrculo{");
        sb.append("radio=").append(radio);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
