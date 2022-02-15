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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Círculo other = (Círculo) obj;
        return Double.doubleToLongBits(this.radio) == Double.doubleToLongBits(other.radio);
    }

    @Override
    public double calculaÁrea() {
        
        return Math.PI*radio*radio;
    }

    @Override
    public double calculaPerím() {
        
        return Math.PI*2*radio;
    }
    
    
}
