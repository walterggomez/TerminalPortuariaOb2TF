package TerminalPortuaria.Ob2TF.EmpresaTransportista;

import TerminalPortuaria.Ob2TF.Orden.Orden;
import TerminalPortuaria.Ob2TF.Orden.*;

public class Chofer 
{

	String nombre;
	private Orden ordenAsignada = null;

	public Chofer(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public boolean tieneOrdenAsignada()
	{
		return ordenAsignada != null;
	}
	
	public void setOrdenAsignada( Orden orden )
	{
		ordenAsignada = orden;
	}
	
	
}
