/**
 * 
 */
package mx.uam.ayd.proyecto.presentacion.IniciarSesion;

import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	String usuario = "ADMINPANROSA";
	String contraseña = "UAMI";
	
/*
	public  void validarDatos(String nombre, String pass) {
			if (nombre == usuario && pass == contraseña) {
				control.inicia();
				ventana.dispose();
			}
	}


	public void inicia() {
		ventana.muestra(this);
	}
	
	*/
	
} 