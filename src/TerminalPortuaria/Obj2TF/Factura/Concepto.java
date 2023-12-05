package TerminalPortuaria.Obj2TF.Factura;

import java.time.LocalDateTime;

public class Concepto 
{
	private String nombre;
	private LocalDateTime fecha;
	private double monto;
	
	public Concepto(String nombre, LocalDateTime fecha, double monto) 
	{
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.monto = monto;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public LocalDateTime getFecha() 
	{
		return fecha;
	}
	
	public double getMonto() 
	{
		return monto;
	}
	
	@Override
	public String toString()
	{
		return "Nombre: " + nombre + "\tfecha: " + fecha + "\tmonto: " + monto;
	}
}
