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

import org.junit.jupiter.api.Test;

class DepartingTest {

	Departing departing;
	
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
		
		bsAs = spy(TerminalPortuaria.class);
		hongKong = mock(TerminalPortuaria.class);

		viajeBsAsHongKong = mock(Viaje.class);
		viajeHongKongMadrid = mock(Viaje.class);
		
		departing = new Departing();

		posicionAraBouchard = spy(Point2D.class);
		posicionTerBsAs = spy(Point2D.class);
		
		araBouchard = spy(Buque.class);

//		araBouchard = new Buque(posicionAraBouchard, garminDrive, viajeBsAsHongKong);
		when(viajeBsAsHongKong.getpuertoDestino()).thenReturn(bsAs);
		when(viajeBsAsHongKong.getpuertoOrigen()).thenReturn(bsAs);
		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs);
		araBouchard.setestadoBuque(departing);
	
	
	}
	
	@Test
	void estoyEnEstado() {
		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Departing"));
	}
	
	@Test
	void actualizarEstado() {
		when(araBouchard.distanciaATerminal()).thenReturn(0.0);
		departing.actualizarEstado(araBouchard);
		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Departing"));
		when(araBouchard.distanciaATerminal()).thenReturn(5.0);
		departing.actualizarEstado(araBouchard);
		assertFalse(araBouchard.getEstadoActual().estoyEnEstado("Departing"));
		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Outbound"));
	}

}
