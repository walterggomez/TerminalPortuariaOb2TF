package TerminalPortuaria.Ob2TF.Circuito;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Circuito {
	int idCircuito;
	LocalDateTime fechaYHoraSalida;
	private List<Tramo> listaDeTramo = new ArrayList<Tramo>();

	public List<Tramo> getListaDeTramo() {
		return listaDeTramo;
	}

	
	public Circuito(List<Tramo> listaDeTramo, LocalDateTime fechaYHoraSalida)
	{
		super();
		this.listaDeTramo = listaDeTramo;
		this.fechaYHoraSalida = fechaYHoraSalida;
		this.setfechaYHoraSalida(fechaYHoraSalida);
	}

	
	public void setfechaYHoraSalida(LocalDateTime fechaYHora)
	{
		if( ! this.listaDeTramo.isEmpty() )
		{
			this.listaDeTramo.get(0).setFechaYHoraSalida(fechaYHora);
			for (int i = 1; i < this.listaDeTramo.size(); i++)
			{
				this.listaDeTramo.get(i).setFechaYHoraSalida(this.listaDeTramo.get(i - 1).getFechaYHoraLlegada());
			}			
		}
	}
	
	
	public LocalDateTime getFechaYHoraSalida()
	{
		return this.fechaYHoraSalida;
	}
	
	
	public LocalDateTime getFechaYHoraLlegada() {
		return this.listaDeTramo.get(this.listaDeTramo.size() - 1).getFechaYHoraLlegada();
	}

	
	public void setListaDeTramo(List<Tramo> listaDeTramo)
	{
		this.listaDeTramo = listaDeTramo;
	}

	
	public TerminalPortuaria puertoDestinoCircuito() {
		return listaDeTramo.get(listaDeTramo.size() - 1).getPuertoDestino();
	}

	
	public TerminalPortuaria puertoOrigenCircuito() {
		return listaDeTramo.get(0).getPuertoOrigen();
	}

	
	public void agregarNuevoTramo(Tramo tramo) throws Exception
	{
		if ( this.listaDeTramo.isEmpty() || coindicenPuertosDestinoOrigen(tramo) )
		{
			listaDeTramo.add(tramo);
		} 
		else
		{
			throw new Exception("El puerto de origen del tramo a agregar no coincide con el puerto destino del último tramo de la lista.");
		}
	}
	
	
	// Validador de tramos entre el puerto destino del último tramo del circuito y el puerto de origen del tramo a agregar.
	private boolean coindicenPuertosDestinoOrigen( Tramo tramo )
	{
		Tramo ultimoTramo = listaDeTramo.get(listaDeTramo.size() - 1);
		return ultimoTramo.getPuertoDestino() == tramo.getPuertoOrigen();
	}
	

	
	//POSIBLE SOLUCION PENSADA POR LAS VIVENCIAS EN EDD
	public List<Tramo> circuitoDesde(TerminalPortuaria terminalPortuaria) {
	    List<Tramo> nuevaLista = new ArrayList<>();
	    boolean condicionCumplida = false;

	    for (Tramo tramo : listaDeTramo) {
	        if (condicionCumplida) {
	            nuevaLista.add(tramo);
	        } else {
	            if (tramo.getPuertoOrigen().equals(terminalPortuaria)) {
	                condicionCumplida = true;
	                nuevaLista.add(tramo);
	            }
	        }
	    }
	    return nuevaLista;
	}

	//POSIBLE SOLUCION PENSADA POR LAS VIVENCIAS EN EDD
	public List<Tramo> circuitoHasta(TerminalPortuaria terminalPortuaria) {
	    List<Tramo> nuevoCircuito = new ArrayList<>();
	    
	    for (Tramo tramo : listaDeTramo) {
	        nuevoCircuito.add(tramo);
	        
	        if (tramo.getPuertoDestino().equals(terminalPortuaria)) {
	            break; // Termina el circuito cuando se cumple la condición
	        }
	    }
	    
	    return nuevoCircuito;
	}




	public double costoTotalDelCircuito()
	{
//		List<Tramo> listaDeTramosDeCircuito = this.circuitoHasta();
		double costoTotal = 0;
		for (Tramo tramo: this.listaDeTramo)
		{
			costoTotal = costoTotal + tramo.getCostoDetramo();
		}
		return costoTotal;
	}

	public boolean contieneA( TerminalPortuaria puertoDestino )
	{
		return this.listaDeTramo.stream().anyMatch(t -> t.getPuertoDestino() == puertoDestino );
	}

	public int cantidadDeEscalas ()
	{
		return listaDeTramo.size() - 1;
	}

	public long duracionCircuito()
	{
		long duracionCircuito = 0;
		for (Tramo tramo: this.listaDeTramo)
		{
			duracionCircuito = (long) (duracionCircuito + tramo.getDuracionTramo());
		}
		return duracionCircuito;
	}

}
