package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;

public class Lavado implements Servicios
{
	public double costoServicio( Orden orden )
	{
		if( orden.getContainer.getVolumen() < 70 )
		{
			return precio1;
		}
		else
		{
			return precio2;
		}
	}

}
