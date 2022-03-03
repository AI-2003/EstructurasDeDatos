package pilas;

/*
* Armando Ibarraran
* 17/Feb/2022
* Esta interface designa el comportamiento de una pila (estructura de dato)
*/

public interface PilaADT <T> {
    
    public void push(T dato);
    public T pop();
    public boolean isEmpty();
    public T peek();
    @Override
    public boolean equals(Object obj);
}
