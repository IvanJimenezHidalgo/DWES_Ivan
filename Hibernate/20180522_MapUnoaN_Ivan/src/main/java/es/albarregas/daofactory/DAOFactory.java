package es.albarregas.daofactory;


import es.albarregas.dao.IDireccionDAO;
import es.albarregas.dao.IProfesorDAO;

public abstract class DAOFactory {

    

    public abstract IProfesorDAO getProfesorDAO();
    public abstract IDireccionDAO getDireccionDAO();

    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}
