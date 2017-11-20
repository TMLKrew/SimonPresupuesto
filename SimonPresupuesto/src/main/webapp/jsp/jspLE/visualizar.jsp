<%-- 
    Document   : visualizar.jsp
    Created on : 19-oct-2017, 16:49:04
    Author     : Simon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP LE Visualizar</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>

    <c:import url="/inc/cabecera.inc"/>
    <c:set var="contenido" scope="session" value="${contenido}"/>
    <c:set var="edificio" scope="session" value="${edificio}"/>
    <c:set var="eleccion" scope="session" value="${eleccion}"/>

    <div id="visualizar">

        <h1>Presupuesto</h1>
        <div id="edificio">
            <c:if test="${eleccion.edificio != null}">
                <h4>Edificio</h4>
                <table>
                    <tr>
                        <td>Tipo de edificio:</td>
                        <td><c:out value="${edificio.tipoEd}"/> </td>                       
                    </tr>
                    <tr>
                        <td>Número de habitaciones:</td>
                        <td><c:out value="${edificio.numeroHab}"/></td>
                    </tr>
                    <tr>
                        <td>Fecha de construcción:</td>
                        <td><c:out value="${edificio.fecha}"/></td>
                    </tr>
                    <tr>
                        <td>Tipo de construcción:</td>
                        <td><c:out value="${edificio.tipoCons}"/></td>
                    </tr>
                    <tr>
                        <td>Valor estimado del mercado:</td>
                        <td><fmt:formatNumber type="currency" value="${edificio.valorMer}"/></td>
                    </tr>
                </table>
                <h4>Presupuesto: <fmt:formatNumber type="currency" value="${edificio.cuota}"/></h4>
            </c:if>
        </div>
        <div id="contenido">
            <c:if test="${eleccion.contenido != null}">
                <h4>Contenido</h4>
                <table>
                    <tr>
                        <td>Cubrir daños accidentales:</td>
                        <td>
                            <c:set var="accidente" value="No"/>
                            <c:if test="${contenido.accidentes != null}">
                                <c:set var="accidente" value="Si"/> 
                            </c:if>
                            <c:out value="${accidente}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Cantidad asegurada:</td>
                        <td><fmt:formatNumber type="currency" value="${contenido.cantidadAseg}"/></td>
                    </tr>
                    <tr>
                        <td>Franquicia:</td>
                        <td><fmt:formatNumber type="currency" value="${contenido.franquicia}"/></td>
                    </tr>             
                </table>
                <h4>Presupuesto: <fmt:formatNumber type="currency" value="${contenido.cuota}"/></h4>
            </c:if>
        </div>       
        <h4>Presupuesto total:</h4>
        <p>Cuota: <fmt:formatNumber type="currency" value="${contenido.cuota + edificio.cuota}"/></p>
        <p id="inicio"><a href="${pageContext.request.contextPath}">Menú inicial</a></p>   
    </div>
    <c:import url="/inc/pie.inc"/>  

</html>
