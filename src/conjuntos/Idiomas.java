package conjuntos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Armando Ibarraran
 */
public class Idiomas{
    
    private static <T> T[] leerNombres(String nomArch, int numIdiomas){
        File dB;
        int splitPos, conj;
        String data, nom, idiom;
        Object[] res;
        ConjuntoA<String>[] conjs;
        ArrayList<String> idiomas;
                
        dB=new File(nomArch);
        try(Scanner lec = new Scanner(dB);){
            res=new Object[2];
            conjs=new ConjuntoA[numIdiomas];
            for(int i=0; i<numIdiomas; i++)
                conjs[i]=new ConjuntoA();
            idiomas=new ArrayList();
            while(lec.hasNext()){
                data=lec.nextLine();
                splitPos=data.indexOf(',');
                idiom=data.substring(0, splitPos);
                nom=data.substring(splitPos+1, data.length());
                if(!idiomas.contains(idiom))
                    idiomas.add(idiom);
                conjs[idiomas.indexOf(idiom)].agrega(nom);
            }
            res[0]=conjs;
            res[1]=idiomas;
        }catch(FileNotFoundException e){
            System.out.println("No se encontró el archivo");
            res=null;
        }
        return (T[]) res;
    }
    
    public static void alumnosQueDominan(int numIdiomas, String nomArch, String[][] idiomas){
        Object[] arch;
        ArrayList<String> idiomasArch;
        ConjuntoA<String>[] conjsArch;
        ConjuntoADT<String> inter;
        int pos;
        
        arch=leerNombres(nomArch, numIdiomas);
        idiomasArch=(ArrayList<String>)arch[1];
        conjsArch=(ConjuntoA<String>[]) arch[0];
        for(int i=0; i<idiomas.length; i++){
            inter=conjsArch[idiomasArch.indexOf(idiomas[i][0])];
            for(int k=1; k<idiomas[i].length; k++){
                pos=idiomasArch.indexOf(idiomas[i][k]);
                inter=inter.interseccion(conjsArch[pos]);
            }
            System.out.println(inter.toString());
        }
    }
    
    public static void main(String[] args){
        String[][] idiomas = {{"ingles","frances"},{"ingles","chino"},{"chino","frances"}};
        
        alumnosQueDominan(4, "src/conjuntos/idiomas.txt", idiomas);
    }
}
