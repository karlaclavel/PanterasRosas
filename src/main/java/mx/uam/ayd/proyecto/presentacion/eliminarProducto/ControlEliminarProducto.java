package mx.uam.ayd.proyecto.presentacion.eliminarProducto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProducto;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.SeccionCatalogo;

/**
 * 
 * Módulo de control para la historia de usuario EliminarProducto
 * 
 * @author veronicasilva
 *
 */
@Component
public class ControlEliminarProducto {
	
	@Autowired 
	private ServicioProducto servicioProducto; 
	
	@Autowired 
	private VentanaEliminarProducto ventana;
	
	/**
	 * 
	 * Permite dar inicio al módulo ControlModificarProducto y a sus respectivos métodos de dicho módulo   
	 * 
	 */
	public void inicia() {
		
		List <Producto> productos = servicioProducto.consultarProductosDisponibles(); 
		ventana.muestra(this, productos);
	}
	
	public void eliminaProducto( String nombre) {

		try {

			servicioProducto.eliminarProducto(nombre);

			ventana.muestraDialogoConMensaje("El producto "+nombre+" sido eliminado exitosamente");
			termina();

		} catch (Exception ex) {
			ventana.muestraDialogoConMensaje("Error al eliminar producto: " + ex.getMessage());
		}

		termina();
	}
	
	
	
	/**
	 * 
	 * Manda a llamar al método obtenerProducto() del módulo ServicioProducto pasandole los mismos parámetros recibidos 
	 * 
	 * @param nombre
	 * @return producto 
	 */
	
	public Producto obtenerProducto(String nombre) {
		Producto producto=servicioProducto.obtenerProducto(nombre);
		return producto; 
	}
	
	/**
	 * 
	 * Manda a llamar al método obtenerSeccionCatalogoDelProducto() del módulo ServicioProducto pasandole los mismos parámetros recibidos  
	 * 
	 * @param producto
	 * @return seccion
	 */
	
	public SeccionCatalogo obtenerSeccionCatalogoDelProducto(Producto producto) {
		SeccionCatalogo seccion=servicioProducto.obtenerSeccionCatalogoDelProducto(producto);
		return seccion; 
	}
	
	/**
	 * Termina la historia de usuario
	 * 
	 */
	public void termina() {
		ventana.setVisible(false);		
	}

}
