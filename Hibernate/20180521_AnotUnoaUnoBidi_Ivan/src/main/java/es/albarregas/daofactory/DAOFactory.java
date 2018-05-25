package es.albarregas.daofactory;


import es.albarregas.dao.IPresidenteDAO;
import es.albarregas.dao.IPaisDAO;

public abstract class DAOFactory {

    

    public abstract IPresidenteDAO getPresidenteDAO();
    public abstract IPaisDAO getPaisDAO();

    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}
