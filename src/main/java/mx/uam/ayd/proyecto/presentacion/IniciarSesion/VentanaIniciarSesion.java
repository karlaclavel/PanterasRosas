package mx.uam.ayd.proyecto.presentacion.IniciarSesion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.agregarCliente.ControlAgregarCliente;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
@Component
public class VentanaIniciarSesion extends JFrame {
	

	private JPanel contentPane;
	
	private JTextField textFieldUsuario;
	private JTextField textFieldContraseña;
	
	private ControlIniciarSesion controlsesion;
	private ControlPrincipal control;
	
	
	public VentanaIniciarSesion() {
		
		JFrame ventana = new JFrame ("Ventana");
		ventana.setSize(300, 400);
		ventana.setResizable(false);
		ventana.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Iniciar Sesión");
		setBounds(100, 100, 330, 400);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(237, 216, 218));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio de Sesión");
		lblNewLabel_1.setBounds(71, 181, 172, 13);
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setBounds(50, 212, 76, 13);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña:");
		lblNewLabel_3.setBounds(50, 246, 76, 13);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabelTitulo = new JLabel("Service TEC");
		lblNewLabelTitulo.setBounds(71, 130, 172, 41);
		lblNewLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTitulo.setFont(new Font("Typo Grotesk Black", Font.PLAIN, 28));
		contentPane.add(lblNewLabelTitulo);
		
		JLabel lblNewLabelLogo = new JLabel("");
		lblNewLabelLogo.setBounds(90, 10, 125, 110);
		lblNewLabelLogo.setIcon(new ImageIcon("\\Service Tec\\src\\main\\java\\mx\\uam\\ayd\\imagen\\logo.png"));
		contentPane.add(lblNewLabelLogo);
		
		/******** CUADROS DE TEXTO ******/
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(136, 210, 131, 19);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(136, 244, 131, 19);
		contentPane.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		/******** LISTENERS ******/
		
		JButton btnNewButtonAceptar = new JButton("Aceptar");
		btnNewButtonAceptar.setBounds(122, 300, 85, 21);
		contentPane.add(btnNewButtonAceptar);
		
		btnNewButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = textFieldUsuario.getText();
				String pass = textFieldContraseña.getText();
				
				if (user.equals("") || pass.equals("")) {
					muestraDialogoConMensaje ("Acceso Denegado! \n Ingrese Usuario y Contraseña correctos");
					textFieldUsuario.requestFocus();
				}
				else {
					if (user.equals(controlsesion.usuario) && pass.equals(controlsesion.contraseña)) {
						controlsesion.ValidarDatos(user, pass);
						control.inicia();
					}
					textFieldUsuario.setText("");
					textFieldContraseña.setText("");
				}
			}
			
		});
		

		
	}
	
	public void muestra(ControlIniciarSesion control) {
		
		this.controlsesion = control;
		
		textFieldUsuario.setText("");
		textFieldContraseña.setText("");
		
		setVisible(true);
		
	}

	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this , mensaje);
		
	}

}
