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

public class ConfirmarPlazaAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		List<String> errores = new ArrayList<String>();
		Trip viaje;
		
		String idViaje = (String) request.getParameter("idViaje");
		String idUsuario = (String) request.getParameter("idUsuario");
		String action = (String) request.getParameter("action");
		
		try{
			Seat asiento = new Seat();
			asiento.setTripId(Long.parseLong(idViaje));
			asiento.setUserId(Long.parseLong(idUsuario));
			if(action.equals("aceptar")){

				viaje=PersistenceFactory.newTripDao().findById(Long.valueOf(request.getParameter("idViaje")));
				if(viaje.getAvailablePax() > 0){
					asiento.setStatus(SeatStatus.ACCEPTED);
					viaje.setAvailablePax(viaje.getAvailablePax()-1);	//
					PersistenceFactory.newTripDao().update(viaje);		
					PersistenceFactory.newApplicationDao().delete(new Long[]{Long.parseLong(idViaje) , Long.parseLong(idUsuario)});	//Eliminar el application
					PersistenceFactory.newSeatDao().save(asiento);
					Log.debug("Se ha confirmado la plaza correctamente");
				}
				errores.add("No puedes añadir participantes, el viaje esta completo");
				resultado = "FRACASO";
			}
			else{
				asiento.setStatus(SeatStatus.EXCLUDED);
				PersistenceFactory.newSeatDao().save(asiento);
			}

		}catch(Exception e){
			resultado = "FRACASO";
		}
		
		//Volver a cargar la pagina
		List<User> participantes = new ArrayList<>();
		List<User> solicitantes = new ArrayList<>();
		RatingsContainer puntuaciones = new RatingsContainer();
		
		try {
			
			viaje=PersistenceFactory.newTripDao().findById(Long.valueOf(request.getParameter("idViaje")));
			List<Application> peticiones = PersistenceFactory.newApplicationDao().findByTripId(viaje.getId());
						
			System.out.println(puntuaciones);
			
			for(Application application : peticiones){
				User participante = PersistenceFactory.newUserDao().findById(application.getUserId());
				Seat asiento = PersistenceFactory.newSeatDao().findByUserAndTrip(participante.getId(), viaje.getId());
				
				if(asiento != null && asiento.getStatus().equals(SeatStatus.ACCEPTED)){
					participantes.add(participante);
					puntuaciones.addRating(participante.getId(), PersistenceFactory.newRatingDao().findByAboutUser(participante.getId()));
				}
				if(asiento == null){
					solicitantes.add(participante);
					puntuaciones.addRating(participante.getId(), PersistenceFactory.newRatingDao().findByAboutUser(participante.getId()));
				}
				
			}
			request.setAttribute("errores", errores);
			request.setAttribute("viaje", viaje);
			request.setAttribute("participantes", participantes);
			request.setAttribute("puntuaciones", puntuaciones);
			request.setAttribute("solicitantes", solicitantes);
			
			Log.debug("Obtenida informacion del viaje [%d]", viaje);
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo lista de viajes");
		}
		return resultado;
	}

}
