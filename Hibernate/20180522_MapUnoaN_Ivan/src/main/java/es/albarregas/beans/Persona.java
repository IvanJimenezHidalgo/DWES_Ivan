package es.albarregas.beans;

import java.io.Serializable;
import java.util.List;

public class Persona implements Serializable{

    private int idPersona;
    private String nombre;
    private List<Libro> libros;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
}
