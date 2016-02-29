package uo.sdi.acciones.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.acciones.Accion;
import uo.sdi.model.Application;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class PedirPlazaAccion implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		User usuario = ((User)request.getSession().getAttribute("user"));
		Application plaza = new Application();
		plaza.setTripId(Long.valueOf(request.getParameter("id")));
		plaza.setUserId(usuario.getId());

		try{

			PersistenceFactory.newApplicationDao().save(plaza);

		} catch(Exception e){

			Log.error("Ya hay una peticion de [%s] para este el viaje [%s].", usuario.getLogin(), request.getParameter("id"));
			List<String> errores = new ArrayList<String>();
			errores.add("Ya has solicitado una plaza para este viaje, espera a ser aceptado.");
			request.setAttribute("errores", errores);

			return "FRACASO";

		}
		
		Log.info("Plaza solicitada [%s]", plaza.toString());
		request.setAttribute("mensaje", "Plaza solicitada correctamente.");

		return "EXITO";
	}

}
