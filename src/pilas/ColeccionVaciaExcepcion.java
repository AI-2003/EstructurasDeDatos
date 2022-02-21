package pilas;

/*
* Armando Ibarraran
* 17/Feb/2022
* Esta clase es hija de RuntimeException y está creada para poder arrojar excepciones
*/

public class ColeccionVaciaExcepcion extends RuntimeException{

    public ColeccionVaciaExcepcion() {
        super();
    }

    public ColeccionVaciaExcepcion(String message) {
        super(message);
    }
    
    
    
}
