package TerminalPortuaria.Ob2TF.Naviera;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Point;
import java.awt.geom.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Circuito.Tramo;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;
import static org.mockito.Mockito.*;

class NavieraTest
{
	
	// TerminalPortuaria buenosAires = new TerminalPortuaria( new Point2D.Double(-34.61315, -58.37723) );
	/*
	TerminalPortuaria saoPablo = new TerminalPortuaria( new Point2D.Double(-23.5475, -46.63611) );
	TerminalPortuaria montevideo = new TerminalPortuaria( new Point2D.Double(-34.90328, -56.18816) );
	TerminalPortuaria asuncion = new TerminalPortuaria( new Point2D.Double(-25.28646, -57.647) );
	TerminalPortuaria lima = new TerminalPortuaria( new Point2D.Double(-12.04318, -77.02824) );
	TerminalPortuaria santiagoDeChile = new TerminalPortuaria( new Point2D.Double(-33.45694, -70.64827) );
	TerminalPortuaria laPaz = new TerminalPortuaria( new Point2D.Double(-16.5, -68.15) );
	*/
	

	
	
	/*
	@Test
	public void whenITryToCutACarrotThenTrue()
	{
	   Knife knife = mock( Knife.class );
	   doReturn( true ).when( knife ).cut( "carrot" ); // Booleanos
	   

	   assertEquals( knife.cut("carrot"), true );
	}
	*/
	
	// Puertos
	TerminalPortuaria bsAs;
	TerminalPortuaria saoPablo;
	TerminalPortuaria montevideo;
	TerminalPortuaria asuncion;
	TerminalPortuaria lima;
	TerminalPortuaria santiagoDeChile;
	TerminalPortuaria laPaz;
	// TerminalPortuaria longBeach;
	

	
	
	// Circuitos
	Circuito circuito1; // [tramo1, tramo2, tramo3]		-> bsAs - saoPablo - busan - hongKong
	//                               1d         5d       2d        = 8d  
	Circuito circuito2; // [tramo4, tramo5, tramo6]	-> bsAs - cartagena - shanghai - singapur
	//                               3d           5d         1d    = 9d   
	Circuito circuito3; // [tramo7, tramo8, tramo9]	-> bsAs - longBeach - saoPablo - cartagena
	//                               5d          4d          1     = 10d  
	
	
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
	
	
	// 
	List<Naviera> navieras;

	List<Circuito> circuitosN1;
	List<Circuito> circuitosN2;
	List<Circuito> circuitosN3;

	List<Circuito> todoCircuito;
	
	List<Tramo> tramosCir1;
	List<Tramo> tramosCir2;
	List<Tramo> tramosCir3;
	
	// Navieras
	Naviera naviera1; // [circuito1, circuito2]
	Naviera naviera2; // [circuito3]
	
	
	
	@BeforeEach
	void setUp() throws Exception
	{
		//Naviera		
		naviera1 = new Naviera();
		naviera2 = new Naviera();
		
		
		// TerminalPortuaria
		bsAs = mock(TerminalPortuaria.class);
		saoPablo = mock(TerminalPortuaria.class);
		montevideo = mock(TerminalPortuaria.class);
		asuncion = mock(TerminalPortuaria.class);
		lima = mock(TerminalPortuaria.class);
		santiagoDeChile = mock(TerminalPortuaria.class);
		laPaz = mock(TerminalPortuaria.class);
		// longBeach = mock(TerminalPortuaria.class);
		
		//Circuito
		circuito1 = mock(Circuito.class);
		circuito2 = mock(Circuito.class);
		circuito3 = mock(Circuito.class);
		
		//Tramo
		tramo1 = mock(Tramo.class);
		tramo2 = mock(Tramo.class);
		tramo3 = mock(Tramo.class);
		tramo4 = mock(Tramo.class);
		tramo5 = mock(Tramo.class);
		tramo6 = mock(Tramo.class);
		tramo7 = mock(Tramo.class);
		
		// Lista de Circuitos
		circuitosN1 = Arrays.asList(circuito1, circuito2);
		circuitosN2 = Arrays.asList(circuito3); 
		
		todoCircuito = Arrays.asList(circuito1, circuito2, circuito3);
		
		// Lista de Tramos
		tramosCir1 = Arrays.asList(tramo1, tramo2,tramo3);
		tramosCir2 = Arrays.asList(tramo4, tramo5,tramo6);
		tramosCir3 = Arrays.asList(tramo7,tramo8,tramo9);
		
		/*
		TerminalPortuaria saoPablo = new TerminalPortuaria( new Point2D.Double(-23.5475, -46.63611) );
		TerminalPortuaria montevideo = new TerminalPortuaria( new Point2D.Double(-34.90328, -56.18816) );
		TerminalPortuaria asuncion = new TerminalPortuaria( new Point2D.Double(-25.28646, -57.647) );
		TerminalPortuaria lima = new TerminalPortuaria( new Point2D.Double(-12.04318, -77.02824) );
		TerminalPortuaria santiagoDeChile = new TerminalPortuaria( new Point2D.Double(-33.45694, -70.64827) );
		TerminalPortuaria laPaz = new TerminalPortuaria( new Point2D.Double(-16.5, -68.15) );
		*/	
		// Ubicación terminales
		
		// getUbicacion()
		when(bsAs.getUbicacion()).thenReturn( new Point2D.Double(-23.5475, -46.63611) );
		when(saoPablo.getUbicacion()).thenReturn( new Point2D.Double(-34.61315, -58.37723) );
		when(montevideo.getUbicacion()).thenReturn( new Point2D.Double(-34.90328, -56.18816) );
		when(asuncion.getUbicacion()).thenReturn( new Point2D.Double(-25.28646, -57.647) );
		when(lima.getUbicacion()).thenReturn( new Point2D.Double(-12.04318, -77.02824) );
		when(santiagoDeChile.getUbicacion()).thenReturn( new Point2D.Double(-33.45694, -70.64827) );
		when(laPaz.getUbicacion()).thenReturn( new Point2D.Double(-16.5, -68.15) );
		
		// Tramos
		
		when( tramo1.getPuertoDestino() )
		
		
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
