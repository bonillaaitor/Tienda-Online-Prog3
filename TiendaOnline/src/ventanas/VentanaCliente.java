package ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Cliente;

public class VentanaCliente extends JFrame {

	private JPanel contentPanelUsuario;
	private final Action eliminarCuenta = new botonEliminarCuenta();
	private final Action cerrarSesion = new botonCerrarSesion();
	private final Action crearPedido = new botonCrearPedido();
	private final Action verPedido = new botonVerPedido();
	protected Cliente cl;
	private final Action action = new botonEliminarPedido();

	public VentanaCliente(Cliente c) { 
		cl = c;
		setTitle("ventana Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelUsuario = new JPanel();
		contentPanelUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelUsuario);
		contentPanelUsuario.setLayout(null);
		
		JButton botonCrearPedido = new JButton("Crear Pedido");
		botonCrearPedido.setAction(crearPedido);
		botonCrearPedido.setBounds(415, 188, 157, 23);
		contentPanelUsuario.add(botonCrearPedido);
		
		JButton botonVerPedido = new JButton("Ver Pedido");
		botonVerPedido.setAction(verPedido);
		botonVerPedido.setBounds(415, 241, 157, 23);
		contentPanelUsuario.add(botonVerPedido);
		
		JButton botonEliminarPedido = new JButton("Eliminar Pedido");
		botonEliminarPedido.setAction(action);
		botonEliminarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonEliminarPedido.setBounds(415, 296, 157, 23);
		contentPanelUsuario.add(botonEliminarPedido);
		
		JButton botonEliminarCuenta = new JButton("Eliminar Cuenta");
		botonEliminarCuenta.setAction(eliminarCuenta);
		botonEliminarCuenta.setBounds(42, 470, 150, 23);
		contentPanelUsuario.add(botonEliminarCuenta);
		
		JButton botonCerrarSesion = new JButton("Cerrar Sesion");
		botonCerrarSesion.setAction(cerrarSesion);
		botonCerrarSesion.setBounds(860, 470, 150, 23);
		contentPanelUsuario.add(botonCerrarSesion);
		
		JLabel labelTitulo = new JLabel("Tienda Online");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelTitulo.setBounds(406, 44, 179, 43);
		contentPanelUsuario.add(labelTitulo);
				
	}
	private class botonEliminarCuenta extends AbstractAction {
		public botonEliminarCuenta() {
			putValue(NAME, "Eliminar Cuenta");
			putValue(SHORT_DESCRIPTION, "Proceso para eliminar la cuenta");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaEliminarCuenta ventanaEliminarCuenta = new VentanaEliminarCuenta();
			ventanaEliminarCuenta.setVisible(true);
			dispose();
		}
	}
	private class botonCerrarSesion extends AbstractAction {
		public botonCerrarSesion() {
			putValue(NAME, "Cerrar Sesion");
			putValue(SHORT_DESCRIPTION, "Cerrar sesion y volver a inicio");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaInicio ventanaInicio = new VentanaInicio();
			ventanaInicio.setVisible(true);
			dispose();
		}
	}
	private class botonCrearPedido extends AbstractAction {
		public botonCrearPedido() {
			putValue(NAME, "Crear pedido");
			putValue(SHORT_DESCRIPTION, "Ir a la ventana de creacion de pedido");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaCrearPedidoIntermedia VentanaCrearPedidoIntermedia = new VentanaCrearPedidoIntermedia(cl);
			VentanaCrearPedidoIntermedia.setVisible(true);
			dispose();
		}
	}
	private class botonVerPedido extends AbstractAction {
		public botonVerPedido() {
			putValue(NAME, "Ver Pedidos");
			putValue(SHORT_DESCRIPTION, "Ver los pedidos realizados");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaVerPedidos ventanaVerPedidos = new VentanaVerPedidos(cl);
			ventanaVerPedidos.setVisible(true);
			dispose();
		}
	}

	private class botonEliminarPedido extends AbstractAction {
		public botonEliminarPedido() {
			putValue(NAME, "Eliminar Pedido");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaEliminarPedido ventanaEliminarPedido = new VentanaEliminarPedido(cl);
			ventanaEliminarPedido.setVisible(true);
			dispose();
		}
	}
}
