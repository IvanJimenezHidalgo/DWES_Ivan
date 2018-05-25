package es.albarregas.dao;

import es.albarregas.beans.Libro;
import java.util.List;


public interface IDireccionDAO {
    
    public void add(Libro direccion);
    public List<Libro> get(int pk);
    public void update(Libro direccion);
    public void delete(Libro direccion);
   
    
}