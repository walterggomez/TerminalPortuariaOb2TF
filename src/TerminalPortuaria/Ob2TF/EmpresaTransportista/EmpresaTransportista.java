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
	private List<Camion> camiones = new ArrayList<Camion>();
	private List<Chofer> choferes = new ArrayList<Chofer>();
	
	
	public TransporteAsignado asignarTransporte(Orden orden)
	{
		// Asigna un chofer y un camión al transporte asignado para el cliente
		Camion camionAsignado = camiones.get(0);
		Chofer choferAsignado = choferes.get(0);
	
		
		// Genera el transporte asignado
		return new TransporteAsignado( camionAsignado, choferAsignado );
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


	public List<Camion> getCamiones()
	{
		return this.camiones;
	}


	public List<Chofer> getChoferes()
	{
		return this.choferes;
	}

	
}
