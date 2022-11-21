package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
/**
 * Servicio relacionado con el Cliente
 * 
 * @author erikamaya 
 * 
 */

@Slf4j
@Service
public class ServicioCliente {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * 
	 * Permite agregar un producto a la seccion catalogo que se desea 
	 * 
	 * 
	 **/
	
	public boolean agregaCliente (String nombre, String telefono, String correo, String direccion) {

		Cliente cliente = clienteRepository.findByNombre(nombre);	
		
		if (cliente != null) 
			throw new IllegalArgumentException ("El cliente ya fue registrado");
		
		cliente = new Cliente ();
		
		cliente.setNombreCompleto(nombre);
		cliente.setTelefono (telefono);
		cliente.setCorreo(correo);
		cliente.setDireccionEntrega(direccion);
		
		clienteRepository.save(cliente);
		
		return true;
	}
	
	/**
	 * Recupera todos los clientes existentes 
	 * Contrato:
	 * @return Una lista con todos los clientes existentes
	 *         Una lista vacía
	A
	 */	
	public List <Cliente> recuperaTodosClientes(){ 
		System.out.println("clienteRepository = " + clienteRepository);
		
		List <Cliente> listaClientes =new ArrayList<>();
		
		for(Cliente cliente:clienteRepository.findAll()) {  
			listaClientes.add(cliente);
		}
		return listaClientes;
	}
	
}
