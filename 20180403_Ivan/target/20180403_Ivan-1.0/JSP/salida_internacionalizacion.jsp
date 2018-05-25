<%-- 
    Document   : salida_internacionalizacion
    Created on : 19-abr-2018, 17:16:18
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilo.css"/>
    </head>
    <body>
        <div id="contenido">
            <p>País: ${cod[1]}</p>
            <p>Saludo: 
                <fmt:bundle basename="${cod[0]}">
                    <fmt:message key="saludo"/>
                </fmt:bundle>
            </p>
            <p>Despedida 
                <fmt:bundle basename="${cod[0]}">
                    <fmt:message key="despedida"/>
                </fmt:bundle>
            </p>
            <p>
                <a href="${pageContext.request.contextPath}/internacionalizacion">Volver</a>
            </p>
        </div>
    </body>
</html>
