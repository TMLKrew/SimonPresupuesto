<%-- 
    Document   : visualizar.jsp
    Created on : 19-oct-2017, 16:49:04
    Author     : Simon
--%>

<%@page import="es.albarregas.seguromvc.beans.Edificio"%>
<%@page import="es.albarregas.seguromvc.beans.Contenido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/estilo.css">
    </head>
    
        <%@include file="../../inc/cabecera.inc"%>
        
            <% HttpSession sesion = request.getSession();
            float contenido = 0;
            float edificio = 0;
            if (sesion.getAttribute("edificio") != null ){
                Edificio edif = (Edificio) sesion.getAttribute("edificio");
                edificio = edif.getCuota();
            }
           if (sesion.getAttribute("contenido") != null ){
               Contenido cont = (Contenido) sesion.getAttribute("contenido");
                contenido = cont.getCuota();
           }
            sesion.invalidate();
            %>
        <div id="visualizar">
        <h1>Presupuesto</h1>
        <p>Cuota: <%= String.format("%.2f", (contenido + edificio) ) %>€</p>
        <p><a href="<%= request.getContextPath()%>/jsp/jspEstandar/index.jsp">Menú inicial</a></p>   
        </div>
         <%@include file="../../inc/pie.inc" %>
    
</html>
