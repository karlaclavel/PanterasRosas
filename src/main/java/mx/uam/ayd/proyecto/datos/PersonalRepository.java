package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Compra;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;


/**
 * Repositorio para Personal
 * 
 * @author erikamaya
 * @author berelucas
 *
 */

public interface PersonalRepository extends CrudRepository<Personal, Long> {
	/**
	 * 
	 * @param 
	 * @return Personal, List <Personal>
	 */
	
	public Personal findByNombre(String nombre);
	public List <Personal>	findAll();
  public Personal deleteByNombre(String nombre);
	//public List <Personal> findAll();

}
