/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Ave;
import es.albarregas.connection.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Crear", urlPatterns = {"/crear"})
public class Crear extends HttpServlet {

 
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
        String url = "jsp/confirmar.jsp";
        Connection conexion = Conexion.getConexion();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from aves");
            while(resultado.next()){
                ave = new Ave();
                ave.setAnilla(resultado.getNString("anilla"));
                ave.setEspecie(resultado.getNString("especie"));
                ave.setLugar(resultado.getNString("lugar"));
                ave.setFecha(resultado.getNString("fecha"));
                aves.add(ave);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crear.class.getName()).log(Level.SEVERE, null, ex);
        }
        ave = new Ave();
        ave.setAnilla(request.getParameter("anilla"));
        ave.setEspecie(request.getParameter("especie"));
        ave.setLugar(request.getParameter("lugar"));
        ave.setFecha(request.getParameter("fecha"));
        for(Ave a:aves){
            if(a.getAnilla().equals(ave.getAnilla())){
                url = "jsp/error.jsp";
                String error = "La anilla ya existe en el registro";
                request.setAttribute("error", error);
            }
        }
        request.setAttribute("ave", ave);
        request.getRequestDispatcher(url).forward(request, response);
    }

  
}
