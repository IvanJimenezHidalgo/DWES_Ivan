/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Ave;
import es.albarregas.connection.Conexion;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "Actualizar", urlPatterns = {"/actualizar"})
public class Actualizar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Ave ave = new Ave();
        ave.setAnilla(request.getParameter("anilla"));
        ave.setEspecie(request.getParameter("especie"));
        ave.setLugar(request.getParameter("lugar"));
        ave.setFecha(request.getParameter("fecha"));
        try {

            String sql = "UPDATE aves set especie=?,lugar=?,fecha=? WHERE aves.anilla=?;";
            PreparedStatement preparada = Conexion.getConexion().prepareStatement(sql);
            preparada.setString(1, ave.getEspecie());
            preparada.setString(2, ave.getLugar());
            preparada.setString(3, ave.getFecha());
            preparada.setString(4, ave.getAnilla());
            request.setAttribute("ave", ave);
            preparada.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Actualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
        String mensaje = "<strong>Se ha actualizado el registro:</strong><br><p>Anilla - " + ave.getAnilla()
                + " ,especie - " + ave.getEspecie() + " ,lugar - " + ave.getLugar()
                + " ,fecha - " + ave.getFecha()+"</p>";
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("jsp/fin.jsp").forward(request, response);
    }

}
