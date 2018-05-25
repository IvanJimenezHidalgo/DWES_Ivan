<%-- 
    Document   : index
    Created on : 16-abr-2018, 20:04:54
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body>
        <div id="contenido">
            <h1>Calculadora</h1>
            <br><br>
            <h3>Inserta operandos</h3>
            <form action="calcular" method="post">
                <p>
                    <input type="number" name="op1" step="any" required/>
                    &nbsp;
                    <select name="operacion">
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">x</option>
                        <option value="/">/</option>
                    </select>
                    &nbsp;
                    <input type="number" name="op2" step="any" required/>
                </p>
                <p>
                    <input type="submit" name="enviar" value="Calcular"/>
                    &nbsp;&nbsp;
                    <input type="reset" name="limpiar" value="Limpiar"/>
                </p>

            </form>
        </div>
    </body>
</html>
