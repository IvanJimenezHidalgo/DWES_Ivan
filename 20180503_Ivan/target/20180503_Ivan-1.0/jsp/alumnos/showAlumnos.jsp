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
        <title>Listado Alumnos</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Alumnos registrados</h1>
            <table>
                <thead>
                    <tr>
                        <th>Id Alumno</th>
                        <th>Nombre</th>
                        <th>Grupo</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="a" items="${alumnos}">
                        <tr>
                            <td>${a.idalumno}</td>
                            <td>${a.nombre}</td>
                            <td>${a.grupo}</td>
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
