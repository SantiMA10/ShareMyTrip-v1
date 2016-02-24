<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>ShareMyTrip - Datos personales</title>
	<link rel="stylesheet" href="./style.css">

	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/jquery.min.js"></script>
</head>
<body>
	<%@ include file="parts/barraNavegacion.jsp" %>
	<jsp:useBean id="user" class="uo.sdi.model.User" scope="session" />
	
	<form action="modificarContraseña" method="POST">
	<table>
		<tr>
			<td>Contraseña antigua:</td>
			<td id="contraseña">
					<input type="password" name="contraseña" size="15"
						value=""> 
				
			</td>
		</tr>
		<tr>
			<td>Contraseña nueva:</td>
			<td id="contraseñaNueva">
					<input type="password" name="contraseñaNueva" size="15"
						value=""> 
				
			</td>
		</tr>
		<tr>
			<td>Confirmar contraseña:</td>
			<td id="contraseñaNuevaConfirmada">
					<input type="password" name="contraseñaNuevaConfirmada" size="15"
						value=""> 
				
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Modificar contraseña">
			</td>
		</tr>
		
	</table>
	</form>
</body>
</html>