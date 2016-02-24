package uo.sdi.acciones.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.acciones.Accion;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class MostrarViajeAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Trip viaje;
		User promotor;
		
		try {
			viaje=PersistenceFactory.newTripDao().findById(Long.valueOf(request.getParameter("id")));
			promotor = PersistenceFactory.newUserDao().findById(viaje.getPromoterId());
			request.setAttribute("viaje", viaje);
			request.setAttribute("promotor", promotor);
			Log.debug("Obtenida informacion del viaje [%d]", viaje);
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo lista de viajes");
		}
		return "EXITO";
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
