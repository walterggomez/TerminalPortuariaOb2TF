package TerminalPortuaria.Ob2TF.Circuito;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class ViajeTest 
{
	
	// Circuitos
	Circuito circuito1;
	Circuito circuito2;
	Circuito circuito3;
	
	
	// Puertos
	TerminalPortuaria bsAs;
	TerminalPortuaria saoPablo;
	TerminalPortuaria montevideo;
	TerminalPortuaria asuncion;
	TerminalPortuaria lima;
	TerminalPortuaria santiagoDeChile;
	TerminalPortuaria laPaz;

	
	// Tramos que conforman circuito 1°.
	Tramo bsAsSaoPablo;
	Tramo saoPabloMontevideo;
	Tramo montevideoAsuncion;
	Tramo asuncionLima; 
	Tramo limaSantiagoDeChile;
	Tramo santiagoDeChileLaPaz;
	
	// Tramos que conforman cirucito 2°
	Tramo saoPabloLima;
	// Tramo limaSantiagoDeChile; 
	Tramo santiagoDeChileMontevideo; 
	Tramo montevideoBsAs;
	Tramo bsAsLaPaz;
	Tramo laPazAsuncion;
	
	// Tramos que conforman circuito 3°
	Tramo limaBsAs;
	Tramo bsAsSantiagoDeChile;
	Tramo santiagoDeChileAsuncion;
	Tramo asuncionSaoPablo;
	// Tramo saoPabloMontevideo;
	Tramo montevideoLaPaz;
	
	// Listas de tramos
	List<Tramo> listaTramosNro1;
	List<Tramo> listaTramosNro2;
	List<Tramo> listaTramosNro3;
	List<Tramo> listaTramosReducida;
	
	
	// Navieras
	Naviera naviera1;
	Naviera naviera2;
	Naviera naviera3;
	
	// Buques
	Buque buque1;
	Buque buque2;
	Buque buque3;
	
	
	// Viaje
	Viaje viajeCircuito1PrimeraFecha;
	Viaje viajeCircuito1Reducido;
	
	Viaje viajeCircuito1SegundaFecha;
	Viaje viajeCircuito2;
	Viaje viajeCircuito3;

	
	
	@BeforeEach
	void setUp() throws Exception 
	{
		// Mocks de las terminales
		bsAs = mock(TerminalPortuaria.class);
		saoPablo = mock(TerminalPortuaria.class);
		montevideo = mock(TerminalPortuaria.class);
		asuncion = mock(TerminalPortuaria.class);
		lima = mock(TerminalPortuaria.class);
		santiagoDeChile = mock(TerminalPortuaria.class);
		laPaz = mock(TerminalPortuaria.class);
		
		// getUbicacion() de las terminales
		when(bsAs.getUbicacion()).thenReturn( new Point2D.Double(-34.61315, -58.37723) );
		when(saoPablo.getUbicacion()).thenReturn( new Point2D.Double(-23.5475, -46.63611) );
		when(montevideo.getUbicacion()).thenReturn( new Point2D.Double(-34.90328, -56.18816) );
		when(asuncion.getUbicacion()).thenReturn( new Point2D.Double(-25.28646, -57.647) );
		when(lima.getUbicacion()).thenReturn( new Point2D.Double(-12.04318, -77.02824) );
		when(santiagoDeChile.getUbicacion()).thenReturn( new Point2D.Double(-33.45694, -70.64827) );
		when(laPaz.getUbicacion()).thenReturn( new Point2D.Double(-16.5, -68.15) );
		
		// Mock buques
		buque1 = mock( Buque.class );
		buque2 = mock( Buque.class );
		buque3 = mock( Buque.class );
		
		
		// Spy de los tramos del circuito 1°
		bsAsSaoPablo = spy( new Tramo() );
		saoPabloMontevideo = spy( new Tramo() );
		montevideoAsuncion = spy( new Tramo() );
		asuncionLima = spy( new Tramo() );
		limaSantiagoDeChile = spy( new Tramo() );
		santiagoDeChileLaPaz = spy( new Tramo() );
		
		// Spy de los tramos del circuito 2°
		saoPabloLima = spy( new Tramo() );
		// limaSantiagoDeChile = spy( new Tramo() );
		santiagoDeChileMontevideo = spy( new Tramo() );
		montevideoBsAs = spy( new Tramo() );
		bsAsLaPaz = spy( new Tramo() );
		laPazAsuncion = spy( new Tramo() );
		
		// Spy de los tramos del circuito 3°
		limaBsAs = spy( new Tramo() );
		bsAsSantiagoDeChile = spy( new Tramo() );
		santiagoDeChileAsuncion = spy( new Tramo() );
		asuncionSaoPablo = spy( new Tramo() );
		// saoPabloMontevideo = spy( new Tramo() );
		montevideoLaPaz = spy( new Tramo() );
		

		// Tramo a agregar, sin continuidad con el último puerto del circuito
		asuncionSaoPablo = spy( Tramo.class );
		when( asuncionSaoPablo.getPuertoOrigen() ).thenReturn(asuncion);
		when( asuncionSaoPablo.getPuertoDestino() ).thenReturn(saoPablo);
		
		
		// Tramo a agregar el cual coincide con el último puerto del circuito
		laPazAsuncion = spy( Tramo.class );
		when( laPazAsuncion.getPuertoOrigen() ).thenReturn(laPaz);
		when( laPazAsuncion.getPuertoDestino() ).thenReturn(asuncion);
		
		
		// Puertos de los tramos
		when( bsAsSaoPablo.getPuertoOrigen() ).thenReturn(bsAs);
		when( bsAsSaoPablo.getPuertoDestino() ).thenReturn(saoPablo);
		when( saoPabloMontevideo.getPuertoOrigen() ).thenReturn(saoPablo);
		when( saoPabloMontevideo.getPuertoDestino() ).thenReturn(montevideo);
		when( montevideoAsuncion.getPuertoOrigen() ).thenReturn(montevideo);
		when( montevideoAsuncion.getPuertoDestino() ).thenReturn(asuncion);
		when( asuncionLima.getPuertoOrigen() ).thenReturn(asuncion);
		when( asuncionLima.getPuertoDestino() ).thenReturn(lima);
		when( limaSantiagoDeChile.getPuertoOrigen() ).thenReturn(lima);
		when( limaSantiagoDeChile.getPuertoDestino() ).thenReturn(santiagoDeChile);
		when( santiagoDeChileLaPaz.getPuertoOrigen() ).thenReturn(santiagoDeChile);
		when( santiagoDeChileLaPaz.getPuertoDestino() ).thenReturn(laPaz);

		
		// Duración de los tramos
		when( bsAsSaoPablo.getDuracionTramo() ).thenReturn(1.0);
		when( saoPabloMontevideo.getDuracionTramo() ).thenReturn(1.0);
		when( montevideoAsuncion.getDuracionTramo() ).thenReturn(1.0);
		when( asuncionLima.getDuracionTramo() ).thenReturn(1.0);
		when( limaSantiagoDeChile.getDuracionTramo() ).thenReturn(1.0);
		when( santiagoDeChileLaPaz.getDuracionTramo() ).thenReturn(1.0);
		
		
		// Costos de los tramos
		when( bsAsSaoPablo.getCostoDetramo() ).thenReturn(1.0);
		when( saoPabloMontevideo.getCostoDetramo() ).thenReturn(1.0);
		when( montevideoAsuncion.getCostoDetramo() ).thenReturn(1.0);
		when( asuncionLima.getCostoDetramo() ).thenReturn(1.0);
		when( limaSantiagoDeChile.getCostoDetramo() ).thenReturn(1.0);
		when( santiagoDeChileLaPaz.getCostoDetramo() ).thenReturn(1.0);
		
		// TerminalPortuaria montevideo = new TerminalPortuaria( new Point2D.Double(-34.90328, -56.18816) );
		// TerminalPortuaria santiagoDeChile = new TerminalPortuaria( new Point2D.Double(-33.45694, -70.64827) );
		
		
		// Lista de tramos 1°
		listaTramosNro1 = new ArrayList<Tramo> // Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						bsAsSaoPablo, saoPabloMontevideo, montevideoAsuncion, asuncionLima, limaSantiagoDeChile, santiagoDeChileLaPaz
				)
		);
		

		// Lista de tramos 2°
		listaTramosNro2 = new ArrayList<Tramo> // Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						saoPabloLima, limaSantiagoDeChile, santiagoDeChileMontevideo, montevideoBsAs, bsAsLaPaz, laPazAsuncion
				)
		);
		
		
		// Lista de tramos 3°
		listaTramosNro3 = new ArrayList<Tramo> // Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						limaBsAs, bsAsSantiagoDeChile, santiagoDeChileAsuncion, asuncionSaoPablo, saoPabloMontevideo, montevideoLaPaz
				)
		);
		
		
		// Lista de tramos nro 1° reducida a dos tramos
		listaTramosReducida = new ArrayList<Tramo> // Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						montevideoAsuncion, asuncionLima
				)
		);

	
		// Spy de los circuitos
		circuito1 = spy( new Circuito(listaTramosNro1, LocalDateTime.now()) );
		circuito2 = spy( new Circuito(listaTramosNro2, LocalDateTime.now()) );
		circuito3 = spy( new Circuito(listaTramosNro3, LocalDateTime.now()) );
		
		
		// 	public Viaje( Buque buqueViaje, Circuito circuitoViaje, LocalDateTime fechaDeSalida)
		// Viajes
		viajeCircuito1PrimeraFecha = new Viaje( buque1, circuito1, LocalDateTime.of(2023, 11, 05, 13, 00) );
		viajeCircuito1SegundaFecha = new Viaje( buque1, circuito1, LocalDateTime.of(2023, 12, 05, 13, 00) );
				
