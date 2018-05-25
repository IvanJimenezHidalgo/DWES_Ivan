<%-- 
    Document   : fin
    Created on : 22-abr-2018, 0:44:51
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fin del juego</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>¡Fin de la partida!</h1>
            <p>${numero.salida} en ${numero.ronda} rondas</p>
            <p>¿Quieres volver a jugar?</p>
            <p>
                <a href="${pageContext.request.contextPath}/index.html">Volver</a>
            </p>
        </div>
    </body>
    <script>
function closeWindow()
{
  // Close the current window
  window.close();
}
</script>
</html>
