package es.albarregas.dao;

import es.albarregas.beans.Alumno;
import java.util.ArrayList;

public interface IAlumnosDAO {

    public void addAlumno(Alumno alumno);
    public ArrayList<Alumno> getAlumnos();
    public Alumno getAlumno(String idalumno);
    public ArrayList<Alumno> getAlumnosequipo();
    public void updateAlumno(Alumno alumno);
    public void deleteAlumno(String idalumno);
    
}
