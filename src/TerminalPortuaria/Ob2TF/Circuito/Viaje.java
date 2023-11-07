package TerminalPortuaria.Ob2TF.Circuito;
import java.time.LocalDate;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Viaje
{
	int idViaje;
	Buque buqueViaje;
	Circuito circuitoViaje;
	LocalDate fechaDeSalida;
	LocalDate fechaDeLlegada;
	TerminalPortuaria puertoDestino;

	public TerminalPortuaria getpuertoDestino()
	{
		return puertoDestino;
	}
	
	public LocalDate getFechaDeLlegada() {
		return fechaDeLlegada;
	}
	
	public Buque getBuqueViaje() {
		return buqueViaje;
	}
	
	public void setBuqueViaje(Buque buqueViaje)
	{
		this.buqueViaje = buqueViaje;
	}
	
	public LocalDate getFechaDeSalida() {
		return fechaDeSalida;
	}
	
	public void setFechaDeSalida(LocalDate fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}
	
	public Circuito getCircuito()
	{
		return this.circuitoViaje;
	}
}
