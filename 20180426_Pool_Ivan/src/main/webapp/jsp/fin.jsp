<%-- 
    Document   : fin
    Created on : 01-may-2018, 14:16:03
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Resultado</h1>
            <p>${mensaje}</p>
            <p>
                <a href="${pageContext.request.contextPath}/index.html">Volver</a>
            </p>
        </div>
    </body>
</html>
