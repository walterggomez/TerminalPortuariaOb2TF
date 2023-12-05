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
	private double costoPorDia = 50;

	public void setCostoPorDia(double costoPorDia) {
		this.costoPorDia = costoPorDia;
	}

	@Override
	public double costoServicio(Orden orden) 
	{
		return costoPorDia * ChronoUnit.HOURS.between(orden.getSalidaContainer(), orden.getEntregaContainer());
	}

	public double getCostoPorDia() 
	{
		return costoPorDia;
	}
	
	 
}




