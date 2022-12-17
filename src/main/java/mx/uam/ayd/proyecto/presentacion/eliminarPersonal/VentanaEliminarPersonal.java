package mx.uam.ayd.proyecto.presentacion.eliminarPersonal;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Personal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
@Component
public class VentanaEliminarPersonal extends JFrame {

	private JPanel contentPane;
	private JTextField textField_NombreCompleto;
	private JTextField textField_Correo;
	private JTextField textField_Telefono;
	private JTextField textField_Puesto;
	private JComboBox <String> comboBoxPersonal;
	
	private ControlEliminarPersonal control;  
	private String personalSeleccionado="";
	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEliminarPersonal frame = new VentanaEliminarPersonal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEliminarPersonal() {
		setTitle("Eliminar Personal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 216, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Eliminar Personal");
		lblTitulo.setForeground(new Color(158,0,82));
		lblTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 30));
		lblTitulo.setBounds(107, 11, 268, 32);
		contentPane.add(lblTitulo);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(128, 0, 128));
		separator.setBounds(0, 41, 460, 2);
		contentPane.add(separator);
		
		JLabel lblSelecPersonal = new JLabel("Seleccione al Personal que desea eliminar");
		lblSelecPersonal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelecPersonal.setBounds(13, 57, 244, 14);
		contentPane.add(lblSelecPersonal);
		
		comboBoxPersonal = new JComboBox();
		comboBoxPersonal.setBounds(254, 54, 144, 22);
		contentPane.add(comboBoxPersonal);
		
		JRadioButton rdbtnVerInformacion = new JRadioButton("");
		rdbtnVerInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnVerInformacion.isSelected()) {
					muestraInformacionPersonal();
                }else {
					
					textField_NombreCompleto.setEditable(true);
					textField_Correo.setEditable(true);
					textField_Telefono.setEditable(true);
					textField_Puesto.setEditable(true);
					comboBoxPersonal.setEnabled(true); 
					
					textField_NombreCompleto.setText("");
	    			textField_Correo.setText("");
	    			textField_Telefono.setText("");
	    			textField_Puesto.setText("");
				}
			}
		});
		rdbtnVerInformacion.setBackground(new Color(255, 182, 193));
		rdbtnVerInformacion.setBounds(404, 53, 21, 23);
		contentPane.add(rdbtnVerInformacion);
		
		JLabel lblAviso = new JLabel("¡Antes de eliminar, por favor verifique que los datos correspondan al personal seleccionado!");
		lblAviso.setForeground(new Color(128, 0, 128));
		lblAviso.setBackground(new Color(139, 0, 139));
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAviso.setBounds(13, 82, 446, 14);
		contentPane.add(lblAviso);
		
		JLabel lblDatos = new JLabel("DATOS DEL PERSONAL SELECCIONADO ");
		lblDatos.setForeground(new Color(128, 0, 128));
		lblDatos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDatos.setBackground(new Color(139, 0, 139));
		lblDatos.setBounds(10, 104, 244, 14);
		contentPane.add(lblDatos);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(20, 129, 61, 14);
		contentPane.add(lblNombre);
		
		textField_NombreCompleto = new JTextField();
		textField_NombreCompleto.setBounds(78, 127, 347, 20);
		contentPane.add(textField_NombreCompleto);
		textField_NombreCompleto.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorreo.setBounds(20, 164, 61, 14);
		contentPane.add(lblCorreo);
		
		textField_Correo = new JTextField();
		textField_Correo.setColumns(10);
		textField_Correo.setBounds(78, 162, 347, 20);
		contentPane.add(textField_Correo);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelfono.setBounds(20, 205, 61, 14);
		contentPane.add(lblTelfono);
		
		textField_Telefono = new JTextField();
		textField_Telefono.setColumns(10);
		textField_Telefono.setBounds(78, 203, 148, 20);
		contentPane.add(textField_Telefono);
		
		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuesto.setBounds(236, 205, 61, 14);
		contentPane.add(lblPuesto);
		
		textField_Puesto = new JTextField();
		textField_Puesto.setColumns(10);
		textField_Puesto.setBounds(277, 203, 148, 20);
		contentPane.add(textField_Puesto);
		
		JButton btnNewButton = new JButton("Eliminar ");
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(137, 238, 100, 32);
		contentPane.add(btnNewButton);
		
		JButton btnCnacelar = new JButton("Cancelar");
		btnCnacelar.setBackground(new Color(255, 228, 225));
		btnCnacelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCnacelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCnacelar.setBounds(254, 238, 100, 32);
		contentPane.add(btnCnacelar);
	}
	
	
	
	/**
	 * @name muestra
	 * muestra() es un método que le indica a la ventanaEliminarPersonal que se muestre cuando inicia la HU-10
	 * @param  control 
	 * @param una lista del personal registrado en la base de datos 
	 *  
	 */
	
	public void muestra(ControlEliminarPersonal control, List <Personal> personal) {
		
		this.control= control;
		
		textField_NombreCompleto.setText("");
		textField_Correo.setText("");
		textField_Telefono.setText("");
		textField_Puesto.setText("");
		
		DefaultComboBoxModel <String> comboBoxModel = new DefaultComboBoxModel <>();
		
		for(Personal personalLista:personal) {
			comboBoxModel.addElement(personalLista.getNombre());
		}
		
		comboBoxPersonal.setModel(comboBoxModel);

		setVisible(true);
	}
	
	/**
	 * @name muestraInformacioPersonal
	 * muestraInformacionPersonal() es un método que muestra la informacion del Personal seleccionado
	 *  
	 */
	
	public void muestraInformacionPersonal() {
		
		personalSeleccionado = (String) comboBoxPersonal.getSelectedItem();
		Personal personal=control.obtenerPersonal(personalSeleccionado);
		
		if(personal!=null) {
			textField_NombreCompleto.setText(personal.getNombre());
			textField_Correo.setText(personal.getCorreo());
			textField_Telefono.setText(personal.getTelefonoPersonal());
			textField_Puesto.setText(personal.getPuesto());
		}else {
			textField_NombreCompleto.setText("");
			textField_Correo.setText("");
			textField_Telefono.setText("");
			textField_Puesto.setText("");
		}
		textField_NombreCompleto.setEditable(false);
		textField_Correo.setEditable(false);
		textField_Telefono.setEditable(false);
		textField_Puesto.setEditable(false);
		comboBoxPersonal.setEnabled(false);
	}
    
	/**
	 * @name muestraDialogoConMensaje
	 * muestraDialogoConMensaje() es un método que muestra los dialogos de confirmación o error 
	 *  
	 */
    
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
	
}
