/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "RegistroUsuarios", urlPatterns = {"/registro"})
public class RegistroUsuarios extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Enumeration<String> nombres = request.getParameterNames();
        ArrayList<String> errores = new ArrayList<String>();
        String nombre;
        boolean ok = true;
        String tipo = null;
        while (nombres.hasMoreElements()) {
            nombre = nombres.nextElement();
            if (nombre.equals("tipo")) {
                tipo = request.getParameter(nombre);
            } else {
                if (comprobar(nombre, request.getParameter(nombre), tipo) == false) {
                    errores.add(nombre);
                    ok = false;
                }
            }
        }

        if (ok) {
            nombres = request.getParameterNames();
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro de Usuarios</title>");
                out.println("<link rel=\'stylesheet\' type=\'text/css\' href=\'CSS/estilos.css\'>");
                out.println("</head>");
                out.println("<body>");
                while (nombres.hasMoreElements()) {
                    nombre = nombres.nextElement();
                    if (!nombre.equals("enviar") && !nombre.equals("tipo") && !nombre.equals("documento") && !nombre.equals("preferencias")) {
                        out.println("<p>" + nombre + ": " + request.getParameter(nombre) + "</p>");
                    } else if (nombre.equals("documento")) {
                        out.println("<p>" + tipo + ": " + request.getParameter(nombre));
                    } else if (nombre.equals("preferencias")) {
                        String[] prefes = request.getParameterValues(nombre);
                        String prefe = prefes[0];
                        for (int i = 1; i < prefes.length; i++) {
                            prefe += ", " + prefes[i];
                        }
                        out.println("<p>" + nombre + ": " + prefe + "</p>");
                    }
                }
                out.println("<a href='HTML/registroUsuarios.html'>Volver</a>&nbsp;&nbsp;<a href='index.html'>Índice</a>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            nombres = request.getParameterNames();
            boolean error;
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro Usuarios</title>");
                out.println("<link rel=\'stylesheet\' type=\'text/css\' href=\'CSS/estilos.css\'>");
                out.println("</head>");
                out.println("<body><form action='registro' method='post'>");
                while (nombres.hasMoreElements()) {
                    error = false;
                    nombre = nombres.nextElement();
                    for (String e : errores) {
                        if (nombre.equals(e)) {
                            error = true;
                        }
                    }
                    if (!nombre.equals("enviar") && !nombre.equals("tipo") && !nombre.equals("documento") && !nombre.equals("preferencias") && !nombre.equals("pass")) {
                        if (error) {
                            out.println("<p>" + nombre + ": <input type='text' name='" + nombre + "' value='" + request.getParameter(nombre) + "'/>&#x2718;</p>");
                        } else {
                            out.println("<p>" + nombre + ": <input type='text' name='" + nombre + "' value='" + request.getParameter(nombre) + "'/>&#x2714;</p>");
                        }
                    } else if (nombre.equals("documento")) {
                        out.println("<input type='hidden' name='tipo' value='"+tipo+"'/>");
                        if (error) {
                            out.println("<p>" + tipo + ": <input type='text' name='" + nombre + "' value='" + request.getParameter(nombre) + "'/>&#x2718;</p>");
                        } else {
                            out.println("<p>" + tipo + ": <input type='text' name='" + nombre + "' value='" + request.getParameter(nombre) + "'/>&#x2714;</p>");
                        }
                    } else if (nombre.equals("preferencias")) {
                        String[] prefes = request.getParameterValues(nombre);
                        String prefe = prefes[0];
                        for (int i = 1; i < prefes.length; i++) {
                            prefe += ", " + prefes[i];
                        }
                        out.println("<p>" + nombre + ": " + prefe + "</p>");
                    }else if(nombre.equals("pass")){
                        out.print("<p>contraseña: <input type='password' name='"+nombre+"'/></p>");
                    }
                }
                out.println("<p><input type='submit' name='enviar' value='Enviar'/>&nbsp;&nbsp;"
                        + "<input type='reset' name='limpiar' value='Limpiar'/>&nbsp;&nbsp;"
                        + "<button><a href='index.html'>Índice</a></button></p>");
                out.println("</form></body>");
                out.println("</html>");
            }
        }

    }

    private boolean comprobar(String nombre, String valor, String tipo) {
        boolean ok = true;
        switch (nombre) {
            case "nombre":
                if (valor.equals("") || valor == null) {
                    ok = false;
                }
                break;
            case "apellidos":
                if (valor.equals("") || valor == null) {
                    ok = false;
                }
                break;
            case "fecha":
                ok = fecha(valor);
                break;
            case "telefono":
                if (valor.equals("") || valor == null) {
                    ok = false;
                }
                if (valor.length() != 9) {
                    ok = false;
                }
                try {
                    int tel = Integer.parseInt(valor);
                    char n = valor.charAt(0);
                    if (n != '6' && n != '9') {
                        ok = false;
                    }
                } catch (NumberFormatException e) {
                    ok = false;
                }

                break;
            case "usuario":
                if (valor.equals("") || valor == null) {
                    ok = false;
                }
                break;
            case "pass":
                if (valor.equals("") || valor == null) {
                    ok = false;
                }
                break;
            case "documento":
                ok = documento(tipo, valor);
        }
        return ok;
    }

    private boolean fecha(String fecha) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            formato.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private boolean documento(String tipo, String valor) {
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        boolean ok = true;
        int num = 0;
        char letra;
        
            switch (tipo) {
                case "nif":
                    if (valor.length() < 10 && valor.length() > 7) {
                        try {
                            num = Integer.parseInt(valor.substring(0, valor.length() - 1));
                            if (Character.toUpperCase(valor.charAt(valor.length() - 1)) != letras[num % 23]) {
                                ok = false;
                            }
                        } catch (NumberFormatException e) {
                            ok = false;
                        }
                    } else {
                        ok = false;
                    }
                    break;
                case "nie":
                    String aux = "";
                    if (valor.length() == 9) {
                        try {
                            num = Integer.parseInt(valor.substring(1, 8));
                            letra = Character.toUpperCase(valor.charAt(0));
                            if (letra != 'X' && letra != 'Y' && letra != 'Z') {
                                ok = false;
                            }
                            switch (letra) {
                                case 'X':
                                    aux = "0";
                                    break;
                                case 'Y':
                                    aux = "1";
                                    break;
                                case 'Z':
                                    aux = "2";
                                    break;
                            }
                            aux += num;
                            num = Integer.parseInt(aux);
                            if (Character.toUpperCase(valor.charAt(valor.length() - 1)) != letras[num % 23]) {
                                ok = false;
                            }
                        } catch (NumberFormatException e) {
                            ok = false;
                        }
                    } else {
                        ok = false;
                    }
                    break;
                case "pasaporte":
                    if (valor.equals("") || valor == null) {
                        ok = false;
                    }
                    ;
                    break;
            }
        
        return ok;
    }
}
