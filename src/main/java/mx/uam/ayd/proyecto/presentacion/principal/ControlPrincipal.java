package mx.uam.ayd.proyecto.presentacion.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.IniciarSesion.ControlIniciarSesion;
import mx.uam.ayd.proyecto.presentacion.IniciarSesion.VentanaIniciarSesion;
import mx.uam.ayd.proyecto.presentacion.agregarCliente.ControlAgregarCliente;
import mx.uam.ayd.proyecto.presentacion.agregarPersonal.ControlAgregarPersonal;
import mx.uam.ayd.proyecto.presentacion.agregarProducto.ControlAgregarProducto;
import mx.uam.ayd.proyecto.presentacion.crearGarantia.ControlCrearGarantia;
import mx.uam.ayd.proyecto.presentacion.modificarProducto.ControlModificarProducto;
import mx.uam.ayd.proyecto.presentacion.obtenerDatos.ControlObtenerDatos;
import mx.uam.ayd.proyecto.presentacion.verCatalogo.ControlVerCatalogo;
import mx.uam.ayd.proyecto.presentacion.vizualizarProducto.ControlVizualizarProducto;

@Component
public class ControlPrincipal{
	
	@Autowired
	private VentanaPrincipal ventana;
	
	@Autowired
	private ControlAgregarProducto controlAgregarProducto; 
	
	@Autowired
	private ControlModificarProducto controlModificarProducto; 
	
	@Autowired
	private ControlObtenerDatos controlObtenerDatos;
	
	@Autowired
	private ControlCrearGarantia controlCrearGarantia;
	
	@Autowired
	private ControlVizualizarProducto controlVizualizarProducto;
	
	@Autowired
	private ControlVerCatalogo controlVerCatalogo;
	
	
	@Autowired
	private ControlAgregarCliente controlAgregarCliente;
	
	@SuppressWarnings("unused")
	@Autowired
	private ControlAgregarPersonal controlAgregarPersonal;
	
	
	/**
	 * Inicia el flujo de control de la ventana de inicio de sesion
	 * 
	 */
	public void inicia() {
		ventana.muestra(this);
	}
	
	/**
	 * Método que arranca la historia de usuario "agregar productos al catalogo"
	 * 
	 */
	public void agregarProducto() {
		
		controlAgregarProducto.inicia();
		
	}
	
	/**
	 * Método que arranca la historia de usuario "modificar productos del catalogo"
	 * 
	 */
	public void modificarProducto() {
		
		controlModificarProducto.inicia();
		
	}
	/**
	 * Método que inicia la historia de usuario " Obtener Datos"
	 * 
	 */
	public void obtenerDatos() {
		
		controlObtenerDatos.inicia();
	}
	/**
	 * Método que arranca la historia de usuario "Crea garantía"
	 * 
	 */
	public void creaGarantia() {
		
		controlCrearGarantia.inicia();
	}
	/**
	 * Método que arranca la historia de usuario "Lista más comprados"
	 * 
	 */
	public void listaProductosMasComprados() {
		
		controlVizualizarProducto.inicia();

	}
	
	public void VerCatalogo() {
		controlVerCatalogo.inicia();
	}

	/**
	 * Método que arranca la historia de usuario "Agregar Clientes"
	 * 
	 */
	public void agregarCliente() {
		controlAgregarCliente.inicia();
	}
	
	/**
	 * Método que arranca la historia de usuario "Agregar Personal"
	 * 
	 */
	
	public void agregarPersonal() {
		controlAgregarPersonal.inicia();
	}
	
	
}