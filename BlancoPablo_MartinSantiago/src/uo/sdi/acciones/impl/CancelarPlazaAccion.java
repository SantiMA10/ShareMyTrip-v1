package uo.sdi.acciones.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.acciones.Accion;

public class CancelarPlazaAccion implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		request.setAttribute("mensaje", "Se ha cancelado tu plaza en el viaje correctamente.");
		return "EXITO";
	}

}
