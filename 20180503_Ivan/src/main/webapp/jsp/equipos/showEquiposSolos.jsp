<%-- 
    Document   : addAlumno
    Created on : 06-may-2018, 18:46:33
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Equipos sin asignar</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Equipos sin asignar</h1>
            <table>
                <thead>
                    <tr>
                        <th>Id Equipo</th>
                        <th>Marca</th>
                        <th>Nº de serie</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="e" items="${equipos}">
                        <tr>
                            <td>${e.idequipo}</td>
                            <td>${e.marca}</td>
                            <td>${e.numserie}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p>
                <a href="${pageContext.request.contextPath}/index.html">Volver</a>
            </p>
        </div>
    </body>
</html>
