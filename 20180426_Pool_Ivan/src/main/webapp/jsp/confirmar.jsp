<%-- 
    Document   : confirmar
    Created on : 01-may-2018, 13:47:09
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar datos</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Confirme los datos</h1>
            <form action="${pageContext.request.contextPath}/add" method="post">

                <input type="text" name="anilla" value="${ave.anilla}" hidden/>
                
                <p>
                    <label>Especie</label>
                    <input type="text" name="especie" value="${ave.especie}" required/>
                </p>
                <p>
                    <label>Lugar</label>
                    <input type="text" name="lugar" value="${ave.lugar}" required/>
                </p>
                <p>
                    <label>Fecha</label>
                    <input type="text" name="fecha" value="${ave.fecha}" required/>
                </p>
                <p>
                    <input type="submit" name="enviar" value="Enviar"/>
                    <input type="reset" name="limpiar" value="Limpiar"/>
                </p>
            </form>
        </div>
    </body>
</html>
