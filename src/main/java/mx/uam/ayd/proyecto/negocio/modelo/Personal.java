package mx.uam.ayd.proyecto.negocio.modelo;
//Entidad de negocio Cliente

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Entidad de negocio Personal
 * 
 * @author berelucas
 * @author erikamaya
 *
 */

@Entity
@Data
public class Personal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long idPersonal;
	
	private String nombre;
	
	//private String apellido;
    
	private String telefonoPersonal;
    
	private String puesto;
	
	private String correo;
  
}
