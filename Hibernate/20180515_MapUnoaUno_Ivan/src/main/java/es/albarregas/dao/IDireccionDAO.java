package es.albarregas.dao;

import es.albarregas.beans.Direccion;


public interface IDireccionDAO {
    
    public void add(Direccion direccion);
    public Direccion getDireccion(int pk);
    public void update(Direccion direccion);
    public void delete(Direccion direccion);
   
    
}