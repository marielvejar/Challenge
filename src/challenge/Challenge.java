package challenge;

import java.awt.Desktop;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.nio.file.*;
import java.util.stream.Collectors;

/**
 * @author Mariel Véjar Morales
 */
public class Challenge {

    public static void ejercicio1() throws IOException {
        // Generar números aleatorios y guardarlos en un archivo
        System.out.println("¿Cuántos números desea generar?");
        Scanner leer = new Scanner(System.in);
        int comando;
        comando = leer.nextInt();
        // Crear ruta y archivo datos.txt
        String ruta = "C:\\datos.txt";
        String contenido = "lalalala";
        FileOutputStream fos = null;
        try {
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(ruta);
            fos.write(contenido.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Random r = new Random();
        try {
            PrintWriter texto = new PrintWriter(ruta);
            int numeros[] = new int[comando];
            for (int i = 0; i < numeros.length; i++) {
                // de r sale números aleatorios hasta el 100
                numeros[i] = (int) (r.nextDouble() * 100);
                //Guarda los números en el archivo
                texto.println(numeros[i]);
            }
            texto.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Archivo guardado.");
        //Para abrir el archivo
        File archivo = new File(ruta);
        Desktop.getDesktop().open(archivo);
    }

    public void ejercicio2() throws FileNotFoundException, IOException {
        // Ordenar los números y crear un nuevo archivo
        String ruta2 = "C:\\datos2.txt";
        String contenido2 = "";
        FileOutputStream fos = null;
        try {
            File file = new File(ruta2);
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(ruta2);
            fos.write(contenido2.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Path ruta = Paths.get("C:\\datos.txt");
            PrintWriter texto2 = new PrintWriter(ruta2);
            //Aqui se guardaran los datos
            byte[] datos = Files.readAllBytes(ruta);
            //Crea una lista de clase
            List<String> allLines = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            //ahora a ordenar;
            List<Integer> lista = allLines.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            Collections.sort(lista);
            //Aqui se imprime al archivo datos2.txt
            texto2.print(lista);
            texto2.close();
        } catch (Exception e) {
            System.out.println("No se pudo encontrar el archivo");
        }
        System.out.println(
                "Nuevo archivo guardado.");
        File archivo = new File(ruta2);
        Desktop.getDesktop().open(archivo);
    }

    public void ejercicio3() throws IOException {
        //Busque un número dentro de tu archivo de números:
        Scanner lectura = new Scanner(System.in);
        System.out.println("Introudce el número que desea buscar");
        int numero = 0;
        try {
            Path ruta = Paths.get("C:\\datos.txt");
            byte[] datos = Files.readAllBytes(ruta);
            List<String> allLines = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            List<Integer> lista = allLines.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            // Para convertir Lista<Integer> a un arreglo de enteros
            int[] numeros = lista.stream().mapToInt(i -> i).toArray();
            numero = lectura.nextInt();
            // aqui se guardara el índice, para ver si dentro del arreglo el numero buscado existe
            int indice = -1;
            // Recorrer el arreglo para encontrar el número buscado
            for (int i = 0; i < numeros.length; i++) {
                if (numero == numeros[i]) {
                    indice = i;
                    System.out.println("El numero fue encontrado: " + numeros[i]);
                    break;
                }
            }
            if (indice < 0) {
                System.out.println("El número no fue encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Hubo un error :C");
        }
    }

    public void ejercicio4() throws FileNotFoundException {
        // Mostrar los números
        int leerNumeros;
        File nuevo = new File("c:/datos.txt");
        try ( Scanner entrada = new Scanner(nuevo)) {
            System.out.println("Los números del archivo datos.txt son:\n");
            while (entrada.hasNextInt()) {
                leerNumeros = entrada.nextInt();
                System.out.println(leerNumeros);

            }
        }
    }

}
