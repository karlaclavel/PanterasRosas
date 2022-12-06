package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.PersonalRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

/**
 * Servicio relacionado con las secciones del catalogo
 * 
 * @author erikamaya
 * @author berelucas
 *
 */
@Slf4j
@Service
public class ServicioPersonal {
	
	@Autowired 
	private PersonalRepository personalRepository; 
	
	/**
	 * 
	 * Recupera un listado de todo el personal agregado en la base de datos 
	 * 
	 * @param 
	 * @return Una lista con todo el personal que se encuentra en la base de datos 
	 */
	
	public List <Personal> consultarPersonal() {
		
		List <Personal> todoPersonal = new ArrayList<>();
		
		for(Personal personal:personalRepository.findAll()) {
			todoPersonal.add(personal);
		}
				
		return todoPersonal;
	}
	
	/**
	 * 
	 * Recupera al personal de acuerdo a su nombre 
	 * 
	 * @param nombre
	 * @return un objeto de tipo Personal si este se encontro en la base de datos 
	 * @throws IllegalArgumentException si el personal no existe
	 */
	
	public Personal obtenerPersonal(String nombre) {
		
		Personal personal = personalRepository.findByNombre(nombre);
		
		if (personal == null) {
			throw new IllegalArgumentException("El personal no existe");
		}else
			return personal; 
	}
	
	public Personal modificaPersonal(String nombrePersonalAModificar, String nombre, String apellido, String telefono, String cargo) {

		
		Personal personal = personalRepository.findByNombre(nombrePersonalAModificar);

		if (personal == null) {
			throw new IllegalArgumentException("El personal no existe");
		}

		log.info("Modificando al personal con nombre: " + nombre + ", apellido:" + apellido + ", telefono:" + telefono
				+ ", cargo:" + cargo);
		
		if(!nombre.equals("")) {
			personal.setNombre(nombre);
		}
		if(!apellido.equals("")) {
			personal.setApellido(apellido);
		}
		if(telefono.equals("")) {
			personal.setTelefonoPersonal(telefono);
		}
		if(!cargo.equals("")) {
			personal.setCargo(cargo);
		}		
		personal=personalRepository.save(personal);
		
		return personal;

}
	
	
}
