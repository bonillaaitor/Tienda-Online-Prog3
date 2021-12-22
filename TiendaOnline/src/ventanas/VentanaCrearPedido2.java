package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import bd.Bd;
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
import java.awt.event.ActionListener;

import javax.swing.Action;

import bd.Bd;
import models.Patin;
import models.Cliente;
import models.Pedido;

public class VentanaCrearPedido2 extends JFrame {


	private DefaultTableModel mDatosPatin;
	private ArrayList<Patin> pedidoPatines = new ArrayList();
	
	private JPanel contentPanelCrearPedido2;
	private JTextField textField;

	private JTable tablaCrearPedidoPatin;
	private final Action action = new BotonAtras();
	protected Cliente cl;
	
	String valorModeloP;
	String valorMarcaP;
	String valorPrecioP;
	String valorCvP;
	String valorRuedasP;
	String valorManillarP;
	String valorSillinP;


	public VentanaCrearPedido2(Cliente c) {
		Bd bd = new Bd();
		cl = c;
		setTitle("Crear Patin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelCrearPedido2 = new JPanel();
		contentPanelCrearPedido2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelCrearPedido2);
		contentPanelCrearPedido2.setLayout(null);
		
		tablaCrearPedidoPatin = new JTable();
		tablaCrearPedidoPatin.setFont(new Font("Arial", Font.PLAIN, 14));
		tablaCrearPedidoPatin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tablaCrearPedidoPatin.setBounds(10, 40, 1014, 277);
		contentPanelCrearPedido2.add(tablaCrearPedidoPatin);
		
		JLabel lblPatin = new JLabel("Crea tu Patin");
		lblPatin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPatin.setBounds(404, 279, 94, 14);
		contentPanelCrearPedido2.add(lblPatin);
		
		JLabel lblModeloP = new JLabel("Modelo");
		lblModeloP.setBounds(260, 328, 46, 14);
		contentPanelCrearPedido2.add(lblModeloP);
		
		JLabel lblMarcaP = new JLabel("Marca");
		lblMarcaP.setBounds(260, 374, 46, 14);
		contentPanelCrearPedido2.add(lblMarcaP);
		
		JLabel lblCvP = new JLabel("Cv");
		lblCvP.setBounds(260, 414, 46, 14);
		contentPanelCrearPedido2.add(lblCvP);
		
		JLabel lblManillarP = new JLabel("Manillar");
		lblManillarP.setBounds(494, 328, 46, 14);
		contentPanelCrearPedido2.add(lblManillarP);
		
		JLabel lblBaseP = new JLabel("Base");
		lblBaseP.setBounds(494, 374, 46, 14);
		contentPanelCrearPedido2.add(lblBaseP);
		
		JLabel lblRuedasP = new JLabel("Ruedas");
		lblRuedasP.setBounds(494, 414, 46, 14);
		contentPanelCrearPedido2.add(lblRuedasP);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setAction(action);
		btnAtras.setBounds(868, 499, 89, 23);
		contentPanelCrearPedido2.add(btnAtras);
		
		JComboBox comboBoxModeloP = new JComboBox();
		comboBoxModeloP.setBounds(332, 324, 109, 22);
		bd.cargarModeloP(comboBoxModeloP);
		contentPanelCrearPedido2.add(comboBoxModeloP);
		
		JComboBox comboBoxMarcaP = new JComboBox();
		comboBoxMarcaP.setBounds(332, 370, 109, 22);
		bd.cargarMarcaP(comboBoxMarcaP);
		contentPanelCrearPedido2.add(comboBoxMarcaP);
		
		JComboBox comboBoxCvP = new JComboBox();
		comboBoxCvP.setBounds(332, 410, 109, 22);
		bd.cargarCvP(comboBoxCvP);
		contentPanelCrearPedido2.add(comboBoxCvP);
		
		JComboBox comboBoxManillarP = new JComboBox();
		comboBoxManillarP.setBounds(570, 324, 121, 22);
		bd.cargarManillarP(comboBoxManillarP);
		contentPanelCrearPedido2.add(comboBoxManillarP);
		
		JComboBox comboBoxBaseP = new JComboBox();
		comboBoxBaseP.setBounds(570, 370, 121, 22);
		bd.cargarBaseP(comboBoxBaseP);
		contentPanelCrearPedido2.add(comboBoxBaseP);
		
		JComboBox comboBoxRuedasP = new JComboBox();
		comboBoxRuedasP.setBounds(570, 410, 121, 22);
		bd.cargarRuedasP(comboBoxRuedasP);
		contentPanelCrearPedido2.add(comboBoxRuedasP);
		
		JButton btnCrearPatin = new JButton("Crear Pedido");
		btnCrearPatin.setBounds(72, 499, 109, 23);
		contentPanelCrearPedido2.add(btnCrearPatin);
		
		cargarPatin();
		
		JButton btnAnadirP = new JButton("Añadir Patín");
		btnAnadirP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patin s = new Patin();
				valorModeloP = comboBoxModeloP.getSelectedItem().toString();
				valorMarcaP = comboBoxMarcaP.getSelectedItem().toString();
				valorCvP = comboBoxCvP.getSelectedItem().toString();
				valorRuedasP = comboBoxRuedasP.getSelectedItem().toString();
				valorManillarP = comboBoxManillarP.getSelectedItem().toString();
				valorSillinP = comboBoxBaseP.getSelectedItem().toString();
			

				int valorCvBInt = Integer.parseInt(valorCvP);
				int precioBicicleta;

				s.setModelo(valorModeloP);
				s.setMarca(valorMarcaP);
				s.setCv(valorCvBInt);
				s.setRueda(valorRuedasP);
				s.setManillar(valorManillarP);
				s.setBase(valorSillinP);

				s.setPrecio(2);

				pedidoPatines.add(s);
				cargarPatin();
			}
		});
		btnAnadirP.setBounds(454, 499, 129, 23);
		contentPanelCrearPedido2.add(btnAnadirP);
	
	}

	
	 public void cargarPatin() {
		
		Vector<String> cabecerasPatin = new Vector<String>(
		Arrays.asList("Modelo", "Marca", "Precio", "Cv", "Ruedas", "Manillar", "Base"));
		mDatosPatin = new DefaultTableModel(new Vector<Vector<Object>>(), cabecerasPatin);
		tablaCrearPedidoPatin.setModel(mDatosPatin);
		
		for (Patin p : pedidoPatines) {
			mDatosPatin.addRow(new Object[] { p.getModelo(), p.getMarca(), p.getPrecio(), p.getCv(),p.getRueda(),p.getManillar(),p.getBase() });
			
		}
		tablaCrearPedidoPatin.getColumnModel().getColumn(0).setMaxWidth(100);
		tablaCrearPedidoPatin.getColumnModel().getColumn(1).setMaxWidth(100);
		tablaCrearPedidoPatin.getColumnModel().getColumn(2).setMaxWidth(50);
		tablaCrearPedidoPatin.getColumnModel().getColumn(3).setMaxWidth(50);
		tablaCrearPedidoPatin.getColumnModel().getColumn(4).setMaxWidth(100);
		tablaCrearPedidoPatin.getColumnModel().getColumn(5).setMaxWidth(100);
		tablaCrearPedidoPatin.getColumnModel().getColumn(6).setMaxWidth(100);


	}
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
