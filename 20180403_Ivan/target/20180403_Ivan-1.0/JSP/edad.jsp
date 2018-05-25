<%-- 
    Document   : edad
    Created on : 10-abr-2018, 17:17:12
    Author     : Ivan
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edad JSP</title>
    </head>
    <body>
        <%-- año = 365 días, meses = 30 días --%>
        <%
            String nombre = request.getParameter("nombre");
            String fecha = request.getParameter("fecha");
            Date fechaNac = null;
            try {
                fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            } catch (Exception ex) {
                System.out.println("Error:" + ex);
            }
            Calendar fechaNacimiento = Calendar.getInstance();
            
            Calendar fechaActual = Calendar.getInstance();
         
            fechaNacimiento.setTime(fechaNac);

            int año = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
            int mes = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
            int dia = fechaActual.get(Calendar.DATE) - fechaNacimiento.get(Calendar.DATE);
            //Se ajusta el año dependiendo el mes y el día
            if (mes < 0 || (mes == 0 && dia < 0)) {
                año--;
            }
            if(dia<0){
                if(mes<0){
                    mes+=1;
                }else{
                    mes-=1;
                }
                dia*=-1;
            }
            if(mes<0){mes*=-1;}
            String respuesta = nombre+" tienes ";
            if(año>0){
                respuesta+=año;
                if(año==1){respuesta+=" año ";
                }else{respuesta+=" años ";}
            }
            if(mes>0){
                respuesta+=mes;
                if(mes==1){respuesta+=" mes ";
                }else{respuesta+=" meses ";}
            }
            if(dia>0){
                respuesta+=dia;
                if(dia==1){respuesta+=" día";                    
                }else{respuesta+=" días";}
            }
        %>
        <p><%=respuesta%></p>
        <p>
            <a href="../HTML/edad.html">Volver</a>
        </p>
    </body>
</html>
