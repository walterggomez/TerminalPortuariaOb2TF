package TerminalPortuaria.Ob2TF.Circuito;
import java.util.List;
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
	
	public Circuito( List<Tramo> listaDeTramo, LocalDateTime fechaYHoraSalida )
	{
		super();
		this.listaDeTramo = listaDeTramo;
		this.fechaYHoraSalida = fechaYHoraSalida;
		this.setfechaYHoraSalida(fechaYHoraSalida);
		/* Este método en el constructor setea la fecha y hora de salida de los tramos del circuito. Testear que funcione correctamente. */
	}
	
	public void setfechaYHoraSalida(LocalDateTime fechaYHora)
	{
		listaDeTramo.get(0).setFechaYHoraSalida(fechaYHora);
		for( int i = 1; i <= listaDeTramo.size(); i++ )
		{
			listaDeTramo.get(i).setFechaYHoraSalida( listaDeTramo.get(i - 1).getFechaYHoraLlegada() );
		}
	} // Testear que funcione bien. Testear el caso en que instancie la fecha de salida desde el constructor y que se accione este método.
	


	public void setListaDeTramo(List<Tramo> listaDeTramo)
	{
		this.listaDeTramo = listaDeTramo;
	}
	
	public TerminalPortuaria puertoDestinoCircuito()
	{
		return listaDeTramo.get(listaDeTramo.size() -1 ).getPuertoDestino();
	}
	
	public TerminalPortuaria puertoOrigenCircuito()
	{
		return listaDeTramo.get(0).getPuertoOrigen();
	}

	
	public void agregarNuevoTramo(Tramo tramo) throws Exception
	{
	Tramo ultimoTramo = listaDeTramo.get(listaDeTramo.size() -1 );
	if ( ultimoTramo.getPuertoDestino() == tramo.getPuertoOrigen() )
	{
		listaDeTramo.add(tramo);
	}
	else
	{
		throw new Exception("Este tramo no es valido");
	}
	//Faltaria contemplar un try/catch para el caso de que sea una lista vacia
	}

	
	public double costoTotalDelCircuito()
	{
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
			duracionCircuito = duracionCircuito + tramo.getDuracionTramo();
		}
		return duracionCircuito;
	}

}
