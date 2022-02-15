package poo;

/*
* Armando Ibarraran
* 30/Ene/2022
* Esta clase modela un rectanglo
*/

public class Cuadrado extends Cuadrilátero{
    private double lado;

    public Cuadrado() {
        super();
    }

    public Cuadrado(double lado) {
        super(lado);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }
}
