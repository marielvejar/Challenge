package challenge;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mariel Véjar Morales
 */
public class prueba {
    public static void main(String[] args) throws IOException {
       Challenge challenge1 =  new Challenge();
        System.out.println("A continuación, que desea realizar?\n"
                + "1. Generar números aleatorios y guardarlos\n"
                + "2. Ordenar los números aleatorios y guardarlos\n"
                + "3. Buscar un número dentro de los archivos\n"
                + "4. Mostrar los números\n"
                + "5. Salir");
        int opcion = new Scanner(System.in).nextInt();
        
        if(opcion == 1){
       challenge1.ejercicio1();
        }
         if(opcion == 2){
       challenge1.ejercicio2();
        }
          if(opcion == 3){
       challenge1.ejercicio3();
        }
           if(opcion == 4){
       challenge1.ejercicio4();
        }else{
               System.out.println("Fin del programa. Adios!");
               System.exit(0);
           }
    }
}
