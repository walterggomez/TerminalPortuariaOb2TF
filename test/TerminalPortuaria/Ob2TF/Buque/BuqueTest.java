package TerminalPortuaria.Ob2TF.Buque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class BuqueTest {

	Buque araBouchard;

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
		garminDrive = mock(GPS.class);

		bsAs = mock(TerminalPortuaria.class);
		hongKong = mock(TerminalPortuaria.class);

		viajeBsAsHongKong = mock(Viaje.class);
		viajeHongKongMadrid = mock(Viaje.class);

		posicionAraBouchard = mock(Point2D.class);
		posicionTerBsAs = mock(Point2D.class);

		araBouchard = new Buque(posicionAraBouchard, garminDrive, viajeBsAsHongKong);

		when(viajeBsAsHongKong.getpuertoDestino()).thenReturn(bsAs);
		when(viajeBsAsHongKong.getpuertoOrigen()).thenReturn(bsAs);
		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs);

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
	void estoyEnEstadoOutboundTest() {
		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Outbound"));

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
	void pasarDelEstadoOutboundAlEstadoInboundTest() {
		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(40.0);
		assertFalse(araBouchard.getEstadoActual().estoyEnEstado("Inbound"));
		araBouchard.actualizarEstado();
		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Inbound"));

	}

	@Test
	void pasarDelEstadoInboundAlEstadoArrivedTest() {
		// Primero paso al Estado Inbound
		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(40.0);
		araBouchard.actualizarEstado();
		// Posiciono al buque en el puerto
		araBouchard.setPosicionActual(posicionTerBsAs);  
		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs);
		assertFalse(araBouchard.getEstadoActual().estoyEnEstado("Arrived"));
		araBouchard.actualizarEstado();
		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Arrived"));

	}

	@Test
	void pasarDelEstadoArrivedAlEstadoWorkingTest() {
		// Hago que el Buque pase por los dos estados anteriores 
		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(40.0);
		araBouchard.actualizarEstado();
		araBouchard.setPosicionActual(posicionTerBsAs);  
		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs);
		araBouchard.actualizarEstado(); // Aca estoy en estado Arrived
		bsAs = spy(TerminalPortuaria.class);
		assertFalse(araBouchard.getEstadoActual().estoyEnEstado("Working"));
		bsAs.trabajoCargaYDescarga(araBouchard);
		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Working"));
		
	}

	@Test
	void pasarDelEstadoWorkingAlEstadoDepartingTest() {
		// Hago que el Buque pase por los dos estados anteriores 
		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(40.0);
		araBouchard.actualizarEstado();
		araBouchard.setPosicionActual(posicionTerBsAs);  
		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs);
		araBouchard.actualizarEstado(); 
		bsAs = spy(TerminalPortuaria.class);
		bsAs.trabajoCargaYDescarga(araBouchard);// Aca estoy en estado Working
		assertFalse(araBouchard.getEstadoActual().estoyEnEstado("Departing"));
		bsAs.depart(araBouchard);
		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Departing"));
		
	}

	@Test
	void pasarDelEstadoDepartingAlEstadoOutboundTest() {
		// Hago que el Buque pase por los dos estados anteriores 
		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(40.0);
		araBouchard.actualizarEstado();
		araBouchard.setPosicionActual(posicionTerBsAs);  
		when(bsAs.getUbicacion()).thenReturn(posicionTerBsAs);
		araBouchard.actualizarEstado(); 
		bsAs = spy(TerminalPortuaria.class);
		bsAs.trabajoCargaYDescarga(araBouchard);
		bsAs.depart(araBouchard); // Aca estoy en estado Departing
		araBouchard.setPosicionActual(posicionAraBouchard);  
		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(5.0);
		assertFalse(araBouchard.getEstadoActual().estoyEnEstado("Outbound"));
		araBouchard.actualizarEstado(); 
		assertTrue(araBouchard.getEstadoActual().estoyEnEstado("Outbound"));
	}

}





