package mx.uam.ayd.proyecto.presentacion.eliminarPersonal;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioPersonal;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;

/**
 * Modulo de Control relacionado con la HU-11 Eliminar Personal
 * 
 * @author erikamaya
 *
 */

@Component
public class ControlEliminarPersonal {
	
	@Autowired
	private VentanaEliminarPersonal ventana;
	
	@Autowired
	private ServicioPersonal servicioPersonal;
	
	/**
	 * @name inicia
	 * Permite dar inicio al módulo ControlEliminarPersonal y a sus respectivos métodos    
	 * 
	 */
	
	public void inicia() {
		List <Personal> personal = servicioPersonal.consultarPersonal();
		
		ventana.muestra(this, personal);
	}
	/**
	 * @name obtenerPersonal
	 * Manda a llamar al método obtenerPersonal() del módulo ServicioPersonal pasandole los mismos parámetros recibidos 
	 * 
	 * @param nombreCompleto
	 * @return personalSeleccionado  
	 */
	
	public Personal obtenerPersonal(String nombreCompleto) {
		Personal personalSeleccionado=servicioPersonal.obtenerPersonal(nombreCompleto);
		return personalSeleccionado; 
	}
	
	/**
	 * @name termina
	 * Termina la historia de usuario 11, se utiliza con el botón "cancelar" permitiendo cerrar la ventana y volver al menú principal 
	 * 
	 */
	
	public void termina() {
		ventana.setVisible(false);		
	}

}
