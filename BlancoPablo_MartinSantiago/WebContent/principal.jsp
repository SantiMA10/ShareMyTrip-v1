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
				<form class="form-horizontal" action="#" method="POST">
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

					<div class="form-center">
						<input class="btn btn-primary" type="submit" value="Registrarse">
						<input class="btn btn-danger" type="reset"
							value="Borrar formulario">
					</div>

				</form>
			</div>
			<div class="col-md-4">
				<h3>Modificar contraseña</h3>

				<hr>
				<form class="form-horizontal" action="#" method="POST">
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

					<div class="form-center">
						<input class="btn btn-primary" type="submit" value="Registrarse">
						<input class="btn btn-danger" type="reset"
							value="Borrar formulario">
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
