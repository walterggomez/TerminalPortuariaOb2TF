package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;

public class Pesado implements Servicios
{
	private double costoPesaje;
	
	public double costoServicio( Orden orden )
	{
		return costoPesaje;
	}

}
