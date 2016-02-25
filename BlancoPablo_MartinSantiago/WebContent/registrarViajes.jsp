<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<title>ShareMyTrip - Mis viajes</title>
<link rel="stylesheet" href="./style.css">

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/jquery.min.js"></script>
</head>
<title>ShareMyTrip - Registrar viaje</title>
</head>
<body>
	<%@ include file="parts/barraNavegacion.jsp"%>
	<h3>Registrar viaje</h3>
	<form action="registrarViaje" method="POST">
		<div class="container">
			<div class="col-md-4">
				<table>
					<tr>
						<td><h4>Lugar de salida:</h4></td>
					</tr>
					<tr>
						<td>Calle:</td>
						<td id="callesalida"><input type="text" name="callesalida"
							size="15" value=""></td>
					</tr>
					<tr>
						<td>Ciudad:</td>
						<td id="ciudadsalida"><input type="text" name="ciudadsalida"
							size="15" value=""></td>
					</tr>
					<tr>
						<td>Provincia:</td>
						<td id="provinciasalida"><input type="text"
							name="provinciasalida" size="15" value=""></td>
					</tr>
					<tr>
						<td>Pais:</td>
						<td id="paissalida"><input type="text" name="paissalida"
							size="15" value=""></td>
					</tr>
					<tr>
						<td>Codigo postal:</td>
						<td id="codigopostalsalida"><input type="text"
							name="codigopostalsalida" size="15" value=""></td>
					</tr>
					<tr>
						<td>Coordenadas (opcional):</td>
						<td id="coordenadassalida"><input type="text"
							name="coordenadassalida" size="15" value=""></td>
					</tr>
					<tr>
						<td>Fecha de salida:</td>
						<td id="fechasalida"><input type="date" name="fechasalida"
							size="15" value=""></td>
					</tr>
					<tr>
						<td>Hora de salida:</td>
						<td id="horasalida"><input type="time" name="horasalida"
							size="15" value=""></td>
					</tr>

				</table>
			</div>
			<div class="col-md-4">
				<table>
					<tr>
						<td><h4>Lugar de llegada:</h4></td>
					</tr>
					<tr>
						<td>Calle:</td>
						<td id="callellegada"><input type="text" name="callellegada"
							size="15" value=""></td>
					</tr>
					<tr>
						<td>Ciudad:</td>
						<td id="ciudadllegada"><input type="text"
							name="ciudadllegada" size="15" value=""></td>
					</tr>
					<tr>
						<td>Provincia:</td>
						<td id="provinciallegada"><input type="text"
							name="provinciallegada" size="15" value=""></td>
					</tr>
					<tr>
						<td>Pais:</td>
						<td id="paisllegada"><input type="text" name="paisllegada"
							size="15" value=""></td>
					</tr>
					<tr>
						<td>Codigo postal:</td>
						<td id="codigopostalllegada"><input type="text"
							name="codigopostalllegada" size="15" value=""></td>
					</tr>
					<tr>
						<td>Coordenadas (opcional):</td>
						<td id="coordenadasllegada"><input type="text"
							name="coordenadasllegada" size="15" value=""></td>
					</tr>
					<tr>
						<td>Fecha de llegada:</td>
						<td id="fechallegada"><input type="date" name="fechallegada"
							size="15" value=""></td>
					</tr>
					<tr>
						<td>Hora de llegada:</td>
						<td id="horallegada"><input type="time" name="horallegada"
							size="15" value=""></td>
					</tr>

				</table>
			</div>
			<div class="col-md-4">
				<table>

					<tr>
						<td><h4> Datos adicionales:</h4></td>
					</tr>
					<tr>
						<td>Fecha limite de solicitud:</td>
						<td id="fechalimite"><input type="date" name="fechalimite"
							size="15" value=""></td>
					</tr>
					<tr>
						<td>Coste estimado (Se reprtira entre los participantes):</td>
						<td id="coste"><input type="text" name="coste" size="15"
							value=""></td>
					</tr>
					<tr>
						<td>Comentarios:</td>
						<td id="comentarios"><input type="text" name="comentarios"
							size="15" value=""></td>
					</tr>
					<tr>
						<td>Numero de plazas maximo:</td>
						<td id="plazasmaximo"><input type="text" name="plazasmaximo"
							size="15" value=""></td>
					</tr>
					<tr>
						<td>Numero de plazas restantes:</td>
						<td id="plazasrestantes"><input type="text"
							name="plazasrestantes" size="15" value=""></td>
					</tr>

				</table>
			</div>
			<input type="submit" value="Registrar">
		</div>
	</form>
</body>
</html>