package mx.uam.ayd.proyecto.presentacion.agregarCliente;

import mx.uam.ayd.proyecto.negocio.ServicioCliente;

public class ControlAgregarCliente {
	
	private ServicioCliente servicioCliente;
	
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
