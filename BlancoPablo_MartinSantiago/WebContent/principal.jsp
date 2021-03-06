<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="parts/comprobarSesion.jsp"%>

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
	<%@ include file="parts/barraNavegacion.jsp"%>
	<div class="container">
		<%@ include file="parts/mostrarErrores.jsp"%>
		<%@ include file="parts/mostrarExito.jsp"%>
		<div class="row">
			<div class="col-md-4">
				<jsp:useBean id="user" class="uo.sdi.model.User" scope="session" />

				<h3>Datos usuario:</h3>
				<hr>
				<p>
					Nombre de usuario:
					<jsp:getProperty property="login" name="user" />
				</p>
				<p>
					Nombre:
					<jsp:getProperty property="name" name="user" />
				</p>
				<p>
					Apellidos:
					<jsp:getProperty property="surname" name="user" />
				</p>
				<p>
					Correo electronico:
					<jsp:getProperty property="email" name="user" />
				</p>
			</div>
			<div class="col-md-4">
				<h3>Modificar datos</h3>

				<hr>
				<form class="form-horizontal" action="modificarDatos" method="POST">
					<div class="form-group">
						<label class="col-sm-4 control-label">Nombre: </label> <input
							class="col-sm-8" type="text" name="name" placeholder="Nombre"
							value="<jsp:getProperty property="name" name="user"/>">
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Apellidos: </label> <input
							class="col-sm-8" type="text" name="surname"
							placeholder="Apellidos"
							value="<jsp:getProperty property="surname" name="user"/>">
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Correo electronico:
						</label> <input class="col-sm-8" type="text" name="email"
							placeholder="Correo electronico"
							value="<jsp:getProperty property="email" name="user"/>">
					</div>

					<div class="form-center">
						<input class="btn btn-primary" type="submit" value="Cambiar datos">
					</div>

				</form>
			</div>
			<div class="col-md-4">
				<h3>Modificar contraseña</h3>

				<hr>
				<form class="form-horizontal" action="modificarContrasena"
					method="POST">
					<div class="form-group">
						<label class="col-sm-4 control-label">Contraseña actual: </label>
						<input class="col-sm-8" type="password" name="contrasena"
							placeholder="Contraseña">
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Contraseña nueva: </label> <input
							class="col-sm-8" type="password" name="contrasenaNueva"
							placeholder="Repita su contraseña">
					</div>

					<div class="form-group">
						<label class="col-sm-4 control-label">Repita su contraseña
							nueva: </label> <input class="col-sm-8" type="password"
							name="contrasenaNuevaConfirmada"
							placeholder="Repita su contraseña">
					</div>

					<div class="form-center">
						<input class="btn btn-primary" type="submit"
							value="Cambiar contraseña">
					</div>

				</form>
			</div>
		</div>
	</div>
	<div class="container">
		<hr>
		<h4 class="form-center">Es Vd el usuario número: ${contador}</h4>

	</div>
</body>
</html>
