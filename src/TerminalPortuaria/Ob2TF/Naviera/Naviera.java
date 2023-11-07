package TerminalPortuaria.Ob2TF.Naviera;
import java.util.List;

import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Circuito.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import TerminalPortuaria.Ob2TF.TerminalP.*;

public class Naviera
{
	private List<Circuito> misCircuitos;
	private List<Viaje> viajes = new ArrayList<>();

	public List<Circuito> getMisCircuitos()
	{
		return misCircuitos;
	}
	
	public List<Viaje> getViajes()
	{
		return viajes;
	}
	
	// Viaje( Buque buqueViaje, Circuito circuitoViaje, LocalDateTime fechaDeSalida)
	public void establecerFechaViaje( LocalDateTime fechaYHora, TerminalPortuaria terminalDestino )
	{
		viajes.add( new Viaje( fechaYHora, terminalDestino ) );
		
		
	}

	
	
	
	

}
