<%-- 
    Document   : contadorCookie
    Created on : 12-abr-2018, 16:25:20
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contador con Cookies</title>
    </head>
    <body>
        <%
            Cookie cookie = null;
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("miCookie")) {
                        cookie = cookies[i];
                    }
                }
            }

            if (cookie == null) {
                cookie = new Cookie("miCookie", "0");
            } else if (request.getParameter("eliminar") != null) {
                cookie.setValue("0");
            }
            int contador = Integer.parseInt(cookie.getValue());
            cookie.setValue(Integer.toString(contador + 1));
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

        %>
        <form action="contadorCookie.jsp" method="post">


            <%if (cookie.getValue().equals("1")) {
            %>
            <h1>Has visitado la página <%=cookie.getValue()%> vez</h1>
            <p>Nombre: <%=cookie.getName()%></p>
            <p>Host: <%=cookie.getDomain()%></p>
            <p>Path: <%=cookie.getPath()%></p>
            <p>Seguridad: <%=cookie.getSecure()%></p>
            <p>Caducidad: <%=cookie.getMaxAge()%></p>
            <p>Versión: <%=cookie.getVersion()%></p>
            <%
            } else {
            %><h1>Has visitado la página <%=cookie.getValue()%> veces</h1><%
                }
            %>
            <p>
                <input type="submit" value="Actualizar" name="actualizar"/>
                <input type="submit" value="Eliminar" name="eliminar"/>
                <button><a href="../index.html">Índice</a></button>
            </p>
        </form>
    </body>
</html>
