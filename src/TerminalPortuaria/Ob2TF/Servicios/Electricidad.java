package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;
import TerminalPortuaria.Ob2TF.Container.*;

public class Electricidad implements Servicios
{
	float costoKwHora;
	
	
	public double costoServicio( Orden orden )
	{
		return costoKwHora * orden.getContainer().getPeso();
	}
	

}
