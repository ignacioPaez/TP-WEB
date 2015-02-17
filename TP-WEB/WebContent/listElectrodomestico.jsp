<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Electrodomesticos</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Id</th>
                <th>Precio</th>
                <th>Peso</th>
                <th>Color</th>
                <th>Consumo</th>
                <th>Carga</th>
                <th>Resolucion</th>
                <th>Sintonizador</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${electrodomesticos}" var="lavarropa">
                <tr>
                    <td><c:out value="${lavarropa.idElectrodomestico}" /></td>
                    <td><c:out value="${lavarropa.precioBase}" /></td>
                    <td><c:out value="${lavarropa.peso}" /></td>
                    <td><c:out value="${lavarropa.color.color}" /></td>
                    <td><c:out value="${lavarropa.consumoEnergetico.consumoEner}" /></td>                    
                   	<c:if test="${lavarropa.getClass().name == 'modelo.Lavarropa'}">
 						<td><c:out value="${lavarropa.carga}" /></td>
 						<td><c:out value="" /></td>
                   		<td><c:out value="" /></td>
 						<td><a href="ControladorLavarropa?action=edit&idElectrodomestico=<c:out value="${lavarropa.idElectrodomestico}"/>">Update</a></td>
                    	<td><a href="ControladorLavarropa?action=delete&idElectrodomestico=<c:out value="${lavarropa.idElectrodomestico}"/>">Delete</a></td>
					</c:if>
					<c:if test="${lavarropa.getClass().name == 'modelo.Televisor'}">
 						<td><c:out value="" /></td>
 						<td><c:out value="${lavarropa.resolucion}" /></td>
                   		<td><c:out value="${lavarropa.sintonizador}" /></td>
 						<td><a href="ControladorTelevisor?action=edit&idElectrodomestico=<c:out value="${lavarropa.idElectrodomestico}"/>">Update</a></td>
                    	<td><a href="ControladorTelevisor?action=delete&idElectrodomestico=<c:out value="${lavarropa.idElectrodomestico}"/>">Delete</a></td>
					</c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ControladorLavarropa?action=insert">Add Lavarropa</a></p>
    <p><a href="ControladorTelevisor?action=insert">Add Televisor</a></p>
</body>
</html>