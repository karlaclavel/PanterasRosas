/**
 * 
 */
package mx.uam.ayd.proyecto.presentacion.IniciarSesion;

import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;

import org.springframework.stereotype.Component;


/**
 * Modulo de control para el inicio de sesión
 * 
 * @author karlaclavel
 *
 */

@Component
public class ControlIniciarSesion {

	private ControlPrincipal control;
	
	private VentanaIniciarSesion is;
	
	String usuario = "PANROSA-ADMIN";
	String contraseña = "BVEKUAMIS22";
	
	
	public void ValidarDatos(String user, String pass) {
		// TODO Auto-generated method stub
		if (user.equals(usuario)) {
			is.dispose();
		}
		
	}
	
	
}
