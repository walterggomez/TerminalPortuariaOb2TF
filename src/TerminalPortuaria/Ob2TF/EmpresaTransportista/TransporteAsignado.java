package TerminalPortuaria.Ob2TF.EmpresaTransportista;
import TerminalPortuaria.Ob2TF.Cliente.*;
import TerminalPortuaria.Ob2TF.Orden.Orden;

public class TransporteAsignado 
{
	private Camion camionAsignado;
	private Chofer choferAsignado;
	private Cliente cliente;
	
	
	public TransporteAsignado(Camion camionasignado, Chofer choferAsignado )
	{
		this.camionAsignado = camionasignado;
		this.choferAsignado = choferAsignado;
	}
	
	public TransporteAsignado() {};
	
	public Camion getCamionAsignado() 
	{
		return camionAsignado;
	}

	public Chofer getChoferAsignado()
	{
		return choferAsignado;
	}

	public Cliente getCliente()
	{
		return cliente;
	}



}
