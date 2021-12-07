package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPatin {
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

}
