package es.albarregas.daofactory;


import es.albarregas.dao.ProfesorDAO;
import es.albarregas.dao.IProfesorDAO;


public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IProfesorDAO getProfesorDAO() {
        return new ProfesorDAO();
    }

}
