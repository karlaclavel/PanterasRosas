package mx.uam.ayd.proyecto.presentacion.agregarPersonal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.ServicioPersonal;

/**
 * 
 * Módulo de control para la historia de usuario AgregarCliente
 *  
 * @author karlaclavel
 *
 */


@Component
public class ControlAgregarPersonal {
	
	@Autowired
	private ServicioPersonal servicioPersonal;
	
	@Autowired
	private VentanaAgregarPersonal ventana;

	public void inicia() {
		ventana.muestra(this);
	}
	
	public void agregaPersonal(String nombre, String telefono, String correo, String puesto) {
		
		try {

			if (servicioPersonal.agregaPersonal (nombre, telefono, correo, puesto) != false) {
				ventana.muestraDialogoConMensaje("Personal agregado");
				termina();
			} else {
				ventana.muestraDialogoConMensaje("El personal no fue agregado");
				termina();
			}

		} catch (Exception ex) {
			ventana.muestraDialogoConMensaje("Error al agregar personal: " + ex.getMessage());
		}

		termina();
		
	}
	
	public void termina() {
		ventana.setVisible(false);		
	}

}
