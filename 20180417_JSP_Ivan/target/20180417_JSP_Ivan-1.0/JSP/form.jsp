<%-- 
    Document   : form
    Created on : 17-abr-2018, 17:06:44
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <form action="../${param.url}" method="post">
                <p>
                    <label>Nombre</label>
                    <input type="text" name="nombre"/>
                </p>
                <p>
                    <label>Nº de hijos</label>
                    <input type="number" name="numHijos"/>
                </p>
                <p>
                    <label>Sueldo</label>
                    <input type="number" step="any" name="sueldo"/>
                </p>
                <p>
                    <label>Dirección</label>
                    <input type="text" name="domicilio"/>
                </p>
                <p>
                    <label>Localidad</label>
                    <input type="text" name="localidad"/>
                </p>
                <input type="hidden" name="tipo" value="${param.tipo}"/>
                <input type="submit" name="enviar" value="Enviar"/>
                <input type="reset" name="limpiar" value="Limpiar"/>
            </form>
        </div>
    </body>
</html>
