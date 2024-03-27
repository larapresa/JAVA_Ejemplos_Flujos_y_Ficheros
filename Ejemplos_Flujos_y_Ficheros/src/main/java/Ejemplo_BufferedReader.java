/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author larapresa
 * 
 */
public class Ejemplo_BufferedReader {

    public static void main(String[] args) throws IOException {
        String cadena;
        File fich = new File("fichero.txt");
        try {
            BufferedReader flujo = new BufferedReader(new FileReader(fich));
            if (fich.exists()) {
                System.out.println("\nEsta es la información que contiene el fichero: ");
                cadena = flujo.readLine();
                while (cadena != null) {
                    System.out.println(cadena);
                    cadena = flujo.readLine();
                }
            }
        } catch (FileNotFoundException e) { System.out.println ("Fichero no encontrado. ");}
    }
}
