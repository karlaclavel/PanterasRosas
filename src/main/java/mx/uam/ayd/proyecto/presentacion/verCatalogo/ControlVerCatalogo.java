package mx.uam.ayd.proyecto.presentacion.verCatalogo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioSeccionCatalogo;
import mx.uam.ayd.proyecto.negocio.modelo.SeccionCatalogo;

/**
 * 
 * Módulo de control para la historia de usuario AgregarProducto
 * 
 * @author Veronica Silva
 *
 */
@Component
public class ControlVerCatalogo {
	
	@Autowired 
	private ServicioSeccionCatalogo servicioSeccionCatalogo; 
	
	//@Autowired 
	//private ServicioProducto servicioProducto; 
	
	@Autowired 
	private VentanaVerCatalogo ventana; 
	
	
	/**
	 * 
	 * Permite dar inicio al módulo ControlAgregarProducto y a sus respectivos métodos de dicho módulo  
	 * 
	 */
	
	public void inicia() {
		
		List <SeccionCatalogo> secciones= servicioSeccionCatalogo.consultarSeccionesDisponibles(); 
		ventana.muestra(this, secciones);
	}
	
	

	
	/**
	 * Termina la historia de usuario
	 * 
	 */
	public void termina() {
		ventana.setVisible(false);		
	}
}
