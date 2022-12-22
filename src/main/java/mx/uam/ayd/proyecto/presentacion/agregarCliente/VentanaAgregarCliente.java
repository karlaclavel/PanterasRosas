package mx.uam.ayd.proyecto.presentacion.agregarCliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class VentanaAgregarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;
	private JTextField textFieldDireccion;
	
	private ControlAgregarCliente controlCliente;
	
	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarCliente frame = new VentanaAgregarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	
	public VentanaAgregarCliente() {
		
		/******** DISEÑO DE LA VENTANA ******/
		
		setTitle("Agregar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 348);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 216, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(158, 0, 82));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 30));
		lblNewLabel.setBounds(120, 20, 230, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(38, 104, 52, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Teléfono");
		lblNewLabel_2.setBounds(38, 137, 52, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo");
		lblNewLabel_3.setBounds(38, 171, 52, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Dirección");
		lblNewLabel_4.setBounds(38, 203, 68, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Rellena los siguientes campos:");
		lblNewLabel_5.setForeground(new Color(128, 0, 128));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_5.setBounds(40, 68, 403, 13);
		contentPane.add(lblNewLabel_5);
		
		/******** CUADROS DE TEXTO ******/
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(116, 101, 271, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(116, 134, 271, 19);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(116, 168, 271, 19);
		contentPane.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(116, 200, 271, 19);
		contentPane.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		
		
		/******** LISTENERS ******/
		
		JButton NewButtonAgregar = new JButton("Agregar");
		NewButtonAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		NewButtonAgregar.setBackground(new Color(255, 228, 225));
		NewButtonAgregar.setBounds(127, 249, 100, 30);
		contentPane.add(NewButtonAgregar);
		
		NewButtonAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textFieldNombre.getText().equals("") || textFieldTelefono.getText().equals("") || textFieldCorreo.getText().equals("") || textFieldDireccion.getText().equals("")) {
					muestraDialogoConMensaje("Rellene todos los campos solicitados");
				}
				else {
					controlCliente.agregaCliente(textFieldNombre.getText(), textFieldTelefono.getText(), textFieldCorreo.getText(), textFieldDireccion.getText());
				}
			}
			
		});
		
		JButton NewButtonCancelar = new JButton("Cancelar");
		NewButtonCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		NewButtonCancelar.setBackground(new Color(255, 228, 225));
		NewButtonCancelar.setBounds(236, 249, 100, 30);
		contentPane.add(NewButtonCancelar);
		
		NewButtonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlCliente.termina();
			}
		});
		
	}
	
	/*
	 * Este método nos muestra la ventana de la HU "Agregar Cliente"
	 */
	public void muestra(ControlAgregarCliente control) {
		
		this.controlCliente = control;
		
		textFieldNombre.setText("");
		textFieldTelefono.setText("");
		textFieldCorreo.setText("");
		textFieldDireccion.setText("");
		
		setVisible(true);
		
	}

	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this , mensaje);
		
	}

}
