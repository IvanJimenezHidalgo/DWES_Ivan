<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contexto" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
        <link rel="stylesheet" type="text/css" href="${contexto}/CSS/estilo.css" />
    </head>
    <body>

        <div id="principal">
            <h2>Inserci&oacute;n de datos</h2>
        <form method="post" action="control?op=add">
            <table>
<%--                <tr>
                    <td>Código</td>
                    <td><input type="text" name="id"  /></td>
                </tr>--%>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" /></td>
                </tr>
                <tr>
                    <td>Apellido 1</td>
                    <td><input type="text" name="ape1"  /></td>
                </tr>
                <tr>
                    <td>Apellido 2</td>
                    <td><input type="text" name="ape2" /></td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td>Calle</td>
                    <td><input type="text" name="calle" /></td>
                </tr>
                <tr>
                    <td>Número</td>
                    <td><input type="text" name="numero" /></td>
                </tr>
                <tr>
                    <td>Población</td>
                    <td><input type="text" name="poblacion" /></td>
                </tr>
                <tr>
                    <td>Provincia</td>
                    <td><input type="text" name="provincia" /></td>
                </tr>
                <tr>
                    
                    <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
                </tr>
            </table>
        </form>
        </div>


    </body>
</html>