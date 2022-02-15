package poo;

/*
* Armando Ibarraran
* 30/Ene/2022
* Esta clase modela un cuadrado
*/

public class Cuadrado extends Cuadrilátero{

    public Cuadrado() {
        super();
    }

    public Cuadrado(double lado) {
        super(lado);
    }
    
    @Override
    public double calculaÁrea(){
        
        return this.getLado1()*this.getLado1();
    }
    //Falta equals y area
}
