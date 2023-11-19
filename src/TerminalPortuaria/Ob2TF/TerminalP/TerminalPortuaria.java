package TerminalPortuaria.Ob2TF.TerminalP;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.List;

import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;

public class TerminalPortuaria
{
	private Point2D  ubicacion;
	private List<Naviera> misNavieras;
	private List<Viaje> viajes;
	
	public TerminalPortuaria() {
		
		
	}

	public TerminalPortuaria(Point2D ubicacion)
	{
		super();
		this.ubicacion = ubicacion;
	}

	public Point2D getUbicacion()
	{
		return ubicacion;
	}


	public List<Naviera> getMisNavieras()
	{
		return misNavieras;
	}

	

	public List<Viaje> getMisViajes()
	{
		return viajes;
	}

	public void registrarNuevaNaviera(Naviera nav) {
		if (this.estoyEnUnCircuitoDeLaNaviera(nav)) {
			this.getMisNavieras().add(nav);
		}else{
			System.out.println("Naviera no valida para registrar");			
		}
		
	}

	public boolean estoyEnUnCircuitoDeLaNaviera(Naviera nav) {
		List<Circuito> circuitosNaviera = nav.getMisCircuitos();
		return circuitosNaviera.stream().anyMatch(cir->cir.validarSiTerminalExisteEnCircuito(this));

	}
	
	
	/*
	 private EstrategiaMejorRuta estrategiaSeleccionada;
	 
	 
	 
	 
	 private void setMejorCircuito( EstrategiaMejorRuta estrategia )
	 {
	 	this.mejorCircuito = estrategia;
	 }
	 
	 
	 public Circuito getMejorCircuito(TerminalGestionada terminalDestino)
	 {
	 	return this.estrategiaSeleccionada.mejorCircuito(this, terminalDestino);
	 }
	 
	 
	 */
	
	
}
