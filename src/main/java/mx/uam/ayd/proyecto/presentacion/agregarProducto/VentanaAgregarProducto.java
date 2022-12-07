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
		setBackground(new Color(204, 204, 153));
		setTitle("Agregar Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel labelSeccionProducto = new JLabel("Seccion del producto *");
		labelSeccionProducto.setForeground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelSeccionProducto, 103, SpringLayout.NORTH, contentPane);
		contentPane.add(labelSeccionProducto);
		
		comboBoxSeccionCatalogo = new JComboBox<>();
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBoxSeccionCatalogo, 6, SpringLayout.EAST, labelSeccionProducto);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBoxSeccionCatalogo, -231, SpringLayout.EAST, contentPane);
		contentPane.add(comboBoxSeccionCatalogo);
		
		JLabel labelAgregarProducto = new JLabel("Agregar Producto");
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelAgregarProducto, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelAgregarProducto, -170, SpringLayout.EAST, contentPane);
		labelAgregarProducto.setForeground(new Color(255, 255, 255));
		labelAgregarProducto.setFont(new Font("Script MT Bold", Font.PLAIN, 28));
		contentPane.add(labelAgregarProducto);
		
		JLabel labelNombreProducto = new JLabel("Nombre del producto *");
		labelNombreProducto.setForeground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelNombreProducto, 142, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelNombreProducto, 32, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelSeccionProducto, 0, SpringLayout.WEST, labelNombreProducto);
		contentPane.add(labelNombreProducto);
		
		JLabel labelRellenarCampos = new JLabel("Rellena los siguientes campos.");
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelRellenarCampos, 69, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBoxSeccionCatalogo, 16, SpringLayout.SOUTH, labelRellenarCampos);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelRellenarCampos, 0, SpringLayout.WEST, labelSeccionProducto);
		labelRellenarCampos.setForeground(new Color(255, 255, 255));
		labelRellenarCampos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(labelRellenarCampos);
		
		JLabel labelCamposObligatorios = new JLabel("*Campos obligatorios");
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelCamposObligatorios, 0, SpringLayout.NORTH, labelRellenarCampos);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelCamposObligatorios, 6, SpringLayout.EAST, labelRellenarCampos);
		labelCamposObligatorios.setForeground(new Color(255, 255, 255));
		contentPane.add(labelCamposObligatorios);
		
		textFieldNombreProducto = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBoxSeccionCatalogo, -18, SpringLayout.NORTH, textFieldNombreProducto);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldNombreProducto, -3, SpringLayout.NORTH, labelNombreProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldNombreProducto, 0, SpringLayout.WEST, comboBoxSeccionCatalogo);
		sl_contentPane.putConstraint(SpringLayout.EAST, textFieldNombreProducto, -116, SpringLayout.EAST, contentPane);
		contentPane.add(textFieldNombreProducto);
		textFieldNombreProducto.setColumns(10);
		
		JLabel labelMarcaProducto = new JLabel("Marca del producto *");
		labelMarcaProducto.setForeground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelMarcaProducto, 20, SpringLayout.SOUTH, labelNombreProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelMarcaProducto, 0, SpringLayout.WEST, labelSeccionProducto);
		contentPane.add(labelMarcaProducto);
		
		textFieldMarcaProducto = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldMarcaProducto, -3, SpringLayout.NORTH, labelMarcaProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldMarcaProducto, 16, SpringLayout.EAST, labelMarcaProducto);
		sl_contentPane.putConstraint(SpringLayout.EAST, textFieldMarcaProducto, 0, SpringLayout.EAST, textFieldNombreProducto);
		contentPane.add(textFieldMarcaProducto);
		textFieldMarcaProducto.setColumns(10);
		
		JLabel labelDescripcion = new JLabel("Descripción *");
		labelDescripcion.setForeground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelDescripcion, 22, SpringLayout.SOUTH, labelMarcaProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelDescripcion, 0, SpringLayout.WEST, labelSeccionProducto);
		contentPane.add(labelDescripcion);
		
		textAreaDescripcionProducto = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textAreaDescripcionProducto, 0, SpringLayout.NORTH, labelDescripcion);
		sl_contentPane.putConstraint(SpringLayout.WEST, textAreaDescripcionProducto, 0, SpringLayout.WEST, comboBoxSeccionCatalogo);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textAreaDescripcionProducto, 85, SpringLayout.NORTH, labelDescripcion);
		sl_contentPane.putConstraint(SpringLayout.EAST, textAreaDescripcionProducto, 0, SpringLayout.EAST, textFieldNombreProducto);
		contentPane.add(textAreaDescripcionProducto);
		
		JLabel labelPrecioProducto = new JLabel("Precio del producto *");
		labelPrecioProducto.setForeground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelPrecioProducto, 96, SpringLayout.SOUTH, labelDescripcion);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelPrecioProducto, 0, SpringLayout.WEST, labelSeccionProducto);
		contentPane.add(labelPrecioProducto);
		
		textFieldPecioProducto = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldPecioProducto, -3, SpringLayout.NORTH, labelPrecioProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldPecioProducto, 0, SpringLayout.WEST, comboBoxSeccionCatalogo);
		textFieldPecioProducto.setColumns(10);
		contentPane.add(textFieldPecioProducto);
		
		JLabel labelDescuentoProducto = new JLabel("Descuento del producto ");
		labelDescuentoProducto.setForeground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelDescuentoProducto, 0, SpringLayout.NORTH, labelPrecioProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelDescuentoProducto, 31, SpringLayout.EAST, textFieldPecioProducto);
		contentPane.add(labelDescuentoProducto);
		
		textFieldDescuentoProducto = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldDescuentoProducto, -3, SpringLayout.NORTH, labelPrecioProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, textFieldDescuentoProducto, 5, SpringLayout.EAST, labelDescuentoProducto);
		textFieldDescuentoProducto.setColumns(10);
		contentPane.add(textFieldDescuentoProducto);
		
		JLabel labelNumeroExistencia = new JLabel("Número en existencia *");
		labelNumeroExistencia.setForeground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelNumeroExistencia, 22, SpringLayout.SOUTH, labelPrecioProducto);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelNumeroExistencia, 0, SpringLayout.WEST, labelSeccionProducto);
		contentPane.add(labelNumeroExistencia);
		
		textFieldNumeroEnExistenciaProducto = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldNumeroEnExistenciaProducto, -3, SpringLayout.NORTH, labelNumeroExistencia);
		sl_contentPane.putConstraint(SpringLayout.EAST, textFieldNumeroEnExistenciaProducto, 0, SpringLayout.EAST, textFieldPecioProducto);
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
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAgregar, -26, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAgregar, -289, SpringLayout.EAST, contentPane);
		btnAgregar.setBackground(new Color(255, 255, 255));
		contentPane.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancelar, 26, SpringLayout.EAST, btnAgregar);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnCancelar, 0, SpringLayout.SOUTH, btnAgregar);
		contentPane.add(btnCancelar);
		
		JLabel labelAgregarImagen = new JLabel("Agregar Imagen");
		sl_contentPane.putConstraint(SpringLayout.NORTH, labelAgregarImagen, 0, SpringLayout.NORTH, labelNumeroExistencia);
		sl_contentPane.putConstraint(SpringLayout.EAST, labelAgregarImagen, 0, SpringLayout.EAST, labelDescuentoProducto);
		labelAgregarImagen.setForeground(Color.WHITE);
		contentPane.add(labelAgregarImagen);
		
		JButton btnSubirImagen = new JButton("Subir");
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
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSubirImagen, 0, SpringLayout.NORTH, labelNumeroExistencia);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSubirImagen, 0, SpringLayout.WEST, textFieldDescuentoProducto);
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
