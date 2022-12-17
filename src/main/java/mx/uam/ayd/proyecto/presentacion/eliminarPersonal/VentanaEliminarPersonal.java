package mx.uam.ayd.proyecto.presentacion.eliminarPersonal;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
@Component
public class VentanaEliminarPersonal extends JFrame {

	private JPanel contentPane;
	private JTextField textField_NombreCompleto;
	private JTextField textField_Correo;
	private JTextField textField_Telefono;
	private JTextField textField_Puesto;
	
	private ControlEliminarPersonal control;  
	
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
		
		JComboBox comboBoxPersonal = new JComboBox();
		comboBoxPersonal.setBounds(254, 54, 121, 22);
		contentPane.add(comboBoxPersonal);
		
		JRadioButton rdbtnVerInformacion = new JRadioButton("");
		rdbtnVerInformacion.setBackground(new Color(255, 182, 193));
		rdbtnVerInformacion.setBounds(385, 53, 30, 23);
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
		textField_Puesto.setBounds(277, 203, 145, 20);
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
	
	public void muestra(ControlEliminarPersonal control) {
		this.control= control;
		setVisible(true);
	}
}
