package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;

public class Lavado implements Servicios // Se instancia de forma opcional en cualquier orden sea importación o exporación.
{	
	
	
	@Override
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
