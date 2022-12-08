package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Compra;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;

/**
 * Repositorio para Personal
 * 
 * @author Berenice
 *
 */

public interface PersonalRepository extends CrudRepository<Personal, Long> {

	/**
	 * Encuentra a al personal a partir de un idPersonal
	 * Repositorio para Personal 
	 * @param idPersonal   
	 * @return
	 * 
	 */
	public List <Compra> findByCompras(Personal personal);
	
	public Personal findByIdPersonal(long idPersonal); //**//
	
	public Personal findByNombreCompleto(String nombre); //**//
	
	public List <Personal> findAll(); // El Repository recupera a una lista de Personal  
	

}
