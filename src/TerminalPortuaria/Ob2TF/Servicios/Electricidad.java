package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import TerminalPortuaria.Ob2TF.Container.*;

public class Electricidad implements Servicios // Se instancia en containers reefer.
{
	double costoKwHora = 50;
	

	
	@Override
	public double costoServicio( Orden orden )
	{
		return costoKwHora *  ChronoUnit.HOURS.between( orden.getSalidaContainer(), orden.getEntregaContainer() );
	}
	
	
	public void setCostoKwHora( double nuevoPrecio)
	{
		this.costoKwHora = nuevoPrecio;
	}
	
	
}
