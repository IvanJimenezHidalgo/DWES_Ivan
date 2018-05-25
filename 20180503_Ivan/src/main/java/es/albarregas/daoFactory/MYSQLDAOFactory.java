package es.albarregas.daoFactory;

import es.albarregas.dao.AlumnosDAO;
import es.albarregas.dao.EquiposDAO;
import es.albarregas.dao.IAlumnosDAO;
import es.albarregas.dao.IEquiposDAO;

public class MYSQLDAOFactory extends DAOFactory{

    @Override
    public IAlumnosDAO getAlumnosDAO() {
        IAlumnosDAO iadao = new AlumnosDAO();
        return iadao;
    }

    @Override
    public IEquiposDAO getEquiposDAO() {
        IEquiposDAO iedao = new EquiposDAO();
        return iedao;
    }
    
}
