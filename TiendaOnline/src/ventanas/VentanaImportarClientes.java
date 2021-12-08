package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class VentanaImportarClientes extends JFrame {

	private JPanel contentPanelImportarClientes;
	private JTextField textFieldNombre;
	private JTextField textFieldUsuario;
	private JTextField textFieldContraseña;
	private JTextField textFieldCorreo;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldTarjeta;
	private final Action action = new botonAtras();
	


	public VentanaImportarClientes() {
		setTitle("Ventana Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelImportarClientes = new JPanel();
		contentPanelImportarClientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelImportarClientes);
		contentPanelImportarClientes.setLayout(null);
		
		JButton botonImportarClientes = new JButton("Añadir cliente");
		botonImportarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		botonImportarClientes.setBounds(389, 433, 125, 23);
		contentPanelImportarClientes.add(botonImportarClientes);
		
		JLabel labelTitulo = new JLabel("Importar Clientes");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelTitulo.setBounds(321, 37, 281, 35);
		contentPanelImportarClientes.add(labelTitulo);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(359, 105, 164, 20);
		contentPanelImportarClientes.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabelNombre = new JLabel("Nombre ");
		lblNewLabelNombre.setBounds(285, 108, 53, 14);
		contentPanelImportarClientes.add(lblNewLabelNombre);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(359, 139, 164, 20);
		contentPanelImportarClientes.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblNewLabelUsuario = new JLabel("Usuario ");
		lblNewLabelUsuario.setBounds(285, 142, 53, 14);
		contentPanelImportarClientes.add(lblNewLabelUsuario);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(359, 173, 164, 20);
		contentPanelImportarClientes.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JLabel lblNewLabelContraseña = new JLabel("Contrase\u00F1a ");
		lblNewLabelContraseña.setBounds(285, 176, 74, 14);
		contentPanelImportarClientes.add(lblNewLabelContraseña);
	
		
		JLabel lblNewLabelCorreo = new JLabel("Correo ");
		lblNewLabelCorreo.setBounds(285, 216, 53, 14);
		contentPanelImportarClientes.add(lblNewLabelCorreo);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(359, 213, 164, 20);
		contentPanelImportarClientes.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(359, 256, 164, 20);
		contentPanelImportarClientes.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(359, 303, 164, 20);
		contentPanelImportarClientes.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldTarjeta = new JTextField();
		textFieldTarjeta.setBounds(359, 348, 164, 20);
		contentPanelImportarClientes.add(textFieldTarjeta);
		textFieldTarjeta.setColumns(10);
		
		JLabel lblNewLabelDireccion = new JLabel("Direcci\u00F3n ");
		lblNewLabelDireccion.setBounds(285, 259, 67, 14);
		contentPanelImportarClientes.add(lblNewLabelDireccion);
		
		JLabel lblNewLabelTelefono = new JLabel("Tel\u00E9fono ");
		lblNewLabelTelefono.setBounds(285, 306, 67, 14);
		contentPanelImportarClientes.add(lblNewLabelTelefono);
		
		JLabel lblNewLabelTarjeta = new JLabel("Tarjeta ");
		lblNewLabelTarjeta.setBounds(285, 351, 46, 14);
		contentPanelImportarClientes.add(lblNewLabelTarjeta);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setAction(action);
		btnAtras.setBounds(771, 433, 89, 23);
		contentPanelImportarClientes.add(btnAtras);
		
		
	}

	    private class botonAtras extends AbstractAction {
		public botonAtras() {
			putValue(NAME, "Atrás");
			putValue(SHORT_DESCRIPTION, "Volver a la ventana admin");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaAdmin ventanaAdmin = new VentanaAdmin();
			ventanaAdmin.setVisible(true);
			dispose();
		}
	}
	}