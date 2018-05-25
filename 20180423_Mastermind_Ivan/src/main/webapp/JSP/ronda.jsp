<%-- 
    Document   : ronda
    Created on : 21-abr-2018, 23:06:22
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ronda ${ronda}</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Ronda ${numero.ronda}</h1>
            <p>(${numero.numero})</p>
            <form action="master" method="post">
                <p>${numero.salida}</p>
                <h3>Introduce las cifras</h3>
                <p>${numero.entrada}</p>
                <p>
                    <input type="submit" name="ronda" value="Aceptar"/>
                </p>
            </form>
        </div>
    </body>
</html>
