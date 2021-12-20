package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PatinTest {
	Patin patin;

	@Before
	public void setUp() {
		patin = new Patin("Ciudad", "Xiaomi", 5000, 30, "carretera", "Base", "Blanco");
	}
	@Test
	public void testGetModelo() {
		assertEquals("Ciudad", patin.getModelo());
	}
	@Test
	public void testGetMarca() {
		assertEquals("Xiaomi", patin.getMarca());
	}
	@Test
	public void testGetPrecio() {
		assertEquals(5000, patin.getPrecio());
	}
	@Test
	public void testGetCv() {
		assertEquals(30, patin.getCv());
	}
	@Test
	public void testGetRueda() {
		assertEquals("carretera", patin.getRueda());
	}
	@Test
	public void testGetManillar() {
		assertEquals("Base", patin.getManillar());
	}
	@Test
	public void testGetBase() {
		assertEquals("Blanco", patin.getBase());
	}
	
	@Test
	public void testSetModelo() {
		patin.setModelo("Monte");
		assertEquals("Monte", patin.getModelo());
	}
	@Test
	public void testSetMarca() {
		patin.setMarca("Samsung");
		assertEquals("Samsung", patin.getMarca());
	}
	@Test
	public void testSetPrecio() {
		patin.setPrecio(6000);
		assertEquals(6000, patin.getPrecio());
	}
	@Test
	public void testSetCv() {
		patin.setCv(40);
		assertEquals(40, patin.getCv());
	}
	@Test
	public void testSetRueda() {
		patin.setRueda("Ciudad");
		assertEquals("Ciudad", patin.getRueda());
	}
	@Test
	public void testSetManillar() {
		patin.setManillar("Doble");
		assertEquals("Doble", patin.getManillar());
	}
	@Test
	public void testSetBase() {
		patin.setBase("Rojo");
		assertEquals("Rojo", patin.getBase());
	}
	@Test
	public void testPatin() {
		patin = new Patin();
		assertEquals("", patin.getModelo());
		assertEquals("", patin.getMarca());
		assertEquals(0, patin.getPrecio());
		assertEquals(0, patin.getCv());
		assertEquals("", patin.getRueda());
		assertEquals("", patin.getManillar());
		assertEquals("", patin.getBase());
	}
	@Test
	public void testToString() {
		assertEquals("Patin [base=Blanco, modelo=Ciudad, marca=Xiaomi, precio=5000, cv=30, ruedas=carretera, manillar=Base]",patin.toString());
	}

}
