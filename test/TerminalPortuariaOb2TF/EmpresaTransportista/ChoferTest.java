package TerminalPortuariaOb2TF.EmpresaTransportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.EmpresaTransportista.Camion;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Chofer;
import TerminalPortuaria.Ob2TF.Orden.Orden;

class ChoferTest {

	//Chofer
	Chofer chofer;
	
	//Ordenes
	Orden orden1;
	Orden orden2;
	Orden orden3;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		chofer = new Chofer("JuanCarlos");
		orden1 = mock(Orden.class);
		orden2 = mock(Orden.class);
		orden3 = mock(Orden.class);
		
	}
	
	@Test
	void verificaQueChoferNoTieneOrdenAsignada() {
		assertFalse (chofer.tieneOrdenAsignada());
	}
	
	
	@Test
	void seAgregaOrden() {
		chofer.setOrdenAsignada(orden1);
		assertTrue(chofer.tieneOrdenAsignada());
	}
	
	@Test
	void seVerificaElNombre() {
		assertEquals(chofer.getNombre(), "JuanCarlos");
	}

}
