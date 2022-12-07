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
 * @author abigailmorales
 * @author erikamaya
 * @author eduardocastro
 *
 */

@Entity
@Data
public class Personal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPersonal;

	private String contraseña;
	
	private String correo; 
	
	private String nombreCompleto;
	
	private String telefono;
	
	private String cargo;
    
	@OneToMany(targetEntity = Personal.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)  
	 @JoinColumn(name= "idCompra")
	 private final List <Compra> compras = new ArrayList <> ();
   
	 @OneToMany(targetEntity = Personal.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)  
	 @JoinColumn(name= "idPersonal")
	 private final List <Personal> personal = new ArrayList <> ();

}
