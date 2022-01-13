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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Action;

import bd.Bd;
import models.Patin;
import models.Cliente;
import models.Pedido;

public class VentanaCrearPedido2 extends JFrame {

	private JPanel contentPanelCrearPedido2;
	private JTable tablaCrearPedidoPatin;
	
	private DefaultTableModel mDatosPatin;
	private ArrayList<Patin> pedidoPatines = new ArrayList();
	
	
	//private JTextField textField;

	String valorModeloP;
	String valorMarcaP;
	String valorPrecioP;
	String valorCvP;
	String valorRuedasP;
	String valorManillarP;
	String valorSillinP;
	
	private final Action action = new BotonAtras();
	protected Cliente cl;

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
		tablaCrearPedidoPatin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tablaCrearPedidoPatin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tablaCrearPedidoPatin.setBounds(261, 36, 514, 277);
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
		

		
		JComboBox comboBoxModeloP = new JComboBox();
		bd.cargarModeloP(comboBoxModeloP);
		comboBoxModeloP.setBounds(332, 324, 109, 22);
		contentPanelCrearPedido2.add(comboBoxModeloP);
		
		JComboBox comboBoxMarcaP = new JComboBox();
		bd.cargarMarcaP(comboBoxMarcaP);
		comboBoxMarcaP.setBounds(332, 370, 109, 22);
		contentPanelCrearPedido2.add(comboBoxMarcaP);
		
		JComboBox comboBoxCvP = new JComboBox();
		bd.cargarCvP(comboBoxCvP);
		comboBoxCvP.setBounds(332, 410, 109, 22);
		contentPanelCrearPedido2.add(comboBoxCvP);
		
		JComboBox comboBoxManillarP = new JComboBox();
		bd.cargarManillarP(comboBoxManillarP);
		comboBoxManillarP.setBounds(570, 324, 121, 22);
		contentPanelCrearPedido2.add(comboBoxManillarP);
		
		JComboBox comboBoxBaseP = new JComboBox();
		bd.cargarBaseP(comboBoxBaseP);
		comboBoxBaseP.setBounds(570, 370, 121, 22);
		contentPanelCrearPedido2.add(comboBoxBaseP);
		
		JComboBox comboBoxRuedasP = new JComboBox();
		bd.cargarRuedasP(comboBoxRuedasP);
		comboBoxRuedasP.setBounds(570, 410, 121, 22);
		contentPanelCrearPedido2.add(comboBoxRuedasP);
		
	
		
	/*	JButton btnCrearPatin = new JButton("Crear Pedido");
		btnCrearPatin.setBounds(72, 499, 109, 23);
		contentPanelCrearPedido2.add(btnCrearPatin);*/
		
		cargarPatin();
		
		JButton btnAnadirPatin = new JButton("Añadir Patín");
		btnAnadirPatin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patin s = new Patin();
				valorModeloP = comboBoxModeloP.getSelectedItem().toString();
				valorMarcaP = comboBoxMarcaP.getSelectedItem().toString();
				valorCvP = comboBoxCvP.getSelectedItem().toString();
				valorRuedasP = comboBoxRuedasP.getSelectedItem().toString();
				valorManillarP = comboBoxManillarP.getSelectedItem().toString();
				valorSillinP = comboBoxBaseP.getSelectedItem().toString();
			

				int valorCvPInt = Integer.parseInt(valorCvP);
				int precioPatin = bd.precioModeloB(valorModeloP) + bd.precioMarcaB(valorMarcaP)
				+ bd.precioCvB(valorCvP) + bd.precioRuedasB(valorRuedasP) + bd.precioManillarB(valorManillarP)
				+ bd.precioSillinB(valorSillinP);;

				s.setModelo(valorModeloP);
				s.setMarca(valorMarcaP);
				s.setCv(valorCvPInt);
				s.setRueda(valorRuedasP);
				s.setManillar(valorManillarP);
				s.setBase(valorSillinP);
				s.setPrecio(precioPatin);

				pedidoPatines.add(s);
				cargarPatin();
			}
		});
		
		btnAnadirPatin.setBounds(454, 499, 129, 23);
		contentPanelCrearPedido2.add(btnAnadirPatin);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setAction(action);
		btnAtras.setBounds(868, 499, 89, 23);
		contentPanelCrearPedido2.add(btnAtras);
		
		JButton btnCrearPatin = new JButton("Crear Pedido");
		btnCrearPatin.setBounds(72, 499, 109, 23);
		contentPanelCrearPedido2.add(btnCrearPatin);
		
		JLabel lblNewLabelModeloP = new JLabel("Modelo");
		lblNewLabelModeloP.setBounds(261, 22, 46, 14);
		contentPanelCrearPedido2.add(lblNewLabelModeloP);
		
		JLabel lblNewLabelMarcaP = new JLabel("Marca");
		lblNewLabelMarcaP.setBounds(343, 22, 46, 14);
		contentPanelCrearPedido2.add(lblNewLabelMarcaP);
		
		JLabel lblNewLabelPrecioP = new JLabel("Precio");
		lblNewLabelPrecioP.setBounds(426, 22, 46, 14);
		contentPanelCrearPedido2.add(lblNewLabelPrecioP);
		
		JLabel lblNewLabelCvP = new JLabel("Cv");
		lblNewLabelCvP.setBounds(476, 22, 46, 14);
		contentPanelCrearPedido2.add(lblNewLabelCvP);
		
		JLabel lblNewLabelRuedasP = new JLabel("Ruedas");
		lblNewLabelRuedasP.setBounds(526, 22, 46, 14);
		contentPanelCrearPedido2.add(lblNewLabelRuedasP);
		
		JLabel lblNewLabelManillarP = new JLabel("Manilllar");
		lblNewLabelManillarP.setBounds(609, 21, 61, 14);
		contentPanelCrearPedido2.add(lblNewLabelManillarP);
		
		JLabel lblNewLabelBaseP = new JLabel("Base");
		lblNewLabelBaseP.setBounds(691, 22, 46, 14);
		contentPanelCrearPedido2.add(lblNewLabelBaseP);
		btnCrearPatin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido p = new Pedido();
				
				String usuarioPedido = VentanaInicio.textoUsuario.getText();
				int precioPatin = bd.precioModeloB(valorModeloP) + bd.precioMarcaB(valorMarcaP)
				+ bd.precioCvB(valorCvP) + bd.precioRuedasB(valorRuedasP) + bd.precioManillarB(valorManillarP)
				+ bd.precioSillinB(valorSillinP);
				
				LocalDate hoy = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd");
				String fechaP = hoy.format(formatter);
				
				LocalDate hoyMasTres = LocalDate.now();
				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MMMM-dd");
				String fechaE = hoyMasTres.format(formatter2);
				
				int idPedido = 0;
				
				p.setIdP(bd.gestionIdPedido(idPedido));
				
				p.setClienteUsuario(usuarioPedido);
				p.setFechaP(fechaP);
				p.setFechaE(fechaE);
				p.setPrecioTotal(precioPatin);
				bd.crearPedido(p);
			}
		});
	}

		private class BotonAtras extends AbstractAction {
		public BotonAtras() {
			putValue(NAME, "Atras");
			putValue(SHORT_DESCRIPTION, "ir a la  ventana pedido");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaCrearPedidoIntermedia VentanaCrearPedidoIntermedia = new VentanaCrearPedidoIntermedia(cl);
			VentanaCrearPedidoIntermedia.setVisible(true);
			dispose();
		}
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

}
