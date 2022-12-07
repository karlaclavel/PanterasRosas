package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.PersonalRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;

/**
 * Pruebas unitarias de los métodos de ServicioPersonal 
 * 
 * @author erikamaya
 * 
 */
@ExtendWith(MockitoExtension.class)
class ServicioPersonalTest {
	
	
	@Mock
	private PersonalRepository personalRepository;
	
	@Mock
	private ServicioPersonal servicioPersonal;
	
	@Mock
	private Personal personalPrueba;
	
	
	@AfterEach
	void tearDown() throws Exception {
		// Este método se ejecuta después de la ejecución
		// de cada método de prueba, es útil para
		// dejar todo como estaba antes de la prueba
	}
	
	@Test
	void testConsultarPersonal() {
		
		// Prueba 1: Probar que el método consultarPersonal()se comporta correctamente si no se encuentra Personal registrado en la Base de datos.
		
		List <Personal> personal =  servicioPersonal.consultarPersonal();
		assertEquals(0,personal.size());
	}
	
	
	@Test
	void testObtenerPersonal() {
		
		// Prueba 1:Probar que el método obtenerPersonal(String nombre) se comporta correctamente si el personal que se desea obtener no se encuentra en la BD.
		
		when(personalRepository.findByNombre("Juan Cruz")).thenReturn(null);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			servicioPersonal.obtenerPersonal("Juan cruz");
		});	
		
		// Prueba 2: Probar que el método obtenerPersonal(String nombre) se comporta correctamente si el personal que se desea obtener si se encuentra en la BD.

		when(personalRepository.findByNombre("Juan Cruz")).thenReturn(personalPrueba);
		
		Personal personal = servicioPersonal.obtenerPersonal("Juan Cruz");
		
		assertNotEquals(null, personal); 
	
	}
	
	@Test
	void testModificaPersonal() {
		
		// Prueba 1: Probar que el método modificaPersonal(nombrePersonalAModificar, nombre, correo, telefono, puesto); se comporta correctamente si el personal que se desea modificar no se encuentra en la BD.
		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {

			servicioPersonal.modificaPersonal("Juan Cruz", "Juan Cruz", "juanCruz23@gmail.com", "5561330399", "Gerente"); 

		});
		
		
		// Prueba 2: Probar que el método modificaPersonal(nombrePersonalAModificar, nombre, correo, telefono, puesto); se comporta correctamente si el personal que se desea modificar si se encuentra en la BD.

		String nombre = "Juan Cruz";
		
		when(personalRepository.findByNombre(nombre)).thenReturn(personalPrueba);
		when(personalRepository.save(personalPrueba)).thenReturn(personalPrueba);
		
		Personal personal = servicioPersonal.modificaPersonal(nombre,"", "", "", "Administrador");
	
		assertNotEquals(null, personal);
		
	} 
	
	@BeforeEach
	void setUp() throws Exception {
		
		personalPrueba = new Personal();
		personalPrueba.setNombre("Juan Cruz");
		personalPrueba.setCorreo("juanCruz23@gmail.com");
		personalPrueba.setTelefonoPersonal("5561330399");
		personalPrueba.setPuesto("Gerente");
		
	}
	
	

}
