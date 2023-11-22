package TerminalPortuaria.Ob2TF.EmpresaTransportista;
import java.util.ArrayList;
import java.util.List;
import TerminalPortuaria.Ob2TF.Cliente.*;
import TerminalPortuaria.Ob2TF.Orden.*;

public class EmpresaTransportista 
{
	private List<Camion> camiones = new ArrayList<Camion>();
	private List<Chofer> choferes = new ArrayList<Chofer>();
	
	
	public TransporteAsignado asignarTransporte(Orden orden)
	{
		// Asigna un chofer y un camión al transporte asignado para el cliente
		Camion camionAsignado = camiones.stream().filter( c -> ! c.tieneOrdenAsignada() ).findFirst().orElse(null);
		Chofer choferAsignado = choferes.stream().filter( c -> ! c.tieneOrdenAsignada() ).findFirst().orElse(null);
		
		// Asigna la orden al chofer y camión asignados
		camionAsignado.setOrdenAsignada(orden);
		choferAsignado.setOrdenAsignada(orden);
		
		// Genera el transporte asignado
		return new TransporteAsignado( orden, camionAsignado, choferAsignado );
	}

	
}
