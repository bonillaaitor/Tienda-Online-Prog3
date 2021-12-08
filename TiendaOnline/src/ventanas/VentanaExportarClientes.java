package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class VentanaExportarClientes extends JFrame {

	private JPanel contentPanelExportarPedidos;
	private final Action action = new botonAtras();
	private JTable tabla;

	public VentanaExportarClientes() {
		setTitle("Ventana Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelExportarPedidos = new JPanel();
		contentPanelExportarPedidos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelExportarPedidos);
		contentPanelExportarPedidos.setLayout(null);
		
		JButton botonExportarClientes = new JButton("Exportar cliente");
		botonExportarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonExportarClientes.setBounds(379, 459, 125, 23);
		contentPanelExportarPedidos.add(botonExportarClientes);
		
		JLabel labelTitulo = new JLabel("Exportar Clientes");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelTitulo.setBounds(321, 37, 281, 35);
		contentPanelExportarPedidos.add(labelTitulo);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setAction(action);
		btnAtras.setBounds(778, 459, 89, 23);
		contentPanelExportarPedidos.add(btnAtras);
		
		tabla = new JTable();
		tabla.setBounds(107, 95, 694, 326);
		contentPanelExportarPedidos.add(tabla);
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
	}}
