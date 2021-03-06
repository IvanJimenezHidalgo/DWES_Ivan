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
                    <td>Id</td>
                    <td><input type="text" name="idPersona" value="${persona.idPersona}" readonly="readonly" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${persona.nombre}" /></td>
                </tr>
                <tr>
                    <td colspan="2">Libros</td>
                </tr>
     
                    <tr>
                        <td>Titulo</td>
                        <td>
                            <input type="number" name="id1" value="${persona.libros[0].idLibro}" hidden/>
                            <input type="text" name="titulo1" value="${persona.libros[0].titulo}" />
                        </td>
                    </tr>
                <tr>
                        <td>Titulo</td>
                        <td>
                            <input type="number" name="id2" value="${persona.libros[1].idLibro}" hidden/>
                            <input type="text" name="titulo2" value="${persona.libros[1].titulo}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Titulo</td>
                        <td>
                            <input type="number" name="id3" value="${persona.libros[2].idLibro}" hidden/>
                            <input type="text" name="titulo3" value="${persona.libros[2].titulo}" />
                        </td>
                    </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
                </tr>
            </table>
        </form>
        </div>


    </body>
</html>