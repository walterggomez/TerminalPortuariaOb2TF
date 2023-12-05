package TerminalPortuaria.Obj2TF.Factura;
import TerminalPortuaria.Ob2TF.Servicios.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import TerminalPortuaria.Ob2TF.Orden.*;

public class Factura
{
	private Orden ordenFacturada;
	private Set<Concepto> conceptos; 
	
	public Factura( Orden ordenFacturada )
	{
		conceptos = new HashSet<Concepto>();
		this.costoServicioElectricidad();
		this.costoServicioLavado();
		this.costoServicioAlmacenamientoExcedente();
		this.costoServicioPesado();
		this.costoCircuito();
		this.conceptos.add( new Concepto( "Monto total del servicio:", LocalDateTime.now(), ordenFacturada.precioTotal() ) );
	}
	
	private void costoCircuito()
	{
		if( this.ordenFacturada.esOrdenImportacion() )
		{
			this.conceptos.add( new Concepto( "Monto total del circuito", ordenFacturada.getSalidaContainer(), ordenFacturada.getViaje().costoViaje() ) );
		}
	}
	
	private void costoServicioElectricidad()
	{
		if( this.ordenFacturada.getServicioElectricidad() != null )
		{
			Electricidad servicio = this.ordenFacturada.getServicioElectricidad();
			this.conceptos.add( new Concepto( "Electricidad", ordenFacturada.getSalidaContainer(), servicio.costoServicio(ordenFacturada) ) );
		}
	}
	
	private void costoServicioLavado()
	{
		if( this.ordenFacturada.getServicioLavado() != null )
		{
			Lavado servicio = this.ordenFacturada.getServicioLavado();
			this.conceptos.add( new Concepto( "Lavado", ordenFacturada.getSalidaContainer(), servicio.costoServicio(ordenFacturada) ) );
		}
	}
	
	private void costoServicioAlmacenamientoExcedente()
	{
		if( this.ordenFacturada.getServicioAlmacenamientoExcedente() != null )
		{
			AlmacenamientoExcedente servicio = this.ordenFacturada.getServicioAlmacenamientoExcedente();
			this.conceptos.add( new Concepto( "Almacenamiento excedente", ordenFacturada.getSalidaContainer(), servicio.costoServicio(ordenFacturada) ) );
		}
	}
	
	private void costoServicioPesado()
	{
		if( this.ordenFacturada.getServicioPesado() != null )
		{
			Pesado servicio = this.ordenFacturada.getServicioPesado();
			this.conceptos.add( new Concepto( "Pesado", ordenFacturada.getSalidaContainer(), servicio.costoServicio(ordenFacturada) ) );
		}
	}
	
	@Override
	public String toString()
	{
		String mensajeFactura = "Aquí está la factura de su orden N°: " + this.ordenFacturada.codigoUnico.toString();
		{
			for( Concepto c: this.conceptos )
			{
				mensajeFactura += "\nMensajeFactura" + c.toString();
			}
		}
		return mensajeFactura;
	}
}
