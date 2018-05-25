/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "Sesion", urlPatterns = {"/sesion"})
public class Sesion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sesion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='sesion' method='post'>");

            if (sesion.getAttribute("contador") == null) {
                sesion.setAttribute("contador", new Integer(1));
                
            } else {
                if (request.getParameter("reiniciar") == null) {
                    Integer aux = (Integer)sesion.getAttribute("contador")+1;
                    sesion.removeAttribute("contador");
                    sesion.setAttribute("contador", aux);
                } else {
                    sesion.removeAttribute("contador");
                    sesion.setAttribute("contador", 1);
                }
            }

            if((int)sesion.getAttribute("contador")>1){
                out.println("<h2>Has visitado la web "+sesion.getAttribute("contador")+ " veces</h2>");
            }else{
                out.println("<h2>Has visitado la web "+sesion.getAttribute("contador")+ " vez</h2>");
            }
            out.println("<input type='submit' name='recargar' value='Recargar'/>"
                    + "<input type='submit' name='reiniciar' value='Reiniciar'/>"
                    + "<button><a href='index.html'>Índice</a></button>");
            out.println("</form></body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
