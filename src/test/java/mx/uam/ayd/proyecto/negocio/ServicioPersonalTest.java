package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import mx.uam.ayd.proyecto.datos.PersonalRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Personal;


public class ServicioPersonalTest {
	@Mock //genera un sustituto
	private PersonalRepository personalRepository;
	@InjectMocks
	private ServicioPersonal servicioPersonalDatos;
	
	private ServicioPersonal servicioPersonal;
	
	private Personal personalprueba;
	@Test
	void testAgregaPersonal () {
		
		// Prueba: Comprobar si AgregarPersonal funciona correctamente
		
		when (personalRepository.findByNombreCompleto("Juan")).thenReturn(personalprueba);
		
		boolean resultado = servicioPersonal.agregaPersonal("Juan", "55601330399", "juan123@gmail.com", Encargado");
		
		assertEquals(true, resultado); 
		
	}


}
