package TerminalPortuaria.Ob2TF.Circuito;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;


public class Circuito
{
	int idCircuito;
	LocalDateTime fechaYHoraSalida;
	private List<Tramo> listaDeTramo = new ArrayList<Tramo>();

	public List<Tramo> getListaDeTramo() 
	{
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

	
	public TerminalPortuaria puertoOrigenCircuito() 
	{
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
	

	
	/*
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
	*/
	
/*
			return viaje.getCircuito.construirCircuitoDesdeHasta( terminalOrgen, terminalDestino).costoTotalDelCircuito();
			
			
			
*/
	
	// Deuda refactor validaciones
    public Circuito construirCircuitoDesdeHasta(TerminalPortuaria terminalOrigen, TerminalPortuaria terminalDestino) 
    {
        if (terminalesExistenEnCircuito(terminalOrigen, terminalDestino)) 
        {
            Tramo tramoOrigen = obtenerTramoPorPuertoOrigen(terminalOrigen);
            Tramo tramoDestino = obtenerTramoPorPuertoDestino(terminalDestino);

            if (validarSiOrigenEstaAntesQueDestino(tramoOrigen, tramoDestino))
            {
                return construirCircuitoReducido(tramoOrigen, tramoDestino);
            }
        }
        return null;
    }
    

    private boolean terminalesExistenEnCircuito(TerminalPortuaria terminalOrigen, TerminalPortuaria terminalDestino)
    {
        return validarSiTerminalExisteEnCircuito(terminalOrigen) && validarSiTerminalExisteEnCircuito(terminalDestino);
    }
    

    Tramo obtenerTramoPorPuertoOrigen(TerminalPortuaria puertoOrigen)
    {
        return listaDeTramo.stream()
                .filter(t -> t.getPuertoOrigen() == puertoOrigen)
                .findFirst()
                .orElse(null);
    }
    
    
    public Tramo obtenerTramoPorPuertoDestino(TerminalPortuaria puertoDestino)
    {
        return listaDeTramo.stream()
                .filter(t -> t.getPuertoDestino() == puertoDestino)
                .findFirst()
                .orElse(null);
    }

    
    boolean validarSiOrigenEstaAntesQueDestino(Tramo tramoOrigen, Tramo tramoDestino)
    {
        return listaDeTramo.indexOf(tramoOrigen) < listaDeTramo.indexOf(tramoDestino) ||
        		listaDeTramo.indexOf(tramoOrigen) == listaDeTramo.indexOf(tramoDestino);
    }

    
    boolean validarSiPuertoOrigenEstaAntesQuePuertoDestino( TerminalPortuaria puertoOrigen, TerminalPortuaria puertoDestino )
    {
    	return this.primerIndexPuerto(puertoOrigen) < this.primerIndexPuerto(puertoDestino);
    }
    
    
    private int primerIndexPuerto( TerminalPortuaria puerto )
    {
        OptionalInt index = IntStream.range(0, listaDeTramo.size())
                .filter(i -> listaDeTramo.get(i).getPuertoOrigen() == puerto || listaDeTramo.get(i).getPuertoDestino() == puerto)
                .findFirst(); // También se podía usar indexOf que es más sencillo y devuelve la primer coincidencia.
        
        return index.getAsInt();
    }
    
    
    
//    private Circuito construirCircuitoReducido(Tramo tramoOrigen, Tramo tramoDestino)
//    {
//        int indexOfOrigen = listaDeTramo.indexOf(tramoOrigen);
//        int indexOfDestino = listaDeTramo.indexOf(tramoDestino);
//
//        List<Tramo> listaTramoReducida = listaDeTramo.subList(indexOfOrigen, indexOfDestino);
//        return new Circuito(listaTramoReducida, listaTramoReducida.get(0).getFechaYHoraSalida());
//    }
    
    //LOS PARAMETROS DEBERIAN SER DEL TIPO TERMINAL PORTUARIA
    private Circuito construirCircuitoReducido(Tramo tramoOrigen, Tramo tramoDestino)
    {
    	int indexOfOrigen = listaDeTramo.indexOf(tramoOrigen);
    	int indexOfDestino = listaDeTramo.indexOf(tramoDestino) + 1;

    	List<Tramo> listaTramoReducida = listaDeTramo.subList(indexOfOrigen, indexOfDestino);
    	return new Circuito(listaTramoReducida, listaTramoReducida.get(0).getFechaYHoraSalida());
    }

    
    public boolean validarSiTerminalExisteEnCircuito(TerminalPortuaria terminal)
    {
        return listaDeTramo.stream().anyMatch(t -> t.getPuertoDestino() == terminal || t.getPuertoOrigen() == terminal);
    }
    
    
/*
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
*/



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

//	public boolean contieneA( TerminalPortuaria puertoDestino )
//	{
//		return this.listaDeTramo.stream().anyMatch(t -> t.getPuertoDestino() == puertoDestino );
//	}

	public int cantidadDeEscalas()
	{
		return this.listaDeTramo.size() - 1;
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