package pilas;

/*
* Armando Ibarraran
* 17/Feb/2022
* Esta clase crea una pila para que se pueda usar
*/

public class PilaA <T> implements PilaADT<T>{
    private T[] datosPila;
    private int tope;
    private final int MAXIMO=20;
    
    public PilaA() {
        datosPila= (T[]) new Object[MAXIMO];
        tope = -1; //Indica la pila vacía
    }

    @Override
    public void push(T dato) {
        if(tope==this.datosPila.length-1) //Pila esá llena
            expand();
        tope++;
        datosPila[tope]=dato;
    }
        
    private void expand(){
        T[] masGrande = (T[]) new Object[this.datosPila.length*2];
        
        for(int i=0; i<=tope; i++)
            masGrande[i]=datosPila[i];
        datosPila=masGrande;
    }

    @Override
    public T pop() {
        if(this.isEmpty())
            throw new ColeccionVaciaExcepcion("La pila está vacía");
        T resultado;
        
        resultado=this.datosPila[tope];
        this.datosPila[tope]=null;
        tope--;
        return resultado;
    }

    @Override
    public boolean isEmpty() {
        
        return tope==(-1);
    }

    @Override
    public T peek() {
        if(this.isEmpty())
            throw new ColeccionVaciaExcepcion("La pila está vacía");
        return this.datosPila[tope];
    }
    
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        
        for(int i=tope; i<=0; i--)
            str.append(datosPila[i]).append("\n");
        return str.toString();
    }
    
    public boolean equals(Object obj){
        boolean res;
        PilaADT<T> a, b, other;
        
        res=false;
        if(obj!=null && obj.getClass().equals(this.getClass())){
            a=new PilaA();
            b=new PilaA();
            other=(PilaA) obj;
            while(!other.isEmpty() && !isEmpty() && other.peek().equals(peek())){
                a.push(other.pop());
                a.push(pop());
            }
            if(other.isEmpty() && isEmpty())
                res=true;
            while(!a.isEmpty()){
                push(a.pop());
                other.push(a.pop());
            }
        }
        return res;
    }
}
