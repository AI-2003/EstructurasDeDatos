package poo;

/*
* Armando Ibarraran
* 09/Feb/2022
* Esta es una clase para representar un rectángulo
* Está hecha conforma las enseñanzas de la maestra Silvia Guardati
*/

public class Rectangulo extends Cuadrilátero{
    private double base;
    private double altura;

    public Rectangulo() {
        super();
    }

    public Rectangulo(double base, double altura) {
        super(base,altura);
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
}
