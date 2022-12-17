package mx.uam.ayd.proyecto.presentacion.agregarProducto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.SeccionCatalogo;


@SuppressWarnings("serial")
@Component
public class VentanaAgregarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombreProducto;
	private JTextField textFieldMarcaProducto;
	private JTextField textFieldPecioProducto;
	private JTextField textFieldDescuentoProducto;
	private JTextField textFieldNumeroEnExistenciaProducto;
	private JComboBox <String> comboBoxSeccionCatalogo; 
	private JTextArea textAreaDescripcionProducto;

	private ControlAgregarProducto control;
	private String PathImagen;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAgregarProducto frame = new VistaAgregarProducto();
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
	public VentanaAgregarProducto() {
		setBackground(new Color(255, 255, 255));
		setTitle("Agregar Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 522);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 216, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel labelSeccionProducto = new JLabel("Seccion del producto *");
		labelSeccionProducto.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelSeccionProducto, 103, SpringLayout.NORTH, contentPane);
		contentPane.add(labelSeccionProducto);
		
		comboBoxSeccionCatalogo = new JComboBox<>();
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBoxSeccionCatalogo, 9, SpringLayout.EAST, labelSeccionProducto);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBoxSeccionCatalogo, 0, SpringLayout.SOUTH, labelSeccionProducto);
		contentPane.add(comboBoxSeccionCatalogo);
		
		JLabel labelAgregarProducto = new JLabel("Agregar Producto");
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelAgregarProducto, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelAgregarProducto, -126, SpringLayout.EAST, contentPane);
		labelAgregarProducto.setForeground(new Color(158, 0, 82));
		labelAgregarProducto.setFont(new Font("Sitka Subheading", Font.BOLD, 30));
		contentPane.add(labelAgregarProducto);
		
		JLabel labelNombreProducto = new JLabel("Nombre del producto *");
		labelNombreProducto.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelNombreProducto, 142, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelNombreProducto, 32, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelSeccionProducto, 0, SpringLayout.WEST, labelNombreProducto);
		contentPane.add(labelNombreProducto);
		
		JLabel labelRellenarCampos = new JLabel("Rellena los siguientes campos.");
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelRellenarCampos, 69, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelRellenarCampos, 0, SpringLayout.WEST, labelSeccionProducto);
		labelRellenarCampos.setForeground(new Color(128, 0, 128));
		labelRellenarCampos.setFont(new Font("Tahoma", Font.PLAIN, 8));
		contentPane.add(labelRellenarCampos);
		
		JLabel labelCamposObligatorios = new JLabel("*Campos obligatorios");
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBoxSeccionCatalogo, 15, SpringLayout.SOUTH, labelCamposObligatorios);
		labelCamposObligatorios.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelCamposObligatorios, 0, SpringLayout.NORTH, labelRellenarCampos);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelCamposObligatorios, 6, SpringLayout.EAST, labelRellenarCampos);
		labelCamposObligatorios.setForeground(new Color(128, 0, 128));
		contentPane.add(labelCamposObligatorios);
		
		textFieldNombreProducto = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBoxSeccionCatalogo, 0, SpringLayout.EAST, textFieldNombreProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldNombreProducto, 8, SpringLayout.EAST, labelNombreProducto);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldNombreProducto, -3, SpringLayout.NORTH, labelNombreProducto);
		contentPane.add(textFieldNombreProducto);
		textFieldNombreProducto.setColumns(10);
		
		JLabel labelMarcaProducto = new JLabel("Marca del producto *");
		labelMarcaProducto.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelMarcaProducto, 20, SpringLayout.SOUTH, labelNombreProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelMarcaProducto, 0, SpringLayout.WEST, labelSeccionProducto);
		contentPane.add(labelMarcaProducto);
		
		textFieldMarcaProducto = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, textFieldNombreProducto, 0, SpringLayout.EAST, textFieldMarcaProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldMarcaProducto, 16, SpringLayout.EAST, labelMarcaProducto);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldMarcaProducto, -3, SpringLayout.NORTH, labelMarcaProducto);
		contentPane.add(textFieldMarcaProducto);
		textFieldMarcaProducto.setColumns(10);
		
		JLabel labelDescripcion = new JLabel("Descripción *");
		labelDescripcion.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelDescripcion, 22, SpringLayout.SOUTH, labelMarcaProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelDescripcion, 0, SpringLayout.WEST, labelSeccionProducto);
		contentPane.add(labelDescripcion);
		
		textAreaDescripcionProducto = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.EAST, textFieldMarcaProducto, 0, SpringLayout.EAST, textAreaDescripcionProducto);
		sl_contentPane.putConstraint(SpringLayout.EAST, textAreaDescripcionProducto, -67, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textAreaDescripcionProducto, 0, SpringLayout.NORTH, labelDescripcion);
		sl_contentPane.putConstraint(SpringLayout.WEST, textAreaDescripcionProducto, 52, SpringLayout.EAST, labelDescripcion);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textAreaDescripcionProducto, 85, SpringLayout.NORTH, labelDescripcion);
		contentPane.add(textAreaDescripcionProducto);
		
		JLabel labelPrecioProducto = new JLabel("Precio del producto *");
		labelPrecioProducto.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelPrecioProducto, 96, SpringLayout.SOUTH, labelDescripcion);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelPrecioProducto, 0, SpringLayout.WEST, labelSeccionProducto);
		contentPane.add(labelPrecioProducto);
		
		textFieldPecioProducto = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldPecioProducto, -3, SpringLayout.NORTH, labelPrecioProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldPecioProducto, 16, SpringLayout.EAST, labelPrecioProducto);
		textFieldPecioProducto.setColumns(10);
		contentPane.add(textFieldPecioProducto);
		
		JLabel labelDescuentoProducto = new JLabel("Descuento del producto ");
		sl_contentPane.putConstraint(SpringLayout.WEST, labelDescuentoProducto, 268, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textFieldPecioProducto, -26, SpringLayout.WEST, labelDescuentoProducto);
		labelDescuentoProducto.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelDescuentoProducto, 0, SpringLayout.NORTH, labelPrecioProducto);
		contentPane.add(labelDescuentoProducto);
		
		textFieldDescuentoProducto = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldDescuentoProducto, -3, SpringLayout.NORTH, labelPrecioProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldDescuentoProducto, 5, SpringLayout.EAST, labelDescuentoProducto);
		sl_contentPane.putConstraint(SpringLayout.EAST, textFieldDescuentoProducto, 0, SpringLayout.EAST, comboBoxSeccionCatalogo);
		textFieldDescuentoProducto.setColumns(10);
		contentPane.add(textFieldDescuentoProducto);
		
		JLabel labelNumeroExistencia = new JLabel("Número en existencia *");
		labelNumeroExistencia.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelNumeroExistencia, 22, SpringLayout.SOUTH, labelPrecioProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelNumeroExistencia, 0, SpringLayout.WEST, labelSeccionProducto);
		contentPane.add(labelNumeroExistencia);
		
		textFieldNumeroEnExistenciaProducto = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldNumeroEnExistenciaProducto, -3, SpringLayout.NORTH, labelNumeroExistencia);
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldNumeroEnExistenciaProducto, 6, SpringLayout.EAST, labelNumeroExistencia);
		textFieldNumeroEnExistenciaProducto.setColumns(10);
		contentPane.add(textFieldNumeroEnExistenciaProducto);
		
		/*Boton agregar imagen
		JLabel labelAgregarImagen = new JLabel("Agregar Imagen");
		labelAgregarImagen.setForeground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelAgregarImagen, 22, SpringLayout.SOUTH, labelDescuentoProducto);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelAgregarImagen, 0, SpringLayout.EAST, textFieldNumeroEnExistenciaProducto);
		contentPane.add(labelAgregarImagen);
		
		JButton btnAgregarImagen = new JButton("Agregar Imagen");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAgregarImagen, -3, SpringLayout.NORTH, textFieldDescuentoProducto);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAgregarImagen, 0, SpringLayout.EAST,labelAgregarImagen );
		textFieldNumeroEnExistenciaProducto.setColumns(10);
		contentPane.add(textFieldNumeroEnExistenciaProducto);
		*//////////////////////////////////////////
		
		JButton btnAgregar = new JButton("Agregar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAgregar, 36, SpringLayout.SOUTH, textFieldNumeroEnExistenciaProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAgregar, 184, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAgregar, -37, SpringLayout.SOUTH, contentPane);
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregar.setBackground(new Color(255, 228, 225));
		contentPane.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancelar, 291, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnCancelar, -37, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCancelar, -163, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAgregar, -6, SpringLayout.WEST, btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnCancelar);
		
		JLabel labelAgregarImagen = new JLabel("Agregar Imagen");
		sl_contentPane.putConstraint(SpringLayout.EAST, textFieldNumeroEnExistenciaProducto, -62, SpringLayout.WEST, labelAgregarImagen);
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelAgregarImagen, 0, SpringLayout.NORTH, labelNumeroExistencia);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelAgregarImagen, 0, SpringLayout.EAST, labelDescuentoProducto);
		labelAgregarImagen.setForeground(new Color(0, 0, 0));
		contentPane.add(labelAgregarImagen);
		
		JButton btnSubirImagen = new JButton("Subir");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancelar, 24, SpringLayout.SOUTH, btnSubirImagen);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSubirImagen, -4, SpringLayout.NORTH, labelNumeroExistencia);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSubirImagen, 5, SpringLayout.EAST, labelAgregarImagen);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSubirImagen, 28, SpringLayout.NORTH, labelNumeroExistencia);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSubirImagen, -53, SpringLayout.EAST, contentPane);
		btnSubirImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter(
		                "JPG & GIF Images", "jpg", "gif");
		        chooser.setFileFilter(filter);
		        int returnVal = chooser.showOpenDialog(null);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		            PathImagen= chooser.getSelectedFile().getAbsolutePath();
		       }
			}
		});
		btnSubirImagen.setBackground(Color.WHITE);
		contentPane.add(btnSubirImagen);
		
		
		//Listeners
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNombreProducto.getText().equals("") || textFieldMarcaProducto.getText().equals("") || textAreaDescripcionProducto.getText().equals("") ||
						textFieldPecioProducto.getText().equals("") || textFieldNumeroEnExistenciaProducto.getText().equals("")) {
					muestraDialogoConMensaje("El nombre, la marca, la descripcion, el precio y el numero en existencia del producto no deben de estar vacios");
				} else {
					
					if(textFieldDescuentoProducto.getText().equals("")) {
						control.agregaProducto(textFieldNombreProducto.getText(), textFieldMarcaProducto.getText(), textAreaDescripcionProducto.getText(), textFieldPecioProducto.getText(),
								"0",textFieldNumeroEnExistenciaProducto.getText(), (String) comboBoxSeccionCatalogo.getSelectedItem(), PathImagen);
					}else {
						control.agregaProducto(textFieldNombreProducto.getText(), textFieldMarcaProducto.getText(), textAreaDescripcionProducto.getText(), textFieldPecioProducto.getText(),
								textFieldDescuentoProducto.getText(),textFieldNumeroEnExistenciaProducto.getText(), (String) comboBoxSeccionCatalogo.getSelectedItem(), PathImagen);
					}
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
		
		
	}
	
	public void muestra(ControlAgregarProducto control, List <SeccionCatalogo> secciones) {
		
		this.control = control;
		
		textFieldNombreProducto.setText("");
		textFieldMarcaProducto.setText("");
		textAreaDescripcionProducto.setText("");
		textFieldPecioProducto.setText("");
		textFieldDescuentoProducto.setText("");
		textFieldNumeroEnExistenciaProducto.setText("");

		DefaultComboBoxModel <String> comboBoxModel = new DefaultComboBoxModel <>();
		
		for(SeccionCatalogo seccion:secciones) {
			comboBoxModel.addElement(seccion.getNombre());
		}
		
		comboBoxSeccionCatalogo.setModel(comboBoxModel);
		
		setVisible(true);
		
	}
	
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}

}
