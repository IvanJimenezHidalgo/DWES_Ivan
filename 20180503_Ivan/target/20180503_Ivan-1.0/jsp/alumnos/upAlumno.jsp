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
        <title>Seleccionar Alumno</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Escoge alumno a actualizar</h1>
            <form action="medio?op=upAl" method="post">
                <c:forEach var="a" items="${alumnos}">
                    <p>
                        <input type="radio" name="idalumno" id="${a.idalumno}" value="${a.idalumno}" required/>
                        <label for="${a.idalumno}">${a.idalumno}. ${a.nombre} - ${a.grupo}</label>
                    </p>
                </c:forEach>
                    <p>
                        <input type="submit" name="enviar" value="Enviar"/>
                        <input type="button" onclick="location.href='index.html';" value="Cancelar"/>
                    </p>
            </form>
        </div>
    </body>
</html>
