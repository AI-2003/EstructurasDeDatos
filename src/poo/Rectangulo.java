package poo;

/*
* Armando Ibarraran
* 09/Feb/2022
* Esta es una clase para representar un rectángulo
* Está hecha conforma las enseñanzas de la maestra Silvia Guardati
*/

public class Rectangulo extends Cuadrilátero{

    public Rectangulo() {
        super();
    }

    public Rectangulo(double base, double altura) {
        super(base,altura);
    }
    
    
    public double calculaÁrea(){
        
        return this.getLado1()*this.getLado2();
    }
}
