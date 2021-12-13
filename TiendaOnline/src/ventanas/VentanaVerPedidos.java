package ventanas;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import models.Cliente;


public class VentanaVerPedidos extends JFrame {

	private JPanel contentPanelVerPedidos;
	private JTable table;
	private JButton botonAtras;
	private final Action action = new BotonAtras();
	protected Cliente cl;

	public VentanaVerPedidos(Cliente c) {
		cl = c;
		setTitle("Ver Pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelVerPedidos = new JPanel();
		contentPanelVerPedidos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelVerPedidos);
		contentPanelVerPedidos.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Lista de pedidos");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelTitulo.setBounds(427, 30, 213, 43);
		contentPanelVerPedidos.add(labelTitulo);
		
		table = new JTable();
		table.setBounds(53, 105, 932, 382);
		contentPanelVerPedidos.add(table);
		
		botonAtras = new JButton("botonAtras");
		botonAtras.setAction(action);
		botonAtras.setBounds(463, 512, 118, 23);
		contentPanelVerPedidos.add(botonAtras);
		
	}
	
	private class BotonAtras extends AbstractAction {
		public BotonAtras() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "Ir a la ventana anterior");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaCliente ventanaCliente = new VentanaCliente(cl);
			ventanaCliente.setVisible(true);
			dispose();
		}
	}
}
