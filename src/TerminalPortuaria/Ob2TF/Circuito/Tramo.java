package TerminalPortuaria.Ob2TF.Circuito;
import java.awt.geom.Point2D;
import TerminalPortuaria.Ob2TF.Buque.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;
import java.time.format.DateTimeFormatter;


public class Tramo
{
	private TerminalPortuaria puertoOrigen;
	private TerminalPortuaria puertoDestino;
	private LocalDateTime fechaYHoraSalida;
	 private double duracionTramo;
	private double costoDetramo;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm"); // Formato de fecha y hora seleccionado.
	
	public TerminalPortuaria getPuertoOrigen()
	{
		return puertoOrigen;
	}

	public Tramo() // Constructor sin argumentos para crear spy en mockito.
	{
		super();
	}
	
	public Tramo(TerminalPortuaria puertoOrigen, TerminalPortuaria puertoDestino, LocalDateTime fechaYHoraSalida, double costoDetramo,  double duracionTramo)
	{
		super();
		this.puertoOrigen = puertoOrigen;
		this.puertoDestino = puertoDestino;
		this.fechaYHoraSalida = fechaYHoraSalida;
		this.duracionTramo = duracionTramo;
		this.costoDetramo = costoDetramo;
	}

	
	public double getDuracionTramo()
	{
		return  duracionTramo;
	}
	
	
	public TerminalPortuaria getPuertoDestino()
	{
		return puertoDestino;
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
	
	public String mostrarFechaYHoraLlegada()
	/*
		Retorna la fecha con formato en 'String' 'LocalDateTime' para poder mostrar la fecha con un formato más legible.
	 */
	{
		 return this.getFechaYHoraLlegada().format(formatter);
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
	// Establece fecha de salida frecuente > se genera un viaje... o no, pero al establecer esa fecha, se setean las fechas de los tramos.

	
	public LocalDateTime getFechaYHoraLlegada()
	{
		return this.fechaYHoraSalida.plus( (long) this.getDuracionTramo(), ChronoUnit.HOURS);
	}
	
}