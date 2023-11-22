package TerminalPortuaria.Ob2TF.EmpresaTransportista;
import TerminalPortuaria.Ob2TF.Orden.*;

public class Camion 
{
	private Orden ordenAsignada = null;
	private String patente;

	public boolean tieneOrdenAsignada()
	{
		return ordenAsignada != null;
	}
	
	public void setOrdenAsignada( Orden orden )
	{
		ordenAsignada = orden;
	}
	
	public Camion(String patente) 
	{
		this.patente = patente;
	}
	
	public String getPatente() 
	{
		return patente;
	}
	

	
	
}
