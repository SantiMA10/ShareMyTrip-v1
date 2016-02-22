package uo.sdi.util;

public class Comprobante {
	
	/**
	 * Comprueba si los parametros introducidos son null o vacios
	 * @param args
	 * @return False si estan vacios o es null. True si son correctos
	 */
	public static boolean comprobarDatos(String... args){
		for (String string : args) {
			if(string == null || string.isEmpty())
				return false;
		}
		return true;
	}

}
