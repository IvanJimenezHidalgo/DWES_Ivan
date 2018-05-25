/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;
import es.albarregas.daoFactory.DAOFactory;
import java.io.IOException;
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
@WebServlet(name = "Medio", urlPatterns = {"/medio"})
public class Medio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");
        StringBuilder url = new StringBuilder("jsp/");
        switch (op) {
            case "addAl":
                Alumno alumno = new Alumno();
                alumno.setNombre(request.getParameter("nombre"));
                alumno.setGrupo(request.getParameter("grupo"));
                HttpSession sesion = request.getSession();
                ArrayList<Equipo> equipos = (ArrayList<Equipo>) sesion.getAttribute("equipos");
                for (Equipo e : equipos) {
                    if (e.getIdequipo().equals(request.getParameter("idequipo"))) {
                        alumno.setEquipo(e);
                    }
                }
                DAOFactory.getDAOFactory().getAlumnosDAO().addAlumno(alumno);
                url.append("fin");
                request.setAttribute("mensaje", "Se ha introducido el alumno "+alumno.getNombre());
                break;
            case "upAl":
                request.setAttribute("alumno", DAOFactory.getDAOFactory().getAlumnosDAO().getAlumno(request.getParameter("idalumno")));
                request.setAttribute("equipos", DAOFactory.getDAOFactory().getEquiposDAO().getEquipos());
                url.append("alumnos/upAlDatos");
                break;
            case "addEq":
                Equipo eq = new Equipo();
                eq.setMarca(request.getParameter("marca"));
                eq.setNumserie(request.getParameter("numserie"));
                DAOFactory.getDAOFactory().getEquiposDAO().addEquipo(eq);
                url.append("fin");
                request.setAttribute("mensaje", "Se ha añadido el equipo "+eq.getMarca());
                break;
            case "upEq":
                request.setAttribute("equipo", DAOFactory.getDAOFactory().getEquiposDAO().getEquipo(request.getParameter("idequipo")));
                url.append("equipos/upEqDatos");
                break;
            case "delAl":
                DAOFactory.getDAOFactory().getAlumnosDAO().deleteAlumno(request.getParameter("idalumno"));
                url.append("fin");
                request.setAttribute("mensaje", "Se ha eliminado el alumno");
                break;
            case "delEq":
               DAOFactory.getDAOFactory().getEquiposDAO().deleteEquipo(request.getParameter("idequipo"));
                url.append("fin");
                request.setAttribute("mensaje", "Se ha eliminado el equipo");
                break;
            default: url.append("error");
                break;
        }
        url.append(".jsp");
        request.getRequestDispatcher(String.valueOf(url)).forward(request, response);

    }

}
