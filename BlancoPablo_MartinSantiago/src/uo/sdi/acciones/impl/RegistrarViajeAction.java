package uo.sdi.acciones.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.acciones.Accion;
import uo.sdi.model.AddressPoint;
import uo.sdi.model.Trip;
import uo.sdi.model.TripStatus;
import uo.sdi.model.User;
import uo.sdi.model.Waypoint;
import uo.sdi.persistence.PersistenceFactory;

public class RegistrarViajeAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";

		// Datos desde el formulario
		// De momento las fechas seran "String a pelo" hasta que miremos como
		// meter calendarios
		String callesalida = (String) request.getParameter("callesalida"), 
				ciudadsalida = (String) request.getParameter("ciudadsalida"), 
				provinciasalida = (String) request.getParameter("provinciasalida"), 
				paissalida = (String) request.getParameter("paissalida"), 
				codigopostalsalida = (String) request.getParameter("codigopostalsalida"), 
				coordenadassalida = (String) request.getParameter("coordenadassalida"), 
				fechasalida = (String) request.getParameter("fechasalida"), 
				horasalida = (String) request.getParameter("horasalida"), 
				callellegada = (String) request.getParameter("callellegada"), 
				ciudadllegada = (String) request.getParameter("ciudadllegada"), 
				provinciallegada = (String) request.getParameter("provinciallegada"), 
				paisllegada = (String) request.getParameter("paisllegada"), 
				codigopostalllegada = (String) request.getParameter("codigopostalllegada"), 
				coordenadasllegada = (String) request.getParameter("coordenadasllegada"), 
				fechallegada = (String) request.getParameter("fechallegada"), 
				horallegada = (String) request.getParameter("horallegada"), 
				fechalimite = (String) request.getParameter("fechalimite"), 
				coste = (String) request.getParameter("coste"), 
				comentarios = (String) request.getParameter("comentarios"), 
				plazasmaximo = (String) request.getParameter("plazasmaximo"), 
				plazasrestantes = (String) request.getParameter("plazasrestantes");
		System.out.println("Salida: " + horasalida+ " llegada: "+ horallegada);

		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("user");
		//Confirmar datos
//		AddressPoint salida = new AddressPoint(callesalida, ciudadsalida, provinciasalida, paissalida, codigopostalsalida, new Waypoint(0.0, 0.0));
		
//		AddressPoint llegada = new AddressPoint(callellegada, ciudadllegada, provinciallegada, paisllegada, codigopostalllegada, new Waypoint(10.0, 10.0));
		
		
//		Trip viaje = new Trip();
//		viaje.setDeparture(salida);
//		viaje.setDestination(llegada);
//		viaje.setDepartureDate((Date) fechasalida); 
//		viaje.setArrivalDate((Date) fechallegada);
//		viaje.setClosingDate((Date)fechalimite);
//		viaje.setAvailablePax(Integer.parseInt(plazasrestantes));
//		viaje.setMaxPax(Integer.parseInt(plazasmaximo));
//		viaje.setEstimatedCost(Double.parseDouble(coste));
//		viaje.setComments(comentarios);
//		viaje.setStatus(TripStatus.OPEN);
		
//		PersistenceFactory.newTripDao().save(viaje);
		return resultado;
	}

}
