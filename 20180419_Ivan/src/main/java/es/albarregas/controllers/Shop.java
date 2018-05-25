/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Libro;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "Shop", urlPatterns = {"/shop"})
public class Shop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("HTML/error.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        
        if(request.getParameter("comprar")!=null){
            System.out.println("fin");
            sesion.removeAttribute("libros");
            Cookie[] cookies = request.getCookies();
            for(Cookie c:cookies){
                if(c.getName().equals("libros")){
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
        ArrayList<Libro> libros = (ArrayList<Libro>) sesion.getAttribute("libros");
        if (libros == null) {
            String[] valores = null;
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                if (c.getName().equals("libros")) {
                    valores = c.getValue().split(",");
                }
            }
            ArrayList<Libro> aux = new ArrayList<>();
            if (valores != null) {
                for (int i = 1; i < valores.length; i+=2) {
                    aux.add(new Libro(valores[i].replace("_", " "), Integer.parseInt(valores[i - 1])));
                }
            }
            libros=aux;
        }
        String compra = "";
        if (libros.isEmpty()) {
            compra = "¿Seguro que no quieres comprar ningún libro?";
        } else {
            for (Libro l : libros) {
                compra += "<p>Título: " + l.getTitulo() + " - Cantidad: " + l.getCantidad() + "</p>";
            }
        }
        request.setAttribute("compra", compra);
        request.getRequestDispatcher("/JSP/carrito.jsp").forward(request, response);
        }
    }

}
