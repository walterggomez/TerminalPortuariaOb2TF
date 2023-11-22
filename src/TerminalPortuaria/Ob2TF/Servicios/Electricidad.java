package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;
import TerminalPortuaria.Ob2TF.Container.*;

public class Electricidad implements Servicios // Se instancia en containers reefer.
{
	float costoKwHora;
	
	public Electricidad( float costoKwHora )
	{
		this.costoKwHora = costoKwHora;
	}
	
	public double costoServicio( Orden orden )
	{
		return costoKwHora * orden.getContainer().getPeso();
	}
	

}
