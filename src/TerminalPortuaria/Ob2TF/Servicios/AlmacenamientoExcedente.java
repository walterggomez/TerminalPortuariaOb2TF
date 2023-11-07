package TerminalPortuaria.Ob2TF.Servicios;
import TerminalPortuaria.Ob2TF.Orden.*;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AlmacenamientoExcedente implements Servicios
{
	private float costoPorDia;
	
	
	public double costoServicio( Orden orden )
	{
		//
		String fechaIngreso = LocalTime.now().toString();
		String fechaLlegada = orden.getViaje().getFechaDeLlegada().toString();
		return costoPorDia * this.diferenciaDias(fechaIngreso, fechaLlegada); // Extraer dato en que el camión va a buscar el container.
	}
	
	public static long diferenciaDias(String ingreso, String retiro){
        //int dias=0,meses=0,anos=0;
        LocalDate i = LocalDate.parse(ingreso, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate r = LocalDate.parse(retiro, DateTimeFormatter.ISO_LOCAL_DATE);
        
        //Period period = Period.between(i, r);
        
        //dias= Math.abs(period.getDays()); meses=Math.abs(period.getMonths()); anos=Math.abs(period.getYears());
        
        //dias=dias+1;
        
        /*if(dias>=30){
            dias=0; meses=meses+1;
        }
        if(meses>=12){
            meses=0;anos=anos+1;
        }*/
        
        return ChronoUnit.DAYS.between(i, r);
        
        //return dias;
    }



}
