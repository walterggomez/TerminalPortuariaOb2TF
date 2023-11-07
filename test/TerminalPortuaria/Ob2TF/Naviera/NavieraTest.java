package TerminalPortuaria.Ob2TF.Naviera;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Point;
import java.awt.geom.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

class NavieraTest
{
	
	TerminalPortuaria buenosAires = new TerminalPortuaria( new Point2D.Double(-34.61315, -58.37723) );
	TerminalPortuaria saoPablo = new TerminalPortuaria( new Point2D.Double(-23.5475, -46.63611) );
	TerminalPortuaria montevideo = new TerminalPortuaria( new Point2D.Double(-34.90328, -56.18816) );
	TerminalPortuaria asuncion = new TerminalPortuaria( new Point2D.Double(-25.28646, -57.647) );
	TerminalPortuaria lima = new TerminalPortuaria( new Point2D.Double(-12.04318, -77.02824) );
	TerminalPortuaria santiagoDeChile = new TerminalPortuaria( new Point2D.Double(-33.45694, -70.64827) );
	TerminalPortuaria laPaz = new TerminalPortuaria( new Point2D.Double(-16.5, -68.15) );
	
	
	
	@BeforeEach
	void setUp() throws Exception
	{
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
