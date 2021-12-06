package ventanas;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaAnyadirStock extends JFrame {

	private JPanel contentPanelAnyadirStock;

	public VentanaAnyadirStock() {
		setTitle("Añadir Stock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPanelAnyadirStock = new JPanel();
		contentPanelAnyadirStock.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelAnyadirStock);
		contentPanelAnyadirStock.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Añadir Stock");
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelTitulo.setBounds(403, 26, 213, 43);
		contentPanelAnyadirStock.add(labelTitulo);
		
		JLabel labelBicicleta = new JLabel("A\u00F1adir stock bicicleta");
		labelBicicleta.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		labelBicicleta.setBounds(210, 100, 140, 26);
		contentPanelAnyadirStock.add(labelBicicleta);
		
		JLabel labelPatin = new JLabel("A\u00F1adir stock patintete");
		labelPatin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		labelPatin.setBounds(210, 326, 154, 14);
		contentPanelAnyadirStock.add(labelPatin);
		
		JLabel labelModeloB = new JLabel("Modelo, Marca, Cv");
		labelModeloB.setBounds(220, 137, 104, 14);
		contentPanelAnyadirStock.add(labelModeloB);
		
		JLabel labelRuedasB = new JLabel("Ruedas");
		labelRuedasB.setBounds(611, 137, 46, 14);
		contentPanelAnyadirStock.add(labelRuedasB);
		
		JLabel labelManillarB = new JLabel("Manillar");
		labelManillarB.setBounds(376, 137, 46, 14);
		contentPanelAnyadirStock.add(labelManillarB);
		
		JLabel labelSillinB = new JLabel("Sillin");
		labelSillinB.setBounds(502, 137, 46, 14);
		contentPanelAnyadirStock.add(labelSillinB);
		
		JLabel labelManillarP = new JLabel("Manillar");
		labelManillarP.setBounds(376, 354, 46, 14);
		contentPanelAnyadirStock.add(labelManillarP);
		
		JLabel labelBaseP = new JLabel("Base");
		labelBaseP.setBounds(502, 354, 46, 14);
		contentPanelAnyadirStock.add(labelBaseP);
		
		JLabel labelRuedas = new JLabel("Ruedas");
		labelRuedas.setBounds(611, 354, 46, 14);
		contentPanelAnyadirStock.add(labelRuedas);
		
		JButton botonAnadirProducto = new JButton("A\u00F1adir Stock");
		botonAnadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonAnadirProducto.setBounds(805, 306, 124, 23);
		contentPanelAnyadirStock.add(botonAnadirProducto);
		
		JComboBox comboBoxModeloB = new JComboBox();
		comboBoxModeloB.setModel(new DefaultComboBoxModel(new String[] {"Carretera", "Ciudad"}));
		comboBoxModeloB.setBounds(221, 162, 94, 22);
		contentPanelAnyadirStock.add(comboBoxModeloB);
		
		JComboBox comboBoxMarcaB = new JComboBox();
		comboBoxMarcaB.setModel(new DefaultComboBoxModel(new String[] {"Xiaomi", "Bezior"}));
		comboBoxMarcaB.setBounds(220, 194, 94, 22);
		contentPanelAnyadirStock.add(comboBoxMarcaB);
		
		JComboBox comboBoxCvB = new JComboBox();
		comboBoxCvB.setModel(new DefaultComboBoxModel(new String[] {"50", "60"}));
		comboBoxCvB.setBounds(220, 227, 94, 22);
		contentPanelAnyadirStock.add(comboBoxCvB);
		
		JComboBox comboBoxManillarB = new JComboBox();
		comboBoxManillarB.setModel(new DefaultComboBoxModel(new String[] {"Base", "Doble Altura"}));
		comboBoxManillarB.setBounds(345, 162, 93, 22);
		contentPanelAnyadirStock.add(comboBoxManillarB);
		
		JComboBox comboBoxSillinB = new JComboBox();
		comboBoxSillinB.setModel(new DefaultComboBoxModel(new String[] {"Sport", "Estandar"}));
		comboBoxSillinB.setBounds(468, 162, 94, 22);
		contentPanelAnyadirStock.add(comboBoxSillinB);
		
		JComboBox comboBoxRuedasB = new JComboBox();
		comboBoxRuedasB.setModel(new DefaultComboBoxModel(new String[] {"Carretera", "Monta\u00F1a"}));
		comboBoxRuedasB.setBounds(589, 162, 92, 22);
		contentPanelAnyadirStock.add(comboBoxRuedasB);
		
		JComboBox comboBoxModeloP = new JComboBox();
		comboBoxModeloP.setModel(new DefaultComboBoxModel(new String[] {"Carretera", "Ciudad"}));
		comboBoxModeloP.setBounds(220, 379, 93, 22);
		contentPanelAnyadirStock.add(comboBoxModeloP);
		
		JComboBox comboBoxMarcaP = new JComboBox();
		comboBoxMarcaP.setModel(new DefaultComboBoxModel(new String[] {"Xiaomi", "Bezior"}));
		comboBoxMarcaP.setBounds(220, 412, 93, 22);
		contentPanelAnyadirStock.add(comboBoxMarcaP);
		
		JComboBox comboBoxCvP = new JComboBox();
		comboBoxCvP.setModel(new DefaultComboBoxModel(new String[] {"50", "60"}));
		comboBoxCvP.setBounds(220, 445, 93, 22);
		contentPanelAnyadirStock.add(comboBoxCvP);
		
		JComboBox comboBoxManillarP = new JComboBox();
		comboBoxManillarP.setModel(new DefaultComboBoxModel(new String[] {"Base", "Doble Altura"}));
		comboBoxManillarP.setBounds(344, 379, 94, 22);
		contentPanelAnyadirStock.add(comboBoxManillarP);
		
		JComboBox comboBoxBaseP = new JComboBox();
		comboBoxBaseP.setModel(new DefaultComboBoxModel(new String[] {"Aluminio", "Fibra"}));
		comboBoxBaseP.setBounds(468, 379, 94, 22);
		contentPanelAnyadirStock.add(comboBoxBaseP);
		
		JComboBox comboBoxRuedasP = new JComboBox();
		comboBoxRuedasP.setModel(new DefaultComboBoxModel(new String[] {"Tierra", "Carretera"}));
		comboBoxRuedasP.setBounds(587, 379, 94, 22);
		contentPanelAnyadirStock.add(comboBoxRuedasP);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(142, 276, 53, 14);
		contentPanelAnyadirStock.add(lblCantidad);
		
		JComboBox comboBoxCantidad = new JComboBox();
		comboBoxCantidad.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxCantidad.setBounds(220, 272, 94, 22);
		contentPanelAnyadirStock.add(comboBoxCantidad);
		
		JComboBox comboBoxCantidad_1 = new JComboBox();
		comboBoxCantidad_1.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxCantidad_1.setBounds(345, 272, 94, 22);
		contentPanelAnyadirStock.add(comboBoxCantidad_1);
		
		JComboBox comboBoxCantidad_2 = new JComboBox();
		comboBoxCantidad_2.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxCantidad_2.setBounds(468, 272, 94, 22);
		contentPanelAnyadirStock.add(comboBoxCantidad_2);
		
		JComboBox comboBoxCantidad_3 = new JComboBox();
		comboBoxCantidad_3.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxCantidad_3.setBounds(589, 272, 94, 22);
		contentPanelAnyadirStock.add(comboBoxCantidad_3);
		
		JLabel labelModeloB_1 = new JLabel("Modelo, Marca, Cv");
		labelModeloB_1.setBounds(220, 354, 104, 14);
		contentPanelAnyadirStock.add(labelModeloB_1);
		
		JLabel lblCantidad_1 = new JLabel("Cantidad:");
		lblCantidad_1.setBounds(142, 493, 53, 14);
		contentPanelAnyadirStock.add(lblCantidad_1);
		
		JComboBox comboBoxCantidad_4 = new JComboBox();
		comboBoxCantidad_4.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxCantidad_4.setBounds(220, 489, 94, 22);
		contentPanelAnyadirStock.add(comboBoxCantidad_4);
		
		JComboBox comboBoxCantidad_5 = new JComboBox();
		comboBoxCantidad_5.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxCantidad_5.setBounds(345, 489, 94, 22);
		contentPanelAnyadirStock.add(comboBoxCantidad_5);
		
		JComboBox comboBoxCantidad_6 = new JComboBox();
		comboBoxCantidad_6.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxCantidad_6.setBounds(468, 489, 94, 22);
		contentPanelAnyadirStock.add(comboBoxCantidad_6);
		
		JComboBox comboBoxCantidad_7 = new JComboBox();
		comboBoxCantidad_7.setModel(new DefaultComboBoxModel(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxCantidad_7.setBounds(589, 489, 94, 22);
		contentPanelAnyadirStock.add(comboBoxCantidad_7);
		
		JLabel labelPatin_1 = new JLabel("----------------------------------------------------------------------------------------------");
		labelPatin_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		labelPatin_1.setBounds(210, 337, 471, 14);
		contentPanelAnyadirStock.add(labelPatin_1);
		
		JLabel labelPatin_1_1 = new JLabel("----------------------------------------------------------------------------------------------");
		labelPatin_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		labelPatin_1_1.setBounds(210, 117, 471, 14);
		contentPanelAnyadirStock.add(labelPatin_1_1);
		
	
	}
}