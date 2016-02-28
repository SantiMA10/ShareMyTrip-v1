<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="parts/comprobarSesion.jsp" %>
<%@ include file="parts/comprobarNavegacion.jsp" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<title>ShareMyTrip - Mis viajes</title>
		<link rel="stylesheet" href="./style.css">

	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="bootstrap/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="parts/barraNavegacion.jsp"%>
	<%@ include file="parts/mostrarErrores.jsp" %>
	<div class="container">
			<%@ include file="parts/mostrarExito.jsp"%>
		<c:if test="${ misViajes.size() > 0 }">				
			<table class="table table-hover">
				<tr>
					<th>Origen</th>
					<th>Destino</th>
					<th>Fecha de salida</th>
					<th>Relacion con el viaje</th>
				</tr>
				<c:forEach var="viaje" items="${misViajes}" varStatus="i">
					<tr id="item_${i.index}">
						<!-- Si es promotor, que vaya a la ventana del promotor -->
						<c:if test= "${viaje.viaje.promoterId == user.id }">
							<td><a href="mostrarViajePromotor?id=${viaje.viaje.id}">${ viaje.viaje.departure.city }</a></td>
						</c:if>
						<!--  Si no lo es, a la informacion -->
						<c:if test= "${viaje.viaje.promoterId != user.id }">
							<td><a href="mostrarViaje?id=${viaje.viaje.id}">${ viaje.viaje.departure.city }</a></td>
						</c:if>
						<td>${ viaje.viaje.destination.city }</td>
						<td><fmt:formatDate value="${ viaje.viaje.departureDate }" type="date" dateStyle="full" /> </td>
						<td>${ viaje.relacion }</td>
						<td>
							<c:if test="${ viaje.isCancelable() }">
							<form action="cancelarPlaza?id=${ viaje.viaje.id }" method="POST">
								<input type="submit" value="cancelar">
							</form>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${ misViajes.size() == 0 }">
			<div class="alert alert-warning"> No tienes viajes en los que hayas participado.</div>
		</c:if>
		<a href="./registrarViaje.jsp"> Registrar viaje </a>
	</div>
</body>
</html>