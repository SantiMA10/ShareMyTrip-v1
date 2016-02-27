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
		<%@ include file="parts/mostrarExito.jsp"%>
		
		
		<c:if test="${ listaViajes.size() > 0 }">
			<table class="table table-hover">
				<tr>
					<th>ID viaje</th>
					<th>Origen</th>
					<th>Destino</th>
					<th>Plazas libres</th>
				</tr>
				<c:forEach var="entry" items="${listaViajes}" varStatus="i">
					<tr id="item_${i.index}">
						<td><a href="mostrarViaje?id=${entry.id}">${entry.id}</a></td>
						<td>${entry.departure.city}</td>
						<td>${entry.destination.city}</td>
						<td>${entry.availablePax}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${ listaViajes.size() == 0 }">
			<div class="alert alert-warning"> No hay viajes activos en nuestro sistema.</div>
		</c:if>
	</div>
</body>
</html>