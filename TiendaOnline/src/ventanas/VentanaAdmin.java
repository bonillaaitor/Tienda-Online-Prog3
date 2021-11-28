package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class VentanaAdmin extends JFrame {

	private JPanel contentAdmin;
	private final Action actionCerrarSesion = new botonCerrarSesion();

	public VentanaAdmin() {
		setTitle("ventana Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentAdmin = new JPanel();
		contentAdmin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentAdmin);
		contentAdmin.setLayout(null);
		
		JButton botonCerrarSesion = new JButton("Cerrar Sesion");
		botonCerrarSesion.setAction(actionCerrarSesion);
		botonCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonCerrarSesion.setBounds(800, 459, 125, 23);
		contentAdmin.add(botonCerrarSesion);
		
		JButton botonVerPedidos = new JButton("Ver Pedidos");
		botonVerPedidos.setBounds(428, 136, 125, 23);
		contentAdmin.add(botonVerPedidos);
		
		JButton botonImportarProducto = new JButton("Importar Productos");
		botonImportarProducto.setBounds(428, 193, 125, 23);
		contentAdmin.add(botonImportarProducto);
		
		JButton botonAnadirStock = new JButton("A\u00F1adir Stock");
		botonAnadirStock.setBounds(428, 246, 125, 23);
		contentAdmin.add(botonAnadirStock);
		
		JButton botonExportarPedidos = new JButton("Exportar Pedidos");
		botonExportarPedidos.setBounds(428, 307, 125, 23);
		contentAdmin.add(botonExportarPedidos);
		
		JLabel labelTitulo = new JLabel("Menu Administrador");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelTitulo.setBounds(359, 35, 281, 35);
		contentAdmin.add(labelTitulo);
	}
	private class botonCerrarSesion extends AbstractAction {
		public botonCerrarSesion() {
			putValue(NAME, "Cerrar Sesion");
			putValue(SHORT_DESCRIPTION, "volver al menu de inicio");
			
		}
		public void actionPerformed(ActionEvent e) {
			VentanaInicio ventanaInicio = new VentanaInicio();
			ventanaInicio.setVisible(true);
			dispose();
		}
	}
}
