/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.daoFactory.DAOFactory;
import java.io.IOException;
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
@WebServlet(name = "Inicio", urlPatterns = {"/inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder url = new StringBuilder("jsp/");
        String op = request.getParameter("op");
        switch (op) {
            case "addAl":
                url.append("alumnos/addAlumno");
                HttpSession sesion = request.getSession();
                sesion.setAttribute("equipos", DAOFactory.getDAOFactory().getEquiposDAO().getEquipos());
                break;
            case "addEq":
                url.append("equipos/addEquipo");
                break;
            case "shAl":
                request.setAttribute("alumnos", DAOFactory.getDAOFactory().getAlumnosDAO().getAlumnos());
                url.append("alumnos/showAlumnos");
                break;
            case "shEq":
                request.setAttribute("equipos", DAOFactory.getDAOFactory().getEquiposDAO().getEquipos());
                url.append("equipos/showEquipos");
                break;
            case "shAE":
                request.setAttribute("alumnos", DAOFactory.getDAOFactory().getAlumnosDAO().getAlumnosequipo());
                url.append("alumnos/showAlumnosEquipos");
                break;
            case "shES":
                request.setAttribute("equipos", DAOFactory.getDAOFactory().getEquiposDAO().getEquiposSinAlumno());
                url.append("equipos/showEquiposSolos");
                break;
            case "upAl":
                request.setAttribute("alumnos", DAOFactory.getDAOFactory().getAlumnosDAO().getAlumnos());
                url.append("alumnos/upAlumno");
                break;
            case "upEq":
                request.setAttribute("equipos", DAOFactory.getDAOFactory().getEquiposDAO().getEquipos());
                url.append("equipos/upEquipo");
                break;
            case "deAl":
                url.append("alumnos/delAlumno");
                request.setAttribute("alumnos", DAOFactory.getDAOFactory().getAlumnosDAO().getAlumnos());
                break;
            case "deEq":
                url.append("equipos/delEquipo");
                request.setAttribute("equipos", DAOFactory.getDAOFactory().getEquiposDAO().getEquipos());
                break;
            default: url.append("errores/error.jsp");
            request.setAttribute("error", "Acceso inadecuado a la app");
                break;
        }
        url.append(".jsp");
        request.getRequestDispatcher(String.valueOf(url)).forward(request, response);

    }

}
