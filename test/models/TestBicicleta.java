package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBicicleta {

	Bicicleta bicicleta;

	@Before
	public void setUp() {
		bicicleta = new Bicicleta("Ciudad", "Xiaomi", 5000, 30, "carretera", "Base", "Blanco");
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
		assertEquals("carretera", bicicleta.getRueda());
	}
	@Test
	public void testGetManillar() {
		assertEquals("Base", bicicleta.getManillar());
	}
	@Test
	public void testGetSillin() {
		assertEquals("Blanco", bicicleta.getSillin());
	}
	@Test
	public void testSetModelo() {
		bicicleta.setModelo("Monte");
		assertEquals("Monte", bicicleta.getModelo());
	}
	@Test
	public void testSetMarca() {
		bicicleta.setMarca("Samsung");
		assertEquals("Samsung", bicicleta.getMarca());
	}
	@Test
	public void testSetPrecio() {
		bicicleta.setPrecio(6000);
		assertEquals(6000, bicicleta.getPrecio());
	}
	@Test
	public void testSetCv() {
		bicicleta.setCv(40);
		assertEquals(40, bicicleta.getCv());
	}
	@Test
	public void testSetRueda() {
		bicicleta.setRueda("Ciudad");
		assertEquals("Ciudad", bicicleta.getRueda());
	}
	@Test
	public void testSetManillar() {
		bicicleta.setManillar("Doble");
		assertEquals("Doble", bicicleta.getManillar());
	}
	@Test
	public void testSetSillin() {
		bicicleta.setSillin("Rojo");
		assertEquals("Rojo", bicicleta.getSillin());
	}
	@Test
	public void testBicicleta() {
		bicicleta = new Bicicleta();
		assertEquals("", bicicleta.getModelo());
		assertEquals("", bicicleta.getMarca());
		assertEquals(0, bicicleta.getPrecio());
		assertEquals(0, bicicleta.getCv());
		assertEquals("", bicicleta.getRueda());
		assertEquals("", bicicleta.getManillar());
		assertEquals("", bicicleta.getSillin());
	}
	
	@Test
	public void testToString() {
		assertEquals("Bicicleta [sillin=Blanco]", bicicleta.toString());
	}

}
