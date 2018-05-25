<%-- 
    Document   : crear
    Created on : 01-may-2018, 13:22:49
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadir ave</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"
    </head>
    <body>
        <div id="contenido">
            <h2>Añadir Ave</h2>
            <form action="${pageContext.request.contextPath}/crear" method="post">
                <p>
                    <label>Anilla</label>
                    <input type="text" name="anilla" required/>
                </p>
                <p>
                    <label>Especie</label>
                    <input type="text" name="especie" required/>
                </p>
                <p>
                    <label>Lugar</label>
                    <input type="text" name="lugar" required/>
                </p>
                <p>
                    <label>Fecha</label>
                    <input type="text" name="fecha" required/>
                </p>
                <p>
                    <input type="submit" name="enviar" value="Enviar"/>
                    <input type="reset" name="limpiar" value="Limpiar"/>
                </p>
            </form>
        </div>
    </body>
</html>
