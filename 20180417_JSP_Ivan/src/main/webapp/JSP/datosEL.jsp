<%-- 
    Document   : datosEL
    Created on : 17-abr-2018, 17:40:41
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos EL</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h2>Datos por EL</h2>
        <p>Nombre: ${datos.nombre}</p>
        <p>Nº de hijos: ${datos.numHijos}</p>
        <p>Sueldo: ${datos.sueldo}</p>    
        <p>Domicilio: ${datos.direccion.domicilio}</p>
        <p>Localidad: ${datos.direccion.localidad}</p>
        <br>
        <p>
            <a href="index.html">Volver</a>
        </p>
        </div>
    </body>
</html>
