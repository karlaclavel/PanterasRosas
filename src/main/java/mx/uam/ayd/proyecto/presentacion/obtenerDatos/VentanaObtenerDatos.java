package mx.uam.ayd.proyecto.presentacion.obtenerDatos;
import java.awt.Font;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Cliente;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
@Component
public class VentanaObtenerDatos extends JFrame {

	private JPanel contentPane;
	private ControlObtenerDatos controlDatos;
	private JTable tablaClientes;
	private DefaultTableModel model;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaObtenerDatos frame = new VentanaObtenerDatos();
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
	public VentanaObtenerDatos() {
		
		setTitle("Lista de clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		setResizable(false);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 216, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 414, 183);
		contentPane.add(scrollPane);
		
		tablaClientes = new JTable();
		model = new DefaultTableModel();
		tablaClientes.setModel(model);
		
		//Creamos las columnas al modelo 
		
		model.addColumn("Nombre Cliente");
		model.addColumn("Teléfono");
		model.addColumn("Correo");
		model.addColumn("Dirección");
		//model.addColumn("Compra");
		
		scrollPane.setViewportView(tablaClientes);
		
		btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlDatos.termina();
			}
		});
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(177, 260, 100, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Lista de clientes");
		lblNewLabel.setForeground(new Color(158, 0, 82));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 30));
		lblNewLabel.setBounds(106, 20, 237, 37);
		contentPane.add(lblNewLabel);
	}
	
	/*
	 * Este método nos muestra la ventana de nuestra historia de usuario HU-05 
	 */
	public void muestra(ControlObtenerDatos control, List <Cliente> listaClientes) {
		controlDatos = control;
		for(Cliente cliente:listaClientes) {
			
			Object[] fila =new Object[5];
			fila[0]=cliente.getNombreCompleto();
			fila[1]=cliente.getTelefono();
			fila[2]=cliente.getCorreo();
			fila[3]=cliente.getDireccionEntrega();
			fila[4]="";
			
			model.addRow(fila);
		}
		tablaClientes.setModel(model);
		setVisible(true);
	}
}
