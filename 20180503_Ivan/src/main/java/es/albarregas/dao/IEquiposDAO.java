package es.albarregas.dao;

import es.albarregas.beans.Equipo;
import java.util.ArrayList;

public interface IEquiposDAO {

    public void addEquipo(Equipo equipo);
    public Equipo getEquipo(String idequipo);
    public ArrayList<Equipo> getEquipos();
    public ArrayList<Equipo> getEquiposSinAlumno();
    public void updateEquipo(Equipo equipo);
    public void deleteEquipo(String idequipo);
    
}
