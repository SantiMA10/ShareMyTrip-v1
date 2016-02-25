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
import uo.sdi.util.RatingsContainer;
import alb.util.log.Log;

public class MostrarViajeAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Trip viaje;
		User promotor;
		List<User> participantes = new ArrayList<>();
		RatingsContainer puntuaciones = new RatingsContainer();
		
		try {
			
			viaje=PersistenceFactory.newTripDao().findById(Long.valueOf(request.getParameter("id")));
			promotor = PersistenceFactory.newUserDao().findById(viaje.getPromoterId());
			List<Application> peticiones = PersistenceFactory.newApplicationDao().findByTripId(viaje.getId());
			
			puntuaciones.addRating(promotor.getId(), PersistenceFactory.newRatingDao().findByAboutUser(promotor.getId()));
			
			System.out.println(puntuaciones);
			
			for(Application application : peticiones){
				User participante = PersistenceFactory.newUserDao().findById(application.getUserId());
				Seat asiento = PersistenceFactory.newSeatDao().findByUserAndTrip(participante.getId(), viaje.getId());
				
				if(asiento != null && asiento.getStatus().equals(SeatStatus.ACCEPTED)){
					participantes.add(participante);
					puntuaciones.addRating(participante.getId(), PersistenceFactory.newRatingDao().findByAboutUser(participante.getId()));
				}
				
			}
			
			request.setAttribute("viaje", viaje);
			request.setAttribute("promotor", promotor);
			request.setAttribute("participantes", participantes);
			request.setAttribute("puntuaciones", puntuaciones);
			
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
