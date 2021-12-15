package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Bicicleta;
import models.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class VentanaCrearPedido2 extends JFrame {
/*	private DefaultTableModel mDatosPatin;
	private ArrayList<Bicicleta> pedidoPatines = new ArrayList();

	private DefaultTableModel mDatosPatin;
	private ArrayList<Bicicleta> pedidoPatines = new ArrayList();*/
	
	private JPanel contentPane;
	private JTextField textField;

	private JTable tablaCrearPedidoPatin;
	private final Action action = new BotonAtras();
	protected Cliente cl;


	public VentanaCrearPedido2(Cliente c) {
		cl = c;
		setTitle("Crear Patin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatin = new JLabel("Crea tu Patin");
		lblPatin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPatin.setBounds(404, 279, 94, 14);
		contentPane.add(lblPatin);
		
		JLabel lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(260, 328, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setBounds(260, 374, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cv");
		lblNewLabel_2.setBounds(260, 414, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Manillar");
		lblNewLabel_3.setBounds(494, 328, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Base");
		lblNewLabel_4.setBounds(494, 374, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ruedas");
		lblNewLabel_5.setBounds(494, 414, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setAction(action);
		btnAtras.setBounds(868, 499, 89, 23);
		contentPane.add(btnAtras);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(332, 324, 109, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(332, 370, 109, 22);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(332, 410, 109, 22);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(570, 324, 121, 22);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(570, 370, 121, 22);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(570, 410, 121, 22);
		contentPane.add(comboBox_5);
		
		textField = new JTextField();
		textField.setBounds(21, 21, 1003, 247);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCrearPatin = new JButton("Crear Pedido");
		btnCrearPatin.setBounds(72, 499, 109, 23);
		contentPane.add(btnCrearPatin);
		
		JButton btnAñadirP = new JButton("A\u00F1adir Patin");
		btnAñadirP.setBounds(416, 499, 121, 23);
		contentPane.add(btnAñadirP);
	}

	/*
	 * public void cargarPatin() {
		
		Vector<String> cabecerasPatin = new Vector<String>(
		Arrays.asList("Modelo", "Marca", "Precio", "Cv", "Ruedas", "Manillar", "Sillin"));
		mDatosPatin = new DefaultTableModel(new Vector<Vector<Object>>(), cabecerasPatin);
		tablaCrearPedidoPatin.setModel(mDatosPatin);
		
		for (Bicicleta b : pedidoPatines) {
			mDatosPatin.addRow(new Object[] { b.getModelo(), b.getMarca(), b.getPrecio(), b.getCv(),b.getRueda(),b.getManillar(),b.getSillin() });
			
		}
		tablaCrearPedidoPatin.getColumnModel().getColumn(0).setMaxWidth(100);
		tablaCrearPedidoPatin.getColumnModel().getColumn(1).setMaxWidth(100);
		tablaCrearPedidoPatin.getColumnModel().getColumn(2).setMaxWidth(50);
		tablaCrearPedidoPatin.getColumnModel().getColumn(3).setMaxWidth(50);
		tablaCrearPedidoPatin.getColumnModel().getColumn(4).setMaxWidth(100);
		tablaCrearPedidoPatin.getColumnModel().getColumn(5).setMaxWidth(100);
		tablaCrearPedidoPatin.getColumnModel().getColumn(6).setMaxWidth(100);


	}*/
	private class BotonAtras extends AbstractAction {
		public BotonAtras() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "ir atras");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaCrearPedidoIntermedia VentanaCrearPedidoIntermedia = new VentanaCrearPedidoIntermedia(cl);
			VentanaCrearPedidoIntermedia.setVisible(true);
			dispose();
		}
	}
}
