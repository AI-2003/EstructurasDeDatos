package poo;

/*
* Armando Ibarraran
* 30/Ene/2022
* Esta clase modela un rectanglo
*/

public class Cuadrado {
    private double lado;

    public Cuadrado() {
    }

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
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
        final Cuadrado other = (Cuadrado) obj;
        return Double.doubleToLongBits(this.lado) == Double.doubleToLongBits(other.lado);
    }

    @Override
    public String toString() {
        return "Cuadrado{" + "lado=" + lado + '}';
    }
    
    public double calculaArea() {
        return lado*lado;
    }
    
    public double calculaPerimetro() {
        return 4*lado;
    }
}
