package mx.uam.ayd.proyecto.presentacion.agregarPersonal;

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
public class VentanaAgregarPersonal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;
	private JTextField textFieldPuesto;
	
	private ControlAgregarPersonal controlPersonal;
	
	
	
	public VentanaAgregarPersonal() {
		
		/******** DISEÑO DE LA VENTANA ******/
		
		setTitle("Agregar Personal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 355);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 216, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personal");
		lblNewLabel.setForeground(new Color(158, 0, 82));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 30));
		lblNewLabel.setBounds(120, 20, 230, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(41, 103, 52, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Teléfono");
		lblNewLabel_2.setBounds(41, 138, 52, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo");
		lblNewLabel_3.setBounds(41, 176, 52, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Puesto");
		lblNewLabel_4.setBounds(41, 212, 68, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Rellena los siguientes campos:");
		lblNewLabel_5.setForeground(new Color(128, 0, 128));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_5.setBounds(41, 68, 367, 13);
		contentPane.add(lblNewLabel_5);
		
		/******** CUADROS DE TEXTO ******/
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(119, 100, 257, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(119, 135, 257, 19);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(119, 173, 257, 19);
		contentPane.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		textFieldPuesto = new JTextField();
		textFieldPuesto.setBounds(119, 209, 257, 19);
		contentPane.add(textFieldPuesto);
		textFieldPuesto.setColumns(10);
		
		
		
		/******** LISTENERS ******/
		
		JButton NewButtonAgregar = new JButton("Agregar");
		NewButtonAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		NewButtonAgregar.setBackground(new Color(255, 228, 225));
		NewButtonAgregar.setBounds(130, 258, 99, 28);
		contentPane.add(NewButtonAgregar);
		
		NewButtonAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textFieldNombre.getText().equals("") || textFieldTelefono.getText().equals("") || textFieldCorreo.getText().equals("") || textFieldPuesto.getText().equals("")) {
					muestraDialogoConMensaje("Rellene todos los campos solicitados");
				}
				else {
					controlPersonal.agregaPersonal(textFieldNombre.getText(), textFieldTelefono.getText(), textFieldCorreo.getText(), textFieldPuesto.getText());
				}
			}
			
		});
		
		JButton NewButtonCancelar = new JButton("Cancelar");
		NewButtonCancelar.setBackground(new Color(255, 228, 225));
		NewButtonCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		NewButtonCancelar.setBounds(239, 258, 92, 28);
		contentPane.add(NewButtonCancelar);
		
		NewButtonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlPersonal.termina();
			}
		});
		
	}
	
	/*
	 * Este método nos muestra la ventana de la HU "Agregar Personal"
   *
	 */
	public void muestra(ControlAgregarPersonal control) {
		
		this.controlPersonal = control;
		
		textFieldNombre.setText("");
		textFieldTelefono.setText("");
		textFieldCorreo.setText("");
		textFieldPuesto.setText("");
		
		setVisible(true);
		
	}

	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this , mensaje);
		
	}

}
