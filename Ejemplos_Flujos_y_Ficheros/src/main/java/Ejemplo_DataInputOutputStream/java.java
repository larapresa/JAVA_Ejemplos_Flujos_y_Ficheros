/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplo_DataInputOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 *
 * @author larapresa
 */
public class Ejemplo_DataInputOutputStream {

    public static void main(String args[]) throws FileNotFoundException {
        int numInt;
        String cadena;
        float numFloat;
        
        Scanner teclado = new Scanner(System.in);
        
        FileOutputStream fichEscrit = new FileOutputStream("prueba.dat");
        DataOutputStream escritTipos = new DataOutputStream(fichEscrit);
        FileInputStream fichLect = new FileInputStream("prueba.dat");
        DataInputStream lectTipos = new DataInputStream(fichLect);
        
        try {
            // -------------------------------------------
            //                 ESCRITURA
            // -------------------------------------------
            System.out.println("Inserta un número entero:");
            numInt = teclado.nextInt();
            escritTipos.writeInt(numInt);
            
            System.out.println("Inserta un número con decimales: ");
            numFloat = teclado.nextFloat();
            escritTipos.writeFloat(numFloat);
            
            System.out.println("Inserta una cadena:");
            cadena = teclado.nextLine();
            escritTipos.writeChars(cadena);
            
            escritTipos.close();
            // -------------------------------------------
            //                 LECTURA
            // --------------------------------------------
            numInt = lectTipos.readInt();
            numFloat = lectTipos.readFloat();
            cadena = lectTipos.readLine();
            System.out.println(" \nLos datos leídos del fichero son: \n");
            System.out.println("-**:" + numInt + "-**:" + numFloat + "-**:" + cadena);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
