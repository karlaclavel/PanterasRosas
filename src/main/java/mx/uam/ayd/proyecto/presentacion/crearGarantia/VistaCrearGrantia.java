package mx.uam.ayd.proyecto.presentacion.crearGarantia;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;
import mx.uam.ayd.proyecto.presentacion.principal.VentanaPrincipal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;


@SuppressWarnings("serial")
@Component
public class VistaCrearGrantia extends JFrame {
	
	private ControlCrearGarantia controlCrearGarantia;
	

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCrearGrantia frame = new VistaCrearGrantia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 */
	

	 
	public VistaCrearGrantia() {
		setTitle("Crea Garantia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 533);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225,216,234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Acta de garantía ");
		lblNewLabel.setForeground(new Color(158, 0, 82));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 30));
		lblNewLabel.setBounds(172, 20, 237, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de expedición");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(274, 68, 134, 28);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(380, 73, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("IDCompra");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(39, 75, 69, 20);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 77, 116, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nombre del usuario");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3_1.setBounds(39, 106, 124, 20);
		contentPane.add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(149, 107, 390, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Direccion de usuario:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3_1_1.setBounds(39, 137, 124, 20);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Calle");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2.setBounds(39, 161, 44, 20);
		contentPane.add(lblNewLabel_3_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(73, 161, 207, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Num. Exterior");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3_3.setBounds(290, 161, 89, 20);
		contentPane.add(lblNewLabel_3_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(366, 162, 44, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Num. Interior");
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3_3_1.setBounds(420, 161, 89, 20);
		contentPane.add(lblNewLabel_3_3_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(495, 162, 44, 20);
		contentPane.add(textField_5);
		
		JEditorPane dtrpncomunicamosAUstedes = new JEditorPane();
		dtrpncomunicamosAUstedes.setText("Comunicamos a ustedes mediante esta Carta de Garantía, que la empresa denominada Service Tec, con número de Registro Federal de ST0947254D,y domicilio es Calle Creacion N.E 15 N.I 15 Santa Catarina, asume completa responsabilidad y obligación solidaria para cubrir cualquier reposición, del producto en caso de fallo");
		dtrpncomunicamosAUstedes.setEditable(false);
		dtrpncomunicamosAUstedes.setBounds(39, 192, 500, 69);
		contentPane.add(dtrpncomunicamosAUstedes);
		
		JLabel lblNewLabel_3_4 = new JLabel("Descripción del equipo");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3_4.setBounds(39, 264, 145, 20);
		contentPane.add(lblNewLabel_3_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(37, 286, 503, 76);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(39, 389, 200, 69);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Firma del garantor");
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3_4_1.setBounds(39, 367, 145, 20);
		contentPane.add(lblNewLabel_3_4_1);
		
		JButton btnNewButton_1 = new JButton("Finalizar la garantia");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(255, 228, 225));
		btnNewButton_1.setBounds(259, 408, 166, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setBackground(new Color(255, 228, 225));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(435, 408, 100, 30);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((textField.getText().length() != 0) && (textField_1.getText().length() != 0) && (textField_2.getText().length() != 0) &&
				   (textField_3.getText().length() != 0) && (textField_4.getText().length() != 0) && (textField_5.getText().length() != 0) &&
				   (textField_6.getText().length() != 0)){
					String fecha = textField.getText();
					String idByCuadroTexto  = textField_1.getText();
					String nombreCompleto = textField_2.getText();
					String calle = textField_3.getText();
					String numExt = textField_4.getText();
					String numInt = textField_5.getText();
					String descripcionEquipo = textField_6.getText();
					
					long idCompra = Long.parseLong(idByCuadroTexto);
					boolean validaCompra = (boolean) controlCrearGarantia.validaCompra(idCompra);
					
					if(validaCompra) {
						controlCrearGarantia.creaGarantia(idCompra,nombreCompleto,fecha,calle,numExt,numInt,descripcionEquipo);
						
					}else {
						
					}
					
				}else {
				muestraDialogoConMensaje("Llene todos los campos");	
				}
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlCrearGarantia.termina();
			}
		});
			
		
	}
	
	public void muestra(ControlCrearGarantia control) {
		controlCrearGarantia = control;
		setVisible(true);
	}
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
	
	
}
