package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class AlmacenamientoExcedente implements Servicios // Se instancia en todas las ordenes de importación.
{
	private double costoPorDia;
	
	public AlmacenamientoExcedente( double costoPorDia )
	{
		this.costoPorDia = costoPorDia;
	}
	
	
	public double costoServicio( Orden orden )
	{
		LocalDateTime fechayHoraRetiroContainer = LocalDateTime.now();
		LocalDateTime fechaYHoraIngresoContainer = orden.getFechaDeLlegadaCarga();
		long diferenciaDias = ChronoUnit.DAYS.between(fechayHoraRetiroContainer, fechaYHoraIngresoContainer);
		return costoPorDia *  diferenciaDias;
	}
	
}




