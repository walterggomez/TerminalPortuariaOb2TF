package TerminalPortuaria.Ob2TF.Circuito;
import java.time.LocalDateTime;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Viaje
{
	Buque buqueViaje;
	Circuito circuitoViaje;
	LocalDateTime fechaDeSalida;
	LocalDateTime fechaDeLlegada;
	TerminalPortuaria puertoOrigen;
	TerminalPortuaria puertoDestino;

	public Viaje( Buque buqueViaje, Circuito circuitoViaje, LocalDateTime fechaDeSalida)
	{
		this.circuitoViaje = circuitoViaje;
		circuitoViaje.setfechaYHoraSalida(fechaDeSalida);
		this.buqueViaje = buqueViaje;
		this.fechaDeSalida = fechaDeSalida;
		this.puertoOrigen = circuitoViaje.puertoOrigenCircuito();
		this.puertoDestino = circuitoViaje.puertoDestinoCircuito();
		this.fechaDeLlegada = circuitoViaje.getFechaYHoraLlegada();
	}
	
	public TerminalPortuaria getpuertoOrigen() {
		return this.puertoOrigen;
	}
	
	public TerminalPortuaria getpuertoDestino()
	{
		return puertoDestino;
	}
	
	public LocalDateTime getFechaDeLlegada()
	{
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
