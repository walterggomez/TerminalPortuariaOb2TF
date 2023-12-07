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
		this.ordenFacturada = ordenFacturada;
		conceptos = new HashSet<Concepto>();
		this.conceptos.add( new Concepto( "Monto total a pagar:", LocalDateTime.now(), ordenFacturada.precioTotal() ) );
		this.agregarCostoCircuito();
		this.agregarConceptosServicios();	
	}
	
	

	public Set<Concepto> getConceptos() 
	{
		return conceptos;
	}



	public void agregarCostoCircuito()
	{
		if( this.ordenFacturada.esOrdenImportacion() )
		{
			this.conceptos.add( new Concepto( "Monto total del circuito", ordenFacturada.getSalidaContainer(), ordenFacturada.getViaje().costoViaje() ) );
		}
	}
	  
	private void agregarConceptosServicios()
	{
		for( Servicios servicio: this.ordenFacturada.getServicios() )
		{
			this.conceptos.add( new Concepto(servicio.toString(), ordenFacturada.getSalidaContainer(), servicio.costoServicio(ordenFacturada)) );
		}
	}
	
	
//	public void imprimirCostoPorCadaServicio()
//	{
//		for (Servicios servicio : this.ordenFacturada.getServicios())
//		{
//			this.imprimirCostoServicio(servicio);
//		}
//	}
//
//		
//	public String imprimirCostoServicio(Servicios servicio)
//	{
//		return servicio.toString() + ":" + " " + servicio.costoServicio(this.ordenFacturada) + "\n";
//	}

	
	@Override
	public String toString()
	{
		String mensajeFactura = "Aquí está la factura de su orden N°: " + this.ordenFacturada.codigoUnico.toString();
			for( Concepto c: this.conceptos )
			{
				mensajeFactura += c.toString() + "/n";
			}
		return mensajeFactura;
	}
	
	
	
}

