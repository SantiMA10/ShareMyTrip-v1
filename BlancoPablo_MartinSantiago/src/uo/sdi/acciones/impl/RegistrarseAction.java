package uo.sdi.acciones.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.acciones.Accion;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.UserDao;
import alb.util.log.Log;

public class RegistrarseAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String respuesta = "EXITO";
		
		//Datos desde el formulario
		String nombreUsuario = (String) request.getParameter("nombreUsuario"),
			   nombre        = (String) request.getParameter("nombre"),
			   apellidos	 = (String) request.getParameter("apellidos"),
			   email		 = (String) request.getParameter("email"),
			   contraseña    = (String) request.getParameter("password"),
			   contraseña2   = (String) request.getParameter("password2");
		
		//Creamos el usurio con los datos
		User user = new User();
		user.setLogin(nombreUsuario);
		user.setName(nombre);
		user.setSurname(apellidos);
		user.setEmail(email);
		user.setPassword(contraseña);
		
		//Mostrando errores al usuario
		List<String> errores = new ArrayList<String>();
		if(nombreUsuario == null || nombreUsuario.isEmpty()){
			errores.add("No se puede dejar vacio el campo nombre de Usuario");
		}
		if(nombre == null || nombre.isEmpty()){
			errores.add("No se puede dejar vacio el campo nombre");
		}
		if(apellidos == null || apellidos.isEmpty()){
			errores.add("No se puede dejar vacio el campo apellidos");
		}
		if(email == null || email.isEmpty()){
			errores.add("No se puede dejar vacio el campo email");
		}
		Log.info("%s = %s", contraseña, contraseña2);
		if(contraseña == null || !contraseña.equals(contraseña2) 
				|| contraseña.isEmpty()){
			errores.add("Las contraseñas deben ser iguales");
		}
		request.getSession().setAttribute("errores", errores);
		
		if(errores.size() == 0){
			//Guardamos el usuario en la base de datos
			UserDao ud = PersistenceFactory.newUserDao();
			Log.info("Usuario %s registrado", user.getLogin());
			ud.save(user);
		}
		else{
			Log.error("Error con los datos del registro");
			respuesta = "FRACASO";
		}
		
		return respuesta;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}