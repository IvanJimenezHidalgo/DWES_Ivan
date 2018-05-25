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
        <title>Añadir Alumno</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Introduce los datos del alumno</h1>
            <form action="medio?op=addAl" method="post">
                <p>
                    <label>Nombre: </label>
                    <input type="text" name="nombre" required/>
                </p>
                <p>
                    <label>Grupo: </label>
                    <input type="text" name="grupo" required/>
                </p>
                <p>
                    <label>Equipo: </label>
                    <select name="idequipo">
                        <option value="0">Escoge equipo</option>
                        <c:forEach var="e" items="${equipos}">
                            <option value="${e.idequipo}">${e.idequipo} - ${e.marca} - ${e.numserie}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <input type="submit" name="enviar" value="Enviar"/>
                    <input type="button" onclick="location.href='index.html';" value="Cancelar"/>
                </p>
            </form>
        </div>
    </body>
</html>
