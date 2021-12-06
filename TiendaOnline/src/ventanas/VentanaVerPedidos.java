package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;


public class VentanaVerPedidos extends JFrame {

	private JPanel contentPanelVerPedidos;
	private JTable table;

	public VentanaVerPedidos() {
		setTitle("Ver Pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelVerPedidos = new JPanel();
		contentPanelVerPedidos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelVerPedidos);
		contentPanelVerPedidos.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Lista de pedidos");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelTitulo.setBounds(403, 26, 213, 43);
		contentPanelVerPedidos.add(labelTitulo);
		
		table = new JTable();
		table.setBounds(24, 105, 979, 401);
		contentPanelVerPedidos.add(table);
	}
	
}
