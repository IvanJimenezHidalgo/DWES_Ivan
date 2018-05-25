package es.albarregas.daoFactory;

import es.albarregas.dao.IAlumnosDAO;
import es.albarregas.dao.IEquiposDAO;

public abstract class DAOFactory {

    public abstract IAlumnosDAO getAlumnosDAO();
    public abstract IEquiposDAO getEquiposDAO();
    
    public static DAOFactory getDAOFactory(){
        DAOFactory daof = new MYSQLDAOFactory();
        return daof;
    }
    
}
