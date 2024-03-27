
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author larapresa
 */
public class Ejemplo_FileInputStream {

    public static void main(String args[]) throws IOException {
        int c;
        try {
            //Se puede poner / o \\
            FileInputStream f = new FileInputStream("Text.txt");
            /* Al poner / va a buscar el fichero en la raíz del disco donde está
            * el proyecto. Si no se pone la /, busca el fichero en la carpeta
            * donde está ahora mismo
            */
            while ((c = f.read()) != -1) { // El caracter -1 indica fin de fichero
                System.out.print((char) c); // Si no hacemos el cast a char visualizaríamos el código ASCII de cada caracter
                //System.out.print(c);// Puede probarlo descomentando esta línea
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe. ");
        }
    }

}
