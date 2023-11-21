package TerminalPortuaria.Ob2TF.Orden;
import TerminalPortuaria.Ob2TF.Container.*;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Circuito.*;
import TerminalPortuaria.Ob2TF.Cliente.*;
import java.time.LocalDateTime;

public class Orden 
{
	protected Cliente cliente;
	protected Viaje viaje;
	protected Container container;
	protected Buque buque;
	
	
	
	public Orden(Cliente cliente, Viaje viaje, Container container, Buque buque) {
		this.cliente = cliente;
		this.viaje = viaje;
		this.container = container;
		this.buque = buque;
	}

	public Buque getbuque() {
		return this.buque;
	}
	
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
