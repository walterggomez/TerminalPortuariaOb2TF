package TerminalPortuaria.Ob2TF.Circuito;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Viaje
{
	Buque buqueViaje;
	Circuito circuitoViaje;
	LocalDateTime fechaDeSalida;
	LocalDateTime fechaDeLlegada;
	TerminalPortuaria puertoOrigen;
	TerminalPortuaria puertoDestino;

	public Viaje() {
		
	}
	
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
	
	public void setFechaDeSalida(LocalDateTime fechaDeSalida)
	{
		this.fechaDeSalida = fechaDeSalida;
	}
	
	public Circuito getCircuito()
	{
		return this.circuitoViaje;
	}
	
	public long duracionViaje()
	{
		return this.circuitoViaje.duracionCircuito();
	}
	
	public int cantidadEscalas()
	{
		return this.circuitoViaje.cantidadDeEscalas();
	}
	
	public double costoViaje()
	{
		return this.circuitoViaje.costoTotalDelCircuito();
	}
	
	public boolean validarSiTerminalExisteEnViaje(TerminalPortuaria terminal)
	{
		return this.circuitoViaje.validarSiTerminalExisteEnCircuito(terminal);
	}
	
	public boolean validarSiTerminalOrigenEstaAntesQueDestino( TerminalPortuaria origen, TerminalPortuaria destino )
	{
		return this.circuitoViaje.validarSiPuertoOrigenEstaAntesQuePuertoDestino(origen, destino);
	}
	
	public Viaje generarViajeConTramosDeInteres( TerminalPortuaria terminalOrigen, TerminalPortuaria terminalDestino )
	{
		Circuito nuevoCircuito = circuitoViaje.construirCircuitoDesdeHasta(terminalOrigen, terminalDestino);
		LocalDateTime fechaSalida = nuevoCircuito.getFechaYHoraSalida();
		return new Viaje( this.buqueViaje, nuevoCircuito, fechaSalida);
	}
    
	
}
