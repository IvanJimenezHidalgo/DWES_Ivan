<%-- 
    Document   : internacionalizacion
    Created on : 19-abr-2018, 16:19:01
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Internacionalización JSTL</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilo.css"/>
    </head>
    <body>
        <div id="contenido">
            <h2>Listado de Países</h2>
            <form action="${pageContext.request.contextPath}/traduccion" method="post">
                <select name="pais">
                <c:forEach var="l" items="${locales}">
                    <c:if test="${l.displayCountry!=''}">
                        <option value="${l.language}_${l.country}-${l.displayCountry}">${l.displayCountry}-${l.language}</option>
                    </c:if>
                </c:forEach>
            </select>
                <p>
                    <input type="submit" name="enviar" value="Envíar"/>
                </p>
            </form>
        </div>
    </body>
</html>
