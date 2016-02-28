package uo.sdi.acciones.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.acciones.Accion;

public class CerrarSesionAction implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		

		String resultado="EXITO";

		HttpSession session=request.getSession();
		if (session.getAttribute("user")!=null) {
			String nombreUsuario = request.getParameter("nombreUsuario");
			session.invalidate();
			Log.info("El usuario [%s] ha cerrado sesion correctamente",nombreUsuario);
		}
		else{
			session.invalidate();
			Log.error("Ha ocurrido un error al cerrar sesion");
			
		}
		
		return resultado;
	}

}
