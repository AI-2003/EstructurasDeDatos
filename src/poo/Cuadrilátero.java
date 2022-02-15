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
    
    public abstract double calculaÁrea();
    
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
        boolean res;
        Cuadrilátero otro;
        
        res=false;
        if(obj!=null && obj instanceof Cuadrilátero){
            otro=(Cuadrilátero) obj;
            if(otro.lado1==this.lado1 && otro.lado2==this.lado2 && otro.lado3==this.lado3 && otro.lado4==this.lado4)
                res=true;
        }
        return res;
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
