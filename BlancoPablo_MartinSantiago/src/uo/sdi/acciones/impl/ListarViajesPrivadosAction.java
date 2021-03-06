package uo.sdi.acciones.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.acciones.Accion;
import uo.sdi.model.Application;
import uo.sdi.model.Seat;
import uo.sdi.model.SeatStatus;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.SeatDao;
import uo.sdi.persistence.TripDao;
import uo.sdi.util.MisViajesConEstado;
import alb.util.log.Log;

public class ListarViajesPrivadosAction implements Accion {
	String busqueda = "";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		if (request.getParameter("criterio") != null)
			busqueda = (String) request.getParameter("criterio");
		List<MisViajesConEstado> misViajes = new ArrayList<>();
		User usuario = ((User) request.getSession().getAttribute("user"));

		cargarViajesPromotor(misViajes, usuario);
		cargarViajes(misViajes, usuario);

		Log.info("Viajes relacionados [%s] con el usuario [%s] cargados",
				misViajes.size(), usuario.getLogin());
		request.setAttribute("misViajes", misViajes);

		return resultado;
	}

	private void cargarViajesPromotor(List<MisViajesConEstado> misViajes,
			User usuario) {
		List<Trip> viajes = PersistenceFactory.newTripDao().findByPromoterId(
				usuario.getId());
		for (Trip viaje : viajes) {
			if (busqueda.equals("") || (viaje.getDeparture().getCity().toUpperCase()
					.contains(busqueda.toUpperCase())
					|| viaje.getDestination().getCity().toUpperCase()
							.contains(busqueda.toUpperCase())))
				misViajes.add(new MisViajesConEstado(viaje, "Promotor"));
		}
	}

	private void cargarViajes(List<MisViajesConEstado> misViajes, User usuario) {

		List<Application> peticiones = PersistenceFactory.newApplicationDao()
				.findByUserId(usuario.getId());
		SeatDao sd = PersistenceFactory.newSeatDao();
		TripDao td = PersistenceFactory.newTripDao();

		for (Application peticion : peticiones) {
			Seat plaza = sd.findByUserAndTrip(usuario.getId(),
					peticion.getTripId());
			Trip viaje = td.findById(peticion.getTripId());
			if (busqueda.equals("") || viaje.getDeparture().getCity().toUpperCase()
					.contains(busqueda.toUpperCase())
					|| viaje.getDestination().getCity().toUpperCase()
							.contains(busqueda.toUpperCase())) {
				if (plaza != null) {
					if (plaza.getStatus().equals(SeatStatus.ACCEPTED)) {
						misViajes
								.add(new MisViajesConEstado(viaje, "Admitido"));
					} else {
						misViajes
								.add(new MisViajesConEstado(viaje, "Excluido"));
					}
				} else if (plaza == null && viaje.getAvailablePax() > 0) {
					misViajes.add(new MisViajesConEstado(viaje, "Pendiente"));
				} else {
					misViajes.add(new MisViajesConEstado(viaje, "Sin plaza"));
				}
			}
		}

	}

}
