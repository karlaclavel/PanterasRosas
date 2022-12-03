package mx.uam.ayd.proyecto.presentacion.modificarPersonal;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioPersonal;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;

/**
 * 
 * Módulo de control para la historia de usuario Modificar Personal
 * 
 * @author erikamaya 
 *
 */
@Component
public class ControlModificarPersonal {
	
	@Autowired 
	private ServicioPersonal servicioPersonal; 
	
	@Autowired 
	private VentanaModificarPersonal ventana;
	
	/**
	 * 
	 * Permite dar inicio al módulo ControlModificarPersonal y a sus respectivos métodos    
	 * 
	 */
	public void inicia() {
		List <Personal> personal = servicioPersonal.consultarPersonal(); 
		ventana.muestra(this, personal);
	}

}
