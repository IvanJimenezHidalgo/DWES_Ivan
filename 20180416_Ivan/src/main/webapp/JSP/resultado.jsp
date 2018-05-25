<%-- 
    Document   : resultado
    Created on : 16-abr-2018, 21:55:15
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Calculadora</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body>
        
        <div id="contenido">
            <h1>Resultado Calculadora</h1>
            <p>Resultado de la operación: <fmt:formatNumber type = "number" 
         maxFractionDigits = "2" value = "${resultado.op1}" /> ${resultado.operacion} <fmt:formatNumber type = "number" 
         maxFractionDigits = "2" value = "${resultado.op2}" /> = <fmt:formatNumber type = "number" 
         maxFractionDigits = "2" value = "${resultado.resultado}" /></p>
            <p>
                <a href="${pageContext.request.contextPath}/index.jsp">Volver</a>
            </p>
        </div>
    </body>
</html>
