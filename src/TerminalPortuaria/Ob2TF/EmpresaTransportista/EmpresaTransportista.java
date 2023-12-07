package TerminalPortuaria.Ob2TF.EmpresaTransportista;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import TerminalPortuaria.Ob2TF.Cliente.*;
import TerminalPortuaria.Ob2TF.Orden.*;

public class EmpresaTransportista
{
	private Set<Camion> camiones = new HashSet<Camion>();
	private Set<Chofer> choferes = new HashSet<Chofer>();
	
	
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


	public void agregarNuevoCamion(Camion camion) {
		if (!camiones.contains(camion)) {
			camiones.add(camion);
		}
		
	}
	
	public void agregarNuevoChofer(Chofer chofer) {
		if (!choferes.contains(chofer)) {
			choferes.add(chofer);
		}
		
	}


	public Object getCamiones() {
		// TODO Auto-generated method stub
		return camiones;
	}


	public Object getChoferes() {
		// TODO Auto-generated method stub
		return choferes;
	}

	
}
