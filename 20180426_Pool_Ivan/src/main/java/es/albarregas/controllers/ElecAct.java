/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Ave;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ElecAct", urlPatterns = {"/elecact"})
public class ElecAct extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String anilla = request.getParameter("anilla");
        System.out.println(anilla);
        HttpSession sesion = request.getSession();
        ArrayList<Ave> aves = (ArrayList<Ave>) sesion.getAttribute("aves");
        Ave ave = null;
        for(Ave a:aves){
            if(a.getAnilla().equals(anilla)){
                ave = a;
            }
        }
        request.setAttribute("ave", ave);
        request.getRequestDispatcher("jsp/actualizar.jsp").forward(request, response);
    }


}
