package TerminalPortuaria.Ob2TF.Buque;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class BuqueTest {
	
	
	Inbound nuevoEstado;
	
	Buque araBouchard;
	
	TerminalPortuaria bsAs;
	TerminalPortuaria hongKong;
	
	Point2D posicionAraBouchard;
	Point2D posicionTerBsAs;
	
	Viaje viajeBsAsHongKong;
	
	GPS garminDrive;
	
	/*public static void main(String[] args)
	{
		final Buque buquebus = new Buque();
		final Buque buquebus2 = new Buque();
		
		buquebus.setPosicionActual(5, 9);
		buquebus2.setPosicionActual(10, 4);
		
		System.out.println( GPS.distanciaEntrePuntos(buquebus.getPosicionActual(), buquebus2.getPosicionActual()) );
	}*/
	@BeforeEach
	void setUp() throws Exception{
		garminDrive = mock(GPS.class);
		
		bsAs = mock(TerminalPortuaria.class);
		hongKong = mock(TerminalPortuaria.class);
		
		viajeBsAsHongKong = mock(Viaje.class);
		
		posicionAraBouchard = mock(Point2D.class);
		posicionTerBsAs = mock(Point2D.class);
		
		araBouchard = new Buque(posicionAraBouchard,garminDrive,viajeBsAsHongKong);
		
		
		when(viajeBsAsHongKong.getpuertoDestino()).thenReturn(hongKong);
		when(garminDrive.distanciaEntrePuntos(posicionAraBouchard, posicionTerBsAs)).thenReturn(40.0);
		
	}
	@Test
	void getMiGpsTest() {
		assertEquals(garminDrive,araBouchard.getMiGps());
	}
	@Test
	void getViajeActualTest() {
		assertEquals(viajeBsAsHongKong,araBouchard.getViajeActual());
	}
	@Test
	void puertoDestinoTest() {
		assertEquals(hongKong,araBouchard.puertoDestino());
	}
	@Test
	void getPosicionActualTest() {
		assertEquals(posicionAraBouchard,araBouchard.getPosicionActual());
	}
	@Test
	void actualizarEstadoTest() { // El buque se esta acercando a la terminal portuaria
		nuevoEstado = new Inbound();
		araBouchard.actualizarEstado();
		assertEquals(nuevoEstado,araBouchard.getEstadoActual());
		
		
	}

	
	
}
