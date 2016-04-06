package uo.sdi.acciones.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.acciones.Accion;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.UserDao;
import uo.sdi.util.Comprobante;
import alb.util.log.Log;

public class ModificarDatosAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		List<String> errores = new ArrayList<String>();
		String resultado = "EXITO";

		String nuevoNombre = request.getParameter("name");
		String nuevoApellido = request.getParameter("surname");
		String nuevoEmail = request.getParameter("email");
		HttpSession session = request.getSession();
		User usuario = ((User) session.getAttribute("user"));

		// Comprobar que los datos no son vacios ni null
		if (!Comprobante.comprobarDatos(nuevoNombre))
			errores.add("No se puede dejar vacio el campo nombre");
		if (!Comprobante.comprobarDatos(nuevoApellido))
			errores.add("No se puede dejar vacio el campo Apellido");
		if (!Comprobante.comprobarDatos(nuevoEmail))
			errores.add("No se puede dejar vacio el campo Email");

		if (errores.isEmpty()) {
			usuario.setName(nuevoNombre);
			usuario.setSurname(nuevoApellido);
			usuario.setEmail(nuevoEmail);
			try {
				UserDao dao = PersistenceFactory.newUserDao();
				dao.update(usuario);
				Log.debug("Modificado datos de [%s] con el valor [%s]",
						usuario.getLogin(), nuevoEmail);
			} catch (Exception e) {
				Log.error("Algo ha ocurrido actualizando el email de [%s]",
						usuario.getLogin());
			}
		}

		else {
			Log.info("Hay campos vacios");
			resultado = "FRACASO";
		}

		request.setAttribute("errores", errores);

		return resultado;
	}

	@Override
	public String toString() {
		return getClass().getName();
	}

}
