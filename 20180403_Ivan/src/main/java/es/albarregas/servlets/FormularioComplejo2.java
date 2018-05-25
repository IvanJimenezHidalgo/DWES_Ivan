/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "FormularioComplejo2", urlPatterns = {"/fcomplejo2"})
public class FormularioComplejo2 extends HttpServlet {

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

        Map<String, String[]> mapa = request.getParameterMap();
        Iterator<Map.Entry<String, String[]>> it = mapa.entrySet().iterator();
        Map.Entry<String, String[]> datos = null;
        boolean ok = true;
        ArrayList<String> errores = new ArrayList<>();
        String nombre;
        boolean vehiculo = false;
        while (it.hasNext()) {
            datos = it.next();
            nombre = datos.getKey();
            if (!nombre.equals("enviar")) {
                switch (nombre) {
                    case "Nombre":
                        if (!Pattern.matches("[A-ZÁÉÍÓÚ]+[a-záéíóú]+", datos.getValue()[0])) {
                            ok = false;
                            errores.add(nombre);
                        }
                        break;
                    case "Telefono":
                        if (!Pattern.matches("(6|9)*[0-9]{8}", datos.getValue()[0])) {
                            ok = false;
                            errores.add("Teléfono");
                        }
                        break;
                    case "Email":
                        if (!Pattern.matches("[^@]+@[^@]+\\.[a-zA-Z]{2,}", datos.getValue()[0])) {
                            ok = false;
                            errores.add(nombre);
                        }
                        break;
                    case "Fecha":
                        if (!Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{4}", datos.getValue()[0])) {
                            ok = false;
                            errores.add("Fecha de nacimiento");
                        }
                        break;
                    case "Vehiculo":
                        vehiculo = true;
                        break;
                }
            }
        }
        if (!vehiculo) {
            ok = false;
            errores.add("Vehículo (Se debe seleccionar uno)");
        }
        if (ok == true) {
            correcto(mapa, it, datos, response);
        } else {
            error(errores, response);
        }
    }

    private void correcto(Map<String, String[]> mapa, Iterator<Map.Entry<String, String[]>> it, Map.Entry<String, String[]> datos, HttpServletResponse response) throws IOException {
        it = mapa.entrySet().iterator();
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioComplejo2</title>"
                    + "<link rel='stylesheet' href='CSS/fcomplejo.css'>");
            out.println("</head>");
            out.println("<body>"
                    + "<h2>Datos del Formulario Complejo 2</h2>"
                    + "<div id='res'>");
            while (it.hasNext()) {
                datos = it.next();
                if (!datos.getKey().equals("enviar")) {
                    out.println("<p>" + datos.getKey() + ":");
                    out.println("&nbsp;" + datos.getValue()[0]);
                    if (datos.getValue().length > 1) {
                        for (int i = 1; i < datos.getValue().length; i++) {
                            out.println(", " + datos.getValue()[i]);
                        }
                    }
                }
            }
            out.println("<br><br><p><a href='HTML/formularioComplejo2.html'>Volver</a>"
                    + "&nbsp;&nbsp;&nbsp;<a href='index.html'>Índice</a></p>");
            out.println("</div></body>");
            out.println("</html>");
        }
    }

    private void error(ArrayList<String> errores, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioComplejo2</title>"
                    + "<link rel='stylesheet' href='CSS/fcomplejo.css'>");
            out.println("</head>");
            out.println("<body>"
                    + "<h2>Hay errores en los siguientes campos</h2>"
                    + "<div id='res'><ul>");
            for (String e : errores) {
                out.println("<li>" + e + "</li>");
            }
            out.println("</ul>");
            out.println("<br><p><a href='HTML/formularioComplejo2.html'>Volver</a>"
                    + "&nbsp;&nbsp;&nbsp;<a href='index.html'>Índice</a></p>");
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
