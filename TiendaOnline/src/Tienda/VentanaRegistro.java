package Tienda;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import Bd.Bd;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPanel;
	private JTextField textoNombre;
	private JTextField textoUsuario;
	private JTextField textoPassword;
	private JTextField textoCorreo;
	private JTextField textoDireccion;
	private JTextField textoTelefono;
	private JTextField textoTarjeta;
	private final Action actionBotonAtras = new SwingAction();
	private final Action actionBotonDosRegistro = new SwingAction_1();
	

	public VentanaRegistro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 564);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(70, 45, 46, 14);
		contentPanel.add(labelNombre);

		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(70, 86, 46, 14);
		contentPanel.add(labelUsuario);

		JLabel labelPassword = new JLabel("Password");
		labelPassword.setBounds(70, 131, 46, 14);
		contentPanel.add(labelPassword);

		JLabel labelCorreo = new JLabel("Correo");
		labelCorreo.setBounds(70, 177, 46, 14);
		contentPanel.add(labelCorreo);

		JLabel labelDireccion = new JLabel("Direccion");
		labelDireccion.setBounds(70, 224, 46, 14);
		contentPanel.add(labelDireccion);

		JLabel labelTelefono = new JLabel("Telefono");
		labelTelefono.setBounds(70, 267, 46, 14);
		contentPanel.add(labelTelefono);

		JLabel labelTarjeta = new JLabel("Tarjeta\r\n");
		labelTarjeta.setBounds(70, 315, 46, 14);
		contentPanel.add(labelTarjeta);

		JButton botonRegistroDos = new JButton("Registrarme");
		botonRegistroDos.setAction(actionBotonDosRegistro);
		botonRegistroDos.setBounds(98, 409, 101, 23);
		contentPanel.add(botonRegistroDos);

		JButton botonAtras = new JButton("Atras");
		botonAtras.setAction(actionBotonAtras);
		botonAtras.setBounds(236, 409, 101, 23);
		contentPanel.add(botonAtras);

		textoNombre = new JTextField();
		textoNombre.setBounds(148, 42, 164, 20);
		contentPanel.add(textoNombre);
		textoNombre.setColumns(10);

		textoUsuario = new JTextField();
		textoUsuario.setBounds(148, 83, 164, 20);
		contentPanel.add(textoUsuario);
		textoUsuario.setColumns(10);

		textoPassword = new JTextField();
		textoPassword.setBounds(148, 128, 164, 20);
		contentPanel.add(textoPassword);
		textoPassword.setColumns(10);

		textoCorreo = new JTextField();
		textoCorreo.setBounds(148, 174, 164, 20);
		contentPanel.add(textoCorreo);
		textoCorreo.setColumns(10);

		textoDireccion = new JTextField();
		textoDireccion.setBounds(148, 221, 164, 20);
		contentPanel.add(textoDireccion);
		textoDireccion.setColumns(10);

		textoTelefono = new JTextField();
		textoTelefono.setBounds(148, 264, 164, 20);
		contentPanel.add(textoTelefono);
		textoTelefono.setColumns(10);

		textoTarjeta = new JTextField();
		textoTarjeta.setBounds(148, 312, 164, 20);
		contentPanel.add(textoTarjeta);
		textoTarjeta.setColumns(10);
		
		JLabel labelRegistro = new JLabel("Registrarse en nuestra tienda online");
		labelRegistro.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
		labelRegistro.setBounds(59, 10, 387, 20);
		contentPanel.add(labelRegistro);

	}
	private boolean comprobarVacios() {
		if (textoUsuario.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca un nombre de usuario");
			return true;
		}

		if (new String(textoPassword.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca una password");
			return true;
		}

		if (new String(textoCorreo.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca un email de contacto");
			return true;
		}

		if (new String(textoNombre.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca su nombre");
			return true;
		}

		if (new String(textoTarjeta.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca su nombre");
			return true;
		}

		if (new String(textoDireccion.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca su nombre");
			return true;
		}

		return false;
	}

	 public void anadirNuevoCliente(Cliente c){
			String sql  = "INSERT INTO cliente (email, password, nombre, direccion, telefono, num_tarjeta)" + " VALUES (?,?,?,?,?,?)";

			PreparedStatement stmt;
			Connection conn = Bd.conectar();
			try {
				
				stmt = conn.prepareStatement(sql);

				stmt.setString(1, c.getGmail());
				stmt.setString(2, c.getPassword());
				stmt.setString(3, c.getNombre());
				stmt.setString(4, c.getDireccion());
				stmt.setString(5, c.getTelefono());
				stmt.setString(6, c.getTarjeta());

				stmt.executeUpdate();

				//log(Level.INFO, "El cliente " + c.getNombre() + " ha sido agregado", null);
			} catch (SQLException e) {
				//log( Level.SEVERE, "Error al insertar el cliente" + sql, e );
				e.printStackTrace();
			}
	 }			
			private void registrar() {
				try {

					if (comprobarVacios()) {
						return;
					}

					String usuario = textoUsuario.getText();
					String pass = new String(textoPassword.getText());;
					String correo = textoCorreo.getText();
					String nombre = textoNombre.getText();
					String tarjeta = textoTarjeta.getText();
					String direccion = textoDireccion.getText();
					String telefono = textoTelefono.getText();
	

					Cliente c = new Cliente(nombre,usuario, pass, correo,direccion,telefono, tarjeta);

					Bd bd = new Bd();
					anadirNuevoCliente(c);
					bd.desconectar();

				} 
				catch (NumberFormatException en) {
					JOptionPane.showMessageDialog(this, "Por favor, introduzca un numero de tarjeta");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "Ir a la ventana de atras");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaInicio ventanaInicio = new VentanaInicio();
			ventanaInicio.setVisible(true);
			dispose();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Registro");
			putValue(SHORT_DESCRIPTION, "Registrar cliente");
		}
		public void actionPerformed(ActionEvent e) {
			comprobarVacios();
			registrar();
		}
	}
}
