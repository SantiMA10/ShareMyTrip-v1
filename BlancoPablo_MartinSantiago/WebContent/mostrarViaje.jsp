<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="parts/comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Listado de viajes</title>

<link rel="stylesheet" href="./style.css">

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="parts/barraNavegacion.jsp"%>
	<div class="container">
		<h2>${ viaje.departure.city }-${  viaje.destination.city }</h2>
		<table class="table talbe-condensed">
			<tr>
				<td>Fecha de cierre de inscripciones:</td>
				<td>${ viaje.closingDate }</td>
			</tr>
			<tr>
				<td>Fecha de salida:</td>
				<td>${ viaje.departureDate }</td>
			</tr>
			<tr>
				<td>Fecha de llegada:</td>
				<td>${ viaje.arrivalDate }</td>
			</tr>
			<tr>
				<td>Plazas</td>
				<td>${ viaje.availablePax }/${ viaje.maxPax }</td>
			</tr>
			<tr>
				<td>Coste del viaje:</td>
				<td>${ viaje.estimatedCost }</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
		</table>
		<c:if test="${ user != null }">
			<h3>Sobre el promotor</h3>
			<table class="table talbe-condensed">
				<tr>
					<td>Nombre:</td>
					<td>${ promotor.name }${ promotor.surname }</td>
				</tr>
				<tr>
					<td>Valoracion:</td>
					<td>4</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
			</table>
			<h3>Participantes</h3>
			${ participantes }
			
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-primary btn-lg"
				data-toggle="modal" data-target="#pedirPlaza">Solicitar plaza</button>

			<%@ include file="parts/modalPedirPlaza.jsp"%>
		</c:if>
	</div>
</body>
</html>