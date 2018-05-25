/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Ave;
import es.albarregas.connection.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "Leer", urlPatterns = {"/leer"})
public class Leer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Ave> aves = new ArrayList<>();
        Ave ave;
        String url;
        HttpSession sesion = request.getSession();
        try {
            Connection conexion = Conexion.getConexion();
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from aves");
            while (resultado.next()) {
                ave = new Ave();
                ave.setAnilla(resultado.getNString("anilla"));
                ave.setEspecie(resultado.getNString("especie"));
                ave.setLugar(resultado.getNString("lugar"));
                ave.setFecha(resultado.getNString("fecha"));
                aves.add(ave);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("aves", aves);
        switch (request.getParameter("op")) {
            case "ac":
                url = "jsp/ele_act.jsp";
                sesion.setAttribute("aves", aves);
                break;
            case "el":
                url = "jsp/eliminar.jsp";
                sesion.setAttribute("aves", aves);
                break;
            default:
                url = "jsp/leer.jsp";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

}
