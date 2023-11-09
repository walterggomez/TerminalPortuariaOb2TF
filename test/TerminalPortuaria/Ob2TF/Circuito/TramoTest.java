package TerminalPortuaria.Ob2TF.Circuito;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*; // Debe tener los paquetes de mockito en el 
import TerminalPortuaria.Ob2TF.TerminalP.*;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import static org.mockito.Mockito.*;
import TerminalPortuaria.Ob2TF.Buque.*;

/*
		Buque carguero del cual tomamos como velocidad 40 km/h
 		La distancia entre Buenos Aires y Sao Pablo debería ser de 1696 km, por ende el buque debería demorar en llegar 49 horas aprox
 */

class TramoTest
{
	public static void main(String[] args)
	{
		// return this.fechaYHoraSalida.plus(this.duracionTramo, ChronoUnit.HOURS);
		
		TerminalPortuaria buenosAires = new TerminalPortuaria( new Point2D.Double(-23.5475, -46.63611) );
		TerminalPortuaria saoPablo = new TerminalPortuaria( new Point2D.Double(-34.61315, -58.37723) );
		Tramo tramo1 = new Tramo( buenosAires, saoPablo, LocalDateTime.of(1980, 12, 18, 07, 00), 1500 );


		System.out.println( GPS.distanciaEntrePuntos(buenosAires.getUbicacion(), saoPablo.getUbicacion()) );
		System.out.println( tramo1.mostrarFechaYHoraLlegada() );

	}
	
	// Puertos
	TerminalPortuaria bsAs;
	TerminalPortuaria saoPablo;
	TerminalPortuaria montevideo;
	TerminalPortuaria asuncion;
	TerminalPortuaria lima;
	TerminalPortuaria santiagoDeChile;
	TerminalPortuaria laPaz;
	
	// Tramos
	Tramo tramo1; // bsAs-saoPablo
	Tramo tramo2; // saoPablo-busan
	Tramo tramo3; // busan-hongKong
	
	Tramo tramo4; // bsAs-cartagena
	Tramo tramo5; // cartagena-shanghai
	Tramo tramo6; // shanghai-singapur
	
	Tramo tramo7; // bsAs-longBeach
	Tramo tramo8; // longBeach-saoPablo
	Tramo tramo9; // saoPablo-cartagena

	@BeforeEach
	void setUp() throws Exception
	{
		// Tramos

		
		
		// Mocks de las terminales
		bsAs = mock(TerminalPortuaria.class);
		saoPablo = mock(TerminalPortuaria.class);
		montevideo = mock(TerminalPortuaria.class);
		asuncion = mock(TerminalPortuaria.class);
		lima = mock(TerminalPortuaria.class);
		santiagoDeChile = mock(TerminalPortuaria.class);
		laPaz = mock(TerminalPortuaria.class);
		
		// getUbicacion() de las terminales
		when(bsAs.getUbicacion()).thenReturn( new Point2D.Double(-23.5475, -46.63611) );
		when(saoPablo.getUbicacion()).thenReturn( new Point2D.Double(-34.61315, -58.37723) );
		when(montevideo.getUbicacion()).thenReturn( new Point2D.Double(-34.90328, -56.18816) );
		when(asuncion.getUbicacion()).thenReturn( new Point2D.Double(-25.28646, -57.647) );
		when(lima.getUbicacion()).thenReturn( new Point2D.Double(-12.04318, -77.02824) );
		when(santiagoDeChile.getUbicacion()).thenReturn( new Point2D.Double(-33.45694, -70.64827) );
		when(laPaz.getUbicacion()).thenReturn( new Point2D.Double(-16.5, -68.15) );
		
		
		tramo1 = new Tramo( bsAs, saoPablo, LocalDateTime.of(1980, 12, 18, 07, 00), 1500 );


	}
	
	@Test
	void tramo1TieneUnaDuracionDe42Horas()
	{
		assertEquals( 42, tramo1.getDuracionTramo() );
	}
	
	@Test
	void elViajeDelTramoBuenosAiresSaoPabloConUnaDuracionDe42HorasLlegaElDia20Mes12Año1980ALas01Hs00Min()
	{
		assertEquals( LocalDateTime.of(1980, 12, 20, 01, 00), tramo1.getFechaYHoraLlegada() );
	}
	
	
	
	
	
	/*
	@Test
	void viajeTramoConDuracion1HoraDevuelveFechaYHoraLlegada()
	{
		Tramo tramoConDuracion1Hora = new Tramo(buenosAires, saoPablo, LocalDateTime.of(2023, 11, 05, 17, 10), 1, 1000);
		assertEquals( LocalDateTime.of(1980, 20, 12, 00, 00), tramoConDuracion1Hora.getFechaYHoraLlegada() );
	}
	*/

	
/*
	 Test double:
	Arroja un error en el when, investigar de qué forma se utiliza el framework mockito.
	
	// Setup
	// DOC: doubles
	TerminalPortuaria buenosAires = mock(TerminalPortuaria.class);
	TerminalPortuaria saoPablo = mock(TerminalPortuaria.class);	

	// SUT
	Tramo buenosAiresSaoPablo = new Tramo( buenosAires, saoPablo, LocalDateTime.of(2023, 11, 05, 17, 10), 49, 1000 );

	buenosAiresSaoPablo.fechaYHoraLlegada();
	LocalDateTime fechaEsperada = LocalDateTime.of(2023, 12, 24, 17, 10);
	when( buenosAiresSaoPablo.fechaYHoraLlegada() ).thenReturn( fechaEsperada );

	buenosAiresSaoPablo.fechaYHoraLlegada();	
*/
	
	
	
	
}
