package mx.uam.ayd.proyecto.presentacion.eliminarPersonal;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Personal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
@Component
public class VentanaEliminarPersonal extends JFrame {

	private JPanel contentPane;
	private JTextField textEliminarP;
	private ControlEliminarPersonal control;  

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEliminarPersonal frame = new VentanaEliminarPersonal();
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
	public VentanaEliminarPersonal() {
		setBackground(new Color(204, 204, 153));
		setTitle("Eliminar Personal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 335);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225,216,234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Eliminar Personal");
		lblTitulo.setBounds(182, 28, 269, 38);
		lblTitulo.setForeground(new Color(158,0,82));
		lblTitulo.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(lblTitulo);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(327, 208, 100, 29);
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setBackground(new Color(255, 228, 225));
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});

		JLabel lblEliminar_ = new JLabel("Ingrese el \"Nombre\" del Personal que desea eliminar");
		lblEliminar_.setBounds(31, 95, 535, 29);
		lblEliminar_.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(lblEliminar_);

		textEliminarP = new JTextField();
		textEliminarP.setBounds(120, 136, 384, 29);
		contentPane.add(textEliminarP);
		textEliminarP.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBounds(182, 208, 100, 29);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control.eliminarPersonal(textEliminarP.getText());
			}
		});
		btnEliminar.setForeground(new Color(0, 0, 0));
		btnEliminar.setBackground(new Color(255, 228, 225));
		contentPane.add(btnEliminar);




	}
	/**
	 * @name muestra
	 * muestra() es un método que le indica a la ventanaEliminarPersonal que se muestre cuando inicia la HU-10
	 * @param  control 
	 * @param una lista del personal registrado en la base de datos 
	 *  
	 */
	public void muestra(ControlEliminarPersonal control, List<Personal> personal) {
		
		this.control=control;
		setVisible(true);

	}

	/**
	 * @name muestraDialogoConMensaje
	 * muestraDialogoConMensaje() es un método que muestra los dialogos de confirmación o error 
	 *  
	 */
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
}