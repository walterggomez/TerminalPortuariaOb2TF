package TerminalPortuaria.Ob2TF.Circuito;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;


public class Tramo {
	private TerminalPortuaria puertoOrigen;
	private TerminalPortuaria puertoDestino;
	private LocalDate fechaSalida;
	private long duracionViaje;
	private double costoDetramo;
	

	
	public TerminalPortuaria getPuertoOrigen() {
		return puertoOrigen;
	}

	public TerminalPortuaria getPuertoDestino() {
		return puertoDestino;
	}

	public long getDuracionViaje() {
		return duracionViaje;
	}

	public double getCostoDetramo() {
		return costoDetramo;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	//PRIMERA FORMA
//	public LocalDate fechaLlegada() {
//		long diasDeViaje = (this.duracionViaje / 24);
//		return this.fechaSalida.plusDays(diasDeViaje);
//	}
	
	//SEGUNDA FORMA
	
	public LocalDate fechaLlegada() {
		return this.fechaSalida.plus(this.duracionViaje, ChronoUnit.HOURS);
	}
	
	public void main () {
		System. out. println(this.fechaLlegada());
	}

}