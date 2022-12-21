package mx.uam.ayd.proyecto.presentacion.verPersonal;
import java.awt.Font;
/**
 * 
 * Módulo de la vista para la historia de usuario Ver la lista del Personal
 *  
 * @author berenicelucas
 *
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.modelo.Personal;


import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
@Component
public class VentanaVerPersonal extends JFrame {

	private JPanel contentPane;
	private ControlVerPersonal controlPersonal;
	private JTable tablaPersonal;
	private DefaultTableModel model;
	
	
	/*DISEÑO DE LA VENTANA	*/
	
	public VentanaVerPersonal() {
	
		setTitle("Personal ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(237, 216, 218));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("Lista Personal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Lista de Personal ");
		lblTitulo.setBounds(122, 11, 228, 32);
		lblTitulo.setForeground(new Color(199, 21, 133));
		lblTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 25));
		contentPane.add(lblTitulo);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 414, 183);
		contentPane.add(scrollPane);
		
		tablaPersonal = new JTable();
		model = new DefaultTableModel();
		tablaPersonal.setModel(model);
		
		//Creamos las columnas al modelo para mostrar los datos
		
		model.addColumn("Nombre Personal");
		model.addColumn("Teléfono");
		model.addColumn("Correo");
		model.addColumn("Puesto");
		
		
		scrollPane.setViewportView(tablaPersonal);
		
		JButton ButtonSalir = new JButton("Salir");
		ButtonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPersonal.termina();
			}
		});
		ButtonSalir.setForeground(Color.BLACK);
		ButtonSalir.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonSalir.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		ButtonSalir.setBackground(new Color(255, 228, 225));
		ButtonSalir.setBounds(249, 226, 119, 23);
		contentPane.add(ButtonSalir);
		
	}
	
	/*
	 * Este método nos muestra la ventana de la historia de usuario HU-08 
	 * 
	 */
	public void muestra(ControlVerPersonal control, List <Personal> listaPersonal) {
		controlPersonal = control;
		for(Personal personal:listaPersonal) {
			
			Object[] fila =new Object[5];
			fila[0]=personal.getNombre();
			fila[1]=personal.getTelefonoPersonal();
			fila[2]=personal.getCorreo();
			fila[3]=personal.getPuesto();
			fila[4]="";
			
			model.addRow(fila);
		}
		tablaPersonal.setModel(model);
		setVisible(true);
	}
}
