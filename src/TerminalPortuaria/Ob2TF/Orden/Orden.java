package TerminalPortuaria.Ob2TF.Orden;
import TerminalPortuaria.Ob2TF.Container.*;
import TerminalPortuaria.Ob2TF.Servicios.*;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Circuito.*;
import TerminalPortuaria.Ob2TF.Cliente.*;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.*;
import TerminalPortuaria.Obj2TF.Factura.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
    public UUID codigoUnico;
	 
    public Orden() {}

	public Orden(Cliente cliente, Viaje viaje, Container container, EmpresaTransportista empresa, boolean servicioLavado)
	{
		this.cliente = cliente;
		this.viaje = viaje;
		this.container = container;
		this.transporteAsignado = empresa.asignarTransporte(this);
		this.servicioLavado = servicioLavado;
		this.evaluarServicioLavado();
		this.evaluarServicioReefer();
		this.codigoUnico = UUID.randomUUID();
	}
	
	public abstract boolean esOrdenImportacion();	
	public abstract boolean esOrdenExportacion();

	
	
	
	public Set<Servicios> getServicios()
	{
		return servicios;
	}

	
	protected void evaluarServicioLavado()
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
	
	public void asignarTransporte(TransporteAsignado transporte)
	{
        this.transporteAsignado = transporte;
    }
	
	public Camion getCamionAsignado()
	{
		return this.transporteAsignado.getCamionAsignado();
	}
	
	
	public Chofer getChoferAsignado()
	{
		return this.transporteAsignado.getChoferAsignado();
	}
	
	
	public double precioTotal()
	{
		return this.servicios.stream().mapToDouble( s -> s.costoServicio(this)  ).sum();
	}

	public UUID getCodigoUnico() 
	{
		return codigoUnico;
	}
	
	public Electricidad getServicioElectricidad()
	{
	    return servicios.stream()
	            .filter(servicio -> servicio instanceof Electricidad)
	            .findFirst()
	            .map(servicio -> (Electricidad) servicio)
	            .orElse(null);
	}
	
	public Lavado getServicioLavado()
	{
	    return servicios.stream()
	            .filter(servicio -> servicio instanceof Lavado)
	            .findFirst()
	            .map(servicio -> (Lavado) servicio)
	            .orElse(null);
	}
	
	public Pesado getServicioPesado()
	{
	    return servicios.stream()
	            .filter(servicio -> servicio instanceof Pesado)
	            .findFirst()
	            .map(servicio -> (Pesado) servicio)
	            .orElse(null);
	}
	
	public AlmacenamientoExcedente getServicioAlmacenamientoExcedente()
	{
	    return servicios.stream()
	            .filter(servicio -> servicio instanceof AlmacenamientoExcedente)
	            .findFirst()
	            .map(servicio -> (AlmacenamientoExcedente) servicio)
	            .orElse(null);
	}

	public void enviarFacturaPorMail()
	{
		Factura factura = new Factura(this);
		cliente.recibirMail( factura.toString() );
	}
	
}
