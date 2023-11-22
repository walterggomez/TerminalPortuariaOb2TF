package TerminalPortuaria.Ob2TF.EmpresaTransportista;
import TerminalPortuaria.Ob2TF.Cliente.*;

public class TransporteAsignado 
{
	private Camion camionAsignado;
	private Chofer choferAsignado;
	private Cliente cliente;
	
	public TransporteAsignado( Cliente cliente, Camion camionasignado, Chofer choferAsignado )
	{
		this.cliente = cliente;
		this.camionAsignado = camionasignado;
		this.choferAsignado = choferAsignado;
	}
	

}
