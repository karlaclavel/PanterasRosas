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
	
	/**
	 * 
	 * Manda a llamar al método modificaPersonal() del módulo ServicioPersonal pasandole los mismos parámetros recibidos 
	 * 
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param cargo
	 * @return Mensaje de exito o de error 
	 */
	public void modificaPersonal(String personal, String nombre, String correo, String telefono, String puesto) {

		try {

			servicioPersonal.modificaPersonal(personal, nombre, correo, telefono, puesto);

			ventana.muestraDialogoConMensaje("El personal con nombre: "+personal+" ha sido modificado exitosamente");
			termina();

		} catch (Exception ex) {
			ventana.muestraDialogoConMensaje("Error al modificar al personal seleccionado: " + ex.getMessage());
		}

		termina();
	}
	
	/**
	 * 
	 * Manda a llamar al método obtenerPersonal() del módulo ServicioPersonal pasandole los mismos parámetros recibidos 
	 * 
	 * @param nombre
	 * @return personal seleccionado  
	 */
	
	public Personal obtenerPersonal(String nombre) {
		Personal personal=servicioPersonal.obtenerPersonal(nombre);
		return personal; 
	}
	
	/**
	 * Termina la historia de usuario 10 
	 * 
	 */
	public void termina() {
		ventana.setVisible(false);		
	}
	

}
