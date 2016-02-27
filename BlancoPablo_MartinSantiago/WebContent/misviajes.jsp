
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
	${misViajes }
		<c:if test="${ misViajes.size() > 0 }">		
			<table class="table table-hover">
				<c:forEach var="viaje" items="${misViajes}" varStatus="i">
					<tr id="item_${i.index}">
						<td${ viaje.viaje }></td>
						<td${ viaje.relacion }></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${ misViajes.size() == 0 }">
			<div class="alert alert-warning"> No tienes viajes en los que hayas participado.</div>
		</c:if>
	</div>
</body>
</html>