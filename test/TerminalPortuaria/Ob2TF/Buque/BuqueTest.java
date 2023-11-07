package TerminalPortuaria.Ob2TF.Buque;
import java.awt.geom.Point2D;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Buque.GPS;

public class BuqueTest
{
	public static void main(String[] args)
	{
		final Buque buquebus = new Buque();
		final Buque buquebus2 = new Buque();
		
		buquebus.setPosicionActual(5, 9);
		buquebus2.setPosicionActual(10, 4);
		
		System.out.println( GPS.distanciaEntrePuntos(buquebus.getPosicionActual(), buquebus2.getPosicionActual()) );
	}
}
