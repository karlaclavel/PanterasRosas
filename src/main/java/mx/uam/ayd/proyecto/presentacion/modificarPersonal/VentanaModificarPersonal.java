package mx.uam.ayd.proyecto.presentacion.modificarPersonal;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Personal;
import mx.uam.ayd.proyecto.presentacion.modificarPersonal.ControlModificarPersonal;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


@SuppressWarnings("serial")
@Component
public class VentanaModificarPersonal extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Apellido;
	private JTextField textField_Nombre;
	private JTextField textField_telefono;
	private JTextField textField_Cargo;
	private ControlModificarPersonal control;
	private JComboBox <String> comboBoxPersonal; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModificarPersonal frame = new VentanaModificarPersonal();
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
	public VentanaModificarPersonal() {
		setTitle("Modificar Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 216, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Modificar Personal ");
		lblTitulo.setBounds(103, 10, 228, 32);
		lblTitulo.setForeground(new Color(199, 21, 133));
		lblTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 25));
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Selecciona al Personal que deseas modificar ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 45, 252, 14);
		contentPane.add(lblNewLabel);
		
		comboBoxPersonal = new JComboBox();
		comboBoxPersonal.setForeground(new Color(255, 182, 193));
		comboBoxPersonal.setBounds(267, 42, 157, 22);
		contentPane.add(comboBoxPersonal);
		
		JLabel lblSelecciona = new JLabel("Ingresa los nuevos datos a modificar ");
		lblSelecciona.setForeground(new Color(128, 0, 128));
		lblSelecciona.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSelecciona.setBounds(10, 70, 252, 22);
		contentPane.add(lblSelecciona);
		
		JLabel lblNombre = new JLabel("Nombre (s)");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNombre.setBounds(20, 103, 71, 14);
		contentPane.add(lblNombre);
		
		textField_Apellido = new JTextField();
		textField_Apellido.setForeground(new Color(255, 228, 225));
		textField_Apellido.setBounds(87, 138, 315, 20);
		contentPane.add(textField_Apellido);
		textField_Apellido.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellido (s)");
		lblApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblApellidos.setBounds(20, 140, 71, 14);
		contentPane.add(lblApellidos);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setForeground(new Color(255, 228, 225));
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(87, 101, 315, 20);
		contentPane.add(textField_Nombre);
		
		JLabel lbltelefono = new JLabel("Teléfono ");
		lbltelefono.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbltelefono.setBounds(20, 177, 71, 14);
		contentPane.add(lbltelefono);
		
		textField_telefono = new JTextField();
		textField_telefono.setForeground(new Color(255, 228, 225));
		textField_telefono.setColumns(10);
		textField_telefono.setBounds(76, 175, 119, 20);
		contentPane.add(textField_telefono);
		
		JLabel lblcargo = new JLabel("Cargo ");
		lblcargo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblcargo.setBounds(220, 176, 71, 17);
		contentPane.add(lblcargo);
		
		textField_Cargo = new JTextField();
		textField_Cargo.setForeground(new Color(255, 228, 225));
		textField_Cargo.setColumns(10);
		textField_Cargo.setBounds(270, 175, 132, 20);
		contentPane.add(textField_Cargo);
		
		JButton ButtonAceptar = new JButton("Aceptar");
		ButtonAceptar.setForeground(new Color(0, 0, 0));
		ButtonAceptar.setBackground(new Color(255, 228, 225));
		ButtonAceptar.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		ButtonAceptar.setBounds(184, 227, 89, 23);
		contentPane.add(ButtonAceptar);
		
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.setForeground(Color.BLACK);
		ButtonCancelar.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		ButtonCancelar.setBackground(new Color(255, 228, 225));
		ButtonCancelar.setBounds(305, 226, 97, 23);
		contentPane.add(ButtonCancelar);
	}
	
        public void muestra(ControlModificarPersonal control, List <Personal> personal) {
		
		this.control = control;
		
		textField_Nombre.setText("");
		textField_Apellido.setText("");
		textField_telefono.setText("");
		textField_Cargo.setText("");
		
		DefaultComboBoxModel <String> comboBoxModel = new DefaultComboBoxModel <>();
		
		for(Personal personal1:personal) {
			comboBoxModel.addElement(personal1.getNombre());
		}
		
		comboBoxPersonal.setModel(comboBoxModel);
		
		setVisible(true);
		
	}
}
