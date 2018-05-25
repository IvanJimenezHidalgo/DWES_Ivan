package es.albarregas.connection;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Ivan
 */
public class Conexion {

    private static Connection conexion;

    public static Connection getConexion() {
        if (conexion == null) {
            try {
                Context initialContext = new InitialContext();
                DataSource ds = (javax.sql.DataSource) initialContext.lookup("java:comp/env/jdbc/pruebasjava");
                try {
                    conexion = ds.getConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NamingException ex) {
                System.out.println("No se puede acceder Datasource");
                ex.printStackTrace();
            }

        }
        return conexion;
    }

}
