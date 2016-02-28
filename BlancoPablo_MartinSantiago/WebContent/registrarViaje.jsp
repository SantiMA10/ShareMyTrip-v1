<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="parts/comprobarSesion.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Registrar viaje</title>
<link rel="stylesheet" href="./style.css">

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="parts/barraNavegacion.jsp"%>
	<%@ include file="parts/mostrarErrores.jsp"%>

	<form class="form-horizontal" action="registrarViaje" method="POST">
		<div class="container">
			<h3>Registrar viaje</h3>

			<div class="col-md-4">

				<h4>Lugar de salida:</h4>
				<hr>
				<div class="form-group">
					<label class="col-sm-5 control-label">Calle: </label> <input
						class="col-sm-7" type="text" name="callesalida">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Ciudad: </label> <input
						class="col-sm-7" type="text" name="ciudadsalida">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Provincia: </label> <input
						class="col-sm-7" type="text" name="provinciasalida">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Pais: </label> <input
						class="col-sm-7" type="text" name="paissalida">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Codigo postal: </label> <input
						class="col-sm-7" type="text" name="codigopostalsalida">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Coordenadas (ejem: 3,3): </label> <input
						class="col-sm-7" type="text" name="coordenadassalida">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Fecha de salida: </label> <input
						class="col-sm-7" type="date" name="fechasalida">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Hora de salida: </label> <input
						class="col-sm-7" type="time" name="horasalida">
				</div>
			</div>
			<div class="col-md-4">
			
				<h4>Lugar de llegada:</h4>
				<hr>
				<div class="form-group">
					<label class="col-sm-5 control-label">Calle: </label> <input
						class="col-sm-7" type="text" name="callellegada">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Ciudad: </label> <input
						class="col-sm-7" type="text" name="ciudadllegada">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Provincia: </label> <input
						class="col-sm-7" type="text" name="provinciallegada">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Pais: </label> <input
						class="col-sm-7" type="text" name="paisllegada">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Codigo postal: </label> <input
						class="col-sm-7" type="text" name="codigopostalllegada">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Coordenadas (ejem: 3,3): </label> <input
						class="col-sm-7" type="text" name="coordenadasllegada">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Fecha de salida: </label> <input
						class="col-sm-7" type="date" name="fechallegada">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Hora de salida: </label> <input
						class="col-sm-7" type="time" name="horallegada">
				</div>
			
			</div>
			<div class="col-md-4">
			
				<h4>Datos adicionales:</h4>
				<hr>
				<div class="form-group">
					<label class="col-sm-5 control-label">Fecha limite de solicitud: </label> <input
						class="col-sm-7" type="date" name="fechalimite">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Coste estimado (Se reprtira entre los participantes): </label> <input
						class="col-sm-7" type="number" name="coste">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Comentarios: </label> <input
						class="col-sm-7" type="area" name="comentarios">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Numero de plazas maximo: </label> <input
						class="col-sm-7" type="number" name="plazasmaximo">
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Numero de plazas restantes: </label> <input
						class="col-sm-7" type="number" name="plazasrestantes">
				</div>
				
			</div>
			<div class="form-center">
				<input class="btn btn-primary" type="submit" value="Registrar viaje">
				<input class="btn btn-danger" type="reset" value="Borrar formulario">
			</div>
		</div>
	</form>
</body>
</html>