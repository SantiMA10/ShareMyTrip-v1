package uo.sdi.acciones.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.acciones.Accion;
import uo.sdi.model.User;
import alb.util.log.Log;

public class CerrarSesionAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		String resultado = "EXITO";

		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			String nombreUsuario = ((User) session.getAttribute("user"))
					.getLogin();
			session.invalidate();
			Log.info("El usuario [%s] ha cerrado sesion correctamente",
					nombreUsuario);
		} else {
			session.invalidate();
			Log.error("Ha ocurrido un error al cerrar sesion");

		}

		return resultado;
	}

}
