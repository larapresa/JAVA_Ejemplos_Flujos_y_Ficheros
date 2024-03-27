
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author larapresa
 * 
 * La clase de Java BufferedWriter escribe texto en un flujo de caracteres de salida,
 * almacenando en búfer los caracteres para escribir de manera eficiente caracteres, 
 * matrices y cadenas. Puede pasar el tamaño del búfer al constructor como segundo argumento. 
 */
public class Ejemplo_BufferedWriter {
    public static void main(String[] args) {
        String[] list = {"uno", "dos", "tres", "cuatro"};
        try {
            File file = new File("fileBufferedWriter.txt");
            // instanciamos objeto FileWriter que conecte con el fichero
            // si el fichero no existe se crea
            FileWriter fileToWrite = new FileWriter(file); 
            // Conectamos FileWriter con BufferedWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileToWrite); 
            // Escribimos las cadenas del array en el fichero
            for (String s : list) {
                bufferedWriter.write(s + "\n"); // ponemos salto de línea (\n) entre ellas
            }

            bufferedWriter.close (); // Cerramos el stream
            fileToWrite.close(); // Cerramos FileWriter
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
