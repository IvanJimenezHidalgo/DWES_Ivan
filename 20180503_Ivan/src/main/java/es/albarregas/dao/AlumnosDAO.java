/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Alumno;
import es.albarregas.daoFactory.DAOFactory;
import es.albarregas.daoFactory.MYSQLDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class AlumnosDAO implements IAlumnosDAO{

    @Override
    public void addAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumnos (idalumno, nombre, grupo, idequipo) VALUES (NULL, ?, ?, ?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparada = con.prepareStatement(sql);
            preparada.setNString(1, alumno.getNombre());
            preparada.setNString(2, alumno.getGrupo());
            if(alumno.getEquipo()!=null){
                preparada.setInt(3, Integer.parseInt(alumno.getEquipo().getIdequipo()));
            }else{
                preparada.setNull(3, java.sql.Types.INTEGER);
            }
            preparada.execute();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EquiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Alumno> getAlumnos() {
        ArrayList<Alumno> alumnos = null;
        Alumno alumno;
        String sql = "select * from alumnos";
        Connection con = ConnectionFactory.getConnection();
        try {
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            alumnos = new ArrayList();
            while(resultado.next()){
                alumno = new Alumno();
                alumno.setIdalumno(String.valueOf(resultado.getInt("idalumno")));
                alumno.setNombre(resultado.getNString("nombre"));
                alumno.setGrupo(resultado.getNString("grupo"));
                alumno.setEquipo(new MYSQLDAOFactory().getEquiposDAO().getEquipo(String.valueOf(resultado.getInt("idequipo"))));
                alumnos.add(alumno);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }

    @Override
    public Alumno getAlumno(String idalumno) {
        Alumno alumno = null;
        String sql = "select * from alumnos where idalumno="+idalumno;
        Connection con = ConnectionFactory.getConnection();
        try {
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
                alumno = new Alumno();
                alumno.setIdalumno(idalumno);
                alumno.setNombre(resultado.getNString("nombre"));
                alumno.setGrupo(resultado.getNString("grupo"));
                alumno.setEquipo(new MYSQLDAOFactory().getEquiposDAO().getEquipo(String.valueOf(resultado.getInt("idequipo"))));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno;
    }

    @Override
    public ArrayList<Alumno> getAlumnosequipo() {
        ArrayList<Alumno> alumnos = null;
        Alumno alumno;
        String sql = "select * from alumnos";
        Connection con = ConnectionFactory.getConnection();
        try {
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            alumnos = new ArrayList();
            while(resultado.next()){
                alumno = new Alumno();
                alumno.setIdalumno(String.valueOf(resultado.getInt("idalumno")));
                alumno.setNombre(resultado.getNString("nombre"));
                alumno.setGrupo(resultado.getNString("grupo"));
                alumno.setEquipo(DAOFactory.getDAOFactory().getEquiposDAO().getEquipo(String.valueOf(resultado.getInt("idequipo"))));
                alumnos.add(alumno);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }

    @Override
    public void updateAlumno(Alumno al) {
        String sql = "UPDATE alumnos SET nombre = '" +al.getNombre()+ "', grupo ='" +al.getGrupo()+ "',idequipo='"+al.getEquipo().getIdequipo()+"' WHERE idalumno =" +al.getIdalumno();
        Connection con = ConnectionFactory.getConnection();
        try {
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EquiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteAlumno(String idalumno) {
        String sql = "DELETE FROM alumnos WHERE idalumno ="+idalumno;
        Connection con = ConnectionFactory.getConnection();
        try {
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EquiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
