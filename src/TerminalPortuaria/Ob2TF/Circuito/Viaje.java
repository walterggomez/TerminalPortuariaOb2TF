package TerminalPortuaria.Ob2TF.Circuito;
import java.time.LocalDateTime;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Viaje
{
	int idViaje;
	Buque buqueViaje;
	Circuito circuitoViaje;
	LocalDateTime fechaDeSalida;
	LocalDateTime fechaDeLlegada;
	TerminalPortuaria puertoDestino;

	public TerminalPortuaria getpuertoDestino()
	{
		return puertoDestino;
	}
	
	public LocalDateTime getFechaDeLlegada() {
		return fechaDeLlegada;
	}
	
	public Buque getBuqueViaje() {
		return buqueViaje;
	}
	
	public void setBuqueViaje(Buque buqueViaje)
	{
		this.buqueViaje = buqueViaje;
	}
	
	public LocalDateTime getFechaDeSalida() {
		return fechaDeSalida;
	}
	
	public void setFechaDeSalida(LocalDateTime fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}
	
	public Circuito getCircuito()
	{
		return this.circuitoViaje;
	}
}
