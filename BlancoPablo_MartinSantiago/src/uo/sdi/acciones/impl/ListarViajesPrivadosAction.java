package uo.sdi.acciones.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.acciones.Accion;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.util.MisViajesConEstado;

public class ListarViajesPrivadosAction implements Accion{
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		List<MisViajesConEstado> misViajes = new ArrayList<>();
		User usuario = ((User)request.getSession().getAttribute("user"));	
		
		List<Trip> viajes = PersistenceFactory.newTripDao().findByPromoterId(usuario.getId());
		for(Trip viaje : viajes){
			misViajes.add(new MisViajesConEstado(viaje, "Promotor"));
		}
		
		Log.info("Viajes relacionados con el usuario [%s] cargados", misViajes.size());
		request.setAttribute("misViajes", misViajes);
		
		return resultado;
	}
	

}
