package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBicicleta {

	Bicicleta bicicleta;

	@Before
	public void setUp() {
		bicicleta = new Bicicleta("Ciudad", "Xiaomi", 5000, 30, 2, "Base", "Blanco");
	}
	@Test
	public void testGetModelo() {
		assertEquals("Ciudad", bicicleta.getModelo());
	}
	@Test
	public void testGetMarca() {
		assertEquals("Xiaomi", bicicleta.getMarca());
	}
	@Test
	public void testGetPrecio() {
		assertEquals(5000, bicicleta.getPrecio());
	}
	@Test
	public void testGetCv() {
		assertEquals(30, bicicleta.getCv());
	}
	@Test
	public void testGetRueda() {
		assertEquals(2, bicicleta.getRueda());
	}
	@Test
	public void testGetManillar() {
		assertEquals("Base", bicicleta.getManillar());
	}
	@Test
	public void testGetSillin() {
		assertEquals("Blanco", bicicleta.getSillin());
	}

}
