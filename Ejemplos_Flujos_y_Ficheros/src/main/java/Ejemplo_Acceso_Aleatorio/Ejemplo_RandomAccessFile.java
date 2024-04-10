/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplo_Acceso_Aleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author larapresa
 */

/**
 * Este programa demuestra el uso de la clase RandomAccessFile para escribir y leer datos en un archivo de acceso aleatorio.
 * El programa escribe un entero, un double y una cadena de caracteres en el archivo "datos.dat".
 * Luego, lee estos datos desde el archivo y los imprime en la consola.
 * El tamaño total de los datos escritos en el archivo es:
 * - 4 bytes para el entero
 * - 8 bytes para el double
 * - 26 bytes para la cadena de caracteres (considerando que cada carácter ocupa 2 bytes)
 */
public class Ejemplo_RandomAccessFile {
    public static void main(String[] args) {
        try {
            // Escribir datos en un archivo de acceso aleatorio
            RandomAccessFile raf = new RandomAccessFile("datos.dat", "rw");
            raf.writeInt(100);  // Escribir un entero (4 bytes)
            raf.writeDouble(3.141592);  // Escribir un double (8 bytes)
            raf.writeChars("Hello, world!");  // Escribir una cadena (26 bytes)
            raf.close();

            // Leer datos desde el archivo de acceso aleatorio
            raf = new RandomAccessFile("datos.dat", "r");
            raf.seek(0);  // Moverse al inicio del archivo
            int intValue = raf.readInt();  // Leer el entero (4 bytes)
            double doubleValue = raf.readDouble();  // Leer el double (8 bytes)
            
            // Leer la cadena (usando readChar() repetidamente para leer cada carácter)
            char[] charBuffer = new char[13]; // Se asume que la cadena tiene 13 caracteres (incluyendo el espacio y el signo de exclamación)
            for (int i = 0; i < charBuffer.length; i++) {
                charBuffer[i] = raf.readChar(); // Leer cada carácter (26 bytes en total)
            }
            String stringValue = new String(charBuffer); // Crear la cadena a partir de los caracteres

            raf.close();

            // Imprimir los datos leídos
            System.out.println("Entero: " + intValue);
            System.out.println("Double: " + doubleValue);
            System.out.println("String: " + stringValue);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

   
