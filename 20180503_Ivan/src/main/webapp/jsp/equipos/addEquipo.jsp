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
        <title>Añadir Equipo</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Introduce los datos del equipo</h1>
            <form action="medio?op=addEq" method="post">
                <p>
                    <label>Marca: </label>
                    <input type="text" name="marca" required/>
                </p>
                <p>
                    <label>Numero de Serie: </label>
                    <input type="text" name="numserie" required/>
                </p>
                <p>
                    <input type="submit" name="enviar" value="Enviar"/>
                    <input type="button" onclick="location.href='index.html';" value="Cancelar"/>
                </p>
            </form>
        </div>
    </body>
</html>
