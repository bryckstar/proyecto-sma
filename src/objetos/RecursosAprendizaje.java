/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author PalaHZ
 */
public class RecursosAprendizaje {
    private int id_recurso = 0;
    private String titulo_recurso = "";
    private String detalle_recurso = "";
    private String enlace_recurso = "";
    private String categoria = "";
    private LeerRepositorioRA repositorio;

    public RecursosAprendizaje() {
    }
    
    public RecursosAprendizaje(int id_recurso, String titulo_recurso, String detalle_recurso, 
            String enlace_recurso, String categoria) {
        this.setId_recurso(id_recurso);
        this.setTitulo_recurso(titulo_recurso);
        this.setDetalle_recurso(detalle_recurso);
        this.setEnlace_recurso(enlace_recurso);
        this.setCategoria(categoria);
    }

    
    
    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public String getTitulo_recurso() {
        return titulo_recurso;
    }

    public void setTitulo_recurso(String titulo_recurso) {
        this.titulo_recurso = titulo_recurso;
    }

    public String getDetalle_recurso() {
        return detalle_recurso;
    }

    public void setDetalle_recurso(String detalle_recurso) {
        this.detalle_recurso = detalle_recurso;
    }

    public String getEnlace_recurso() {
        return enlace_recurso;
    }

    public void setEnlace_recurso(String enlace_recurso) {
        this.enlace_recurso = enlace_recurso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String sinResultados(String ruta){
        String datos = "";
        try{
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(ruta));
            datos = (String) read.readObject();
            read.close();
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return datos;
    }
    
    public ArrayList<String> buscarRA(String recursosAprendizaje) throws FileNotFoundException{
        repositorio = new LeerRepositorioRA();
        repositorio.abrirArchivo("Repositorio de RA.txt");
        ArrayList<String> lista = repositorio.leer_informacion(recursosAprendizaje);
        return lista;
    }
}
