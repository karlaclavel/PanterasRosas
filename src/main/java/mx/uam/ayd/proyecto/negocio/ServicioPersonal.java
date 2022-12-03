package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.PersonalRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;

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
}
