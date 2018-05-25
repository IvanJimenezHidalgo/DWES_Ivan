<%-- 
    Document   : leer
    Created on : 30-abr-2018, 19:54:12
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Aves</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h2>Listado de las Aves</h2>
            <table>
                <thead>
                    <tr>
                        <th>Anilla</th>
                        <th>Especie</th>
                        <th>Lugar</th>
                        <th>Fecha</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ave" items="${aves}">
                        <tr>
                            <td>${ave.anilla}</td>
                            <td>${ave.especie}</td>
                            <td>${ave.lugar}</td>
                            <td>${ave.fecha}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p><a href="${pageContext.request.contextPath}/index.html">Volver</a></p>
        </div>
    </body>
</html>
