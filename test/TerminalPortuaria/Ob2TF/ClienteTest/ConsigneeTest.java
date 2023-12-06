package TerminalPortuaria.Ob2TF.ClienteTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Cliente.Consignee;

class ConsigneeTest {
	Consignee federico;

	@BeforeEach
	void setUp() throws Exception {
		federico = new Consignee ("Federico",1001);
	}

	@Test
	void soyConsigneeTest() {
		assertTrue(federico.soyConsignee());
	}
	@Test
	void soyShipperTest() {
		assertFalse(federico.soyShipper());
	}


}
