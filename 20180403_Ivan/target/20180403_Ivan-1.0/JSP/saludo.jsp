<%-- 
    Document   : inicio
    Created on : 10-abr-2018, 16:26:30
    Author     : Ivan
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saludo JSP</title>
        <link rel="stylesheet" type="text/css" href="">
    </head>
    <body>
        <%
            String nombre = request.getParameter("nombre");
            String sexo = request.getParameter("sexo");
            SimpleDateFormat fecha = new SimpleDateFormat("HH");
            int hora = Integer.parseInt(fecha.format(new Date()));
            String saludo;
            if(hora>=8 && hora<=12){
               saludo = "Buenos días ";
            }else if(hora>12 && hora<=21){
                saludo = "Buenas tardes ";
            }else{
                saludo = "Buenas noches ";
            }
            if(sexo.equals("hombre")){
                saludo+="señor ";
            }else{
                saludo+="señora ";
            }
            if(nombre=="" && sexo.equals("hombre")){
                saludo+="anónimo";
            }else if(nombre=="" && sexo.equals("mujer")){
                saludo+="anónima";
            }else{
                saludo+=nombre;
            }
        %>
        <h2><%=saludo%></h2>
        <br>
        <a href="../HTML/saludo.html">Volver</a>
        <a href="../index.html">Inicio</a>
    </body>
</html>
