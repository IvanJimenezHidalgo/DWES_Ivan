/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ivan
 */
@Entity
@Table(name = "pais1a1anotbidi")
public class Pais implements Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idPais")
    private int idPais;
    @Column(name = "nombrePais", length = 30, nullable=false)
    private String nombrePais;
    @OneToOne(mappedBy = "pais")
    private Presidente presidente;
    
    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public Presidente getPresidente() {
        return presidente;
    }

    public void setPresidente(Presidente presidente) {
        this.presidente = presidente;
    }

    
}
