package TerminalPortuaria.Ob2TF.ClienteTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Cliente.Shipper;

class ShipperTest {
	Shipper natalia;

	@BeforeEach
	void setUp() throws Exception {
		natalia = new Shipper ("Natalia",2005);
	}

	@Test
	void soyConsigneeTest() {
		assertFalse(natalia.soyConsignee());
	}
	@Test
	void soyShipperTest() {
		assertTrue(natalia.soyShipper());
	}

}
