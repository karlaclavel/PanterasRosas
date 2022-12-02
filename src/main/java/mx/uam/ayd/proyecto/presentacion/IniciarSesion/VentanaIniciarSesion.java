package mx.uam.ayd.proyecto.presentacion.IniciarSesion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.agregarCliente.ControlAgregarCliente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
@Component
public class VentanaIniciarSesion extends JFrame {
	
	private JPanel contentPane;
	
	private JTextField textFieldUsuario;
	private JTextField textFieldContraseña;
	
	private ControlIniciarSesion controlsesion;
	
	
	public VentanaIniciarSesion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Iniciar Sesión");
		setBounds(100, 100, 339, 442);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(237, 216, 218));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio de Sesión");
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(71, 181, 172, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(50, 212, 76, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(50, 246, 76, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabelTitulo = new JLabel("Service TEC");
		lblNewLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTitulo.setFont(new Font("Typo Grotesk Black", Font.PLAIN, 28));
		lblNewLabelTitulo.setBounds(71, 130, 172, 41);
		contentPane.add(lblNewLabelTitulo);
		
		JLabel lblNewLabelLogo = new JLabel("");
		lblNewLabelLogo.setIcon(new ImageIcon("D:\\Archivos\\Documentos\\SPRING TOOL SUITE\\workspace\\Service Tec\\src\\main\\java\\mx\\uam\\ayd\\imagen\\logo.png"));
		lblNewLabelLogo.setBounds(88, 25, 119, 108);
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
		

		
	}
	
	public void muestra(ControlIniciarSesion control) {
		
		this.controlsesion = control;

		setVisible(true);
		
	}

	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this , mensaje);
		
	}

}
