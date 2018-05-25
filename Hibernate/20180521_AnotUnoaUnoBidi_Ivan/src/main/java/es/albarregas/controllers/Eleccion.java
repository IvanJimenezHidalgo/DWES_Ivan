/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Pais;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.beans.Presidente;
import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.albarregas.dao.IPresidenteDAO;
import es.albarregas.dao.IPaisDAO;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Eleccion", urlPatterns = {"/eleccion"})
public class Eleccion extends HttpServlet {

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
        String url = null;
        DAOFactory daof = DAOFactory.getDAOFactory();
//        IGenericoDAO gdao = daof.getGenericoDAO();
        IPresidenteDAO pdao = daof.getPresidenteDAO();
        IPaisDAO ddao = daof.getPaisDAO();
        switch (request.getParameter("op")) {
            case "add":
                url = "JSP/formularioAlta.jsp";
                break;
            case "delete":
            case "update":
            case "listpre":
//                String entidad = "Presidente";
                List<Presidente> listaPresi = pdao.get(); //new ArrayList<>();
                for (Presidente p : listaPresi) {
                    p.setPais(ddao.getPais(p.getIdPresi()));
                }
//                List<Object> lista = pdao.get(entidad);
//                for(Object profesor : lista){
//                    listaPresi.add((Presidente)profesor);
//                }
//                listaPresi = pdao.get();
                request.setAttribute("listado", listaPresi);
                break;
            case "listpa":
                List<Pais> listaPais = ddao.get(); //new ArrayList<>();
                for (Pais p : listaPais) {
                    p.setPresidente(pdao.getOne(p.getIdPais()));
                }
                request.setAttribute("listado", listaPais);
                break;
        }
        switch (request.getParameter("op")) {
            case "listpre":
                url = "JSP/listadoPresi.jsp";
                break;
            case "listpa":
                url = "JSP/listadoPais.jsp";
                break;
            case "delete":
                url = "JSP/borrado.jsp";
                break;
            case "update":
                url = "JSP/actual.jsp";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
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
