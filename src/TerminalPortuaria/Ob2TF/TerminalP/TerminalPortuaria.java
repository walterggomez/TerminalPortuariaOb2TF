package TerminalPortuaria.Ob2TF.TerminalP;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;

import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;

public class TerminalPortuaria
{
	private Point2D  ubicacion;
	private List<Naviera> misNavieras;
	private List<Viaje> viajes;
	
	
	
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
	
	public List<Viaje> getMisViajes() {
		return viajes;
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
