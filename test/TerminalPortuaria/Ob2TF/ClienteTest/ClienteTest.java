package TerminalPortuaria.Ob2TF.ClienteTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Cliente.Consignee;
import TerminalPortuaria.Ob2TF.Cliente.Shipper;

class ClienteTest {
	
	Consignee federico;
	Shipper natalia;

	@BeforeEach
	void setUp() throws Exception {
		federico = new Consignee ("Federico",1001);
		natalia = new Shipper ("Natalia",2005);
	}

	@Test
	void getNombreTest() {
		assertEquals("Federico",federico.getNombre());
		assertEquals("Natalia",natalia.getNombre());
	}
	@Test
	void getCodigoClienteTest() {
		assertEquals(1001,federico.getCodigoCliente());
		assertEquals(2005,natalia.getCodigoCliente());
	}
	@Test
	void soyTest() {
		assertTrue(federico.soy("Consignee"));
		assertTrue(natalia.soy("Shipper"));
	}


}
