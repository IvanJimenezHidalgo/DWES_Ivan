<%-- 
    Document   : carrito
    Created on : 17-abr-2018, 23:10:54
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Carrito de la compra</h1>
        <p>${compra}</p>
        <p><button onclick="window.location.href='${pageContext.request.contextPath}/JSP/tienda.jsp'">Seguir comprando</button></p>
        <form action="shop" method="post">
            <input type="submit" name="comprar" value="Comprar"/>
        </form>
        </div>
    </body>
</html>
