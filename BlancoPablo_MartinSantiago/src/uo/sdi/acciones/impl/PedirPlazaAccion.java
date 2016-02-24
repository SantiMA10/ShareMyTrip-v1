package uo.sdi.acciones.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.acciones.Accion;
import uo.sdi.model.Seat;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class PedirPlazaAccion implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Seat plaza = new Seat();
		plaza.setTripId(Long.valueOf(request.getParameter("id")));
		plaza.setComment(request.getParameter("comentario"));
		plaza.setUserId(((User)request.getSession().getAttribute("user")).getId());
		plaza.setStatus(null);
		
		Log.info("Plaza %s", plaza.toString());
		PersistenceFactory.newSeatDao().save(plaza);
		
		return "EXITO";
	}

}
