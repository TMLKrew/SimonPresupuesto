<%-- 
    Document   : contenido.jsp
    Created on : 19-oct-2017, 16:48:49
    Author     : Simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Contenido</title>
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/estilo.css">
    </head>
    <body>
            <%@include file="../../inc/cabecera.inc"%>
        <div id="formulario">
        <h2>Detalles de la póliza de contenidos</h2>
        <p><em>Sírvase proporcionar información acerca de su contenido en el siguiente formulario, y a continuación, haga clic en Enviar</em></p>
        <form action="<%=request.getContextPath()%>/contenido" method="post">
        <table>           
            <tr>
                <td>Cubrir daños accidentales:</td>
                <td><input type="checkbox" name="accidentes" value="accidentes" checked="checked"></td>
            </tr>
                <tr>
                <td>Cantidad asegurada:</td>
                        <td>
                            <select name="cantidadAseg">
                                <option value="10000">10000</option>
                                <option value="20000">20000</option>
                                <option value="30000">30000</option>
                                <option value="50000">50000</option>
                                <option value="100000">100000</option>
                            </select>
                        </td>
            </tr>
            <tr>
                <td rowspan="3">Franquicia:</td>
                <td><input type="radio" name="franquicia" value="0" checked="checked">Ninguna</td>
            </tr>
               <tr>
                <td><input type="radio" name="franquicia" value="500">500</td>
            </tr>
               <tr>
               <td><input type="radio" name="franquicia" value="1000">1000</td>
            </tr>
        </table>
        <input type="submit" name="enviar" value="Enviar">
        </form>
         </div>
        <%@include file="../../inc/pie.inc" %>
    </body>
</html>
