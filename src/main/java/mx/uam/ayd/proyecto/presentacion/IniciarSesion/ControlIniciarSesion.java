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
	
	private VentanaIniciarSesion ventana;
	
	String usuario = "admin";
	String contraseña = "123";
	
	/*
	public void validaDatos(String user, String pass) {
		// TODO Auto-generated method stub
		if (user == usuario && pass == contraseña) {
			control.inicia();
			ventana.dispose();
		}
		
	}*/
	
	
}
