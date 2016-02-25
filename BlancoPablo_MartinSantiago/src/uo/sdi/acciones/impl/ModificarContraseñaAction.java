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

public class ModificarContraseñaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		List<String> errores = new ArrayList<String>();

		HttpSession session = request.getSession();
		User usuario = ((User) session.getAttribute("user"));

		String contraseña = request.getParameter("contraseña");
		String contraseñaNueva = request.getParameter("contraseñaNueva");
		String contraseñaNuevaConfirmada = request
				.getParameter("contraseñaNuevaConfirmada");
		if (usuario != null) {
			if (!compararContraseñas(usuario.getPassword(), contraseña))
				errores.add("La contraseña introducida no es correcta");
			if (!compararContraseñas(contraseñaNueva, contraseñaNuevaConfirmada))
				errores.add("La contraseña nueva no coincide");
			if (errores.isEmpty()) {
				try {
					usuario.setPassword(contraseñaNueva);
					UserDao dao = PersistenceFactory.newUserDao();
					dao.update(usuario);
					Log.debug(
							"Modificada contraseña de [%s] con el valor [%s]",
							usuario.getLogin(), contraseñaNueva);
				} catch (Exception e) {

					Log.error(
							"Algo ha ocurrido actualizando la contraseña de [%s]",
							usuario.getLogin());
					resultado = "FRACASO";
				}
			}
		}
		else{
			Log.debug("El usuario no esta registrado");
			resultado = "FRACASO";
		}

		return resultado;
	}

	private boolean compararContraseñas(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		return false;
	}

}
