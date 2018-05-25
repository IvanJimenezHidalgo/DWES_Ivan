<%-- 
    Document   : actualizar
    Created on : 01-may-2018, 15:05:50
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar datos registro</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h2>Modifique los datos</h2>
            <form action="actualizar" method="post">
                <input type="text" name="anilla" value="${ave.anilla}" hidden/>
                <p>
                    <label>Especie</label><input type="text" name="especie" value="${ave.especie}"/>
                </p>
                <p>
                    <label>Lugar</label><input type="text" name="lugar" value="${ave.lugar}"/>
                </p>
                <p>
                    <label>Fecha</label><input type="text" name="fecha" value="${ave.fecha}"/>
                </p>
                <p>
                    <input type="submit" name="enviar" value="Enviar"/>
                    <input type="reset" name="limpiar" value="Limpiar"/>
                </p>
            </form>
        </div>
    </body>
</html>
