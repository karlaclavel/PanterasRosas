package mx.uam.ayd.proyecto.presentacion.verCatalogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.SeccionCatalogo;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import java.awt.TextField;

@SuppressWarnings("serial")
@Component
public class VentanaVerCatalogo extends JFrame {

	private ControlVerCatalogo controlVerCatalogo;
	
	
	private JPanel contentPane;


	
	public VentanaVerCatalogo() {
		setBackground(new Color(204, 204, 153));
		setTitle("Ver Catálogo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225,216,234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Catálogo");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 240, SpringLayout.WEST, contentPane);
		lblNewLabel.setForeground(new Color(158, 0, 82));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblImagen1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImagen1, 96, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblImagen1, 24, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblImagen1, -207, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblImagen1, 194, SpringLayout.WEST, contentPane);
		lblImagen1.setIcon(new ImageIcon(VentanaVerCatalogo.class.getResource("/mx/uam/ayd/imagen/Laptop-Lenovo1.jpg")));
		contentPane.add(lblImagen1);
		
		JLabel lblImagen2 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImagen2, 0, SpringLayout.NORTH, lblImagen1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblImagen2, 40, SpringLayout.EAST, lblImagen1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblImagen2, 0, SpringLayout.SOUTH, lblImagen1);
		lblImagen2.setIcon(new ImageIcon(VentanaVerCatalogo.class.getResource("/mx/uam/ayd/imagen/Procesador-Ci310100.jpg")));
		contentPane.add(lblImagen2);
		
		JLabel lblImagen3 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblImagen2, -41, SpringLayout.WEST, lblImagen3);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImagen3, 96, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblImagen3, -166, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblImagen3, 0, SpringLayout.SOUTH, lblImagen1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblImagen3, -10, SpringLayout.EAST, contentPane);
		lblImagen3.setIcon(new ImageIcon(VentanaVerCatalogo.class.getResource("/mx/uam/ayd/imagen/Impresora-HP.jpg")));
		contentPane.add(lblImagen3);
		
		JEditorPane dtrpnDescrip1 = new JEditorPane();
		sl_contentPane.putConstraint(SpringLayout.WEST, dtrpnDescrip1, 27, SpringLayout.WEST, contentPane);
		dtrpnDescrip1.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, dtrpnDescrip1, 23, SpringLayout.SOUTH, lblImagen1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, dtrpnDescrip1, -118, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, dtrpnDescrip1, -11, SpringLayout.EAST, lblImagen1);
		dtrpnDescrip1.setFont(new Font("Tahoma", Font.BOLD, 14));
		dtrpnDescrip1.setText("Lenovo Core-i51010 8RAM 512gb, 14pulg   $14999");
		contentPane.add(dtrpnDescrip1);
		
		JEditorPane dtrpnDescrip2 = new JEditorPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, dtrpnDescrip2, 23, SpringLayout.SOUTH, lblImagen2);
		sl_contentPane.putConstraint(SpringLayout.WEST, dtrpnDescrip2, 57, SpringLayout.EAST, dtrpnDescrip1);
		dtrpnDescrip2.setText("Core i3 Intel, 10100FComet Lake Quad Procesador de sobremesa   $5999");
		dtrpnDescrip2.setForeground(Color.BLACK);
		dtrpnDescrip2.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(dtrpnDescrip2);
		
		JEditorPane dtrpnDescrip3 = new JEditorPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, dtrpnDescrip3, 23, SpringLayout.SOUTH, lblImagen3);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, dtrpnDescrip3, -118, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, dtrpnDescrip2, -42, SpringLayout.WEST, dtrpnDescrip3);
		sl_contentPane.putConstraint(SpringLayout.WEST, dtrpnDescrip3, 0, SpringLayout.WEST, lblImagen3);
		dtrpnDescrip3.setText("Impresora Multifuncional HP Smart Tank 615 wireless $5680");
		sl_contentPane.putConstraint(SpringLayout.EAST, dtrpnDescrip3, 0, SpringLayout.EAST, lblImagen3);
		dtrpnDescrip3.setForeground(Color.BLACK);
		dtrpnDescrip3.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(dtrpnDescrip3);
		
		TextField textFieldPz1 = new TextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldPz1, 6, SpringLayout.SOUTH, dtrpnDescrip1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldPz1, 87, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textFieldPz1, 130, SpringLayout.WEST, contentPane);
		textFieldPz1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldPz1.setText("2 pz");
		contentPane.add(textFieldPz1);
		
		TextField textFieldPz2 = new TextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldPz2, 175, SpringLayout.EAST, textFieldPz1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, dtrpnDescrip2, -6, SpringLayout.NORTH, textFieldPz2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textFieldPz2, 0, SpringLayout.SOUTH, textFieldPz1);
		textFieldPz2.setText("1 pz");
		textFieldPz2.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(textFieldPz2);
		
		TextField textFieldPz3 = new TextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, textFieldPz2, -146, SpringLayout.WEST, textFieldPz3);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldPz3, 6, SpringLayout.SOUTH, dtrpnDescrip3);
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldPz3, -107, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textFieldPz3, -65, SpringLayout.EAST, contentPane);
		textFieldPz3.setText("5 pz");
		textFieldPz3.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(textFieldPz3);
		
		JButton btnSalir = new JButton("Salir");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSalir, -53, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSalir, 19, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSalir, -25, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSalir, 0, SpringLayout.EAST, lblNewLabel);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.setBackground(new Color(255, 228, 225));
		contentPane.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVerCatalogo.termina();
			}
		});
		
		
	}
	
	public void muestra(ControlVerCatalogo control, List <SeccionCatalogo> secciones) {
		controlVerCatalogo=control;
		setVisible(true);
		
	}
}
