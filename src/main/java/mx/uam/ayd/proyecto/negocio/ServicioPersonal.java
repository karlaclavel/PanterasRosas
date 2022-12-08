package mx.uam.ayd.proyecto.negocio;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.PersonalRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;
/**
 * Servicio relacionado con el Cliente
 * 
 * @author erikamaya 
 * @author Berenice 
 * 
 * 
 */

@Slf4j
@Service
public class ServicioPersonal {
	
	@Autowired
	private PersonalRepository personalRepository;
	
	/**
	 * 
	 * Permite agregar un producto a la seccion catalogo que se desea 
	 * 
	 * 
	 **/
	
	public boolean agregaPersonal(String nombre, String telefono, String correo, String puesto) {

		Personal personal = personalRepository.findByNombreCompleto(nombre);	
		
		if (personal != null) 
			throw new IllegalArgumentException ("El personal ya fue registrado");
		
		log.info("Agregando personal con nombre: " + nombre + ", teléfono: " + telefono + "correo: " + correo + "dirección" + puesto);
		
		personal = new Personal ();
		personal.setNombreCompleto(nombre);
		personal.setTelefono (telefono);
		personal.setCorreo(correo);
		personal.setCargo(puesto);
		
		personalRepository.save(personal);
		
		return true;
	}
	
	/**
	 * Recupera todos los empleados existentes 
	 * Contrato:
	 * @return Una lista con todos los empleados existentes
	 *         Una lista vacía
	
	 */	
	public List <Personal> recuperaTodosPersonal(){ 
		
		
		List <Personal> listaPersonal =new ArrayList<>();
		
		for(Personal personal:personalRepository.findAll()) {  
			listaPersonal.add(personal);
		}
		return listaPersonal;
	}

}
