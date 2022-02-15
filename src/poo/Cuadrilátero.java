package poo;

/*
* Armando Ibarraran
* 12/Feb/2022
* Esta clase modela un círculo
*/


public abstract class Cuadrilátero implements FigGeométrica{
    private double lado1;
    private double lado2;
    private double lado3;
    private double lado4;

    public Cuadrilátero() {
    }

    public Cuadrilátero(double lado1) {
        this.lado1 = lado1;
        this.lado2 = lado1;
        this.lado3 = lado1;
        this.lado4 = lado1;
    }

    public Cuadrilátero(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado1;
        this.lado4 = lado2;
    }

    public Cuadrilátero(double lado1, double lado2, double lado3, double lado4) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.lado4 = lado4;
    }
    
    public double calculaÁrea(){
        return lado1*lado2;
    }
    
    public double calculaPerím(){
        return lado1+lado2+lado3+lado4;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public double getLado4() {
        return lado4;
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
        final Cuadrilátero other = (Cuadrilátero) obj;
        if (this.lado1 != other.lado1) {
            return false;
        }
        if (this.lado2 != other.lado2) {
            return false;
        }
        if (this.lado3 != other.lado3) {
            return false;
        }
        return this.lado4 == other.lado4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuadril\u00e1tero{");
        sb.append("lado1=").append(lado1);
        sb.append(", lado2=").append(lado2);
        sb.append(", lado3=").append(lado3);
        sb.append(", lado4=").append(lado4);
        sb.append('}');
        return sb.toString();
    }
    
    
}
