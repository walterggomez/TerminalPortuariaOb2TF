package TerminalPortuaria.Ob2TF.Buque;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;


import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class BuqueTest {


	Buque araBouchard;
	
	
	//ESTADOS
	Outbound outbound;
	Inbound inbound;
	Arrived arrived;
	Working working;
	Departing departing;
	

	TerminalPortuaria bsAs;
	TerminalPortuaria hongKong;

	Point2D posicionAraBouchard;
	Point2D posicionTerBsAs;

	Viaje viajeBsAsHongKong;
	Viaje viajeHongKongMadrid;

	GPS garminDrive;

	/*
	 * public static void main(String[] args) { final Buque buquebus = new Buque();
	 * final Buque buquebus2 = new Buque();
	 * 
	 * buquebus.setPosicionActual(5, 9); buquebus2.setPosicionActual(10, 4);
	 * 
	 * System.out.println( GPS.distanciaEntrePuntos(buquebus.getPosicionActual(),
	 * buquebus2.getPosicionActual()) ); }
	 */
	@BeforeEach
	void setUp() throws Exception {
		garminDrive = spy(GPS.class);
		
		//Estados
		
		bsAs = mock(TerminalPortuaria.class);
		hongKong = mock(TerminalPortuaria.class);

		viajeBsAsHongKong = mock(Viaje.class);
		viajeHongKongMadrid = mock(Viaje.class);
		
		outbound = mock(Outbound.class);
		inbound = mock(Inbound.class);
		arrived = spy(Arrived.class);
		working = spy(Working.class);
		departing = spy(Departing.class);

		posicionAraBouchard = mock(Point2D.class);
		posicionTerBsAs = mock(Point2D.class);

		araBouchard = new Buque(posicionAraBouchard, garminDrive, viajeBsAsHongKong);
		when(viajeBsAsHongKong.getpuertoDestino()).thenReturn(bsAs);
		when(viajeBsAsHongKong.getpuertoOrigen()).thenReturn(hongKong);
		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs);

	}
	
	@Test
	void setPosicionActualTest() {
		assertEquals(araBouchard.getPosicionActual(), posicionAraBouchard);
		araBouchard.setPosicionActual(posicionTerBsAs);
		assertEquals(araBouchard.getPosicionActual(), posicionTerBsAs);

	}

	@Test
	void getMiGpsTest() {
		assertEquals(garminDrive, araBouchard.getMiGps());
	}

	@Test
	void getViajeActualTest() {
		assertEquals(viajeBsAsHongKong, araBouchard.getViajeActual());
	}

	@Test
	void puertoDestinoTest() {
		assertEquals(bsAs, araBouchard.puertoDestino());
	}

	@Test
	void getPosicionActualTest() {
		assertEquals(posicionAraBouchard, araBouchard.getPosicionActual());
	}

	@Test
	void setViajeActualTest() {
		araBouchard.setViajeActual(viajeHongKongMadrid);
		assertEquals(viajeHongKongMadrid, araBouchard.getViajeActual());
	}
	@Test
	void puedeDescargarbuequeTest() {
		assertFalse(araBouchard.getsePuedeDescargar());
		araBouchard.setsePuedeDescargar();
		assertTrue(araBouchard.getsePuedeDescargar());
	}
	
	@Test
	void puertoOrigenTest() {
		assertEquals(araBouchard.puertoOrigen(), hongKong);
	}
//	@Test
//	void posicionOutbound() {
//		when(outbound.posicionBuque(araBouchard)).thenReturn(40.0);
//	    assertTrue(outbound.posicionBuque(araBouchard) < 50);
//	    outbound.actualizarEstado(araBouchard);
//	    assertEquals(araBouchard.getEstadoActual(),inbound);
//	}

//	@Test
//	void pasarDelEstadoOutboundAlEstadoInboundTest() {
//		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Outbound"));
//		assertTrue(outbound.estoyEnEstado("Outbound"));
//		assertTrue(outbound.posicionBuque(araBouchard) > 50);
//		when(outbound.posicionBuque(araBouchard)).thenReturn(40.0);
//		assertTrue(outbound.posicionBuque(araBouchard) < 50);
//		outbound.actualizarEstado(araBouchard);
//
//	}

//	@Test
//	assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Outbound"));
//	void pasarDelEstadoInboundAlEstadoArrivedTest() {
//		// Primero paso al Estado Inbound
//		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(40.0);
//		// Posiciono al buque en el puerto
//		araBouchard.setPosicionActual(posicionTerBsAs);  
//		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs);
//		assertFalse(araBouchard.getEstadoActual().estoyEnEstado("Arrived"));
//		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Arrived"));
//
//	}
//
//	@Test
//	void pasarDelEstadoArrivedAlEstadoWorkingTest() {
//		// Hago que el Buque pase por los dos estados anteriores 
//		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(40.0);
//		araBouchard.setPosicionActual(posicionTerBsAs);  
//		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs); // Aca estoy en estado Arrived
//		bsAs = spy(TerminalPortuaria.class);
//		assertFalse(araBouchard.getEstadoActual().estoyEnEstado("Working"));
//		bsAs.trabajoCargaYDescarga(araBouchard);
//		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Working"));
//		
//	}
//
//	@Test
//	void pasarDelEstadoWorkingAlEstadoDepartingTest() {
//		// Hago que el Buque pase por los dos estados anteriores 
//		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(40.0);
//		araBouchard.setPosicionActual(posicionTerBsAs);  
//		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs); 
//		bsAs = spy(TerminalPortuaria.class);
//		bsAs.trabajoCargaYDescarga(araBouchard);// Aca estoy en estado Working
//		assertFalse(araBouchard.getEstadoActual().estoyEnEstado("Departing"));
//		bsAs.depart(araBouchard);
//		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Departing"));
//		
//	}
//
//	@Test
//	void pasarDelEstadoDepartingAlEstadoOutboundTest() {
//		// Hago que el Buque pase por los dos estados anteriores 
//		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(40.0);
//		araBouchard.setPosicionActual(posicionTerBsAs);  
//		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs); 
//		bsAs = spy(TerminalPortuaria.class);
//		bsAs.trabajoCargaYDescarga(araBouchard);
//		bsAs.depart(araBouchard); // Aca estoy en estado Departing
//		araBouchard.setPosicionActual(posicionAraBouchard);  
//		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(5.0);
//		assertFalse(araBouchard.getEstadoActual().estoyEnEstado("Outbound"));
//		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Outbound"));
//	}

}





