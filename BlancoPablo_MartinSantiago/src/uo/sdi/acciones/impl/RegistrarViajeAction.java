package uo.sdi.acciones.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.acciones.Accion;
import uo.sdi.model.AddressPoint;
import uo.sdi.model.Trip;
import uo.sdi.model.TripStatus;
import uo.sdi.model.User;
import uo.sdi.model.Waypoint;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.util.Comprobante;

public class RegistrarViajeAction implements Accion {

	@SuppressWarnings("deprecation")
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";

		List<String> errores = new ArrayList<String>();
		int codigoPostalSalidaInt, codigoPostalLlegadaInt;

		Date fechaSalidaDate, fechaLlegadaDate, fechaLimiteDate;

		int[] horaSalidaInts, horaLlegadaInts;

		Waypoint salida = null, llegada = null;
		// Datos desde el formulario
		// De momento las fechas seran "String a pelo"
		String callesalida = (String) request.getParameter("callesalida");
		String ciudadsalida = (String) request.getParameter("ciudadsalida");
		String provinciasalida = (String) request
				.getParameter("provinciasalida");
		String paissalida = (String) request.getParameter("paissalida");
		String codigopostalsalida = (String) request
				.getParameter("codigopostalsalida");
		String coordenadassalida = (String) request
				.getParameter("coordenadassalida");
		String fechasalida = (String) request.getParameter("fechasalida");
		String horasalida = (String) request.getParameter("horasalida");
		String callellegada = (String) request.getParameter("callellegada");
		String ciudadllegada = (String) request.getParameter("ciudadllegada");
		String provinciallegada = (String) request
				.getParameter("provinciallegada");
		String paisllegada = (String) request.getParameter("paisllegada");
		String codigopostalllegada = (String) request
				.getParameter("codigopostalllegada");
		String coordenadasllegada = (String) request
				.getParameter("coordenadasllegada");
		String fechallegada = (String) request.getParameter("fechallegada");
		String horallegada = (String) request.getParameter("horallegada");
		String fechalimite = (String) request.getParameter("fechalimite");
		String coste = (String) request.getParameter("coste");
		String comentarios = (String) request.getParameter("comentarios");
		String plazasmaximo = (String) request.getParameter("plazasmaximo");
		String plazasrestantes = (String) request
				.getParameter("plazasrestantes");

		if (!Comprobante.comprobarDatos(callesalida))
			errores.add("No se puede dejar vacio el campo calle de salida");
		if (!Comprobante.comprobarDatos(ciudadsalida))
			errores.add("No se puede dejar vacio el campo ciudad de salida no puede estar vacio");
		if (!Comprobante.comprobarDatos(provinciasalida))
			errores.add("No se puede dejar vacio el campo provincia de salida");
		if (!Comprobante.comprobarDatos(paissalida))
			errores.add("No se puede dejar vacio el campo pais de salida");
		if (!Comprobante.comprobarDatos(codigopostalsalida))
			errores.add("No se puede dejar vacio el campo codigo postal de salida");
		if (!Comprobante.comprobarDatos(fechasalida))
			errores.add("No se puede dejar vacio el campo fecha de salida");
		if (!Comprobante.comprobarDatos(horasalida))
			errores.add("No se puede dejar vacio el campo hora de salida");
		if (!Comprobante.comprobarDatos(callellegada))
			errores.add("No se puede dejar vacio el campo calle de llegada");
		if (!Comprobante.comprobarDatos(ciudadllegada))
			errores.add("No se puede dejar vacio el campo ciudad de llegada");
		if (!Comprobante.comprobarDatos(provinciallegada))
			errores.add("No se puede dejar vacio el campo provincia de llegada");
		if (!Comprobante.comprobarDatos(paisllegada))
			errores.add("No se puede dejar vacio el campo pais de llegada");
		if (!Comprobante.comprobarDatos(codigopostalllegada))
			errores.add("No se puede dejar vacio el campo codigo postal de llegada");
		if (!Comprobante.comprobarDatos(fechallegada))
			errores.add("No se puede dejar vacio el campo fecha de llegada");
		if (!Comprobante.comprobarDatos(horallegada))
			errores.add("No se puede dejar vacio el campo hora de llegada");
		if (!Comprobante.comprobarDatos(fechalimite))
			errores.add("No se puede dejar vacio el campo fecha limite");
		if (!Comprobante.comprobarDatos(coste))
			errores.add("No se puede dejar vacio el campo coste");
		if (!Comprobante.comprobarDatos(comentarios))
			errores.add("No se puede dejar vacio el campo cometnarios");
		if (!Comprobante.comprobarDatos(plazasmaximo))
			errores.add("No se puede dejar vacio el campo plazas maximo");
		if (!Comprobante.comprobarDatos(plazasrestantes))
			errores.add("No se puede dejar vacio el campo plazas restantes");
		if (!Comprobante.comprobarDatos(coordenadassalida))
			errores.add("No se puede dejar vacio el coordenadas");
		if (!Comprobante.comprobarDatos(coordenadasllegada))
			errores.add("No se puede dejar vacio el coordenadas");

