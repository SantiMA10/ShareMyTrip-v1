package uo.sdi.acciones.impl;

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
		
		Application plaza = new Application();
		plaza.setTripId(Long.valueOf(request.getParameter("id")));
		plaza.setUserId(((User)request.getSession().getAttribute("user")).getId());
		
		Log.info("Plaza solicitada %s", plaza.toString());
		PersistenceFactory.newApplicationDao().save(plaza);
		
		return "EXITO";
	}

}
