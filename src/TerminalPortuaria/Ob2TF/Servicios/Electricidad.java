package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;
import TerminalPortuaria.Ob2TF.Container.*;

public class Electricidad implements Servicios // Se instancia en containers reefer.
{
	double costoKwHora = 50;
	

	
	@Override
	public double costoServicio( Orden orden )
	{
		return costoKwHora * orden.getContainer().getPeso();
	}
	
	public void setCostoKwHora( double nuevoPrecio)
	{
		this.costoKwHora = nuevoPrecio;
	}
	
	
}
