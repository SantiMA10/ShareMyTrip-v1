<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Registro</title>
</head>
<body>
	
	<%@ include file="mostrarErrores.jsp" %>

	<form action="registro" method="POST">
	
		<input type="text" name="nombreUsuario" placeholder="Nombre de usuario">
		<input type="text" name="nombre" placeholder="Nombre">
		<input type="text" name="apellidos" placeholder="Apellidos">
		<input type="text" name="email" placeholder="Correo electronico">
		<input type="password" name="password" placeholder="Contraseña">
		<input type="password" name="password2" placeholder="Repita su contraseña">
		
		<input type="submit">
		
	</form>
</body>
</html>
