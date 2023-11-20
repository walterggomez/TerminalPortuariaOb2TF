package TerminalPortuaria.Ob2TF.Buque;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GPSTest {

	Point2D puntoA;
	Point2D puntoB;
	
	GPS garminDrive;
	
	@BeforeEach
	void setUp() throws Exception{
		
		garminDrive = new GPS();
		puntoA = new Point2D.Double(-34.61315, -58.37723);
		puntoB = new Point2D.Double(-23.5475, -46.63611);
	}
	
	@Test
	void distanciaEntrePuntosTest() {
		assertEquals(1677.0,garminDrive.distanciaEntrePuntos(puntoA, puntoB));
	}
}
