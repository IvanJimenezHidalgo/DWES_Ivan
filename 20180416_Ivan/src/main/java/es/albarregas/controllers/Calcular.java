/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Calculadora;
import es.albarregas.models.Dividir;
import es.albarregas.models.Multiplicar;
import es.albarregas.models.Restar;
import es.albarregas.models.Sumar;
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
@WebServlet(name = "Calcular", urlPatterns = {"/calcular"})
public class Calcular extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double op1 = Double.parseDouble(request.getParameter("op1"));
        double op2 = Double.parseDouble(request.getParameter("op2"));
        String operacion = request.getParameter("operacion");
        Calculadora cal = new Calculadora(op1, op2, operacion);
        String url;
        switch (operacion) {
            case "+":
                cal.setResultado(Sumar.sumar(op1, op2));
                break;
            case "-":
                cal.setResultado(Restar.restar(op1, op2));
                break;
            case "*":
                cal.setResultado(Multiplicar.multiplicar(op1, op2));
                break;
            case "/":
                double division = Dividir.dividir(op1, op2);
                if(op2==0){
                    cal.setError("Estás dividiendo por 0");
                }else{
                    cal.setResultado(division);
                }
                break;
        }
        if(cal.getError()==null){
            url="JSP/resultado.jsp";
        }else{
            url="JSP/error.jsp";
        }
        request.setAttribute("resultado", cal);
        request.getRequestDispatcher(url).forward(request, response);
    }

}
