package mx.uam.ayd.proyecto.presentacion.verPersonal;

import java.util.List;
/**
 * 
 * Módulo de control para la historia de usuario VerListaDelPersonal
 *  
 * @author berenicelucas
 *
 */


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioPersonal;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;

@Component
public class ControlVerPersonal {
	
	@Autowired
	private VentanaVerPersonal ventanaPersonal;
	
	@Autowired
	private ServicioPersonal servicioPersonal;
	
	/**
	 * El control inicia (muestra) la Ventana VerPeronal 
	 */
	public void inicia() {
		
		List <Personal> listaPersonal =servicioPersonal.recuperaTodosPersonal(); // El control le pide al ServicioPersonal una lista de clientes 
		
		ventanaPersonal.muestra(this, listaPersonal); // La ventana me va a mostrar una lista del personal
	}
	
	/**
	 * Termina la historia de usuario
	 * 
	 */
	public void termina() {
		ventanaPersonal.setVisible(false);		
	}
	
	
} 
