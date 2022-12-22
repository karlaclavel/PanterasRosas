package mx.uam.ayd.proyecto.presentacion.eliminarProducto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.SeccionCatalogo;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import java.awt.TextField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
@Component
public class VentanaEliminarProducto extends JFrame {

	private ControlEliminarProducto controlEliminarProducto;
	
	
	private JPanel contentPane;
	private JTextField textEliminarP;


	
	public VentanaEliminarProducto() {
		setBackground(new Color(204, 204, 153));
		setTitle("Eliminar Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225,216,234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Eliminar Producto");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -157, SpringLayout.EAST, contentPane);
		lblNewLabel.setForeground(new Color(158,0,82));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setBackground(new Color(255, 255, 255));
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEliminarProducto.termina();
			}
		});
		
		JLabel lblEliminar_ = new JLabel("Ingrese el \"Nombre\" del producto que desea eliminar");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblEliminar_, -294, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEliminar_, -10, SpringLayout.EAST, contentPane);
		lblEliminar_.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblEliminar_);
		
		textEliminarP = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textEliminarP, 18, SpringLayout.SOUTH, lblEliminar_);
		sl_contentPane.putConstraint(SpringLayout.WEST, textEliminarP, 115, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textEliminarP, -233, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textEliminarP, -132, SpringLayout.EAST, contentPane);
		contentPane.add(textEliminarP);
		textEliminarP.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminar, 251, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEliminar, -325, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancelar, 0, SpringLayout.NORTH, btnEliminar);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancelar, 53, SpringLayout.EAST, btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				controlEliminarProducto.eliminaProducto(textEliminarP.getText());
			}
		});
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setBackground(Color.WHITE);
		contentPane.add(btnEliminar);
		
		
		
		
	}
	
	public void muestra(ControlEliminarProducto control, List<Producto> productos) {
		controlEliminarProducto=control;
		setVisible(true);
		
	}
	
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}

}
