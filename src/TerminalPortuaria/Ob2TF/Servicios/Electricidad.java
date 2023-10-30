package TerminalPortuaria.Ob2TF.Servicios;

public class Electricidad implements Servicios
{
	float costoKwHora;
	
	
	double costoServicio( Orden orden )
	{
		return costoKwHora * orden.getContainer.getConsumo() 
	}
	

}
