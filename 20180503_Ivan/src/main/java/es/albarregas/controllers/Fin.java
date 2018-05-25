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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "Fin", urlPatterns = {"/fin"})
public class Fin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");
        System.out.println(op);
        StringBuilder url = new StringBuilder("jsp/");
        if (op == null) {
            request.setAttribute("mensaje", "Has accedio incorrectamente");
            url.append("error");
        } else {
            switch (op) {
                case "upAl":
                    DAOFactory daof = DAOFactory.getDAOFactory();
                    Alumno al = new Alumno();
                    al.setIdalumno(request.getParameter("idalumno"));
                    al.setNombre(request.getParameter("nombre"));
                    al.setGrupo(request.getParameter("grupo"));
                    Equipo eq = daof.getEquiposDAO().getEquipo(request.getParameter("idequipo"));
                    al.setEquipo(eq);
                    daof.getAlumnosDAO().updateAlumno(al);
                    url.append("fin");
                    request.setAttribute("mensaje", "Se ha actualizado el alumno " + al.getNombre());
                    break;
                case "upEq":
                    eq = new Equipo();
                    eq.setIdequipo(request.getParameter("idequipo"));
                    eq.setMarca(request.getParameter("marca"));
                    eq.setNumserie(request.getParameter("numserie"));
                    DAOFactory.getDAOFactory().getEquiposDAO().updateEquipo(eq);
                    url.append("fin");
                    request.setAttribute("mensaje", "Se ha actualizado el equipo " + eq.getIdequipo() + ". " + eq.getMarca());
                    break;
                default:
                    url.append("error");
                    break;
            }
        }

        url.append(".jsp");
        request.getRequestDispatcher(String.valueOf(url)).forward(request, response);

    }

}
