package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;

public class Pesado implements Servicios // Se intancia en todas las ordenes de exportación.
{
	private double costoPesaje;
	
	public Pesado( float costoPesaje )
	{
		this.costoPesaje = costoPesaje;
	}
	
	public double costoServicio(Orden orden )
	{
		return costoPesaje;
	}

}
