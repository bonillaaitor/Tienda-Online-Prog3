package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Bicicleta;

import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class VentanaCrearPedido extends JFrame {

	private JPanel contentPanelCrearPedido;
	private JTable tablaCrearPedidoBici;
	private JTable tablaCrearPedidoPatin;

	private DefaultTableModel mDatosBici;
	private ArrayList<Bicicleta> pedidoBicis = new ArrayList();

	private DefaultTableModel mDatosPatin;
	private ArrayList<Bicicleta> pedidoPatines = new ArrayList();

	String valorModeloB;
	String valorMarcaB;
	String valorPrecioB;
	String valorCvB;
	String valorRuedasB;
	String valorManillarB;
	String valorSillinB;
	
	private final Action actionBotonAtras = new btnAtras();
	

	public VentanaCrearPedido() {
		
		setTitle("Crear Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelCrearPedido = new JPanel();
		contentPanelCrearPedido.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelCrearPedido);
		contentPanelCrearPedido.setLayout(null);

		tablaCrearPedidoBici = new JTable();
		tablaCrearPedidoBici.setFont(new Font("Arial", Font.PLAIN, 14));
		tablaCrearPedidoBici.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tablaCrearPedidoBici.setBounds(10, 40, 500, 218);
		contentPanelCrearPedido.add(tablaCrearPedidoBici);
		
		tablaCrearPedidoPatin = new JTable();
		tablaCrearPedidoPatin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tablaCrearPedidoPatin.setBounds(529, 40, 464, 218);
		contentPanelCrearPedido.add(tablaCrearPedidoPatin);
		
		
		Vector<String> cabecerasPatin = new Vector<String>(
				Arrays.asList("Modelo", "Marca", "Precio", "Cv", "Ruedas", "Manillar", "Base"));
		mDatosPatin = new DefaultTableModel(new Vector<Vector<Object>>(), cabecerasPatin);
		tablaCrearPedidoPatin.setModel(mDatosPatin);

		JLabel labelBicicleta = new JLabel("Crea tu bicicleta");
		labelBicicleta.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		labelBicicleta.setBounds(150, 343, 118, 26);
		contentPanelCrearPedido.add(labelBicicleta);

		JLabel labelPatin = new JLabel("Crea tu patin");
		labelPatin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		labelPatin.setBounds(807, 349, 94, 14);
		contentPanelCrearPedido.add(labelPatin);

		JLabel labelModeloB = new JLabel("Modelo");
		labelModeloB.setBounds(33, 385, 46, 14);
		contentPanelCrearPedido.add(labelModeloB);

		JLabel labelMarcaB = new JLabel("Marca");
		labelMarcaB.setBounds(33, 418, 46, 14);
		contentPanelCrearPedido.add(labelMarcaB);

		JLabel labelCvB = new JLabel("Cv");
		labelCvB.setBounds(33, 458, 46, 14);
		contentPanelCrearPedido.add(labelCvB);

		JLabel labelRuedasB = new JLabel("Ruedas");
		labelRuedasB.setBounds(224, 458, 46, 14);
		contentPanelCrearPedido.add(labelRuedasB);

		JLabel labelManillarB = new JLabel("Manillar");
		labelManillarB.setBounds(222, 385, 46, 14);
		contentPanelCrearPedido.add(labelManillarB);

		JLabel labelSillinB = new JLabel("Sillin");
		labelSillinB.setBounds(222, 418, 46, 14);
		contentPanelCrearPedido.add(labelSillinB);

		JLabel labelModeloP = new JLabel("Modelo");
		labelModeloP.setBounds(669, 385, 46, 14);
		contentPanelCrearPedido.add(labelModeloP);

		JLabel labelMarcaP = new JLabel("Marca");
		labelMarcaP.setBounds(669, 430, 46, 14);
		contentPanelCrearPedido.add(labelMarcaP);

		JLabel labelCvP = new JLabel("Cv");
		labelCvP.setBounds(669, 468, 46, 14);
		contentPanelCrearPedido.add(labelCvP);

		JLabel labelManillarP = new JLabel("Manillar");
		labelManillarP.setBounds(843, 385, 46, 14);
		contentPanelCrearPedido.add(labelManillarP);

		JLabel labelBaseP = new JLabel("Base");
		labelBaseP.setBounds(843, 430, 46, 14);
		contentPanelCrearPedido.add(labelBaseP);

		JLabel labelRuedas = new JLabel("Ruedas");
		labelRuedas.setBounds(843, 468, 46, 14);
		contentPanelCrearPedido.add(labelRuedas);

		JComboBox comboBoxModeloB = new JComboBox();
		comboBoxModeloB.setModel(new DefaultComboBoxModel(new Object[] { "Carretera", "Ciudad" }));
		comboBoxModeloB.setBounds(89, 381, 94, 22);
		contentPanelCrearPedido.add(comboBoxModeloB);
		

		JComboBox comboBoxMarcaB = new JComboBox();
		comboBoxMarcaB.setModel(new DefaultComboBoxModel(new String[] { "Xiaomi", "Bezior" }));
		comboBoxMarcaB.setBounds(89, 414, 94, 22);
		contentPanelCrearPedido.add(comboBoxMarcaB);
		

		JComboBox comboBoxCvB = new JComboBox();
		comboBoxCvB.setModel(new DefaultComboBoxModel(new String[] { "50", "60" }));
		comboBoxCvB.setBounds(89, 454, 94, 22);
		contentPanelCrearPedido.add(comboBoxCvB);
		

		JComboBox comboBoxManillarB = new JComboBox();
		comboBoxManillarB.setModel(new DefaultComboBoxModel(new String[] { "Base", "Doble Altura" }));
		comboBoxManillarB.setBounds(279, 381, 93, 22);
		contentPanelCrearPedido.add(comboBoxManillarB);
		

		JComboBox comboBoxSillinB = new JComboBox();
		comboBoxSillinB.setModel(new DefaultComboBoxModel(new String[] { "Sport", "Estandar" }));
		comboBoxSillinB.setBounds(278, 414, 94, 22);
		contentPanelCrearPedido.add(comboBoxSillinB);
		

		JComboBox comboBoxRuedasB = new JComboBox();
		comboBoxRuedasB.setModel(new DefaultComboBoxModel(new String[] { "Carretera", "Monta\u00F1a" }));
		comboBoxRuedasB.setBounds(280, 454, 92, 22);
		contentPanelCrearPedido.add(comboBoxRuedasB);
		

		JComboBox comboBoxModeloP = new JComboBox();
		comboBoxModeloP.setModel(new DefaultComboBoxModel(new String[] { "Carretera", "Ciudad" }));
		comboBoxModeloP.setBounds(714, 381, 93, 22);
		contentPanelCrearPedido.add(comboBoxModeloP);

		JComboBox comboBoxMarcaP = new JComboBox();
		comboBoxMarcaP.setModel(new DefaultComboBoxModel(new String[] { "Xiaomi", "Bezior" }));
		comboBoxMarcaP.setBounds(714, 426, 93, 22);
		contentPanelCrearPedido.add(comboBoxMarcaP);

		JComboBox comboBoxCvP = new JComboBox();
		comboBoxCvP.setModel(new DefaultComboBoxModel(new String[] { "50", "60" }));
		comboBoxCvP.setBounds(714, 464, 93, 22);
		contentPanelCrearPedido.add(comboBoxCvP);

		JComboBox comboBoxManillarP = new JComboBox();
		comboBoxManillarP.setModel(new DefaultComboBoxModel(new String[] { "Base", "Doble Altura" }));
		comboBoxManillarP.setBounds(899, 381, 94, 22);
		contentPanelCrearPedido.add(comboBoxManillarP);

		JComboBox comboBoxBaseP = new JComboBox();
		comboBoxBaseP.setModel(new DefaultComboBoxModel(new String[] { "Aluminio", "Fibra" }));
		comboBoxBaseP.setBounds(899, 426, 94, 22);
		contentPanelCrearPedido.add(comboBoxBaseP);

		JComboBox comboBoxRuedasP = new JComboBox();
		comboBoxRuedasP.setModel(new DefaultComboBoxModel(new String[] { "Tierra", "Carretera" }));
		comboBoxRuedasP.setBounds(899, 464, 94, 22);
		contentPanelCrearPedido.add(comboBoxRuedasP);
		
		cargarBicicletas();
		
		JButton btnAnadirBici = new JButton("A\u00F1adir Bici");
		btnAnadirBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bicicleta o = new Bicicleta();
				valorModeloB= comboBoxModeloB.getSelectedItem().toString();
				valorMarcaB= comboBoxMarcaB.getSelectedItem().toString();
				valorCvB= comboBoxCvB.getSelectedItem().toString();
				valorRuedasB= comboBoxRuedasB.getSelectedItem().toString();
				valorManillarB= comboBoxManillarB.getSelectedItem().toString();
				valorSillinB= comboBoxSillinB.getSelectedItem().toString();
				
				int valorCvBInt=Integer.parseInt(valorCvB);
				int precioBicicleta;
				
				o.setModelo(valorModeloB);
				o.setMarca(valorMarcaB);
				o.setCv(valorCvBInt);
				o.setRueda(valorRuedasB);
				o.setManillar(valorManillarB);
				o.setSillin(valorSillinB);
				
				
				o.setPrecio(2);
				
				
				
				
				pedidoBicis.add(o);
				cargarBicicletas();
			}
		});
		btnAnadirBici.setBounds(139, 512, 129, 23);
		contentPanelCrearPedido.add(btnAnadirBici);

		JButton btnAnadirPatin = new JButton("A\u00F1adir Patin");
		btnAnadirPatin.setBounds(785, 512, 129, 23);
		contentPanelCrearPedido.add(btnAnadirPatin);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setAction(actionBotonAtras);
		btnAtras.setBounds(463, 512, 118, 23);
		contentPanelCrearPedido.add(btnAtras);

		JButton btnCrearPedido = new JButton("Crear pedido");
		btnCrearPedido.setBounds(463, 396, 118, 23);
		contentPanelCrearPedido.add(btnCrearPedido);

	}

	private class btnAtras extends AbstractAction {
		public btnAtras() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "ir a la ventana cliente");
		}

		public void actionPerformed(ActionEvent e) {
			VentanaCliente ventanaCliente = new VentanaCliente();
			ventanaCliente.setVisible(true);
			dispose();
		}
	}
	
	public void cargarBicicletas() {
		
		Vector<String> cabecerasBici = new Vector<String>(
				Arrays.asList("Modelo", "Marca", "Precio", "Cv", "Ruedas", "Manillar", "Sillin"));
		mDatosBici = new DefaultTableModel(new Vector<Vector<Object>>(), cabecerasBici);
		tablaCrearPedidoBici.setModel(mDatosBici);
		
		for (Bicicleta b : pedidoBicis) {
			mDatosBici.addRow(new Object[] { b.getModelo(), b.getMarca(), b.getPrecio(), b.getCv(),b.getRueda(),b.getManillar(),b.getSillin() });
			
		}
		tablaCrearPedidoBici.getColumnModel().getColumn(0).setMaxWidth(100);
		tablaCrearPedidoBici.getColumnModel().getColumn(1).setMaxWidth(100);
		tablaCrearPedidoBici.getColumnModel().getColumn(2).setMaxWidth(50);
		tablaCrearPedidoBici.getColumnModel().getColumn(3).setMaxWidth(50);
		tablaCrearPedidoBici.getColumnModel().getColumn(4).setMaxWidth(100);
		tablaCrearPedidoBici.getColumnModel().getColumn(5).setMaxWidth(100);
		tablaCrearPedidoBici.getColumnModel().getColumn(6).setMaxWidth(100);


	}
	

	public void cargarPatin() {
		

	}
}
