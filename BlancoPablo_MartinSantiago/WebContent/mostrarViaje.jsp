<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="parts/comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Listado de viajes</title>

<link rel="stylesheet" href="./style.css">

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<fmt:setLocale value="es_ES"/>
</head>
<body>
	<%@ include file="parts/barraNavegacion.jsp"%>
	<div class="container">
		<h2>${ viaje.departure.city }-${  viaje.destination.city }</h2>
		<table class="table talbe-condensed">
			<tr>
				<td>Fecha de cierre de inscripciones:</td>
				<td><fmt:formatDate value="${ viaje.closingDate }"  type="date" dateStyle="full" /> 
				a la/s 
				<fmt:formatDate value="${ viaje.closingDate }"  type="time" dateStyle="short" /></td>
				
			</tr>
			<tr>
				<td>Fecha de salida:</td>
				<td><fmt:formatDate value="${ viaje.departureDate }" type="date" dateStyle="full" /> 
				a la/s 
				<fmt:formatDate value="${ viaje.departureDate }"  type="time" dateStyle="short" /></td>
			</tr>
			<tr>
				<td>Fecha de llegada:</td>
				<td><fmt:formatDate value="${ viaje.arrivalDate }" type="date" dateStyle="full" /> 
				a la/s 
				<fmt:formatDate value="${ viaje.departureDate }"  type="time" dateStyle="shot" /></td>
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
			<c:if test="${ participantes.size() == 0 }">
				No hay participantes aun.
			</c:if>
			<c:if test="${ participantes.size() > 0 }">
				<c:forEach var="participante" items="${participantes}" varStatus="i">
					<table class="table talbe-condensed">
				<tr>
					<td>Nombre:</td>
					<td>${ participante.name }${ participante.surname }</td>
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
				</c:forEach>
			</c:if>
			
			<form action="pedirPlaza?id=${ viaje.id }" method="post">
				<input type="submit" value="Pedir plaza">
			</form>
		</c:if>
	</div>
</body>
</html>