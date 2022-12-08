package mx.uam.ayd.proyecto.presentacion.modificarPersonal;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Personal;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.SeccionCatalogo;
import mx.uam.ayd.proyecto.presentacion.modificarPersonal.ControlModificarPersonal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
@Component
public class VentanaModificarPersonal extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Correo;
	private JTextField textField_NombreCompleto;
	private JTextField textField_telefono;
	private JTextField textField_Puesto;
	private JRadioButton rdbtnVerInformacion; 
	
	private ControlModificarPersonal control;
	private JComboBox <String> comboBoxPersonal; 
	private String personalSeleccionado="";
	private String seccionDelPersonal=""; 
	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaModificarPersonal() {
		setTitle("Modificar Personal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 216, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Modificar Personal ");
		lblTitulo.setBounds(122, 11, 228, 32);
		lblTitulo.setForeground(new Color(199, 21, 133));
		lblTitulo.setFont(new Font("Sitka Subheading", Font.BOLD, 25));
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Selecciona al Personal que deseas modificar ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 45, 252, 14);
		contentPane.add(lblNewLabel);
		
		comboBoxPersonal = new JComboBox();
		comboBoxPersonal.setForeground(new Color(128, 0, 128));
		comboBoxPersonal.setBounds(267, 42, 138, 22);
		contentPane.add(comboBoxPersonal);
		
		JLabel lblSelecciona = new JLabel("Ingresa los nuevos datos a modificar ");
		lblSelecciona.setForeground(new Color(128, 0, 128));
		lblSelecciona.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSelecciona.setBounds(10, 70, 252, 22);
		contentPane.add(lblSelecciona);
		
		JLabel lblNombreCompleto = new JLabel("Nombre ");
		lblNombreCompleto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNombreCompleto.setBounds(20, 103, 71, 14);
		contentPane.add(lblNombreCompleto);
		
		textField_Correo = new JTextField();
		textField_Correo.setForeground(new Color(0, 0, 0));
		textField_Correo.setBounds(87, 138, 345, 20);
		contentPane.add(textField_Correo);
		textField_Correo.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCorreo.setBounds(20, 140, 71, 14);
		contentPane.add(lblCorreo);
		
		textField_NombreCompleto = new JTextField();
		textField_NombreCompleto.setForeground(new Color(0, 0, 0));
		textField_NombreCompleto.setColumns(10);
		textField_NombreCompleto.setBounds(87, 101, 345, 20);
		contentPane.add(textField_NombreCompleto);
		
		JLabel lbltelefono = new JLabel("Teléfono ");
		lbltelefono.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbltelefono.setBounds(20, 177, 71, 14);
		contentPane.add(lbltelefono);
		
		textField_telefono = new JTextField();
		textField_telefono.setForeground(new Color(0, 0, 0));
		textField_telefono.setColumns(10);
		textField_telefono.setBounds(87, 175, 157, 20);
		contentPane.add(textField_telefono);
		
		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPuesto.setBounds(254, 176, 47, 17);
		contentPane.add(lblPuesto);
		
		textField_Puesto = new JTextField();
		textField_Puesto.setForeground(new Color(0, 0, 0));
		textField_Puesto.setColumns(10);
		textField_Puesto.setBounds(299, 175, 133, 20);
		contentPane.add(textField_Puesto);
		
		JButton ButtonAceptar = new JButton("Aceptar");
		ButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.modificaPersonal(personalSeleccionado,textField_NombreCompleto.getText(),textField_Correo.getText(),textField_telefono.getText(),textField_Puesto.getText());
			}
		});
		ButtonAceptar.setForeground(new Color(0, 0, 0));
		ButtonAceptar.setBackground(new Color(255, 228, 225));
		ButtonAceptar.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		ButtonAceptar.setBounds(100, 226, 112, 23);
		contentPane.add(ButtonAceptar);
		
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
		ButtonCancelar.setForeground(Color.BLACK);
		ButtonCancelar.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		ButtonCancelar.setBackground(new Color(255, 228, 225));
		ButtonCancelar.setBounds(249, 226, 119, 23);
		contentPane.add(ButtonCancelar);
		
		rdbtnVerInformacion = new JRadioButton("");
		rdbtnVerInformacion.setBackground(new Color(255, 182, 193));
		rdbtnVerInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnVerInformacion.isSelected()) {
					muestraInformacionPersonal();
				}else {
					
					textField_NombreCompleto.setEditable(true);
					textField_Correo.setEditable(true);
					textField_telefono.setEditable(true);
					textField_Puesto.setEditable(true);
					comboBoxPersonal.setEnabled(true); 
					
					textField_NombreCompleto.setText("");
	    			textField_Correo.setText("");
	    			textField_telefono.setText("");
	    			textField_Puesto.setText("");
				}
			}
		});
		rdbtnVerInformacion.setBounds(411, 42, 21, 23);
		contentPane.add(rdbtnVerInformacion);
	}
	
        public void muestra(ControlModificarPersonal control, List <Personal> personal) {
		
		this.control = control;
		
		textField_NombreCompleto.setText("");
		textField_Correo.setText("");
		textField_telefono.setText("");
		textField_Puesto.setText("");
		
		DefaultComboBoxModel <String> comboBoxModel = new DefaultComboBoxModel <>();
		
		for(Personal personal1:personal) {
			comboBoxModel.addElement(personal1.getNombre());
		}
		
		comboBoxPersonal.setModel(comboBoxModel);
		
		setVisible(true);
		
	}
        public void muestraInformacionPersonal() {
    		
    		personalSeleccionado = (String) comboBoxPersonal.getSelectedItem();
    		Personal personal=control.obtenerPersonal(personalSeleccionado); 
    		seccionDelPersonal=personal.getNombre();
    		
    		if(personal!=null) {
    			textField_NombreCompleto.setText(personal.getNombre());
    			textField_Correo.setText(personal.getCorreo());
    			textField_telefono.setText(personal.getTelefonoPersonal());
    			textField_Puesto.setText(personal.getPuesto());
    		}else {
    			textField_NombreCompleto.setText("");
    			textField_Correo.setText("");
    			textField_telefono.setText("");
    			textField_Puesto.setText("");
    		}
    		textField_NombreCompleto.setEditable(false);
			textField_Correo.setEditable(false);
			textField_telefono.setEditable(false);
			textField_Puesto.setEditable(false);
    		comboBoxPersonal.setEnabled(false);
    	}
        
        public void muestraDialogoConMensaje(String mensaje ) {
    		JOptionPane.showMessageDialog(this , mensaje);
    	}
}
