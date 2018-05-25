package es.albarregas.dao;

import es.albarregas.beans.Persona;
import java.util.List;


public interface IProfesorDAO {
    
    public void add(Persona profesor);
    public List<Persona> get();
    public Persona getOne(int pk);
    public void update(Persona profesor);
    public void delete(Persona profesor);
   
    
}