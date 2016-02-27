<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<title>ShareMyTrip - Inicie sesión</title>
	<link rel="stylesheet" href="./style.css">

	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="bootstrap/jquery.min.js"></script></head>
	<script src="bootstrap/js/bootstrap.min.js"></script>
<body>

	<%@ include file="parts/barraNavegacion.jsp" %>
	<%@ include file="parts/mostrarErrores.jsp" %>
	<div class="contenido">
	  <form action="validarse" method="post">
	
	 	<center><h1>Inicie sesión</h1></center>
	 	<hr><br>
	 	<table align="center">
	    	<tr> 
	    		<td align="right">Usuario</td>
		    	<td><input type="text" name="nombreUsuario" align="left" size="15"></td>
	      	</tr>
	      	<tr> 
	    		<td align="right">Contraseña</td>
		    	<td><input type="password" name="contrasena" align="left" size="15"></td>
	      	</tr>
	      	<tr>
	    	    <td><input type="submit" value="Enviar"/></td>
	      	</tr>
	      </table>
	   </form>
	   <a id="listarViajes" href="listarViajes">Lista de viajes</a>
   </div>
</body>
</html>