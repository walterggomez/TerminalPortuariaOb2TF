package TerminalPortuaria.Ob2TF.Buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class OutboundTest {

	Outbound outbound;
	
	Buque araBouchard;
	
	GPS gpsBarco;
	GPS gpsPuerto;
	GPS distancia;
	
	

	TerminalPortuaria bsAs;
	TerminalPortuaria hongKong;

	Point2D posicionAraBouchard;
	Point2D posicionTerBsAs;
	Point2D posicionHongKong;

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
		
		outbound = spy(new Outbound());

		posicionAraBouchard = mock(Point2D.class);
		posicionTerBsAs = mock(Point2D.class);
		posicionHongKong = mock(Point2D.class);
		
		araBouchard = spy(Buque.class);
		

//		araBouchard = new Buque(posicionAraBouchard, garminDrive, viajeBsAsHongKong);
		when(viajeBsAsHongKong.getpuertoDestino()).thenReturn(bsAs);
		when(viajeBsAsHongKong.getpuertoOrigen()).thenReturn(hongKong);
		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs);
		when(araBouchard.getPosicionActual()).thenReturn(posicionAraBouchard);
		when(araBouchard.getViajeActual()).thenReturn(viajeBsAsHongKong);
		doNothing().when(bsAs).darAvisoConsignees(viajeBsAsHongKong);
		when(garminDrive.distanciaEntrePuntos(posicionTerBsAs, posicionAraBouchard)).thenReturn(0.6);
		when(araBouchard.getMiGps()).thenReturn(garminDrive);
		araBouchard.setestadoBuque(outbound);
		
	
	}

	
	@Test
	void distanciaATerminal() {
		assertEquals(67.0 , outbound.distanciaATerminal(araBouchard, bsAs));
	}
	
	@Test
	void evaluarEstado() {
		when(garminDrive.distanciaEntrePuntos(posicionTerBsAs, posicionAraBouchard)).thenReturn(0.3);
		outbound.evaluar(araBouchard, bsAs);
		verify( outbound, times(1) ).actualizarEstado(araBouchard);
	}
	

}
