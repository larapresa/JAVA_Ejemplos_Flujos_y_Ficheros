package Ejemplo_Serializacion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author larapresa
 *
 * Este ejemplo muestra la serialización de objetos para escribir en un flujo de
 * datos con destino un fichero
 *
 * Pero se podría haber utilizado cualquier otro tipo de canal (por ejemplo para
 * enviar un objeto Java desde un servidor web hasta una máquina cliente). En
 * aplicaciones distribuidas los objetos serializables nos permitirán mover
 * estructuras de datos entre diferentes máquinas sin que el desarrollador tenga
 * que preocuparse de la codificación y transmisión de los datos.
 * 
 * Podemos realizar esto porque la clase Punto2D implementa la interfaz SERIALIZABLE
 *
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ejemplo_Serializacion_Objetos {

    public static void main(String[] args) {

        //-----------------------------------------------
        // ESCRITURA A FICHERO DE UN OBJETO SERIALIZABLE
        //-----------------------------------------------
        // Instanciamos un objeto 
        Punto2D p = new Punto2D(1, 2);
        // Declaramos un ObjectOutputStream
        ObjectOutputStream fichEscribir = null;

        // Escribimos el objeto en el fichero ficheroPuntos.dat
        try {
            FileOutputStream fos = new FileOutputStream("ficheroPuntos.dat");
            // Instanciamos el flujo ObjectOutputStream asociando el fichero
            fichEscribir = new ObjectOutputStream(fos);
            // Escribimos el objeto con el método writeObject
            // La serialización se hace automáticamente, 
            // no tenemos que gestionar el contenido del objeto
            fichEscribir.writeObject(p);
        } catch (FileNotFoundException e) {
            System.out.println("Error. no se encuentra el fichero");
        } catch (IOException e) {
            System.out.println("Error E/S: " + e.getMessage());
        } finally {
            try {
                if (fichEscribir != null) {
                    fichEscribir.close();
                }
            } catch (IOException ex) {
                System.out.println("Error al cerrar fichero: " + ex.getMessage());

            }
        }//finally
        
        //---------------------------------------------------
        // LECTURA DESDE UN FICHERO DE UN OBJETO SERIALIZABLE
        //----------------------------------------------------
        ObjectInputStream fichLeer = null;
        try { // leemos el fichero de objetos
            boolean hayaDatos = true;
            Punto2D punto;
            // Instanciamos el flujo ObjectInputStream asociando el fichero
            fichLeer = new ObjectInputStream(new FileInputStream("ficheroPuntos.dat"));
            System.out.println("\nLos datos de los puntos recuperados del fichero son: ");
            while (hayaDatos) {
                try {
                    // Leemos el objeto con el método readObject
                    punto = (Punto2D) fichLeer.readObject();
                    System.out.println(punto);
                } catch (EOFException e) {
                    hayaDatos = false; //Salimos del bucle al terminar de recorrer el fichero }
                }
                System.out.println("Fichero recorrido completamente");
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fichLeer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }// main
}//class
