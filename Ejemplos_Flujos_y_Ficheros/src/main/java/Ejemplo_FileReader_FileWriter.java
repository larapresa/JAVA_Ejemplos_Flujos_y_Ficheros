

import java.io.*;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author larapresa
 */
/**
 * Este ejemplo muestra cómo emplear las clases FileReader y FileWriter con
 * ficheros de texto. 
 * Vamos a crear un fichero con FileWriter y escribiremos en él la cadena de texto leída por 
 * teclado. Después cerramos el fichero y lo abrimos como lectura con una instancia de FileReader
 */
public class Ejemplo_FileReader_FileWriter {

    public static void main(String args[]) throws IOException {
        String cadena;
        int codCaracter;
        char caracter;

        // Pedimos al usuario una frase
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nIntroduce una frase: ");
        cadena = teclado.nextLine();
        // *******************************************
        // Instanciamos un nuevo objeto FileWriter
        // Si el fichero no existe se crea
        // *****************************************
        FileWriter fichEsc = new FileWriter("nuevo.txt");
        // Con el método write escribimos la cadena de texto
        fichEsc.write(cadena);
        fichEsc.close(); // Cerramos el fichero 
        // Si no cerramos el fichero no podríamos abrirlo para lectura
        // *********************************************
        // Instanciamos un nuevo objeto FileReader 
        // para leer el fichero "nuevo.txt"
        // Si el fichero no existe o no es válido 
        // se lanza la excepción FileNotFoundException
        // *********************************************
        try {
            FileReader fichLect = new FileReader("nuevo.txt");
            cadena = "";
            // Leemos el fichero caracter a caracter
            // Sabemos que es final de fichero cuando el caracter es -1
            codCaracter = fichLect.read();
            while (codCaracter != -1) {
                caracter = (char) codCaracter;
                cadena = cadena + caracter;
                codCaracter = fichLect.read();
            }
            // Cerramos fichero
            fichLect.close();
            System.out.println("\nLa frase leída del fichero es: \"" + cadena + "\"");
        } catch (FileNotFoundException e) { // Lo ponemos dentro de un try-catch, pero en este caso 
            //siempre va a existir el fichero porque lo estamos creando lineas más arriba
        }

    }
}
