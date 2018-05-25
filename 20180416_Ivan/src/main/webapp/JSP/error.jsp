<%-- 
    Document   : error
    Created on : 16-abr-2018, 21:55:43
    Author     : Ivan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Calculadora</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body>
        
        <div id="contenido">
            <h1>Error Calculadora</h1>
            <p>${resultado.error}</p>
            <p>
                <a href="${pageContext.request.contextPath}/index.jsp">Volver</a>
            </p>
        </div>
    </body>
</html>
