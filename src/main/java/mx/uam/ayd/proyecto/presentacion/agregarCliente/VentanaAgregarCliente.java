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
		setBounds(100, 100, 467, 393);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 216, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("KG WhY YoU GoTtA Be So MeAn", Font.BOLD, 40));
		lblNewLabel.setBounds(141, 13, 188, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(41, 129, 52, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Teléfono");
		lblNewLabel_2.setBounds(41, 169, 52, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo");
		lblNewLabel_3.setBounds(41, 207, 52, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Dirección");
		lblNewLabel_4.setBounds(41, 243, 68, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Rellena los siguientes campos:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_5.setBounds(41, 88, 403, 13);
		contentPane.add(lblNewLabel_5);
		
		/******** CUADROS DE TEXTO ******/
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(119, 126, 257, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(119, 166, 257, 19);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(119, 204, 257, 19);
		contentPane.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(119, 240, 257, 19);
		contentPane.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		
		
		/******** LISTENERS ******/
		
		JButton NewButtonAgregar = new JButton("Agregar");
		NewButtonAgregar.setBounds(130, 289, 99, 28);
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
		NewButtonCancelar.setBounds(239, 289, 92, 28);
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
