package uo.sdi.tests;

import org.junit.*;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

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
    	beginAt("/registrarViaje.jsp");
    	assertTitleEquals("ShareMyTrip - Registrar viaje");  // Comprobar título de la página

//    	setTextField("nombreUsuario", "user1");
//    	setTextField("contrasena", "contrasenaMala");
//    	submit();
//        assertTitleEquals("ShareMyTrip - Inicie sesión");  // Ya que no cambia hasta que se den los datos correctos
    	
    }
//    @Test
//    public void testListarViajes() {
//        beginAt("/registro.jsp");  // Navegar a la URL
//        assertTitleEquals("ShareMyTrip - Registro");  // Comprobar título de la páginanculo
//
//        setTextField("nombre", "nombrePrueba");
//        setTextField("apellidos", "apellidosPrueba");
//        setTextField("email", "email@prueba.es");
//        setTextField("password", "pass");
//        setTextField("password2", "noLaMismaPass");
//        submit();
//        assertTitleEquals("ShareMyTrip - Registro");  // Ya que no cambia hasta que se den los datos correctos
//    }

    //DE AQUI PARA ABJO SON LOS TEST ORIGINALES
    @Test
    public void testIniciarSesionConExito() {
//    	// Rellenando el formulario HTML
//        beginAt("/");  // Navegar a la URL
//        setTextField("nombreUsuario", "user1"); // Rellenar primer campo de formulario
//        submit(); // Enviar formulario
//        assertTitleEquals("ShareMyTrip - Página principal del usuario");  // Comprobar título de la página
//        assertTextInElement("login", "user1");  // Comprobar cierto elemento contiene cierto texto
//        assertTextInElement("name", "Fernando");  // Comprobar cierto elemento contiene cierto texto
//        assertTextPresent("Es Vd el usuario número:"); // Comprobar cierto texto está presente
    }

    @Test
    public void testIniciarSesionConExitoConQueryString() {
//    	// Rellenando el formulario HTML
//        beginAt("/validarse?nombreUsuario=user2");  // Navegar a la URL
//        assertTitleEquals("ShareMyTrip - Página principal del usuario");  // Comprobar título de la página
//        assertTextInElement("login", "user2");  // Comprobar cierto elemento contiene cierto texto
//        assertTextInElement("name", "Luisa");  // Comprobar cierto elemento contiene cierto texto
//        assertTextPresent("Es Vd el usuario número:"); // Comprobar cierto texto está presente
    }
    
    @Test
    public void testIniciarSesionSinExito() {
//    	// Rellenando el formulario HTML
//        beginAt("/");  // Navegar a la URL
//        setTextField("nombreUsuario", "yoNoExisto"); // Rellenar primer campo de formulario
//        submit(); // Enviar formulario
//        assertTitleEquals("ShareMyTrip - Inicie sesión");  // Comprobar título de la página
    }
    
    @Test
    public void testListarViajesQueFuncionaBienYNoVoyABorrarDeMomento() {
        beginAt("/");  // Navegar a la URL
//        assertLinkPresent("listarViajes");  // Comprobar que existe el hipervínculo
//        clickLink("listarViajes"); // Seguir el hipervínculo

//        assertTitleEquals("ShareMyTrip - Listado de viajes");  // Comprobar título de la página

        // La base de datos contiene 2 viajes tal y como se entrega
//        assertElementPresent("item_0"); // Comprobar elemento presente en la página
//        assertElementPresent("item_1"); // Comprobar elemento presente en la página
    }

}