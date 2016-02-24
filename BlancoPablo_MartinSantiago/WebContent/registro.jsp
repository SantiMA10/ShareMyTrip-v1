<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Registro</title>
<link rel="stylesheet" href="./style.css">

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/jquery.min.js"></script>
</head>
<body>
	<%@ include file="parts/barraNavegacion.jsp"%>
	<%@ include file="parts/mostrarErrores.jsp"%>

	<div class="container">
	<center><h1>Registrese</h1></center>
	 	<hr>
		<form class="form-horizontal" action="registro" method="POST">
			<div class="form-group">
				<input type="text" name="nombreUsuario"
					placeholder="Nombre de usuario">
			</div>
			<div class="form-group">
				<input type="text" name="nombre" placeholder="Nombre">
			</div>
			<div class="form-group">
				<input type="text" name="apellidos" placeholder="Apellidos">
			</div>
			<div class="form-group">
				<input type="text" name="email" placeholder="Correo electronico">
			</div>
			<div class="form-group">
				<input type="password" name="password" placeholder="Contraseña">
			</div>
			<div class="form-group">
				<input type="password" name="password2"
					placeholder="Repita su contraseña">
			</div>

			<input type="submit">

		</form>
	</div>

</body>
</html>
