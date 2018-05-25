package es.albarregas.dao;

import es.albarregas.beans.Pais;
import java.util.List;


public interface IPaisDAO {
    
    public void add(Pais pais);
    public Pais getPais(int pk);
    public List<Pais> get();
    public void update(Pais pais);
    public void delete(Pais pais);
   
    
}