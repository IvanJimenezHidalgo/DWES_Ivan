/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "FormuarioComplejo1", urlPatterns = {"/fcomplejo1"})
public class FormuarioComplejo1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Map<String, String[]> datos = request.getParameterMap();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormuarioComplejo1</title>"
                    + "<link rel='stylesheet' href='CSS/fcomplejo.css'>");
            out.println("</head>");
            out.println("<body>"
                    + "<h2>Datos del Formulario Complejo 1</h2>"
                    + "<div id='res'>");
            for (Map.Entry<String, String[]> dato : datos.entrySet()) {
                if (!dato.getKey().equals("enviar")) {
                    out.println("<p>" + dato.getKey() + ":&nbsp;&nbsp;&nbsp;");
                    if (dato.getKey().equals("Avatar")) {
                        
                    } else {
                        out.println(dato.getValue()[0]);
                        if (dato.getValue().length > 1) {
                            for (int i = 1; i < dato.getValue().length; i++) {
                                out.println(", " + dato.getValue()[i]);
                            }
                        }
                    }
                    out.println("</p>");
                }
            }
            out.println("<br><br><a href='HTML/formularioComplejo1.html'>Volver</a>"
                    + "&nbsp;&nbsp;&nbsp;<a href='index.html'>Índice</a>");
            out.println("</div></body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
