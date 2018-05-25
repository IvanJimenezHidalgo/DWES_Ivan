<%-- 
    Document   : tienda
    Created on : 17-abr-2018, 23:11:38
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda</title>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Escoge libro y cantidad</h1>
            <h3>${mensaje}</h3>
            <form action="${pageContext.request.contextPath}/add" method="post">

                <select name="titulo" size="5">
                    <option value="Juego de Tronos">Juego de Tronos</option>
                    <option value="Mass Effect">Mass Effect</option>
                    <option value="Los Juegos del Hambre">Los Juegos del Hambre</option>
                    <option value="El Codigo da Vinci">El Código da Vinci</option>
                    <option value="Ola de Calor">Ola de Calor</option>
                </select>
                <p>
                    <label>Cantidad</label>
                    <input type="number" name="cantidad" min="0" class="number" value="0"/>
                </p>
                <p>
                    <input type="submit" name="enviar" value="Añadir"/>
                    &nbsp;&nbsp;
                    <input type="reset" name="reset" value="Limpiar"/>
                </p>
            </form>
            <form action="${pageContext.request.contextPath}/shop" method="post">
                <input type="submit" name="carrito" value="Ir a carrito"/>
            </form>
        </div>
    </body>
</html>
