package es.albarregas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionFactory {

    private static DataSource ds;
    private static Connection con;
    private static final String DS_NAME = "java:comp/env/jdbc/equiposdept";
    
    public static Connection getConnection(){
        try{
            Context contexto = new InitialContext();
            ds = (DataSource)contexto.lookup(DS_NAME);
            try {
                con = ds.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(NamingException ex){
            ex.printStackTrace();
        }
        return con;
    }
    
}
