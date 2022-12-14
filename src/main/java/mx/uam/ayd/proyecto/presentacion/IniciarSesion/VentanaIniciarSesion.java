package mx.uam.ayd.proyecto.presentacion.IniciarSesion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.agregarCliente.ControlAgregarCliente;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;
import mx.uam.ayd.proyecto.presentacion.principal.VentanaPrincipal;

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
	
	private ControlIniciarSesion controlIniciarSesion;
	@Autowired
	private ControlPrincipal controlPrincipal;
	
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContraseña;
	
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
	
	public VentanaIniciarSesion() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		setTitle("Iniciar Sesión");
		setResizable(false);
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
		lblNewLabelLogo.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\ERIKA\\NOVENO TRIMESTRE\\PanterasRosas\\src\\main\\java\\mx\\uam\\ayd\\imagen\\logo.png"));
		contentPane.add(lblNewLabelLogo);
		
		/******** CUADROS DE TEXTO ******/
		
		textUsuario = new JTextField();
		textUsuario.setBounds(136, 210, 131, 19);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textContraseña = new JPasswordField();
		textContraseña.setBounds(136, 244, 131, 19);
		contentPane.add(textContraseña);
		textContraseña.setColumns(10);
		
		/******** LISTENERS ******/
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(122, 300, 85, 21);
		contentPane.add(btnAceptar);
		
		
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				String user = textUsuario.getText();
				String pass = textContraseña.getText();
				
				
				if (user.equals("") || pass.equals("")) {
					muestraDialogoConMensaje ("Ingrese Usuario y Contraseña");
					textUsuario.requestFocus();
				}
				else {
					if (user.equals("ADMIN_PANROSA") && pass.equals("UAMI2022")) {
						muestraDialogoConMensaje ("Su usuario y contraseña correctos");
						controlPrincipal.inicia();
						dispose();
					} 
					else {
						muestraDialogoConMensaje ("Su usuario y constraseña es incorrecto");
					} 
					
					textUsuario.setText("");
					textContraseña.setText("");
				}
			}
		});
		
	}


	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this , mensaje);
		
	}

	public void muestra(ControlIniciarSesion control) {
		this.controlIniciarSesion = control;
		setVisible(true);
		
	}

}
