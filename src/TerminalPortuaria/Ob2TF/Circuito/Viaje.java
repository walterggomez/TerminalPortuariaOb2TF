package TerminalPortuaria.Ob2TF.Circuito;
import java.time.LocalDate;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Viaje
{
	Buque buqueViaje;
	Circuito circuitoViaje;
	LocalDate fechaDeSalida;

	
	
	public Buque getBuqueViaje() {
		return buqueViaje;
	}
	public void setBuqueViaje(Buque buqueViaje) {
		this.buqueViaje = buqueViaje;
	}
	public LocalDate getFechaDeSalida() {
		return fechaDeSalida;
	}
	public void setFechaDeSalida(LocalDate fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}
	
	
}
