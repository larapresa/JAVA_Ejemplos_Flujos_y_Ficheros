
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author larapresa
 * 
 * El siguiente ejemplo muestra cómo emplear tanto FileOutputStream como FileInputStream
 * Se muestra cómo acceder a un fichero con FileOutputStream y escribir desde el inicio 
 * o conservar su contenido realizando la escritura desde el final del fichero. 
 */
public class Ejemplo_FileOutputStream {

    public static void main(String args[]) throws IOException {
        int codCaracter;
        char caracter;

        Scanner teclado = new Scanner(System.in);
        // *************************************************************
        // OPCIÓN 1: Constructor de FileOutputStream sin append
        // El fichero se borra con su apertura y se escribe desde el inicio, 
        // eliminando el contenido previo
        // *************************************************************
        System.out.println("Introduce una frase:");
        String cadena = teclado.nextLine();
        try {
            // Instancia nuevo FileOutputStream, lo abre, borra contenido y  
            // comienza a escribir desde la primera posición        
            FileOutputStream f1 = new FileOutputStream("fichFileOutputStreamSobreescrito.txt ");
            // Escribimos caracter a caracter en el fichero
            for (int pos = 0; pos < cadena.length(); pos++) {
                f1.write(cadena.charAt(pos));
            }
            f1.write('\n');//Para separar las frases
            f1.close();
            System.out.println(" \nEl contenido del fichero es: ");
            FileInputStream f2 = new FileInputStream("fichFileOutputStreamSobreescrito.txt ");
            codCaracter = f2.read(); // leemos el código ascii
            while (codCaracter != -1) { // El final del fichero devuelve el caracter -1
                caracter = (char) codCaracter; // hay que hacer cast a caracter
                System.out.print(caracter);
                codCaracter = f2.read();
            }
            f2.close();
        } catch (FileNotFoundException e) {
        }
        // *************************************************************
        // OPCIÓN 2: Constructor de FileOutputStream con APPEND == true. 
        // Abrimos el fichero y nos situamos al final de él
        // de este modo no sobreescribimos el contenido previo
        // *************************************************************
        try {
            // Si queremos mantener el contenido del fichero 
            // tendríamos que llamar al siguiente constructor con append == true
            FileOutputStream f3 = new FileOutputStream("fichFileOutputStreamSinSobreescribir.txt ", true);
            // Escribimos caracter a caracter en el fichero
            for (int pos = 0; pos < cadena.length(); pos++) {
                f3.write(cadena.charAt(pos));
            }
            f3.write('\n');//Para separar las frases
            f3.close();
            System.out.println(" \nEl contenido del fichero sin sobreescribir es: ");
            FileInputStream f4 = new FileInputStream("fichFileOutputStreamSinSobreescribir.txt ");
            codCaracter = f4.read(); // leemos el código ascii
            while (codCaracter != -1) { // El final del fichero devuelve el caracter -1
                caracter = (char) codCaracter; // hay que hacer cast a caracter
                System.out.print(caracter);
                codCaracter = f4.read();
            }
            f4.close();
        } catch (FileNotFoundException e) {
        }
    }

}
