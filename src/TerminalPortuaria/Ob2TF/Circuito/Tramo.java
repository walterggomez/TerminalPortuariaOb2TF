package TerminalPortuaria.Ob2TF.Circuito;
// import java.time.LocalDate;
// import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;


public class Tramo
{
	private TerminalPortuaria puertoOrigen;
	private TerminalPortuaria puertoDestino;
	private LocalDateTime fechaYHoraSalida;
	private long duracionTramo;
	private double costoDetramo;
	

	
	public TerminalPortuaria getPuertoOrigen()
	{
		return puertoOrigen;
	}

	public Tramo(TerminalPortuaria puertoOrigen, TerminalPortuaria puertoDestino, LocalDateTime fechaYHoraSalida,
		long duracionTramo, double costoDetramo){
		super();
		this.puertoOrigen = puertoOrigen;
		this.puertoDestino = puertoDestino;
		this.fechaYHoraSalida = fechaYHoraSalida;
		this.duracionTramo = duracionTramo;
		this.costoDetramo = costoDetramo;
	}

	public TerminalPortuaria getPuertoDestino()
	{
		return puertoDestino;
	}

	public long getDuracionTramo()
	{
		return duracionTramo;
	}

	public double getCostoDetramo()
	{
		return costoDetramo;
	}

	public LocalDateTime getFechaYHoraSalida()
	{
		return fechaYHoraSalida;
	}

	public void setFechaYHoraSalida(LocalDateTime fechaYHoraSalida)
	{
		this.fechaYHoraSalida = fechaYHoraSalida;
	}
	
	//PRIMERA FORMA
//	public LocalDate fechaLlegada() {
//		long diasDeViaje = (this.duracionViaje / 24);
//		return this.fechaSalida.plusDays(diasDeViaje);
//	}
	
	//SEGUNDA FORMA
	
	public LocalDateTime fechaYHoraLlegada()
	{
		return this.fechaYHoraSalida.plus(this.duracionTramo, ChronoUnit.HOURS);
	}
	
}