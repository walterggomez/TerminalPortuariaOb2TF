package TerminalPortuaria.Ob2TF.Circuito;
// import java.time.LocalDate;
// import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;
import java.time.format.DateTimeFormatter;


public class Tramo
{
	private TerminalPortuaria puertoOrigen;
	private TerminalPortuaria puertoDestino;
	private LocalDateTime fechaYHoraSalida;
	private long duracionTramo;
	private double costoDetramo;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm"); // Formato de fecha y hora seleccionado.
	
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

	
	public String mostrarFechaYHoraSalida()
	/*
		Retorna la fecha con formato en 'String' 'LocalDateTime' para poder mostrar la fecha con un formato más legible.
	 */
	{
		 return fechaYHoraSalida.format(formatter);
	}
	
	
	public LocalDateTime getFechaYHoraSalida()
	/*
	 		Retorna la fecha sin formato en tipo 'LocalDateTime' para poder trabajar con otras fechas. Utilizar cada vez que se quiera leer el dato fechaYHoraSalida
	 		en el formato 'LocalDateTime'.
	 */
	{
		return fechaYHoraSalida;
	}
	
	
	public void setFechaYHoraSalida(LocalDateTime fechaYHoraSalida)
	{
		this.fechaYHoraSalida = fechaYHoraSalida;
	}
	

	
	public LocalDateTime getFechaYHoraLlegada()
	{
		return this.fechaYHoraSalida.plus(this.duracionTramo, ChronoUnit.HOURS);
	}
	
}