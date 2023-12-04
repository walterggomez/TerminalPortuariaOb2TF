package TerminalPortuaria.Ob2TF.EmpresaTransportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.EmpresaTransportista.Camion;
import TerminalPortuaria.Ob2TF.Orden.Orden;

class CamionTest {

	//Camiones
	Camion camion;
	
	//Ordenes
	Orden orden1;
	Orden orden2;
	Orden orden3;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		camion = new Camion("HDR001");
		orden1 = mock(Orden.class);
		orden2 = mock(Orden.class);
		orden3 = mock(Orden.class);
		
	}
	
	@Test
	void verificaQueCamionNoTieneOrdenAsignada() {
		assertFalse (camion.tieneOrdenAsignada());
	}
	
	@Test
	void setOrdenEnCamion() {
		assertFalse (camion.tieneOrdenAsignada());
		camion.setOrdenAsignada(orden1);
		assertTrue (camion.tieneOrdenAsignada());
	}
	
	@Test
	void patenteDeCamion() {
		assertEquals(camion.getPatente(), "HDR001");
	}
	



}
