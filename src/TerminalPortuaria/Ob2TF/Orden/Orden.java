package TerminalPortuaria.Ob2TF.Orden;
import TerminalPortuaria.Ob2TF.Container.*;
import TerminalPortuaria.Ob2TF.Circuito.*;
import TerminalPortuaria.Ob2TF.Cliente.*;
import java.time.LocalDateTime;

public class Orden 
{
	protected Cliente cliente;
	protected Viaje viaje;
	protected Container container;
	
	
	public Viaje getViaje()
	{
		return viaje;
	}
	
	public Container getContainer() 
	{
		return container;
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}
	
	public LocalDateTime getFechaDeSalidaCarga()
	{
		return viaje.getFechaDeSalida();
	}
	
	public LocalDateTime getFechaDeLlegadaCarga()
	{
		return viaje.getFechaDeLlegada();
	}
}