		// Comprobacion de campos vacios
		if (errores.isEmpty()) {
			if (Integer.parseInt(plazasmaximo) < 0)
				errores.add("No puede haber plazas negativas");
			if (Integer.parseInt(plazasrestantes) < 0)
				errores.add("No puede haber plazas negativas");
			if (Integer.parseInt(plazasmaximo) < Integer
					.parseInt(plazasrestantes))
				errores.add("No puede haber mas sitios ocupados que plazas disponibles");
			codigoPostalSalidaInt = Comprobante
					.comprobarInt(codigopostalsalida);
			if (codigoPostalSalidaInt < 0)
				errores.add("El codigo postal de salida debe ser correcto");

			codigoPostalLlegadaInt = Comprobante
					.comprobarInt(codigopostalllegada);
			if (codigoPostalLlegadaInt < 0)
				errores.add("El codigo postal de salida debe ser correcto");

			fechaSalidaDate = Comprobante.comprobarFecha(fechasalida);
			horaSalidaInts = Comprobante.comprobarHora(horasalida);
			if (fechaSalidaDate != null && horaSalidaInts != null) {
				fechaSalidaDate.setHours(horaSalidaInts[0]);
				fechaSalidaDate.setMinutes(horaSalidaInts[1]);
			} else {
				errores.add("Error en la fecha de salida");
			}
			fechaLlegadaDate = Comprobante.comprobarFecha(fechallegada);
			horaLlegadaInts = Comprobante.comprobarHora(horallegada);
			if (fechaLlegadaDate != null && horaLlegadaInts != null) {
				fechaLlegadaDate.setHours(horaLlegadaInts[0]);
				fechaLlegadaDate.setMinutes(horaLlegadaInts[1]);
			} else {
				errores.add("Error en la fecha de llegada");
			}
			fechaLimiteDate = Comprobante.comprobarFecha(fechalimite);
			if (fechalimite == null) {

				errores.add("Error en la fecha limite");
			}

			if (!coordenadassalida.equals("")) {
				salida = Comprobante.comprobarPunto(coordenadassalida);
				if (salida == null)
					errores.add("Error en las coordenadas de salida");
			}
			if (!coordenadasllegada.equals("")) {
				llegada = Comprobante.comprobarPunto(coordenadasllegada);
				if (llegada == null)
					errores.add("Error en las coordenadas de llegada");
			}
			if (errores.isEmpty()) {
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");

				// Confirmar datos
				AddressPoint direccionSalida = new AddressPoint(callesalida,
						ciudadsalida, provinciasalida, paissalida,
						codigopostalsalida, salida);

				AddressPoint direccionLlegada = new AddressPoint(callellegada,
						ciudadllegada, provinciallegada, paisllegada,
						codigopostalllegada, llegada);

				Trip viaje = new Trip();
				viaje.setDeparture(direccionSalida);
				viaje.setDestination(direccionLlegada);
				viaje.setDepartureDate(fechaSalidaDate);
				viaje.setArrivalDate(fechaLlegadaDate);
				viaje.setClosingDate(fechaLimiteDate);
				viaje.setAvailablePax(Integer.parseInt(plazasrestantes));
				viaje.setMaxPax(Integer.parseInt(plazasmaximo));
				viaje.setEstimatedCost(Double.parseDouble(coste));
				viaje.setComments(comentarios);
				viaje.setStatus(TripStatus.OPEN);
				viaje.setPromoterId(user.getId());

				try {
					PersistenceFactory.newTripDao().save(viaje);
				} catch (Exception e) {

					Log.error(
							"El usuario [%s] ya ha creado un viaje para esa fecha.",
							user.getLogin());
					errores = new ArrayList<String>();
					errores.add("Ya creado un viaje para esa fecha.");
					request.setAttribute("errores", errores);

					return "FRACASO";

				}

				Log.debug("Viaje [%s] registrado correctamente", viaje);
			} else {
				resultado = "FRACASO";
				request.setAttribute("errores", errores);
				Log.error("Error en los datos, algun campo/s contiene/n datos incorrectos.");
			}
		} else {
			resultado = "FRACASO";
			request.setAttribute("errores", errores);
			Log.error("Error en los datos, algun campo/s esta/n vacio.");
		}

		return resultado;
	}

}
