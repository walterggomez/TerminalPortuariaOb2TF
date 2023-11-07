package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;

public class Electricidad implements Servicios
{
	float costoKwHora;
	
	
	public double costoServicio( Orden orden )
	{
		return costoKwHora * orden.getContainer.getConsumo() * 
	}
	

}
