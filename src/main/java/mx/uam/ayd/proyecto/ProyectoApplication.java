package mx.uam.ayd.proyecto;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.datos.CompraRepository;
import mx.uam.ayd.proyecto.datos.PersonalRepository;
import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.datos.SeccionCatalogoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Compra;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.SeccionCatalogo;
import mx.uam.ayd.proyecto.presentacion.IniciarSesion.ControlIniciarSesion;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;



/**
 * 
 * Clase principal que arranca la aplicación 
 * construida usando el principio de 
 * inversión de control
 * 
 * 
 * @author Humberto Cervantes (c) 9 Dic 2021
 *
 */
@SpringBootApplication
public class ProyectoApplication {

	@Autowired
	ControlPrincipal controlPrincipal;
	
	@Autowired
	ControlIniciarSesion controlSesion;
	
	@Autowired
	SeccionCatalogoRepository seccionCatalogoRepository; 
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PersonalRepository personalRepository;
	
	@Autowired
	CompraRepository compraRepository;
	
	/**
	 * 
	 * Método principal
	 *
	 * @params args argumentos de la línea de comando
	 * 
	 */
	public static void main(String[] args) {
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ProyectoApplication.class);

		builder.headless(false);

		builder.run(args);
	}

	/**
	 * Metodo que arranca la aplicacion
	 * inicializa la bd y arranca el controlador
	 * otro comentario
	 */
	@PostConstruct
	public void inicia() {
		
		inicializaBD();
		
		controlSesion.inicia();
	}
	
	
	/**
	 * 
	 * Inicializa la BD con datos
	 * 
	 * 
	 */
	public void inicializaBD() {
		
		// Vamos a crear los dos grupos de usuarios
		
		SeccionCatalogo seccionImpresora = new SeccionCatalogo();
		seccionImpresora.setNombre("Impresora");
		seccionCatalogoRepository.save(seccionImpresora);
		
		SeccionCatalogo seccionProcesador = new SeccionCatalogo();
		seccionProcesador.setNombre("Procesadores");
		
		SeccionCatalogo seccionTarjetaMadre = new SeccionCatalogo();
		seccionTarjetaMadre.setNombre("Tarjetas Madres");
		seccionCatalogoRepository.save(seccionTarjetaMadre);
		
		SeccionCatalogo seccionMonitor = new SeccionCatalogo();
		seccionMonitor.setNombre("Monitores");
		seccionCatalogoRepository.save(seccionMonitor);
		
		SeccionCatalogo seccionDiscoDuro = new SeccionCatalogo();
		seccionDiscoDuro.setNombre("Discos Duros");
		seccionCatalogoRepository.save(seccionDiscoDuro);
		
		SeccionCatalogo seccionLaptop = new SeccionCatalogo();
		seccionLaptop.setNombre("Laptops");
		seccionCatalogoRepository.save(seccionLaptop);
		
		Cliente cliente1=new Cliente();
		cliente1.setNombreCompleto("Juan");
		cliente1.setTelefono("5561330399");
		cliente1.setCorreo("juan123@gmail.com");
		cliente1.setDireccionEntrega("Calle 33 #113 Col. Santa Cruz Meyehualco");
		clienteRepository.save(cliente1);
		
		Cliente cliente2=new Cliente();
		cliente2.setNombreCompleto("Sara");
		cliente2.setTelefono("5525689528");
		cliente2.setCorreo("sara456@gmail.com");
		cliente2.setDireccionEntrega("Calle 34 #125 Col. Santa Cruz Meyehualco");
		clienteRepository.save(cliente2);
		
		Personal personal1=new Personal();
		personal1.setNombre("Erika Maya");
		personal1.setCorreo("erikamaya840@gmail.com");
		personal1.setTelefonoPersonal("5561330399");
		personal1.setPuesto("Diseñadora");
		personalRepository.save(personal1);
		
		Personal personal2=new Personal();
		personal2.setNombre("Berenice Lucas");
		personal2.setCorreo("berelu123@gmail.com");
		personal2.setTelefonoPersonal("5556789032");
		personal2.setPuesto("Gerente");
		personalRepository.save(personal2);
		
		Personal personal3=new Personal();
		personal3.setNombre("Veronica Silva");
		personal3.setCorreo("veroSil98@gmail.com");
		personal3.setTelefonoPersonal("5590654455");
		personal3.setPuesto("Contadora");
		personalRepository.save(personal3);
		
		Personal personal4=new Personal();
		personal4.setNombre("Karla Clavel");
		personal4.setCorreo("Karla456@gmail.com");
		personal4.setTelefonoPersonal("5523435678");
		personal4.setPuesto("Administradora");
		personalRepository.save(personal4);
		
		var productoPrueba = new Producto();
		 
		productoPrueba.setNombre("Core i3");
		productoPrueba.setMarca("Intel");
		productoPrueba.setDescripcion("10100F Comet Lake Quad - Procesador de sobremesa, Core 3,6 GHz, 6 MB, LGA 1200, 65W, 4C / 8T");
		productoPrueba.setPrecio(1499.90);
		productoPrueba.setDescuento(15);
		productoPrueba.setExistencia(7);
		productoPrueba.setTotalComprasProducto(0);
		
		seccionProcesador.addProducto(productoPrueba);
		//productoRepository.save(productoPrueba);
		seccionCatalogoRepository.save(seccionProcesador);
		
		var productoPrueba1 = new Producto();
		productoPrueba1.setNombre("Impresora Deskjet Ink Advantage 2375");
		productoPrueba1.setMarca("HP");
		productoPrueba1.setDescripcion("HP Impresora Multifuncional Deskjet Ink Advantage 2375 + Software The Creativity Collection (6Y6X1AW)");
		productoPrueba1.setPrecio(2250);
		productoPrueba1.setDescuento(17);
		productoPrueba1.setExistencia(1);
		productoPrueba1.setTotalComprasProducto(0);
		
		seccionImpresora.addProducto(productoPrueba1);
		//productoRepository.save(productoPrueba);
		seccionCatalogoRepository.save(seccionImpresora);
		
		var productoPrueba2 = new Producto(); 
		productoPrueba2.setNombre("Laptop IP315ITL6");
		productoPrueba2.setMarca("Lenovo");
		productoPrueba2.setDescripcion("Laptop Lenovo IP315ITL6 15.6'' Intel Core i5 8 GB RAM 512 GB SSD Gris");
		productoPrueba2.setPrecio(13999);
		productoPrueba2.setDescuento(10);
		productoPrueba2.setExistencia(2);
		productoPrueba2.setTotalComprasProducto(0);
		
		seccionLaptop.addProducto(productoPrueba2);
		//productoRepository.save(productoPrueba);
		seccionCatalogoRepository.save(seccionLaptop);

		
		var compraPrueba = new Compra();
		compraPrueba.setCantidad(2);
		compraPrueba.setEstadoCompra("Mexico");
		compraPrueba.setFecha("23/05/2022");
		compraPrueba.setGarantia(null);
		compraPrueba.setIdCompra(1);
		compraPrueba.setViaCompra("Internet");
		
		compraRepository.save(compraPrueba);
		
	
		}
}
