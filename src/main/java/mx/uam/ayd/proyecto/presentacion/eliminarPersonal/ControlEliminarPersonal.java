package mx.uam.ayd.proyecto.presentacion.eliminarPersonal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ControlEliminarPersonal {
	
	@Autowired
	private VentanaEliminarPersonal ventana;
	
	public void inicia() {
		ventana.muestra(this);
	}

}
