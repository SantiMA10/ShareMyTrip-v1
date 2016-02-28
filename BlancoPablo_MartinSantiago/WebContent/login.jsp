<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Inicie sesión</title>
<link rel="stylesheet" href="./style.css">

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/jquery.min.js"></script>
</head>
<script src="bootstrap/js/bootstrap.min.js"></script>
<body>

	<%@ include file="parts/barraNavegacion.jsp"%>
	<div class="container">
		<%@ include file="parts/mostrarErrores.jsp"%>

		<div class="row form-center">
			<div class="col-md-6 col-md-offset-3 ">

					<form class="form-horizontal" action="validarse" method="post">

						<h1>Inicie sesión</h1>
						<hr>
						<div class="form-group">
							<label class="col-sm-4 control-label">Nombre de usuario:
							</label> <input class="col-sm-8" type="text" name="nombreUsuario"
								placeholder="Nombre de usuario">
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Contraseña: </label> <input
								class="col-sm-8" type="text" name="contrasena"
								placeholder="Contraseña">
						</div>
						
						<input class="btn btn-primary" type="submit" value="Registrarse">
						<input class="btn btn-danger" type="reset" value="Borrar formulario">
					</form>
			</div>
		</div>


	</div>
</body>
</html>