<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">ShareMyTrip</a>
		</div>
		<c:if test="${user == null}">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.jsp">Iniciar sesión</a></li>
				<li><a href="registro.jsp">Registrarse</a></li>
			</ul>
		</c:if>
		<c:if test="${user != null}">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="listarViajes">Viajes disponibles</a></li>
				<li><a href="misviajes.jsp">Mis viajes</a></li>
				<li><a href="datosPersonales.jsp">Mis datos</a></li>
				<li><a id = "cerrarSesion" href="cerrarSesion">Salir</a></li>
			</ul>
		</c:if>
	</div>
</nav>
