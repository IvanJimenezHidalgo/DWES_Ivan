<%-- 
    Document   : index
    Created on : 18-abr-2018, 0:09:43
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Carrito de la Compra</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Bienvenido a la tienda!</h1>
            <a href="${pageContext.request.contextPath}/JSP/tienda.jsp">
                <img src="${pageContext.request.contextPath}/img/logo.png" alt="tienda online"/>
            </a>
        </div>
    </body>
</html>