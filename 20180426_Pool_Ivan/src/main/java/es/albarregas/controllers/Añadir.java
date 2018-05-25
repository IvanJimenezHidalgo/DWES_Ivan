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
@WebServlet(name = "Añadir", urlPatterns = {"/add"})
public class Añadir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexion = Conexion.getConexion();
        Ave ave = new Ave();
        ave.setAnilla(request.getParameter("anilla"));
        ave.setEspecie(request.getParameter("especie"));
        ave.setLugar(request.getParameter("lugar"));
        ave.setFecha(request.getParameter("fecha"));
        try {
            PreparedStatement preparada = conexion.prepareStatement("insert into aves"
                    + "(anilla,especie,lugar,fecha) values (?,?,?,?)");
            preparada.setString(1, ave.getAnilla());
            preparada.setString(2, ave.getEspecie());
            preparada.setString(3, ave.getLugar());
            preparada.setString(4, ave.getFecha());
            preparada.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Añadir.class.getName()).log(Level.SEVERE, null, ex);
        }
        String mensaje = "<strong>Se ha introducido el registro:</strong><br><p>Anilla - "+ave.getAnilla()+
                " ,especie - "+ave.getEspecie()+" ,lugar - "+ave.getLugar()+
                " ,fecha - "+ave.getFecha()+"</p>";
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("jsp/fin.jsp").forward(request, response);
    }

}
