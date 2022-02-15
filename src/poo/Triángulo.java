package poo;


/*
* Armando Ibarraran
* 12/Feb/2022
* Esta clase modela un triángulo
*/

public class Triángulo implements FigGeométrica{
    private double lado1;
    private double lado2;
    private double lado3;
    
    public Triángulo(){
        
    }
    
    public Triángulo(double lado1, double lado2, double lado3){
        this.lado1=lado1;
        this.lado2=lado2;
        this.lado3=lado3;
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
    

    @Override
    public double calculaÁrea() {
        double s;
        
        s=calculaPerím()/2;
        return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }

    @Override
    public double calculaPerím() {
        return lado1+lado2+lado3;
    }
    
    public boolean esEquilátero() {
        return lado1==lado2 && lado1==lado3;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res;
        Triángulo otro;
        
        res=false;
        if(obj != null && obj instanceof Triángulo){
            otro=(Triángulo) obj;
            if(otro.lado1==this.lado1 && otro.lado2==this.lado2 && otro.lado3==this.lado3)
                res=true;
        }            
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tri\u00e1ngulo{");
        sb.append("lado1=").append(lado1);
        sb.append(", lado2=").append(lado2);
        sb.append(", lado3=").append(lado3);
        sb.append('}');
        return sb.toString();
    }


    
    
    
}
