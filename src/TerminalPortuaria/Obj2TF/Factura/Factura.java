package TerminalPortuaria.Obj2TF.Factura;
import TerminalPortuaria.Ob2TF.Servicios.*;

import java.util.HashSet;
import java.util.Set;

import TerminalPortuaria.Ob2TF.Orden.*;

public class Factura
{
	private Orden ordenFacturada;
	private Electricidad servicioElectricidad;
	private Lavado servicioLavado;
	private Pesado servicioPesado;
	private AlmacenamientoExcedente servicioAlmacenamientoExcedente;
	private double costoTramosCircuito;
	private Set<Concepto> conceptos = new HashSet<Concepto>();
	
	
	
	private void costoServicioElectricidad()
	{
		if( this.ordenFacturada.getServicios().contains( instanceof Electricidad ) )
		{
			
		}
	}

	
	
	
	

}
