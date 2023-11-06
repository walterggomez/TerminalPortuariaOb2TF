package TerminalPortuaria.Ob2TF.Circuito;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*; // Debe tener los paquetes de mockito en el 
import TerminalPortuaria.Ob2TF.TerminalP.*;
import java.awt.Point;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/*
		Buque carguero del cual tomamos como velocidad 40 km/h
 		La distancia entre Buenos Aires y Sao Pablo debería ser de 1696 km, por ende el buque debería demorar en llegar 49 horas aprox
 */

class TramoTest
{
	public static void main(String[] args)
	{
		// return this.fechaYHoraSalida.plus(this.duracionTramo, ChronoUnit.HOURS);
		
		TerminalPortuaria buenosAires = new TerminalPortuaria( new Point(-34, -58) );
		TerminalPortuaria saoPablo = new TerminalPortuaria( new Point(-23, -46) );
		Tramo buenosAiresSaoPablo = new Tramo( buenosAires, saoPablo, LocalDateTime.of(2023, 11, 05, 17, 10), 49, 1000 );
		
		System.out.println( buenosAiresSaoPablo.getFechaYHoraSalida() );
		System.out.println( buenosAiresSaoPablo.getFechaYHoraLlegada() );	
	}
	
	// Terminales portuarias
	TerminalPortuaria buenosAires;
	TerminalPortuaria saoPablo;
	
	// Tramos
	Tramo buenosAiresSaoPablo;
	
	
	@BeforeEach
	void setUp() throws Exception
	{

		
		buenosAires = new TerminalPortuaria( new Point(-34, -58) );
		saoPablo = new TerminalPortuaria( new Point(-23, -46) );
		buenosAiresSaoPablo = new Tramo( buenosAires, saoPablo, LocalDateTime.of(2023, 11, 05, 17, 10), 49, 1000 );

	}
	
	
	//	7/11/2023 (Martes), 18:00:00
	@Test
	void elViajeDelTramoBuenosAiresSaoPabloConUnaDuracionDe49HorasLlegaElDia07Mes11Año2023Hs18Hs()
	{
		assertEquals( LocalDateTime.of(2023, 11, 07, 18, 10), buenosAiresSaoPablo.getFechaYHoraLlegada() );
	}
	
	@Test
	void viajeTramoConDuracion1HoraDevuelveFechaYHoraLlegada()
	{
		Tramo tramoConDuracion1Hora = new Tramo(buenosAires, saoPablo, LocalDateTime.of(2023, 11, 05, 17, 10), 1, 1000);
		assertEquals( LocalDateTime.of(2023, 11, 05, 18, 10), tramoConDuracion1Hora.getFechaYHoraLlegada() );
	}

	
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
