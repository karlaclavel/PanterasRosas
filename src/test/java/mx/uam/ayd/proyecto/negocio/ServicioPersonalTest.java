package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.PersonalRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
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
	
	@InjectMocks
	private ServicioPersonal servicioPersonalDatos;
	
	
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
	void setUp1() throws Exception {
		
		personalPrueba = new Personal();
		personalPrueba.setNombre("Juan Cruz");
		personalPrueba.setCorreo("juanCruz23@gmail.com");
		personalPrueba.setTelefonoPersonal("5561330399");
		personalPrueba.setPuesto("Gerente");
		
	}
	
	@Test
	void testAgregaPersonal () {
		
		// Prueba: Comprobar si AgregarPersonal funciona correctamente
		
		when (personalRepository.findByNombre("Juan")).thenReturn(personalPrueba);
		
		boolean resultado = servicioPersonal.agregaPersonal("Juan", "55601330399", "juan123@gmail.com", "Encargado");
		
		assertEquals(true, resultado); 
		
	}
	@Test
	void testRecuperaTodosPersonal() {
		//Caso de prueba No.1: Regresa una lista vacía
				/*
				 * Simulamos la reposición del repositorio usando un sustituto
				*/
				
				List <Personal> personal = servicioPersonalDatos.recuperaTodosPersonal();
				assertEquals(0,personal.size());
	    //Caso de prueba No.2: Regresa una lista con todos los empleados que se encuentran en la base de datos.
				/*
				 * Como personalRepository.findAll() regresa un Iterable usamos ArrayList
				
				 */
				ArrayList <Personal> listaPersonal = new ArrayList <>();
				
				Personal personal1=new Personal();
				personal1.setNombre("Veronica Silva");
				personal1.setTelefonoPersonal("5561330399");
				personal1.setCorreo("vero@gmail.com");
				personal1.setPuesto("Contadora");
				
				Personal personal2=new Personal();
				personal2.setNombre("Berenice Lucas");
				personal2.setTelefonoPersonal("5588220302");
				personal2.setCorreo("bere@gmail.com");
				personal2.setPuesto("Gerente");
				
				Personal personal3=new Personal();
				personal3.setNombre("Erika Maya");
				personal3.setTelefonoPersonal("5612752187");
				personal3.setCorreo("erika@gmail.com");
				personal3.setPuesto("Diseñadora");
				
				listaPersonal.add(personal1);
				listaPersonal.add(personal2);
				listaPersonal.add(personal3);
				
				when(personalRepository.findAll()).thenReturn(listaPersonal);
				personal = servicioPersonalDatos.recuperaTodosPersonal();
				assertEquals(3,personal.size());
				
	}
	
	@BeforeEach
	void setUp () throws Exception {
		
		personalPrueba = new Personal ();
		
		personalPrueba.setNombre("Juan");
		personalPrueba.setTelefonoPersonal("5561330399");
		personalPrueba.setCorreo("juan123@gmail.com");
		personalPrueba.setPuesto("Calle 33 #113 Col. Santa Cruz Meyehualco");
	}
	
	
	

}