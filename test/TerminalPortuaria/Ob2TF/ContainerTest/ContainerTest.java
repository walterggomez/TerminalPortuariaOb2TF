package TerminalPortuaria.Ob2TF.ContainerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Container.Dry;
import TerminalPortuaria.Ob2TF.Container.Reefer;
import TerminalPortuaria.Ob2TF.Container.Tanque;

class ContainerTest {
	Dry containerA;
	Reefer containerB;
	Tanque containerC;
	

	@BeforeEach
	void setUp() throws Exception {
		containerA = new Dry(15,20,17,3000);
		containerB = new Reefer(20,15,10,7000,36);
		containerC = new Tanque(12,16,10,5000);
	}

	@Test
	void pesoTest() {
		assertEquals(3000,containerA.getPeso());
		assertEquals(7000,containerB.getPeso());
		assertEquals(5000,containerC.getPeso());
	}
	@Test
	void volumenTest() {
		assertEquals(5100,containerA.volumen());
		assertEquals(3000,containerB.volumen());
		assertEquals(1920,containerC.volumen());
	}
	@Test
	void necesitaRefrigeracionTest() {
		assertFalse(containerA.necesitaRefrigeracion());
		assertTrue(containerB.necesitaRefrigeracion());
		assertFalse(containerC.necesitaRefrigeracion());
		// verifico el consumo para el container Reefer
		assertEquals(36,containerB.getConsumo());
	}
	@Test
	void isAptoLiquidoTest() {
		assertFalse(containerA.isAptoLiquido());
		assertFalse(containerB.isAptoLiquido());
		assertTrue(containerC.isAptoLiquido());
	}

}
// getPeso volumen necesitaRefrigeracion isAptoLiquido