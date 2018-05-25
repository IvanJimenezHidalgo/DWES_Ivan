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
            <h2>Actualizaci&oacute;n de datos</h2>
        <form method="post" action="conclusion?op=update">
            <table>
                <tr>
                    <td>Código</td>
                    <td><input type="text" name="id" value="${profesor.id}" readonly="readonly" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${profesor.nombre}" /></td>
                </tr>
                <tr>
                    <td>Apellido 1</td>
                    <td><input type="text" name="ape1" value="${profesor.ape1}" /></td>
                </tr>
                <tr>
                    <td>Apellido 2</td>
                    <td><input type="text" name="ape2" value="${profesor.ape2}" /></td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td>Calle</td>
                    <td><input type="text" name="calle" value="${profesor.direccion.calle}"/></td>
                </tr>
                <tr>
                    <td>Número</td>
                    <td><input type="text" name="numero" value="${profesor.direccion.numero}"/></td>
                </tr>
                <tr>
                    <td>Población</td>
                    <td><input type="text" name="poblacion" value="${profesor.direccion.poblacion}"/></td>
                </tr>
                <tr>
                    <td>Provincia</td>
                    <td><input type="text" name="provincia" value="${profesor.direccion.provincia}"/></td>
                </tr>
                <tr>
                    
                    <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
                </tr>
            </table>
        </form>
        </div>


    </body>
</html>