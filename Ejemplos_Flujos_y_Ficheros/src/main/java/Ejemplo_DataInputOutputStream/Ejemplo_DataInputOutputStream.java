/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplo_DataInputOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author larapresa
 */
public class Ejemplo_DataInputOutputStream {

    public static void main(String args[]) throws FileNotFoundException {
        int numInt;
        boolean booleano;
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
            teclado.nextLine();// leemos salto de linea
            escritTipos.writeInt(numInt);
            
            System.out.println("Inserta un número con decimales: ");
            numFloat = teclado.nextFloat();
            teclado.nextLine();// leemos salto de linea
            escritTipos.writeFloat(numFloat);
            
            System.out.println("Inserta un número entero:");
            numInt = teclado.nextInt();
            teclado.nextLine();// leemos salto de linea
            escritTipos.writeInt(numInt);
            
            System.out.println("Inserta un número con decimales: ");
            numFloat = teclado.nextFloat();
            teclado.nextLine();// leemos salto de linea
            escritTipos.writeFloat(numFloat);
           
            
            escritTipos.close();
            // -------------------------------------------
            //                 LECTURA
            // --------------------------------------------
            numInt = lectTipos.readInt();
            numFloat = lectTipos.readFloat();
            numInt = lectTipos.readInt();
            numFloat = lectTipos.readFloat();
            System.out.println(" \nLos datos leídos del fichero son: \n");
            System.out.println("Número entero:" + numInt + " Número decimal:" + numFloat + " Número entero:" + numInt + " Número decimal:" + numFloat );
            lectTipos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
