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
        <title>Seleccionar Equipo</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Escoge equipo a eliminar</h1>
            <form action="medio?op=delEq" method="post">
                <c:forEach var="e" items="${equipos}">
                    <p>
                        <input type="radio" name="idequipo" id="${e.idequipo}" value="${e.idequipo}" required/>
                        <label for="${e.idequipo}">${e.idequipo}. ${e.marca} - ${e.numserie}</label>
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
