package TerminalPortuaria.Ob2TF.Naviera;
import java.util.List;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Circuito.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import TerminalPortuaria.Ob2TF.TerminalP.*;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class Naviera
{
	private List<Circuito> misCircuitos = new ArrayList<>();
	// private Map<Circuito, LocalDateTime> listaCircuitosSalidas = new HashMap<>();
	private Set<Buque> misBuques = new HashSet<>();
	private Set<Viaje> viajes = new HashSet<>();
	

	public List<Circuito> getMisCircuitos()
	{
		return misCircuitos;
	}
	
	public Set<Viaje> getViajes()
	{
		return viajes;
	}
	
	// Viaje( Buque buqueViaje, Circuito circuitoViaje, LocalDateTime fechaDeSalida)
	
	public void establecerViaje( Buque buque, LocalDateTime fechaYHora, Circuito circuito ) throws Exception
	{
		this.validarCircuito( circuito );
		this.validarBuque( buque );
		viajes.add( new Viaje( buque, circuito, fechaYHora ) );
	}
	
	/*
	private boolean validarCircuito( Circuito circuito )
	{
		return this.getMisCircuitos().contains(circuito);
	}
	*/
	
	public void agregarCircuito( Circuito circuito )
	{
		// Agregarle validador
		misCircuitos.add(circuito);
	}
	
	public void validarCircuito(Circuito circuito) throws Exception
	{
		if ( ! misCircuitos.contains(circuito) )
		{
			throw new Exception("Este circuito no se encuentra en las ofertas de la naviera");
		}
	}
	
	public void validarBuque(Buque buque) throws Exception
	{
		if ( ! misBuques.contains(buque) )
		{
			throw new Exception("Este buque no existe en la naviera");
		}
	}
	
/*
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

 */
	
	
	
	

}
