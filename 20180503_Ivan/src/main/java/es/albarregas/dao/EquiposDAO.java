/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Equipo;
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
public class EquiposDAO implements IEquiposDAO {

    @Override
    public void addEquipo(Equipo equipo) {
        String sql = "INSERT INTO equipos (idequipo, marca, numserie) VALUES (NULL, ?, ?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparada = con.prepareStatement(sql);
            preparada.setNString(1, equipo.getMarca());
            preparada.setNString(2, equipo.getNumserie());
            preparada.execute();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EquiposDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Equipo getEquipo(String idequipo) {
        Equipo equipo = null;
        String sql = "select * from equipos where idequipo=" + idequipo;
        Connection con = ConnectionFactory.getConnection();
        try {
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                equipo = new Equipo();
                equipo.setIdequipo(idequipo);
                equipo.setMarca(resultado.getNString("marca"));
                equipo.setNumserie(resultado.getNString("numserie"));
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return equipo;
    }

    @Override
    public ArrayList<Equipo> getEquipos() {
        ArrayList<Equipo> equipos = null;
        Equipo equipo;
        String sql = "select * from equipos";
        Connection con = ConnectionFactory.getConnection();
        try {
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            equipos = new ArrayList();
            while (resultado.next()) {
                equipo = new Equipo();
                equipo.setIdequipo(String.valueOf(resultado.getInt("idequipo")));
                equipo.setMarca(resultado.getNString("marca"));
                equipo.setNumserie(resultado.getNString("numserie"));
                equipos.add(equipo);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return equipos;
    }

    @Override
    public ArrayList<Equipo> getEquiposSinAlumno() {
        ArrayList<Equipo> equipos = null;
        String sql = "SELECT idequipo,marca,numserie FROM equipos LEFT JOIN alumnos USING(idequipo) WHERE idalumno is null";
        Equipo equipo;
        Connection con = ConnectionFactory.getConnection();
        try {
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            equipos = new ArrayList();
            while (resultado.next()) {
                equipo = new Equipo();
                equipo.setIdequipo(String.valueOf(resultado.getInt("idequipo")));
                equipo.setMarca(resultado.getNString("marca"));
                equipo.setNumserie(resultado.getNString("numserie"));
                equipos.add(equipo);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipos;
    }

    @Override
    public void updateEquipo(Equipo equipo) {
        String sql = "UPDATE equipos SET marca = '" + equipo.getMarca() + "', numserie ='" + equipo.getNumserie() + "' WHERE idequipo =" + equipo.getIdequipo();
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
    public void deleteEquipo(String id) {
        String sql = "DELETE FROM equipos WHERE idequipo =" + id;
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
