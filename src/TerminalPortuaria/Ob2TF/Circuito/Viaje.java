package TerminalPortuaria.Ob2TF.Circuito;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Cliente.Suscriptor;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Viaje
{
	Buque buqueViaje;
	Circuito circuitoViaje;
	LocalDateTime fechaDeSalida;
	LocalDateTime fechaDeLlegada;
	TerminalPortuaria puertoOrigen;
	TerminalPortuaria puertoDestino;
    // private Map<String, List<Suscriptor>> listeners = new HashMap<>();      
    private List<Suscriptor> shippers = new ArrayList<Suscriptor>();
    private List<Suscriptor> consignees = new ArrayList<Suscriptor>();
    
	
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
	
	public TerminalPortuaria getpuertoOrigen() {
		return this.puertoOrigen;
	}
	
	public TerminalPortuaria getpuertoDestino()
	{
		return puertoDestino;
	}
	
	public LocalDateTime getFechaDeLlegada()
	{
		return fechaDeLlegada;
	}
	
	public Buque getBuqueViaje() {
		return buqueViaje;
	}
	
	public void setBuqueViaje(Buque buqueViaje)
	{
		this.buqueViaje = buqueViaje;
	}
	
	public LocalDateTime getFechaDeSalida() {
		return fechaDeSalida;
	}
	
	public void setFechaDeSalida(LocalDateTime fechaDeSalida)
	{
		this.fechaDeSalida = fechaDeSalida;
	}
	
	public Circuito getCircuito()
	{
		return this.circuitoViaje;
	}
	
    public void suscribe(List<Suscriptor> suscriptores, Cliente cliente)
    {
    	suscriptores.add(cliente);
     }

    public void unsubscribe(List<Suscriptor> suscriptores, Cliente cliente)
    {
    	suscriptores.remove(cliente);
    }
    
    public void notify(List<Suscriptor> suscriptores, String mensaje) 
    {
            for ( Suscriptor suscriptor : suscriptores ) 
            {
            	suscriptor.recibirMail( mensaje );
            }
    }

	public List<Suscriptor> getShippers()
	{
		return shippers;
	}

	public List<Suscriptor> getConsignees() 
	{
		return consignees;
	}
    
    
	
}
