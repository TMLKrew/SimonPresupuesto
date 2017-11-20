<%-- 
    Document   : index.jsp
    Created on : 19-oct-2017, 16:48:30
    Author     : Simon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP LE</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
        <c:import url="/inc/cabecera.inc"/>  
    <div id="formulario">
        <h2>¡Elija su seguro!</h2>
        <p><em>Por favor elegir seguro de los edificios, seguro de contenido, o ambos, marcando las casillas de abajo</em></p>
        <p>¿Qué tipo de seguro requiere?</p>
        <form action="${pageContext.request.contextPath}/eleccion" method="post">
            <p><label for="edificio"><input type="checkbox" name="edificio" value="edificio" checked="checked" id="edificio">Seguro de edificios</label></p>
            <p><label for="contenido"><input type="checkbox" name="contenido" value="contenido" checked="checked" id="contenido">Seguro de contenido</label></p>
            <input type="submit" name="enviar" value="Enviar">
        </form>
    </div>        
    <c:import url="/inc/pie.inc"/>  
</body>
</html>
