package mx.uam.ayd.proyecto.presentacion.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.IniciarSesion.ControlIniciarSesion;
import mx.uam.ayd.proyecto.presentacion.IniciarSesion.VentanaIniciarSesion;
import mx.uam.ayd.proyecto.presentacion.agregarCliente.ControlAgregarCliente;
import mx.uam.ayd.proyecto.presentacion.agregarPersonal.ControlAgregarPersonal;
import mx.uam.ayd.proyecto.presentacion.agregarProducto.ControlAgregarProducto;
import mx.uam.ayd.proyecto.presentacion.crearGarantia.ControlCrearGarantia;
import mx.uam.ayd.proyecto.presentacion.eliminarPersonal.ControlEliminarPersonal;
import mx.uam.ayd.proyecto.presentacion.eliminarProducto.ControlEliminarProducto;
import mx.uam.ayd.proyecto.presentacion.modificarPersonal.ControlModificarPersonal;
import mx.uam.ayd.proyecto.presentacion.modificarProducto.ControlModificarProducto;
import mx.uam.ayd.proyecto.presentacion.obtenerDatos.ControlObtenerDatos;
import mx.uam.ayd.proyecto.presentacion.verCatalogo.ControlVerCatalogo;
import mx.uam.ayd.proyecto.presentacion.verPersonal.ControlVerPersonal;
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
	
	@Autowired
	private ControlModificarPersonal controlModificarPersonal;
	
	@Autowired
	private ControlAgregarPersonal controlAgregarPersonal;
	
	@Autowired
	private ControlEliminarPersonal controlEliminarPersonal;
	
  @Autowired
	private ControlVerPersonal controlVerPersonal;
  
  @Autowired
	private ControlEliminarProducto controlEliminarProducto;

	/**
	 * Inicia el flujo de control de la ventana de inicio de sesion
	 * 
	 */
	public void inicia() {
		ventana.muestra(this);
	}
	
	/**
	 * M??todo que arranca la historia de usuario "agregar productos al catalogo"
	 * 
	 */
	public void agregarProducto() {
		
		controlAgregarProducto.inicia();
		
	}
	
	/**
	 * M??todo que arranca la historia de usuario "modificar productos del catalogo"
	 * 
	 */
	public void modificarProducto() {
		
		controlModificarProducto.inicia();
		
	}
	
	/**
	 * M??todo que arranca la historia de usuario "eliminar productos"
	 * 
	 */
	public void eliminarProducto() {
		
		controlEliminarProducto.inicia();
	}
	
	/**
	 * M??todo que inicia la historia de usuario " Obtener Datos"
	 * 
	 */
	public void obtenerDatos() {
		
		controlObtenerDatos.inicia();
	}
	/**
	 * M??todo que arranca la historia de usuario "Crea garant??a"
	 * 
	 */
	public void creaGarantia() {
		
		controlCrearGarantia.inicia();
	}
	/**
	 * M??todo que arranca la historia de usuario "Lista m??s comprados"
	 * 
	 */
	public void listaProductosMasComprados() {
		
		controlVizualizarProducto.inicia();

	}
	
	public void VerCatalogo() {
		controlVerCatalogo.inicia();
	}

	/**
	 * M??todo que arranca la historia de usuario "Agregar Clientes"
	 * 
	 */
	public void agregarCliente() {
		controlAgregarCliente.inicia();
	}
	
	/**
	 * M??todo que arranca la historia de usuario "Modificar Personal"
	 * 
	 */
	public void modificarPersonal() {
		controlModificarPersonal.inicia();
	}
  
	/**
	 * M??todo que arranca la historia de usuario "Agregar Personal"
	 * 
	 */
	
  public void agregarPersonal() {
		controlAgregarPersonal.inicia();
	}

   /**
	 * M??todo que arranca la historia de usuario "Eliminar Personal"
	 * 
	 */
  public void eliminarPersonal() {
	  controlEliminarPersonal.inicia();
  }
	
  /**
	 * M??todo que arranca la historia de usuario "Lista ver Personal"
	 * 
	 */
  public void verPersonal() {
		controlVerPersonal.inicia();
	}

}