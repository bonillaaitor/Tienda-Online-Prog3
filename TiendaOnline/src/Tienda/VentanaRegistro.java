package Tienda;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class VentanaRegistro extends JFrame {

	private JPanel contentPanel;
	private JTextField textoNombre;
	private JTextField textoUsuario;
	private JTextField textoPassword;
	private JTextField textoCorreo;
	private JTextField textoDireccion;
	private JTextField textoTelefono;
	private JTextField textoTarjeta;

	public VentanaRegistro() {
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
		botonRegistroDos.setBounds(98, 409, 101, 23);
		contentPanel.add(botonRegistroDos);
		ActionListener botonRegistroDosListener = new botonRegistroDosListener();
		botonRegistroDos.addActionListener(botonRegistroDosListener);

		JButton botonAtras = new JButton("Atras");
		botonAtras.setBounds(236, 409, 101, 23);
		contentPanel.add(botonAtras);
		ActionListener botonAtrasListener = new botonAtrasListener();
		botonAtras.addActionListener(botonAtrasListener);

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

	}
	public class botonAtrasListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class botonRegistroDosListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}

}
