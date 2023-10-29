package TerminalPortuaria.Ob2TF.Buque;
import java.awt.Point;

public class GPS 
{
	
	public static double distanciaEntrePuntos( Point punto1, Point punto2 )
	{
		double x = punto1.getX() - punto2.getX();
	    double y = punto1.getY() - punto2.getY();
	    double Distance_Result = Math.sqrt(x * x + y * y);
	    return Math.round(Distance_Result);
	}
	
}
