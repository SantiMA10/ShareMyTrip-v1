package uo.sdi.tests;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertTextPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.gotoPage;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTextField;
import static net.sourceforge.jwebunit.junit.JWebUnit.submit;

import org.junit.Before;
import org.junit.Test;

public class Sesion4Tests {

    @Before
    public void prepare() {
        setBaseUrl("http://localhost:8280/BlancoPablo_MartinSantiago");
    }

    //Si falla el test porque dice "Bootstrap's JavaScript requires jQuery" hay cambiar el orden de estas lineas:
    //<script src="bootstrap/js/bootstrap.min.js">	----------->		</script><script src="bootstrap/jquery.min.js"></script>
    //<script src="bootstrap/jquery.min.js">		----------->		</script><script src="bootstrap/js/bootstrap.min.js"></script>
    
    
    
   //TEST OBLIGATORIOS
    /**
     * Registrarse - La contraseña introducida 2 veces es errones
     */
    @Test
    public void testRegistro() {
        beginAt("/registro.jsp");  // Navegar a la URL
        assertTitleEquals("ShareMyTrip - Registro");  // Comprobar título de la página

        setTextField("nombre", "nombrePrueba");
        setTextField("apellidos", "apellidosPrueba");
        setTextField("email", "email@prueba.es");
        setTextField("password", "pass");
        setTextField("password2", "noLaMismaPass");
        submit();
        
        assertTitleEquals("ShareMyTrip - Registro");  // Ya que no cambia hasta que se den los datos correctos
    }
    
    /**
     * Iniciar sesion - Sin exito porque la contraseña no es valida
     */
    @Test
    public void testIniciarSesion() {
    	beginAt("/login.jsp");
    	assertTitleEquals("ShareMyTrip - Inicie sesión");  // Comprobar título de la página

    	setTextField("nombreUsuario", "user1");
    	setTextField("contrasena", "contrasenaMala");
    	submit();
    	
        assertTitleEquals("ShareMyTrip - Inicie sesión");  // Ya que no cambia hasta que se den los datos correctos
    }
    
    /**
     * Registrar viaje - Registrar un viaje correctamente
     */
    @Test
    public void registrarViaje(){
    	beginAt("/login.jsp");
    	assertTitleEquals("ShareMyTrip - Inicie sesión");  // Comprobar título de la página

    	setTextField("nombreUsuario", "user1");
    	setTextField("contrasena", "user1");

    	submit();
    	gotoPage("/registrarViaje.jsp");
    	assertTitleEquals("ShareMyTrip - Registrar viaje");  // Comprobar título de la página

    	setTextField("callesalida", "cardenal cienfuegos");
    	setTextField("ciudadsalida", "oviedo");
    	setTextField("provinciasalida", "asturias");
    	setTextField("paissalida", "españa");
    	setTextField("codigopostalsalida", "12345");
    	setTextField("coordenadassalida", "55,55");
    	setTextField("fechasalida", "2016-03-26");
    	setTextField("horasalida", "15:00");
    	setTextField("callellegada", "principal");
    	setTextField("ciudadllegada", "madrid");
    	setTextField("provinciallegada", "madrid");
    	setTextField("paisllegada", "españa");
    	setTextField("codigopostalllegada", "67890");
    	setTextField("coordenadasllegada", "35,55");
    	setTextField("fechallegada", "2016-03-26");
    	setTextField("horallegada", "21:00");
    	setTextField("fechalimite", "2016-03-25");
    	setTextField("coste", "80");
    	setTextField("comentarios", "Nos vamos de fiesta a madrid, ¿quien viene?");
    	setTextField("plazasmaximo", "5");
    	setTextField("plazasrestantes", "4");
    	submit();
        assertTitleEquals("ShareMyTrip - Mis viajes");  
    	
    }
    
    /**
     * Solicitar plaza en viaje en el que el usuario no es promotor
     */
    @Test
    public void solicitarPlaza(){
    	beginAt("/login.jsp");
    	assertTitleEquals("ShareMyTrip - Inicie sesión");  // Comprobar título de la página

    	setTextField("nombreUsuario", "user1");
    	setTextField("contrasena", "user1");
    	submit();
    	
    	gotoPage("/mostrarViaje?id=30");
    	assertTitleEquals("ShareMyTrip - Detalles viaje");  // Comprobar título de la página
    	assertTextPresent("Barcelona-Valencia");

    	submit();
        assertTitleEquals("ShareMyTrip - Listado de viajes");  
        assertTextPresent("Plaza solicitada correctamente.");
        
    }

}