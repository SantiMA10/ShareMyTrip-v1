package uo.sdi.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.acciones.Accion;
import uo.sdi.acciones.impl.CerrarSesionAction;
import uo.sdi.acciones.impl.ListarViajesAction;
import uo.sdi.acciones.impl.ModificarContraseñaAction;
import uo.sdi.acciones.impl.ModificarDatosAction;
import uo.sdi.acciones.impl.RegistrarseAction;
import uo.sdi.acciones.impl.ValidarseAction;
import alb.util.log.Log;

public class Controlador extends javax.servlet.http.HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Map<String, Accion>> mapaDeAcciones; // <rol, <opcion, objeto Accion>>
	private Map<String, Map<String, Map<String, String>>> mapaDeNavegacion; // <rol, <opcion, <resultado, JSP>>>

	public void init() throws ServletException {  
		crearMapaAcciones();
		crearMapaDeJSP();
    }
	

	public void doGet(HttpServletRequest req, HttpServletResponse res)
				throws IOException, ServletException {
		
		String opcion, resultado, jspSiguiente;
		Accion accion;
		String rolAntes, rolDespues;
		
		try {
			opcion=req.getServletPath().replace("/","");
				
			rolAntes=obtenerRolDeSesion(req);
			
			accion=buscarAccionParaOpcion(rolAntes, opcion);
				
			resultado=accion.execute(req,res);
				
			rolDespues=obtenerRolDeSesion(req);
			
			jspSiguiente=buscarJSPSegun(rolDespues, opcion, resultado);

			req.setAttribute("jspSiguiente", jspSiguiente);

		} catch(Exception e) {
			
			req.getSession().invalidate();
			
			Log.error("Se ha producido alguna excepción no manejada [%s]",e);
			
			accion = buscarAccionParaOpcion("PUBLICO", "listarViajes");
			resultado=accion.execute(req, res);
			rolDespues=obtenerRolDeSesion(req);
			jspSiguiente=buscarJSPSegun(rolDespues, "listarViajes", resultado);

			jspSiguiente="/listaViajes.jsp";
			req.setAttribute("jspSiguiente", jspSiguiente);
			
		}
			
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jspSiguiente); 
			
		dispatcher.forward(req, res);			
	}			
	
	
	private String obtenerRolDeSesion(HttpServletRequest req) {
		HttpSession sesion=req.getSession();
		if (sesion.getAttribute("user")==null)
			return "PUBLICO";
		else
			return "REGISTRADO";
	}

	// Obtiene un objeto accion en funci�n de la opci�n
	// enviada desde el navegador
	private Accion buscarAccionParaOpcion(String rol, String opcion) {
		
		Accion accion=mapaDeAcciones.get(rol).get(opcion);
		Log.debug("Elegida acción [%s] para opción [%s] y rol [%s]",accion,opcion,rol);
		return accion;
	}
	
	
	// Obtiene la p�gina JSP a la que habr� que entregar el
	// control el funci�n de la opci�n enviada desde el navegador
	// y el resultado de la ejecuci�n de la acci�n asociada
	private String buscarJSPSegun(String rol, String opcion, String resultado) {
		
		Log.info("Buscar JSP %s -(%s)-> %s -(%s)-> %s", rol,
				mapaDeNavegacion.get(rol), opcion, 
				mapaDeNavegacion.get(rol).get(opcion), resultado, mapaDeNavegacion.get(rol).get(opcion).get(resultado));
		
		String jspSiguiente=mapaDeNavegacion.get(rol).get(opcion).get(resultado);
		Log.debug("Elegida página siguiente [%s] para el resultado [%s] tras realizar [%s] con rol [%s]",jspSiguiente,resultado,opcion,rol);
		return jspSiguiente;		
	}
		
		
	private void crearMapaAcciones() {
		
		mapaDeAcciones=new HashMap<String,Map<String,Accion>>();
	
		Map<String,Accion> mapaPublico=new HashMap<String,Accion>();
		mapaPublico.put("validarse", new ValidarseAction());
		mapaPublico.put("listarViajes", new ListarViajesAction());
		mapaPublico.put("registro", new RegistrarseAction());
		mapaDeAcciones.put("PUBLICO", mapaPublico);
		
		Map<String,Accion> mapaRegistrado=new HashMap<String,Accion>();
		mapaRegistrado.put("modificarDatos", new ModificarDatosAction());
		mapaRegistrado.put("modificarContraseña", new ModificarContraseñaAction());
		mapaRegistrado.put("cerrarSesion", new CerrarSesionAction());
		mapaRegistrado.put("listarViajes", new ListarViajesAction());
		mapaDeAcciones.put("REGISTRADO", mapaRegistrado);
	}
	
	
	private void crearMapaDeJSP() {
				
		mapaDeNavegacion=new HashMap<String,Map<String, Map<String, String>>>();

		// Crear mapas auxiliares vacíos
		Map<String, Map<String, String>> opcionResJSP=new HashMap<String, Map<String, String>>();
		Map<String, String> resJSP=new HashMap<String, String>();

		// Mapa de navegación del público
		resJSP.put("FRACASO","/login.jsp");
		opcionResJSP.put("validarse", resJSP);
		
		resJSP = new HashMap<String, String>();
		resJSP.put("EXITO","/listaViajes.jsp");
		opcionResJSP.put("listarViajes", resJSP);
		
		resJSP = new HashMap<String, String>();
		resJSP.put("EXITO", "/principal.jsp");
		resJSP.put("FRACASO", "/registro.jsp");
		opcionResJSP.put("registro", resJSP);
		
		mapaDeNavegacion.put("PUBLICO",opcionResJSP);
		
		// Crear mapas auxiliares vacíos
		opcionResJSP=new HashMap<String, Map<String, String>>();
		resJSP=new HashMap<String, String>();
		
		// Mapa de navegación de usuarios registrados
		resJSP.put("EXITO","/principal.jsp");
		opcionResJSP.put("validarse", resJSP);
		
		resJSP=new HashMap<String, String>();			//Modificar datos
		resJSP.put("EXITO","/principal.jsp");
		opcionResJSP.put("modificarDatos", resJSP);
		
		resJSP=new HashMap<String, String>();			//Cerrar sesion
		resJSP.put("EXITO","/login.jsp");
		resJSP.put("FRACASO","/login.jsp");
		opcionResJSP.put("cerrarSesion", resJSP);
		
		resJSP=new HashMap<String, String>();			//Modificar contraseña
		resJSP.put("EXITO","/principal.jsp");
		resJSP.put("FRACASO","/login.jsp");
		opcionResJSP.put("modificarContraseña", resJSP);
		
		
		mapaDeNavegacion.put("REGISTRADO",opcionResJSP);
	}
			
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		doGet(req, res);
	}

}