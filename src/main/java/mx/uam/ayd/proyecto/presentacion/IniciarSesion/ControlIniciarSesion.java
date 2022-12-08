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
	
	@Autowired
	private VentanaIniciarSesion ventana;

	public void inicia() {
		// TODO Auto-generated method stub
		ventana.muestra(this);
	}
	
} 