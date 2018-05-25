<%-- 
    Document   : eliminar
    Created on : 01-may-2018, 14:41:08
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Registros</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h2>Escoge registro/s a eliminar</h2>
            <form action="eliminar" method="post">
                <ul>
                <c:forEach var="a" items="${aves}">
                    <li><input type="checkbox" name="anilla" id="${a.anilla}" value="${a.anilla}"/>
                    <label for="${a.anilla}">${a.anilla} - ${a.especie} - ${a.lugar} - ${a.fecha}</label>
                    </li>
                </c:forEach>
                </ul>
                    <p><input type="submit" name="enviar" value="Enviar"/></p>
            </form>
        </div>
    </body>
</html>
