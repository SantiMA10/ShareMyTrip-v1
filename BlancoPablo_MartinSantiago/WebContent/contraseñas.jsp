<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>ShareMyTrip - Datos personales</title>
	<link rel="stylesheet" href="./style.css">
</head>
<body>
	<%@ include file="barraNavegacionUsuario.jsp" %>
	<jsp:useBean id="user" class="uo.sdi.model.User" scope="session" />
	
	<form action="modificarContrase�a" method="POST">
	<table>
		<tr>
			<td>Contrase�a antigua:</td>
			<td id="contrase�a">
					<input type="text" name="contrase�a" size="15"
						value=""> 
				
			</td>
		</tr>
		<tr>
			<td>Contrase�a nueva:</td>
			<td id="contrase�aNueva">
					<input type="text" name="contrase�aNueva" size="15"
						value=""> 
				
			</td>
		</tr>
		<tr>
			<td>Confirmar contrase�a:</td>
			<td id="contrase�aNuevaConfirmada">
					<input type="text" name="contrase�aNuevaConfirmada" size="15"
						value=""> 
				
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Modificar contrase�a">
			</td>
		</tr>
		
	</table>
	</form>
</body>
</html>