package TerminalPortuaria.Ob2TF.Buque;
import java.awt.Point;
import java.awt.geom.Point2D;

import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class GPSTest 
{
	public static void main(String[] args)
	{
		TerminalPortuaria buenosAires = new TerminalPortuaria( new Point2D.Double(-34.61315, -58.37723) );
		TerminalPortuaria saoPablo = new TerminalPortuaria( new Point2D.Double(-23.5475, -46.63611) );
		
		System.out.println( GPS.distanciaEntrePuntos( buenosAires.getUbicacion(), saoPablo.getUbicacion()) );
		
	}
	
	
	
	
	
	

}
