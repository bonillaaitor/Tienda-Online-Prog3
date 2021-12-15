package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class VentanaCrearPedidoIntermedia extends JFrame {

	private JPanel contentPane;
	private final Action action = new botonBici();
	private final Action action_1 = new botonPatin();
	private final Action action_2 = new botonAtras();

	protected Cliente cl;
	

	/**
	 * Create the frame.
	 */
	public VentanaCrearPedidoIntermedia(Cliente c) {
		cl = c;
		setTitle("Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00BFQu\u00E9 tipo de pedido deseas realizar?");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(288, 48, 445, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnBici = new JButton("Comprar  Bici");
		btnBici.setAction(action);
		btnBici.setBounds(432, 171, 151, 23);
		contentPane.add(btnBici);
		
		JButton btnPatin = new JButton("Comprar Patin");
		btnPatin.setAction(action_1);
		btnPatin.setBounds(432, 278, 151, 23);
		contentPane.add(btnPatin);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setAction(action_2);
		btnAtras.setBounds(462, 443, 89, 23);
		contentPane.add(btnAtras);
	}
	private class botonBici extends AbstractAction {
		public botonBici() {
			putValue(NAME, "Comprar Bici");
			putValue(SHORT_DESCRIPTION, " comprar una bici");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaCrearPedido VentanaCrearPedido = new VentanaCrearPedido(cl);
			VentanaCrearPedido.setVisible(true);
			dispose();
		}
	}
	private class botonPatin extends AbstractAction {
		public botonPatin() {
			putValue(NAME, "Comprar Patin");
			putValue(SHORT_DESCRIPTION, "comprar un patin");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaCrearPedido2 VentanaCrearPedido2 = new VentanaCrearPedido2(cl);
			VentanaCrearPedido2.setVisible(true);
			dispose();
		}
	}
	private class botonAtras extends AbstractAction {
		public botonAtras() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaCliente ventanaCliente = new VentanaCliente(cl);
			ventanaCliente.setVisible(true);
			dispose();
		}
	}
}
