<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new Televisor</title>
</head>
<body>

    <form method="POST" action='ControladorTelevisor' name="frmAddUser">
        ID : <input type="text" readonly="readonly" name="idElectrodomestico"
            value="<c:out value="${lavarropa.idElectrodomestico}" />" /> <br /> 
        Peso : <input
            type="text" name="peso"
            value="<c:out value="${lavarropa.peso}" />" /> <br /> 
        Precio : <input
            type="text" name="precioBase"
            value="<c:out value="${lavarropa.precioBase}" />" /> <br /> 
        Color : <select name="color" id="color">
        			<option value="Blanco"  ${lavarropa.color.color == 'Blanco' ? 'selected' : ''}>Blanco</option>
					<option value="Negro" 	${lavarropa.color.color == 'Negro' ? 'selected' : ''}>Negro</option>
					<option value="Azul" 	${lavarropa.color.color == 'Azul' ? 'selected' : ''}>Azul</option>
					<option value="Gris" 	${lavarropa.color.color == 'Gris' ? 'selected' : ''}>Gris</option>
					<option value="Rojo" 	${lavarropa.color.color == 'Rojo' ? 'selected' : ''}>Rojo</option>        
        		</select><br />  
       Consumo : <select name="consumo" id="consumo">
					<option value="A"  ${lavarropa.consumoEnergetico.consumoEner == 'A'.charAt(0) ? 'selected' : ''}>A</option>
					<option value="B"  ${lavarropa.consumoEnergetico.consumoEner == 'B'.charAt(0)  ? 'selected' : ''}>B</option> 
					<option value="C"  ${lavarropa.consumoEnergetico.consumoEner == 'C'.charAt(0)  ? 'selected' : ''}>C</option> 
					<option value="D"  ${lavarropa.consumoEnergetico.consumoEner == 'D'.charAt(0)  ? 'selected' : ''}>D</option> 
					<option value="E"  ${lavarropa.consumoEnergetico.consumoEner == 'E'.charAt(0)  ? 'selected' : ''}>E</option> 
					<option value="F"  ${lavarropa.consumoEnergetico.consumoEner == 'F'.charAt(0)  ? 'selected' : ''}>F</option>                 
        		</select><br />   
        Resolucion : <input type="text" name="resolucion" value="<c:out value="${lavarropa.resolucion}" />" /> <br />
		Sintonizador : <select name="sintonizador" id="sintonizador">
					<option value="Si"  ${lavarropa.sintonizador == 'Si' ? 'selected' : ''}>Si</option>
					<option value="No"  ${lavarropa.sintonizador == 'No' ? 'selected' : ''}>No</option>            
        				</select><br />  
        			<input type="submit" value="Submit" />
    </form>
</body>
</html>