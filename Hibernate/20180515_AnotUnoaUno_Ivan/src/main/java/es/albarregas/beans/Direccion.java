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
import javax.persistence.Table;

@Entity
@Table(name = "direccion1a1anot")

public class Direccion implements Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idDirec")
    private int id;
    @Column(name = "calle", length = 30, nullable=false)
    private String calle;
    @Column(name = "numero", length = 2, nullable=false)
    private String numero;
    @Column(name = "poblacion", length = 30, nullable=false)
    private String poblacion;
    @Column(name = "provincia", length = 30, nullable=false)
    private String provincia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
}
