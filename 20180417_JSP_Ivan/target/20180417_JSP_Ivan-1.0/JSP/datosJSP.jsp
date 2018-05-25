<%-- 
    Document   : datosJSP
    Created on : 17-abr-2018, 17:40:27
    Author     : Ivan
--%>

<%@page import="es.albarregas.beans.Datos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos JSP</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body>
        <%
            Datos datos = (Datos)request.getAttribute("datos");
        %>
        <div id="contenido">
            <h2>Datos por JSP</h2>
        <p>Nombre: <%=datos.getNombre()%></p>
        <p>Nº de hijos: <%=datos.getNumHijos()%></p>
        <p>Sueldo: <%=datos.getSueldo()%></p>    
        <p>Domicilio: <%=datos.getDireccion().getDomicilio()%></p>
        <p>Localidad: <%=datos.getDireccion().getLocalidad()%></p>
        <br>
        <p>
            <a href="<%=request.getContextPath()%>/index.html">Volver</a>
        </p>
        </div>
    </body>
</html>
