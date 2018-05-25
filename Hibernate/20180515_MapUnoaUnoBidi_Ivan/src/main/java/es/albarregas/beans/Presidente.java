package es.albarregas.beans;

import java.io.Serializable;

public class Presidente implements Serializable{

    private int idPresi;
    private String nombrePresi;
    private Pais pais;

    public int getIdPresi() {
        return idPresi;
    }

    public void setIdPresi(int idPresi) {
        this.idPresi = idPresi;
    }

    public String getNombrePresi() {
        return nombrePresi;
    }

    public void setNombrePresi(String nombrePresi) {
        this.nombrePresi = nombrePresi;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    
}
