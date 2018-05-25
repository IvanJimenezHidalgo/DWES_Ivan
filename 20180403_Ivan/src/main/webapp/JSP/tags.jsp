<%-- 
    Document   : tags
    Created on : 24-abr-2018, 12:57:44
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tlds/Libreria" prefix="li" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tags</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/libreria.css" />
    </head>
    <body>
        <c:set var="num" scope="page" value="{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}"/>
        <c:set var="palabra" scope="page" value="Hola Mundo"/>
        <div id="contenido">
            <h1>Etiquetas JSP personalizadas</h1>
            <table>
                <thead>
                    <tr>
                        <th>Definición</th>
                        <th>Etiqueta</th>
                        <th>Atributos</th>
                        <th>Requerido</th>
                        <th>Ejemplo</th>
                        <th>Salida</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td colspan="6" class="tipo">Estáticos</td>
                    </tr>

                <td>Formatea los números con 2 decimales o enteros</td>
                <td>formatNumber</td>
                <td>
                    formato
                    <hr>
                    numero
                </td>
                <td>
                    No
                    <hr>
                    Si
                </td>
                <td>
                    &lt;li:formatNumber formato="" numero="5.25"&gt;
                    <br>&lt;/li:formatNumber&gt;
                    <hr>
                    &lt;li:formatNumber formato="entero" numero="5.25"&gt;
                    <br>&lt;/li:formatNumber&gt;
                </td>
                <td>
                    <li:formatNumber formato="" numero="5.25">
                    </li:formatNumber>
                    <hr>
                    <li:formatNumber formato="entero" numero="5.25"></li:formatNumber>
                    </td>
                    </tr>
                    <tr>
                        <td>Enmarca el contenido y añade margen</td>
                        <td>marco</td>
                        <td>contenido</td>
                        <td>Si</td>
                        <td>
                            &lt;li:marco&gt;
                            <br>Texto<br>
                            &lt;/li:link&gt;
                        </td>
                        <td><li:marco>Texto</li:marco></td>
                    </tr>
                    <tr>
                        <td colspan="6" class="tipo">Dinámicos</td>
                    </tr>
                    <tr>
                        <td>Quita los estilos predefinidos de los enlaces</td>
                        <td>link</td>
                        <td>enlace</td>
                        <td>Si</td>
                        <td>
                            &lt;li:link enlace="#"&gt;
                            <br>enlace<br>
                            &lt;/li:link&gt;
                        </td>
                        <td><li:link enlace="#"> enlace </li:link></td>
                    </tr>
                    <tr>
                        <td>Colorea cada letra de un color aleatorio</td>
                        <td>colores</td>
                        <td>texto</td>
                        <td>Si</td>
                        <td>
                            &lt;li:colores texto="&amp;{palabra}"&gt;
                            <br>
                            &lt;/li:colores&gt;
                        </td>
                        <td>
                        <li:colores texto="${palabra}"></li:colores>
                        </td>
            </tr>
                        </tbody>
                </table>
                <p>
                <li:link enlace="${pageContext.request.contextPath}/index.html">Volver</li:link>
            </p>
        </div>
    </body>
</html>
