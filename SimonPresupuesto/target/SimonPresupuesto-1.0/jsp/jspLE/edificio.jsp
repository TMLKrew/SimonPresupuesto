<%-- 
    Document   : edificio.jsp
    Created on : 19-oct-2017, 16:48:41
    Author     : Simon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP LE Edificio</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
        <c:import url="/inc/cabecera.inc"/>
        <div id="formulario">
        <h2>Detalles de la póliza de edificios</h2>
        <p><em>Sírvase proporcionar información acerca de dónde usted vive en el siguiente formulario, y a continuación, haga clic en Enviar</em></p>
        <form action="${pageContext.request.contextPath}/edificio" method="post">
        <table>           
            <tr>
                <td>Tipo de edificio:</td>
                        <td>
                            <select name="tipoEd">
                                <option value="piso">Piso</option>
                                <option value="casa">Casa</option>
                                <option value="adosado">Adosado</option>
                                <option value="duplex">Duplex</option>
                                <option value="chalet">Chalet</option>
                            </select>
                        </td>
            </tr>
                <tr>
                <td>Número de habitaciones</td>
                        <td>
                            <select name="numeroHab">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5 o más</option>
                            </select>
                        </td>
            </tr>
            <tr>
                <td>Fecha de construcción:</td>
                        <td>
                            <select name="fecha">
                                <option value="1949">Antes de 1950</option>
                                <option value="1950">Entre 1950 y 1990</option>
                                <option value="1991">Entre 1991 y 2005</option>
                                <option value="2006">Entre 2006 y 2015</option>
                                <option value="2016">Después de 2015</option>
                            </select>
                        </td>
            </tr>
            <tr>
                <td rowspan="2">Tipo de construcción:</td>
                <td><input type="radio" name="tipoCons" value="madera" checked="checked">Madera</td>
            </tr>
             <tr>
                <td><input type="radio" name="tipoCons" value="hormigon">Hormigón</td>
            </tr>
                 <tr>
                <td>Valor estimado en el mercado:</td>
                        <td>
                            <select name="valorMer">
                                <option value="25000">Menos de 50.000</option>
                                <option value="50001">Entre 50.001 y 80.000</option>
                                <option value="80001">Entre 80.001 y 100.000</option>
                                <option value="100001">Entre 100.001 y 150.000</option>
                                <option value="150001">Más de 150.000</option>
                            </select>
                        </td>
            </tr>          
        </table>
        <input type="submit" name="enviar" value="Enviar">
        </form>
         </div>
        <c:import url="/inc/pie.inc"/>  
    </body>
</html>
