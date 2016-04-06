package uo.sdi.acciones.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.acciones.Accion;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.UserDao;

public class ModificarContrasenaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		List<String> errores = new ArrayList<String>();

		HttpSession session = request.getSession();
		User usuario = ((User) session.getAttribute("user"));

		String contrasena = request.getParameter("contrasena");
		String contrasenaNueva = request.getParameter("contrasenaNueva");
		String contrasenaNuevaConfirmada = request
				.getParameter("contrasenaNuevaConfirmada");
		if (usuario != null) {
			if (!compararContrasenas(usuario.getPassword(), contrasena))
				errores.add("La contraseña introducida no es correcta");
			if (!compararContrasenas(contrasenaNueva, contrasenaNuevaConfirmada))
				errores.add("La contraseña nueva no coincide");
			if (errores.isEmpty()) {
				try {
					usuario.setPassword(contrasenaNueva);
					UserDao dao = PersistenceFactory.newUserDao();
					dao.update(usuario);
					Log.debug(
							"Modificada contraseña de [%s] con el valor [%s]",
							usuario.getLogin(), contrasenaNueva);
				} catch (Exception e) {

					Log.error(
							"Algo ha ocurrido actualizando la contraseña de [%s]",
							usuario.getLogin());
					resultado = "FRACASO";
				}
			}
			else{
				Log.error(
						"Algo ha ocurrido actualizando la contraseña de [%s]",
						usuario.getLogin());
				resultado = "FRACASO";
			}
		}
		else{
			Log.debug("El usuario no esta registrado");
			resultado = "FRACASO";
		}
		
		request.setAttribute("errores", errores);

		return resultado;
	}

	private boolean compararContrasenas(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		return false;
	}

}
