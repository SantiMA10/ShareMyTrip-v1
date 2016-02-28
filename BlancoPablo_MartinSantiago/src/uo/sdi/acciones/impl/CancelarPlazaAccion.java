package uo.sdi.acciones.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.acciones.Accion;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;

public class CancelarPlazaAccion implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		User usuario = (User) request.getSession().getAttribute("user");
		Long idTrip = Long.valueOf(request.getParameter("id"));
		
		PersistenceFactory.newApplicationDao().delete(new Long[]{usuario.getId(), idTrip});
		PersistenceFactory.newSeatDao().delete(new Long[]{usuario.getId(), idTrip});
		
		Log.info("Plaza/peticion en viaje [id: %s] cancelada.", idTrip);
		request.setAttribute("mensaje", "Se ha cancelado tu plaza en el viaje correctamente. ");
		return "EXITO";
	}

}
