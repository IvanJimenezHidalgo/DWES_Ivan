/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "CicloVida", urlPatterns = {"/ciclo"}, initParams = {
    @WebInitParam(name = "Nombre", value = "Ivan")
    , @WebInitParam(name = "Edad", value = "28")})
public class CicloVida extends HttpServlet {

    public CicloVida() {
        super();
        System.out.println("Se crea el Servlet");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Se inicia Servlet " + config.getServletName()
                + " en " + config.getServletContext());
        Enumeration<String> nombres = config.getInitParameterNames();
        System.out.println("Parámetros:");
        String nombre;
        while(nombres.hasMoreElements()){
            nombre = nombres.nextElement();
            System.out.println(nombre+": "+config.getInitParameter(nombre));
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Se llama al Servlet "+request.getServletPath() +" en " + request.getRequestURI() + " con el método " + request.getMethod());
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Tiempo: "+fecha.format(new Date()));
    }

    @Override
    public void destroy() {
        System.out.println("Se destruye el Servlet");
    }

}
