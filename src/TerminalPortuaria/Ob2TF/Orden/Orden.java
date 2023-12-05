package TerminalPortuaria.Ob2TF.Orden;
import TerminalPortuaria.Ob2TF.Container.*;
import TerminalPortuaria.Ob2TF.Servicios.Electricidad;
import TerminalPortuaria.Ob2TF.Servicios.Lavado;
import TerminalPortuaria.Ob2TF.Servicios.Servicios;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Circuito.*;
import TerminalPortuaria.Ob2TF.Cliente.*;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import TerminalPortuaria.Ob2TF.Container.*;


public abstract class Orden 
{
	protected Cliente cliente;
	protected Viaje viaje;
	protected Container container;
	protected Set<Servicios> servicios = new HashSet<Servicios>();
	protected TransporteAsignado transporteAsignado;
	protected boolean servicioLavado;
	protected LocalDateTime entregaContainer;
	protected LocalDateTime salidaContainer;
	
	public Orden() {
		
	}
	
	public Orden(Cliente cliente, Viaje viaje, Container container, EmpresaTransportista empresa, boolean servicioLavado)
	{
		this.cliente = cliente;
		this.viaje = viaje;
		this.container = container;
		this.transporteAsignado = empresa.asignarTransporte(this);
		this.servicioLavado = servicioLavado;
		this.evaluarServicioLavado();
		this.evaluarServicioReefer();
	}
	
	

	
	public Set<Servicios> getServicios()
	{
		return servicios;
	}

	
	private void evaluarServicioLavado()
	{
		if( servicioLavado )
		{
			servicios.add( new Lavado() );
		}
	}
	
	protected void evaluarServicioReefer()
	{
		if( container instanceof  Reefer )
		{
			servicios.add( new Electricidad() );
		}
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
	
	public void registrarEntregaContainer()
	{
		this.entregaContainer = LocalDateTime.now();
	}
	
	public void registrarSalidaContainer()
	{
		this.salidaContainer = LocalDateTime.now();
	}
	
	public LocalDateTime getEntregaContainer() 
	{
		return entregaContainer;
	}

	public LocalDateTime getSalidaContainer() 
	{
		return salidaContainer;
	}

	public TransporteAsignado getTransporteAsignado()
	{
		return transporteAsignado;
	}
	
	public double precioTotal()
	{
		return this.servicios.stream().mapToDouble( s -> s.costoServicio(this)  ).sum();
	}
	
}
