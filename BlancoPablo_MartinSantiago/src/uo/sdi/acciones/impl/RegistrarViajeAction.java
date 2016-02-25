package uo.sdi.acciones.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import uo.sdi.util.Comprobante;

public class RegistrarViajeAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		List<String> errores = new ArrayList<>();
		int codigoPostalSalidaInt , 
			codigoPostalLlegadaInt;

		// Datos desde el formulario
		// De momento las fechas seran "String a pelo"
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

		if(!Comprobante.comprobarDatos(callesalida))
			errores.add("No se puede dejar vacio el campo calle de salida");
		if(!Comprobante.comprobarDatos(ciudadsalida))
			errores.add("No se puede dejar vacio el campo ciudad de salida no puede estar vacio");
		if(!Comprobante.comprobarDatos(provinciasalida))
			errores.add("No se puede dejar vacio el campo provincia de salida");
		if(!Comprobante.comprobarDatos(paissalida))
			errores.add("No se puede dejar vacio el campo pais de salida");
		if(!Comprobante.comprobarDatos(codigopostalsalida))
			errores.add("No se puede dejar vacio el campo codigo postal de salida");
		if(!Comprobante.comprobarDatos(fechasalida))
			errores.add("No se puede dejar vacio el campo fecha de salida");
		if(!Comprobante.comprobarDatos(horasalida))
			errores.add("No se puede dejar vacio el campo hora de salida");
		if(!Comprobante.comprobarDatos(callellegada))
			errores.add("No se puede dejar vacio el campo calle de llegada");
		if(!Comprobante.comprobarDatos(ciudadllegada))
			errores.add("No se puede dejar vacio el campo ciudad de llegada");
		if(!Comprobante.comprobarDatos(provinciallegada))
			errores.add("No se puede dejar vacio el campo provincia de llegada");
		if(!Comprobante.comprobarDatos(paisllegada))
			errores.add("No se puede dejar vacio el campo pais de llegada");
		if(!Comprobante.comprobarDatos(codigopostalllegada))
			errores.add("No se puede dejar vacio el campo codigo postal de llegada");
		if(!Comprobante.comprobarDatos(fechallegada))
			errores.add("No se puede dejar vacio el campo fecha de llegada");
		if(!Comprobante.comprobarDatos(horallegada))
			errores.add("No se puede dejar vacio el campo hora de llegada");
		if(!Comprobante.comprobarDatos(fechalimite))
			errores.add("No se puede dejar vacio el campo fecha limite");
		if(!Comprobante.comprobarDatos(coste))
			errores.add("No se puede dejar vacio el campo coste");
		if(!Comprobante.comprobarDatos(comentarios))
			errores.add("No se puede dejar vacio el campo cometnarios");
		if(!Comprobante.comprobarDatos(plazasmaximo))
			errores.add("No se puede dejar vacio el campo plazas maximo");
		if(!Comprobante.comprobarDatos(plazasrestantes))
			errores.add("No se puede dejar vacio el campo plazas restantes");
		
		
		codigoPostalSalidaInt = Comprobante.comprobarInt(codigopostalsalida);
		if(codigoPostalSalidaInt == -1)
			errores.add("El codigo postal de salida debe ser correcto");
		
		codigoPostalLlegadaInt = Comprobante.comprobarInt(codigopostalllegada);
		if(codigoPostalLlegadaInt == -1)
			errores.add("El codigo postal de salida debe ser correcto");
		
		if(errores.isEmpty()){
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
		}
		return resultado;
	}

}
