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
	
	<form action="modificarDatos" method="POST">
	<table>
		<tr>
			<td>Login:</td><td id="login"><jsp:getProperty property="login" name="user" /></td>
		</tr>
		<tr>
			<td>Nombre:</td>
				<td id="name"><input type="text" name="name" size="15"
					value="<jsp:getProperty property="name" name="user"/>">
		</tr>
		<tr>
			<td>Apellidos:</td>
				<td id="surname"><input type="text" name="surname" size="15"
					value="<jsp:getProperty property="surname" name="user" />">
			</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td id="email">
					<input type="text" name="email" size="15"
						value="<jsp:getProperty property="email" name="user"/>"> 
				
			</td>
		</tr>
		<tr>
			<td>
			<input type="submit" value="Modificar">
			</td>
		</tr>
		
	</table>
	</form>
	
	<br/>
	<a href="contraseñas.jsp">Modificar contraseña</a></li>
</body>
</html>