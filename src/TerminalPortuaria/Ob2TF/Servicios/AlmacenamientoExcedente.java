package TerminalPortuaria.Ob2TF.Servicios;

import java.time.LocalTime;

public class AlmacenamientoExcedente implements Servicios
{
	private float costoPorDia;
	
	double costoServicio( Orden orden )
	{
		return costoPorDia * ( (LocalTime.now() - orden.getViaje().getCircuito().getFechaLlegada()).getAmountOfDays()   ) // Extraer dato en que el camión va a buscar el container.
		
	}
	

}
