package mx.uam.ayd.proyecto.presentacion.agregarCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.ServicioCliente;

/**
 * 
 * Módulo de control para la historia de usuario AgregarCliente
 *  
 * @author karlaclavel
 *
 */


@Component
public class ControlAgregarCliente {
	
	@Autowired
	private ServicioCliente servicioCliente;
	
	@Autowired
	private VentanaAgregarCliente ventana;

	public void inicia() {
		ventana.muestra(this);
	}
	
	public void agregaCliente(String nombre, String telefono, String correo, String direccion) {
		
		try {

			if (servicioCliente.agregaCliente (nombre, telefono, correo, direccion) != false) {
				ventana.muestraDialogoConMensaje("Cliente agregado");
				termina();
			} else {
				ventana.muestraDialogoConMensaje("Cliente no fue agregado");
				termina();
			}

		} catch (Exception ex) {
			ventana.muestraDialogoConMensaje("Error al agregar cliente: " + ex.getMessage());
		}

		termina();
		
	}
	
	public void termina() {
		ventana.setVisible(false);		
	}

}
