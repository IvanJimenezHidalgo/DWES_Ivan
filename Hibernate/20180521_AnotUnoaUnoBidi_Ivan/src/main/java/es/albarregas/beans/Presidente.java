package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "presidente1a1anotbidi")
public class Presidente implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @GenericGenerator(name = "gen", strategy = "foreign", parameters=@Parameter(name="property",value="pais"))
    @Column(name = "idPresi")
    private int idPresi;
    @Column(name = "nombrePresi")
    private String nombrePresi;
    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
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
