package TerminalPortuaria.Ob2TF.Orden;
import java.time.LocalDateTime;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Container.Container;
import TerminalPortuaria.Ob2TF.Container.Reefer;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.TransporteAsignado;
import TerminalPortuaria.Ob2TF.Servicios.*;

public class OrdenExportacion extends Orden
{


	public OrdenExportacion( Cliente cliente, Viaje viaje, Container container, TransporteAsignado transporte, boolean servicioLavado)
	{
		super( cliente, viaje, container, transporte, servicioLavado );
		servicios.add( new Pesado( viaje.getpuertoOrigen().getCostoServicioPesaje() ) );
	}

	@Override
	protected void evaluarServicioReefer() 
	{
		if( container instanceof  Reefer )
		{
			servicios.add( new Electricidad( viaje.getpuertoOrigen().getCostoKwConsumido() ) );
		}
		
	}


	
}
