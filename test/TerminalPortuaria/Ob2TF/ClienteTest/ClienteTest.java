package TerminalPortuaria.Ob2TF.ClienteTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Cliente.Consignee;
import TerminalPortuaria.Ob2TF.Cliente.Shipper;

class ClienteTest {
	
	Consignee federico;
	Shipper natalia;
	
	LocalDateTime turno;

	@BeforeEach
	void setUp() throws Exception {
		federico = new Consignee ("Federico",1001);
		natalia = new Shipper ("Natalia",2005);
		turno = LocalDateTime.of(2023, 12, 28, 15, 00);
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
	void turnoTest() {
		federico.setTurno(turno);
		assertEquals(turno,federico.getTurno());
		
	}


}
