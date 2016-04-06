package uo.sdi.acciones.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.acciones.Accion;
import uo.sdi.model.Seat;
import uo.sdi.model.SeatStatus;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.SeatDao;
import uo.sdi.persistence.TripDao;
import alb.util.log.Log;

public class CancelarPlazaAccion implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		User usuario = (User) request.getSession().getAttribute("user");
		Long idTrip = Long.valueOf(request.getParameter("id"));

		SeatDao sd = PersistenceFactory.newSeatDao();
		Seat plaza = sd.findByUserAndTrip(usuario.getId(), idTrip);

		sd.delete(new Long[] { usuario.getId(), idTrip });
		PersistenceFactory.newApplicationDao().delete(
				new Long[] { usuario.getId(), idTrip });

		if (plaza != null && plaza.getStatus().equals(SeatStatus.ACCEPTED)) {
			TripDao td = PersistenceFactory.newTripDao();

			Trip viaje = td.findById(idTrip);
			viaje.setAvailablePax(viaje.getAvailablePax() + 1);

			td.update(viaje);
			Log.info("Plaza liberada.", idTrip);

		}

		Log.info("Plaza/peticion en viaje [id: %s] cancelada.", idTrip);
		request.setAttribute("mensaje",
				"Se ha cancelado tu plaza en el viaje correctamente. ");
		return "EXITO";
	}

}
