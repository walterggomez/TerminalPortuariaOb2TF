package TerminalPortuaria.Ob2TF.Buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class OutboundTest {

	Outbound outbound;
	
	Buque araBouchard;
	
	

	TerminalPortuaria bsAs;
	TerminalPortuaria hongKong;

	Point2D posicionAraBouchard;
	Point2D posicionTerBsAs;

	Viaje viajeBsAsHongKong;
	Viaje viajeHongKongMadrid;

	GPS garminDrive;
	
	
	@BeforeEach
	void setUp() throws Exception {
		garminDrive = spy(GPS.class);
		
		//Estados
		
		bsAs = mock(TerminalPortuaria.class);
		hongKong = mock(TerminalPortuaria.class);

		viajeBsAsHongKong = mock(Viaje.class);
		viajeHongKongMadrid = mock(Viaje.class);
		
		outbound = new Outbound();

		posicionAraBouchard = mock(Point2D.class);
		posicionTerBsAs = mock(Point2D.class);
		
		araBouchard = spy(Buque.class);

//		araBouchard = new Buque(posicionAraBouchard, garminDrive, viajeBsAsHongKong);
		when(viajeBsAsHongKong.getpuertoDestino()).thenReturn(bsAs);
		when(viajeBsAsHongKong.getpuertoOrigen()).thenReturn(bsAs);
		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs);
		araBouchard.setestadoBuque(outbound);
	
	}
	@Test
	void estoyEnEstado() {
		assertTrue(outbound.estoyEnEstado("Outbound"));
	}
	
	@Test
	void actualizar() {
		assertEquals(araBouchard.getEstadoActual(), outbound);
		outbound.actualizarEstado(araBouchard);
		when(araBouchard.distanciaATerminal()).thenReturn(40.0);
		outbound.actualizarEstado(araBouchard);
		assertFalse(araBouchard.getEstadoActual().estoyEnEstado("Outbound"));
		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Inbound"));
	}

}
