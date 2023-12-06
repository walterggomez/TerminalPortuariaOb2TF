package TerminalPortuaria.Obj2TF.Factura;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConceptoTest {
	
	Concepto lavado;
	LocalDateTime fecha;

	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDateTime.of(1980, 12, 18, 22, 00);
		lavado = new Concepto ("Lavado",fecha,20.0);
	}

	@Test
	void getNombre() {
		assertEquals("Lavado",lavado.getNombre());
		
	}
	@Test
	void getFecha() {
		assertEquals(fecha,lavado.getFecha());
		
	}
	@Test
	void getMonto() {
		assertEquals(20.0,lavado.getMonto());
	}
	
}
