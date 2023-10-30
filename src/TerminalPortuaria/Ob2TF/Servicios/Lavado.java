package TerminalPortuaria.Ob2TF.Servicios;

public class Lavado implements Servicios
{
	double costoServicio( Orden orden )
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
