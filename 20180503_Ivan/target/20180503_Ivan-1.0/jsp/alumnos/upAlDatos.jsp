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
        <title>Actualizar Alumno</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Introduce los cambios</h1>
            <form action="fin?op=upAl" method="post">
                <input type="text" name="idalumno" value="${alumno.idalumno}" hidden/>
                <p>
                    <label>Nombre: </label>
                    <input type="text" name="nombre" value="${alumno.nombre}"/>
                </p>
                <p>
                    <label>Grupo</label>
                    <input type="text" name="grupo" value="${alumno.grupo}"/>
                </p>
                <p>
                    <label>Equipo: </label>
                    <select name="idequipo">
                        <option value="${alumno.equipo.idequipo}">${alumno.equipo.idequipo} - ${alumno.equipo.marca} - ${alumno.equipo.numserie}</option>
                        <c:forEach var="e" items="${equipos}">
                            <option value="${e.idequipo}">${e.idequipo} - ${e.marca} - ${e.numserie}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <input type="submit" name="enviar" value="Enviar"/>
                    <input type="button" onclick="location.href = 'index.html';" value="Cancelar"/>
                </p>
            </form>
        </div>
    </body>
</html>
