/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author PalaHZ
 */
public class LeerRepositorioRA {
    private Scanner entrada;
    
    public void abrirArchivo(String ruta) throws FileNotFoundException{
        try{
            entrada = new Scanner(new File(ruta));
        }catch (FileNotFoundException e){
            System.out.println("Error al abrir archivo. "+e.getMessage());
            System.exit(1);
        }
    }
    
    public ArrayList<String> leer_informacion(String recursoAprendizaje){
        ArrayList<String> linea_partes = null;
        ArrayList<String> sinonimos = null;
        try {
            while (entrada.hasNext()){
                String linea = entrada.nextLine();
                linea_partes = new ArrayList<> (Arrays.asList(linea.split(",")));
                for (int i = 0; i < linea_partes.size();i++){
                    if (linea_partes.get(i).equals(recursoAprendizaje)){
                        sinonimos = new ArrayList<>();
                        sinonimos = linea_partes;
                        break;
                    }
                }
            }
        } catch (NoSuchElementException elementException){
            System.out.println("El archivo tiene un formato incorrecto. "+elementException.getMessage());
            entrada.close();
            System.exit(1);
        } catch (IllegalStateException e){
            System.out.println("Error al leer el archivo. "+e.getMessage());
            System.exit(1);
        }
        return sinonimos;
    }
}