//		viajeCircuito2 = new Viaje(  );
//		
//		viajeCircuito3 = new Viaje(  );
		
		
		// Creamos un viaje con un circuito que solo contenga a las terminales de interés ...
		viajeCircuito1Reducido = viajeCircuito1PrimeraFecha.generarViajeConTramosDeInteres( montevideo, lima );
		
	}
	
	@Test
	void fechaLlegadaViajePrimeraFechaMismoDiaALas19Hs()
	{
		assertEquals( LocalDateTime.of(2023, 11, 05, 19, 00), viajeCircuito1PrimeraFecha.getFechaDeLlegada() );
	}
	
	@Test
	void viajeCircuito1ReducidoContieneLosTramosMontevideoAsuncionYAsuncionLima()
	{	
		assertEquals( listaTramosReducida, viajeCircuito1Reducido.getCircuito().getListaDeTramo() );
	}
	
	@Test
	void fechaSalidaViajeTramoReducidoSeCorrespondeAFechaSalidaTramoCorrespondienteAlViajeOriginal()
	{
		LocalDateTime fechaTramoOriginal = viajeCircuito1PrimeraFecha.getCircuito().getListaDeTramo().get(2).getFechaYHoraSalida();
		LocalDateTime fechaViajeReducido = viajeCircuito1Reducido.getFechaDeSalida();
		assertEquals( fechaTramoOriginal,  fechaViajeReducido);
	}
	
	@Test
	void duracionViajeReducidoEsDe2HorasPorContenerDosTramos()
	{
		assertEquals( 2, viajeCircuito1Reducido.duracionViaje() );
	}
	
	@Test
	void cantidadEscalasDeViajeReducidoEsDe2()
	{
		assertEquals( 1, viajeCircuito1Reducido.cantidadEscalas() );
	}
	
	@Test
	void validarQueCostoDelViajeReducidoSea2()
	{
		assertEquals( 2.0, viajeCircuito1Reducido.costoViaje(), 0 ); // El cero es la máxima diferencia permitida.
	}
	
	@Test
	void validarQueTerminalExistaEnViaje()
	{
		assertTrue( viajeCircuito1PrimeraFecha.validarSiTerminalExisteEnViaje(montevideo) );
	}
	
	
}
