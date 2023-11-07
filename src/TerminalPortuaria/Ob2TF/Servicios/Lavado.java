package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;

public class Lavado implements Servicios
{
	
	public double costoServicio( Orden orden )
	{
		if( orden.getContainer().volumen() < 70 )
		{
			return 100;
		}
		else
		{
			return 30;
		}
	}

}
