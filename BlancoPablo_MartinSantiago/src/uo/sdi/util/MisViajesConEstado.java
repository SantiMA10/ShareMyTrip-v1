package uo.sdi.util;

import uo.sdi.model.Trip;

public class MisViajesConEstado {
	
	private Trip viaje;
	private String relacion;
	
	public MisViajesConEstado(Trip viaje, String relacion) {
		this.viaje = viaje;
		this.relacion = relacion;
	}

	public Trip getViaje() {
		return viaje;
	}

	public String getRelacion() {
		return relacion;
	}

}
