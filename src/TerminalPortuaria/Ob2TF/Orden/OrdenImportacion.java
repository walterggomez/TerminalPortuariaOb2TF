package TerminalPortuaria.Ob2TF.Orden;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Container.Container;
import TerminalPortuaria.Ob2TF.Container.Reefer;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.EmpresaTransportista;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.TransporteAsignado;
import TerminalPortuaria.Ob2TF.Servicios.AlmacenamientoExcedente;
import TerminalPortuaria.Ob2TF.Servicios.Electricidad;
import TerminalPortuaria.Ob2TF.Servicios.Lavado;

public class OrdenImportacion extends Orden
{

	public OrdenImportacion( Cliente cliente, Viaje viaje, Container container, EmpresaTransportista empresa, boolean servicioLavado)
	{
		super( cliente, viaje, container, empresa, servicioLavado );
		servicios.add( new AlmacenamientoExcedente() );
		this.entregaContainer = viaje.getFechaDeLlegada();
		viaje.suscribe(viaje.getConsignees(), cliente);
	}
	
	@Override
	public double precioTotal()
	{
		return super.precioTotal() + this.viaje.getCircuito().costoTotalDelCircuito();
	}

	@Override
	public boolean esOrdenImportacion()
	{
		return true;
	}

	@Override
	public boolean esOrdenExportacion()
	{
		return false;
	}

}
