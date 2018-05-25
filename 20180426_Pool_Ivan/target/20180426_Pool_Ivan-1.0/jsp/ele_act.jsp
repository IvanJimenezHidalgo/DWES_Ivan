<%-- 
    Document   : ele_act
    Created on : 01-may-2018, 14:40:14
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar registro</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Escoge registro</h1>
            <form action="elecact" method="post">
                <ul>
                    <c:forEach var="ave" items="${aves}">
                        <li>
                            <input type="radio" name="anilla" id="${ave.anilla}" value="${ave.anilla}"/>
                            <label for="${ave.anilla}">${ave.anilla} - ${ave.especie}
                                - ${ave.lugar} -  ${ave.fecha}</label>
                        </li>
                    </c:forEach>
                </ul>
               
                <input type="submit" name="enviar" value="Cambiar"/>
                <br><br>
            </form>
            <button onclick="window.location.href= '${pageContext.request.contextPath}/index.html'">Cancelar</button>
        
        </div>
    </body>
</html>
