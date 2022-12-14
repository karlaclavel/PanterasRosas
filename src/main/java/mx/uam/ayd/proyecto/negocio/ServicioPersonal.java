package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.PersonalRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;

/**
 * Servicio relacionado con la entidad Personal 
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
	 * @name consultarPersonal 
	 * Recupera un listado de todo el personal agregado en la base de datos 
	 * 
	 * @param 
	 * @return Una lista con todo el personal que se encuentra en la base de datos 
	 */
	
	public List <Personal> consultarPersonal() {
		
		List <Personal> listaPersonal = new ArrayList<>();
		
		for(Personal personal:personalRepository.findAll()) {
		  	listaPersonal.add(personal);
		}
				
		return listaPersonal;
	}
	
	/**
	 * 
	 * Recupera al personal de acuerdo a su nombre 
	 * 
	 * @name obtenPersonal
	 * @param nombre
	 * @return un objeto de tipo Personal si este se encontro en la base de datos 
	 * @throws IllegalArgumentException, si el personal no existe
	 */
	
	public Personal obtenerPersonal(String nombre) {
		
		Personal personal = personalRepository.findByNombre(nombre);
		
		if (personal == null) {
			throw new IllegalArgumentException("El personal no existe");
		}else
			return personal; 
	}
	
	/**
	 * 
	 * método eliminarPersonal() del módulo ServicioPersonal pasandole los mismos parámetros recibidos 
	 * 
	 * @param nombrePersonalAModificar
	 * @return personalSeleccionado
	 */
	
	public Personal eliminarPersonal(String nombrePersonalEliminar) {
		
		
		Personal personalSeleccionado = personalRepository.findByNombre(nombrePersonalEliminar);
		
		if (personalSeleccionado == null) { 
			throw new IllegalArgumentException ("El personal no existe");
		}
		log.info("Eliminando personal con nombre: " + personalSeleccionado.getNombre());
		
		if(personalSeleccionado.getNombre().equals(nombrePersonalEliminar)) {
			personalRepository.delete(personalSeleccionado);
		}
		return personalSeleccionado;
	
	}
	
	/**
	 * 
	 * método modificaPersonal() del módulo ServicioPersonal pasandole los mismos parámetros recibidos 
	 * 
	 * @param nombrePersonalAModificar
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param cargo
	 * @return Mensaje de exito o de error 
	 */
	
	public Personal modificaPersonal(String nombrePersonalAModificar, String nombre, String correo, String telefono, String puesto) {

		
		Personal personal = personalRepository.findByNombre(nombrePersonalAModificar);

		if (personal == null) {
			throw new IllegalArgumentException("El personal no existe");
		}

		log.info("Modificando al personal con nombre: " + nombre + ", apellido:" + correo + ", telefono:" + telefono
				+ ", cargo:" + puesto);
		
		if(!nombre.equals("")) {
			personal.setNombre(nombre);
		}
		if(!correo.equals("")) {
			personal.setCorreo(correo);
		}
		if(telefono.equals("")) {
			personal.setTelefonoPersonal(telefono);
		}
		if(!puesto.equals("")) {
			personal.setPuesto(puesto);
		}		
		personal=personalRepository.save(personal);
		
		return personal;

     }
	
	public boolean agregaPersonal(String nombre, String telefono, String correo, String puesto) {

		Personal personal = personalRepository.findByNombre(nombre);	

		if (personal != null) 
			throw new IllegalArgumentException ("El personal ya fue registrado");
		
		log.info("Agregando personal con nombre: " + nombre + ", teléfono: " + telefono + "correo: " + correo + "dirección" + puesto);
		
		personal = new Personal ();

		personal.setNombre(nombre);
		personal.setTelefonoPersonal(telefono);
		personal.setCorreo(correo);
		personal.setPuesto(puesto);
		
		personalRepository.save(personal);
		return true;
	}
	
	/*Recupera una lista de todos los emleados que estan registrados 
	 * 
	 */
	public List <Personal> recuperaTodosPersonal(){ 
		
		List <Personal> listaPersonal =new ArrayList<>();
		
		for(Personal personal:personalRepository.findAll()) {  
			listaPersonal.add(personal);
		}
		return listaPersonal;
	}

}
