<%-- 
    Document   : visualizar.jsp
    Created on : 19-oct-2017, 16:49:04
    Author     : Simon
--%>

<%@page import="es.albarregas.seguromvc.beans.Eleccion"%>
<%@page import="es.albarregas.seguromvc.beans.Edificio"%>
<%@page import="es.albarregas.seguromvc.beans.Contenido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Visualizar</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/estilo.css">
    </head>
    <body>

        <%@include file="../../inc/cabecera.inc"%>

        <% HttpSession sesion = request.getSession();

            Edificio edificio = (Edificio) sesion.getAttribute("edificio");

            Contenido contenido = (Contenido) sesion.getAttribute("contenido");

            Eleccion eleccion = (Eleccion) sesion.getAttribute("eleccion");

            sesion.invalidate();
        %>

        <div id="visualizar">

            <h1>Presupuesto</h1>
            <div id="edificio">
                <% if (eleccion.getEdificio() != null) {
                %>          
                <h4>Edificio</h4>
                <table>
                    <tr>
                        <td>Tipo de edificio:</td>
                        <td><%= edificio.getTipoEd()%></td>                     
                    </tr>
                    <tr>
                        <td>Número de habitaciones:</td>
                        <td><%= edificio.getNumeroHab()%></td>  
                    </tr>
                    <tr>
                        <td>Fecha de construcción:</td>
                        <td><%= edificio.getFecha()%></td>  
                    </tr>
                    <tr>
                        <td>Tipo de construcción:</td>
                        <td><%= edificio.getTipoCons()%></td>  
                    </tr>
                    <tr>
                        <td>Valor estimado del mercado:</td>
                        <td><%= edificio.getValorMer()%></td>  
                    </tr>
                </table>
                <h4>Presupuesto: <%= edificio.getCuota()%></h4>
                <% }%>
            </div>
            <div id="contenido">
                <% if (eleccion.getContenido() != null) {
                %>

                <h4>Contenido</h4>
                <table>
                    <tr>
                        <td>Cubrir daños accidentales:</td>
                        <td>
                            <%
                                String accidente = "No";
                                if (contenido.getAccidentes() != null) {
                                    accidente = "Si";
                                }
                            %>
                            <%= accidente%>
                        </td>
                    </tr>
                    <tr>
                        <td>Cantidad asegurada:</td>
                        <td><%= contenido.getCantidadAseg()%></td>
                    </tr>
                    <tr>
                        <td>Franquicia:</td>
                        <td><%= contenido.getFranquicia()%></td>
                    </tr>             
                </table>
                <h4>Presupuesto: <%= contenido.getCuota()%></h4>
                <% }
                %>
            </div>       
            <h4>Presupuesto total:</h4>
            <p>Cuota: <%= edificio.getCuota() + contenido.getCuota()%></p>

            <div id="inicio">
                <a href="<%=request.getContextPath()%>">Menú inicial</a>
            </div>
        </div>
        <%@include file="../../inc/pie.inc" %>

    </body>
</html>
