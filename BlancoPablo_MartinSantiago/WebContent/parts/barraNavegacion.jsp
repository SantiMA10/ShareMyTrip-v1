<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<h2>ShareMyTrip</h2>
	<c:if test="${user == null}">
		<ul>
			<li><a href="login.jsp">Iniciar sesión</a></li>
			<li><a href="registro.jsp">Registrarse</a></li>
		</ul>
	</c:if>
	<c:if test="${user != null}">
		<ul>
			<li><a href="listarViajes">Viajes disponibles</a></li>
			<li><a href="misviajes.jsp">Mis viajes</a></li>
			<li><a href="datosPersonales.jsp">Mis datos</a></li>
			<li><a id = "cerrarSesion" href="cerrarSesion">Salir</a></li>
		</ul>
	</c:if>
</header>
