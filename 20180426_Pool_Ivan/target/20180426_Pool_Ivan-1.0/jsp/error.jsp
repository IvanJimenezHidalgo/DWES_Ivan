<%-- 
    Document   : error
    Created on : 01-may-2018, 14:23:19
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Ha habido un error</h1>
            <p>${error}</p>
            <p><a href="${pageContext.request.contextPath}/jsp/crear.jsp">Volver</a></p>
        </div>
    </body>
</html>
