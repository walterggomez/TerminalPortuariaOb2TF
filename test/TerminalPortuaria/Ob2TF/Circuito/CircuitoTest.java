package TerminalPortuaria.Ob2TF.Circuito;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TerminalPortuaria.Ob2TF.Buque.GPS;
import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class CircuitoTest 
{
/*
	Lista de tests a crear en circuito:
	- Agregar tramo > OK.
	
	- Evaluar duración de cada tramo y sumarlo. Testear que sea igual a la duración del circuito > OK.
	
	- Evaluar fecha de inicio y fecha de final > OK.
	
	- Evaluar método para extraer circuito desde cierto tramo, creando un nuevo circuito que solo incluya ese tramo.
	
	- Evaluar excepción al agregar tramo... el último tramo del circuito debe tener como puerto de destino al puerto de origen del tramo
		que quiero agregar. OK.
*/
	
	public static void main(String[] args)
	{
		// return this.fechaYHoraSalida.plus(this.duracionTramo, ChronoUnit.HOURS);
		
	
		
		TerminalPortuaria bsAs = new TerminalPortuaria( new Point2D.Double(-34.61315, -58.37723) );
		TerminalPortuaria saoPablo = new TerminalPortuaria( new Point2D.Double(-23.5475, -46.63611) );
		TerminalPortuaria montevideo = new TerminalPortuaria( new Point2D.Double(-34.90328, -56.18816) );
		TerminalPortuaria asuncion = new TerminalPortuaria( new Point2D.Double(-25.28646, -57.647) );
		TerminalPortuaria lima = new TerminalPortuaria( new Point2D.Double(-12.04318, -77.02824) );
		TerminalPortuaria santiagoDeChile = new TerminalPortuaria( new Point2D.Double(-33.45694, -70.64827) );
		TerminalPortuaria laPaz = new TerminalPortuaria( new Point2D.Double(-16.5, -68.15) );

		Tramo bsAsSaoPablo = new Tramo(bsAs, saoPablo, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0 );
		Tramo saoPabloMontevideo  = new Tramo(saoPablo, montevideo, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0 );
		Tramo montevideoAsuncion  = new Tramo(montevideo, asuncion, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0 );
		Tramo asuncionLima  = new Tramo(asuncion, lima, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0 );
		Tramo limaSantiagoDeChile  = new Tramo(lima, santiagoDeChile, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0 );
		Tramo santiagoDeChileLaPaz  = new Tramo(santiagoDeChile, laPaz, LocalDateTime.of(1980, 12, 18, 13, 00), 10.0 );
		
		
		List<Tramo> listaTramosNro1 = Arrays.asList
				(
						bsAsSaoPablo, saoPabloMontevideo, montevideoAsuncion, asuncionLima, limaSantiagoDeChile, santiagoDeChileLaPaz
				);

		System.out.println( bsAsSaoPablo.getDuracionTramo() );
		System.out.println( bsAsSaoPablo.mostrarFechaYHoraSalida() );
		System.out.println( bsAsSaoPablo.mostrarFechaYHoraLlegada() );
		
		Circuito circuito1 = new Circuito( listaTramosNro1, LocalDateTime.of(2023, 10, 5, 12, 00) );
		
		System.out.println( circuito1.getListaDeTramo().get(0).mostrarFechaYHoraSalida() );
		System.out.println( circuito1.getListaDeTramo().get(0).mostrarFechaYHoraLlegada() );
		
		// System.out.println( circuito1.getListaDeTramo().get(0).mostrarFechaYHoraLlegada() );
		
		// System.out.println( circuito1.getFechaYHoraLlegada() );
		// System.out.println( buenosAiresSaoPablo.getFechaYHoraLlegada() );	
	}
	
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
	Tramo montevideoBuenosAires;
	Tramo buenosAiresLaPaz;
	Tramo laPazAsuncion;
	
	// Tramos que conforman circuito 3°
	Tramo limaBuenosAires;
	Tramo buenosAiresSantiagoDeChile;
	Tramo santiagoDeChileAsuncion;
	Tramo asuncionSaoPablo;
	// Tramo saoPabloMontevideo;
	Tramo montevideoLaPaz;
	
	// Listas de tramos
	List<Tramo> listaTramosNro1;
	List<Tramo> listaTramosNro2;
	List<Tramo> listaTramosNro3;
	
	
	/*
	 		bsAs = mock(TerminalPortuaria.class);
			saoPablo = mock(TerminalPortuaria.class);
			montevideo = mock(TerminalPortuaria.class);
			asuncion = mock(TerminalPortuaria.class);
			lima = mock(TerminalPortuaria.class);
			santiagoDeChile = mock(TerminalPortuaria.class);
			laPaz = mock(TerminalPortuaria.class);
	 */

/*
	List<Naviera> navieras;

	List<Circuito> circuitosN1;
	List<Circuito> circuitosN2;
	List<Circuito> circuitosN3;

	List<Circuito> todoCircuito;

	List<Tramo> tramosCir1;
	List<Tramo> tramosCir2;
	List<Tramo> tramosCir3;
*/

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
		
		
		// Spy de los tramos
		bsAsSaoPablo = spy( Tramo.class );
		saoPabloMontevideo = spy( Tramo.class );
		montevideoAsuncion = spy( Tramo.class );
		asuncionLima = spy( Tramo.class );
		limaSantiagoDeChile = spy( Tramo.class );
		// Último tramo del circuito
		santiagoDeChileLaPaz = spy( Tramo.class );
		when( santiagoDeChileLaPaz.getPuertoOrigen() ).thenReturn(santiagoDeChile);
		when( santiagoDeChileLaPaz.getPuertoDestino() ).thenReturn(laPaz);
		
		
		// Tramo a agregar, sin continuidad con el último puerto del circuito
		asuncionSaoPablo = spy( Tramo.class );
		when( asuncionSaoPablo.getPuertoOrigen() ).thenReturn(asuncion);
		when( asuncionSaoPablo.getPuertoDestino() ).thenReturn(saoPablo);
		
		// Tramo a agregar el cual coincide con el último puerto del circuito
		laPazAsuncion = spy( Tramo.class );
		when( laPazAsuncion.getPuertoOrigen() ).thenReturn(laPaz);
		when( laPazAsuncion.getPuertoDestino() ).thenReturn(asuncion);
		
		
		
		
		when( bsAsSaoPablo.getDuracionTramo() ).thenReturn(10.0);
		when( saoPabloMontevideo.getDuracionTramo() ).thenReturn(10.0);
		when( montevideoAsuncion.getDuracionTramo() ).thenReturn(10.0);
		when( asuncionLima.getDuracionTramo() ).thenReturn(10.0);
		when( limaSantiagoDeChile.getDuracionTramo() ).thenReturn(10.0);
		when( santiagoDeChileLaPaz.getDuracionTramo() ).thenReturn(10.0);
		
		// Lista de tramos
		listaTramosNro1 = new ArrayList<Tramo> // Al instanciar un ArrayList permito utilizar las operaciones de manejo de arrays.
		(
				Arrays.asList // Arrays.asList crea una vista de la lista, pero no permite modificaciones.
				(
						bsAsSaoPablo, saoPabloMontevideo, montevideoAsuncion, asuncionLima, limaSantiagoDeChile, santiagoDeChileLaPaz
				)
		);
		
		listaTramosNro2 = new ArrayList<Tramo>();
		
		// Circuitos
		circuito1 = new Circuito( listaTramosNro1, LocalDateTime.of(2023, 11, 18, 11, 00) );
		
	}
	
	// AssertEquals( Expected, Actual )
	@Test
	void seteoFechaDeSalidaEnTramo() 
	{
		bsAsSaoPablo.setFechaYHoraSalida( LocalDateTime.of(1980, 12, 18, 17, 00) );
		assertEquals( LocalDateTime.of(1980, 12, 18, 17, 00), bsAsSaoPablo.getFechaYHoraSalida() );
	}

	@Test
	void laDuracionDelCircuitoEsLaSumaDeLaDuracionDeTodosSusTramos()
	{
		assertEquals( 60.0, circuito1.duracionCircuito() );
	}
	
	@Test
	void laFechaYHoraDeSalidaDelCircuito1EsEl18Del11Del2023ALas11Horas00Minutos()
	{
		assertEquals( LocalDateTime.of(2023, 11, 18, 11, 00), circuito1.getFechaYHoraSalida() );
	}
	
	@Test
	void laFechaYHoraDeSalidaDelPrimerTramoDelCircuito1EsEl20Del11Del2023ALas11Horas00Minutos()
	{
		assertEquals( LocalDateTime.of(2023, 11, 18, 11, 00), circuito1.getListaDeTramo().get(0).getFechaYHoraSalida() );
	}
	
	@Test
	void laFechaYHoraDeLlegadaDelPrimerTramoDelCircuito1EsEl18Del11Del2023ALas21Horas00Minutos()
	{
		assertEquals( LocalDateTime.of(2023, 11, 18, 21, 00), circuito1.getListaDeTramo().get(0).getFechaYHoraLlegada() );
	}
	
	@Test
	void laFechaYHoraDeLlegadaDelUltimoTramoDelCircuito1EsEl20Del11Del2023ALas23Horas00Minutos()
	{
		assertEquals( LocalDateTime.of(2023, 11, 20, 23, 00), circuito1.getListaDeTramo().get(5).getFechaYHoraLlegada() );
	}
	
	@Test
	void laFechaYHoraDeLlegadaDelCircuito1EsEl20Del11Del2023ALas23Horas00Minutos()
	{
		assertEquals( LocalDateTime.of(2023, 11, 20, 23, 00), circuito1.getFechaYHoraLlegada() );
	}
	
	@Test
	void lanzarExcepciónAlAgregarTramoCuyoPuertoOrigenNoCoincideConElPuertoDestinoDelCircuito() throws Exception
	{
		Exception error = assertThrows( Exception.class, () -> 
		{
			circuito1.agregarNuevoTramo(asuncionSaoPablo);
		} );
		
		assertEquals( "El puerto de origen del tramo a agregar no coincide con el puerto destino del último tramo de la lista.", error.getMessage() );
	}
	
	@Test
	void agregoTramoAListaDeTramosVacía() throws Exception
	{
		circuito2 = new Circuito( listaTramosNro2, LocalDateTime.of(2023, 11, 18, 11, 00) );
		circuito2.agregarNuevoTramo(asuncionSaoPablo);
	}
	
	@Test
	void agregoTramoCuyoPuertoOrigenCoincideConPuertoDestinoDelUltimoTramoDelCircuito() throws Exception
	{
		circuito1.agregarNuevoTramo(laPazAsuncion);
	}
	

	
	

}
