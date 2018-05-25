/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

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
@WebServlet(name = "Eliminar", urlPatterns = {"/eliminar"})
public class Eliminar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] anillas = request.getParameterValues("anilla");
        String sql = "delete from aves where aves.anilla=?";
        for (String s : anillas) {
            PreparedStatement preparada;
            try {
                preparada = Conexion.getConexion().prepareStatement(sql);
                preparada.setString(1, s);
                preparada.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        StringBuilder mensaje = new StringBuilder("Se han eliminado la/s anilla/s:<br> ");
        mensaje.append(anillas[0]);
        for(int i=1;i<anillas.length;i++){
            mensaje.append("<br>").append(anillas[i]);
        }
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("jsp/fin.jsp").forward(request, response);
    }

}
