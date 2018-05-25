package es.albarregas.dao;

import es.albarregas.beans.Presidente;
import java.util.List;


public interface IPresidenteDAO {
    
    public void add(Presidente presidente);
    public List<Presidente> get();
    public Presidente getOne(int pk);
    public void update(Presidente presidente);
    public void delete(Presidente presidente);
   
    
}