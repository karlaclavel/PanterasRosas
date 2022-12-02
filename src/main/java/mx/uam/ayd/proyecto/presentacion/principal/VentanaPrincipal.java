package mx.uam.ayd.proyecto.presentacion.principal;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
@SuppressWarnings("serial")
@Component
public class VentanaPrincipal extends JFrame {

	private ControlPrincipal controlPrincipal;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Menú principal/ServiceTEC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 323);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(153, 102, 204));
		setJMenuBar(menuBar);
		
		//***********
		JMenu mnNewMenu = new JMenu("            Catálogo          ");
		mnNewMenu.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar ");
		mntmNewMenuItem.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.agregarProducto();
			}
		});
		mntmNewMenuItem.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modificar");
		mntmNewMenuItem_1.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.modificarProducto();
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Eliminar");
		mntmNewMenuItem_2.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem_2.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_2);
	
		JMenu mnNewMenu_1 = new JMenu("      Clientes      ");
		mnNewMenu_1.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Ver");
		mntmNewMenuItem_5.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.obtenerDatos();
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Agregar"); 
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.agregarCliente();
			}
		}); 
		mntmNewMenuItem_6.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_3 = new JMenu("       Personal       ");
		mnNewMenu_3.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Agregar ");
		mntmNewMenuItem_8.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem_8.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Modificar ");
		mntmNewMenuItem_9.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem_9.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Eliminar");
		mntmNewMenuItem_10.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem_10.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Lista");
		mntmNewMenuItem_11.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem_11.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mnNewMenu_3.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_2 = new JMenu("        Ventas        ");
		mnNewMenu_2.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Garantía ");
		mntmNewMenuItem_3.setBackground(new Color(204, 153, 204));
		mntmNewMenuItem_3.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPrincipal.creaGarantia();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 560, 257);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("D:\\Archivos\\Documentos\\SPRING TOOL SUITE\\workspace\\Service Tec\\src\\main\\java\\mx\\uam\\ayd\\imagen\\logo.png"));
		lblLogo.setBounds(231, 30, 132, 133);
		panel.add(lblLogo);
		
		JLabel lblTitulo = new JLabel("Service Tec");
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 45));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(192, 141, 213, 60);
		panel.add(lblTitulo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 560, 257);
		panel.add(lblFondo);
		lblFondo.setIcon(new ImageIcon("D:\\Archivos\\Documentos\\SPRING TOOL SUITE\\workspace\\Service Tec\\src\\main\\java\\mx\\uam\\ayd\\imagen\\fondo (1).jpg"));
	
  }
  
	public void muestra(ControlPrincipal control) {
		
		controlPrincipal = control;
		setVisible(true);
	}
}
