<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="parts/comprobarNavegacion.jsp" %>
<%@ include file="parts/comprobarSesion.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<title>ShareMyTrip - Página principal del usuario</title>
		<link rel="stylesheet" href="./style.css">

	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<script src="bootstrap/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="parts/barraNavegacion.jsp" %>
	<jsp:useBean id="user" class="uo.sdi.model.User" scope="session" />
	<table>
		<tr>
			<td>Login:</td><td id="login"><jsp:getProperty property="login" name="user" /></td>
		</tr>
		<tr>
			<td>Nombre:</td><td id="name"><jsp:getProperty property="name" name="user" /></td>
		</tr>
		<tr>
			<td>Apellidos:</td><td id="surname"><jsp:getProperty property="surname" name="user" /></td>
		</tr>
		<tr>
			<td>Email:</td><td id="email"><jsp:getProperty property="email" name="user"/></td>
		</tr>
	</table>
	<br/>	
	Es Vd el usuario número: ${contador}
</body>
</html>
