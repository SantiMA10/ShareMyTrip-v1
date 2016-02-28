package uo.sdi.acciones.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.acciones.Accion;
import uo.sdi.model.Application;
import uo.sdi.model.Seat;
import uo.sdi.model.SeatStatus;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.util.RatingsContainer;

public class MostrarViajePromotorAction implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		Trip viaje;
		User promotor;
		List<User> participantes = new ArrayList<>();
		List<User> solicitantes = new ArrayList<>();
		RatingsContainer puntuaciones = new RatingsContainer();
		
		try {
			
			viaje=PersistenceFactory.newTripDao().findById(Long.valueOf(request.getParameter("id")));
			List<Application> peticiones = PersistenceFactory.newApplicationDao().findByTripId(viaje.getId());
						
			System.out.println(puntuaciones);
			
			for(Application application : peticiones){
				User participante = PersistenceFactory.newUserDao().findById(application.getUserId());
				Seat asiento = PersistenceFactory.newSeatDao().findByUserAndTrip(participante.getId(), viaje.getId());
//				participantes.add(participante);
//				puntuaciones.addRating(participante.getId(), PersistenceFactory.newRatingDao().findByAboutUser(participante.getId()));
				
				if(asiento != null && asiento.getStatus().equals(SeatStatus.ACCEPTED)){
					participantes.add(participante);
					puntuaciones.addRating(participante.getId(), PersistenceFactory.newRatingDao().findByAboutUser(participante.getId()));
				}
				if(asiento == null){
					solicitantes.add(participante);
					puntuaciones.addRating(participante.getId(), PersistenceFactory.newRatingDao().findByAboutUser(participante.getId()));
				}
				
			}
			
			request.setAttribute("viaje", viaje);
			request.setAttribute("participantes", participantes);
			request.setAttribute("puntuaciones", puntuaciones);
			request.setAttribute("solicitantes", solicitantes);
			
			Log.debug("Obtenida informacion del viaje [%d]", viaje);
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo lista de viajes");
		}
		return "EXITO";
	}

	
}
