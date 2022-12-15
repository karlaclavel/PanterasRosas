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
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;


@SuppressWarnings("serial")
@Component
public class VentanaIniciarSesion extends JFrame {
	
	protected static final String JoptionPane = null;
	private ControlIniciarSesion controlIniciarSesion;
	@Autowired
	private ControlPrincipal controlPrincipal;
	
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContraseña;
	String usuario = "ADMIN_PANROSA";
	String contraseña = "UAMI2022";	
	int numero; 
	
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
		setSize(335, 450);
		setResizable(false);
		setTitle("Iniciar Sesión");
		setBounds(100, 100, 335, 450);
		
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
		lblNewLabelLogo.setIcon(new ImageIcon(VentanaIniciarSesion.class.getResource("/mx/uam/ayd/imagen/logo.png")));
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
		btnAceptar.setBounds(115, 284, 85, 21);
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
					if (user.equals(usuario) && pass.equals(contraseña)) {
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
		
		JButton btnRecuperar = new JButton("Recuperar contraseña");
		btnRecuperar.setBackground(new Color(216, 227, 237));
		btnRecuperar.setIcon(new ImageIcon(VentanaIniciarSesion.class.getResource("/mx/uam/ayd/imagen/candado.png")));
		btnRecuperar.setBounds(50, 328, 217, 41);
		contentPane.add(btnRecuperar);
		
		btnRecuperar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				muestraDialogoConMensaje ("Codigo de verificación enviado al correo electronico registrado");
				
				Random random = new Random();
				numero = random.nextInt((99999 - 10000) + 1) + 10000;
				
				String correo_emisor = "servicetec.panrosa@gmail.com";
				String contraseña_emisor = "pjxsgcpippforbfs";
				String correo_receptor = "karla.clavel1@gmail.com";
				String asunto = "SERVICE TEC [ Recuperación de contraseña ]";
				String mensaje = ("Usuario: ADMIN_PANROSA \nCodigo de recuperación: " + numero);
				
				Properties propiedades = new Properties();
				
				propiedades.put("mail.smtp.host", "smtp.gmail.com");
				propiedades.put ("mail.smtp.ssl.trust", "smtp.gmail.com");
				//propiedades.setProperty ("mail.smtp.host", "smtp.gmail.com");
				propiedades.setProperty("mail.smtp.starttls.enable", "true");
				propiedades.setProperty("mail.smtp.port", "587");
				//propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
				propiedades.setProperty("mail.smtp.user", correo_emisor);
				propiedades.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
				propiedades.setProperty("mail.smtp.auth", "true");
				
				Session session = Session.getDefaultInstance(propiedades);
						
				try {
					
					MimeMessage message = new MimeMessage (session);
					
					message.setFrom(new InternetAddress(correo_emisor));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo_receptor));
					message.setSubject(asunto);
					message.setText(mensaje);
					
					Transport t = session.getTransport("smtp");
					t.connect(correo_emisor, contraseña_emisor);
					t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
					t.close();
				
				} catch (AddressException ad) {
					System.out.print("Exception: " + ad);
				} catch (MessagingException me) {
					System.out.print("Exception: " + me);
				}
				
				
				System.out.println("" + numero);
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el codigo de verificación: ", "Código de verificación", JOptionPane.QUESTION_MESSAGE));
				
				
				if (codigo == numero) 
					muestraDialogoConMensaje ("La contraseña es  UAMI2022 ");
				else 
					muestraDialogoConMensaje ("Codigo de verificación incorrecto");
			
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