<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Registro</title>
<link rel="stylesheet" href="./style.css">

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="parts/barraNavegacion.jsp"%>

	<div class="container">
		<%@ include file="parts/mostrarErrores.jsp"%>

		<div class="row form-center">
			<div class="col-md-6 col-md-offset-3 ">
				<h1>Registrese</h1>

				<hr>
				<form class="form-horizontal" action="registro" method="POST">
					<div class="form-group">
						<label class="col-sm-4 control-label">Nombre de usuario: </label>
						<input class="col-sm-8" type="text" name="nombreUsuario"
							placeholder="Nombre de usuario">
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Nombre: </label> <input
							class="col-sm-8" type="text" name="nombre" placeholder="Nombre">
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Apellidos: </label> <input
							class="col-sm-8" type="text" name="apellidos"
							placeholder="Apellidos">
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Correo electronico:
						</label> <input class="col-sm-8" type="text" name="email"
							placeholder="Correo electronico">
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Contraseña: </label> <input
							class="col-sm-8" type="password" name="password"
							placeholder="Contraseña">
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Repita su
							contraseña: </label> <input class="col-sm-8" type="password"
							name="password2" placeholder="Repita su contraseña">
					</div>

					<input class="btn btn-primary" type="submit" value="Registrarse">
					<input class="btn btn-danger" type="reset"
						value="Borrar formulario">

				</form>
			</div>
		</div>

	</div>

</body>
</html>
