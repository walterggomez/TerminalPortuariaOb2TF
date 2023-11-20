package TerminalPortuaria.Ob2TF.TerminalP;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import TerminalPortuaria.Ob2TF.Naviera.Naviera;
import TerminalPortuaria.Ob2TF.Orden.Orden;
import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.BusquedaMaritima.*;
import TerminalPortuaria.Ob2TF.Circuito.Circuito;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;


public class TerminalPortuaria
{
	private Point2D  ubicacion;
	private List<Naviera> misNavieras;
	private List<Viaje> viajes;
	private List<Orden> ordenes;
	
	public TerminalPortuaria() {
		
	}

	public TerminalPortuaria(Point2D ubicacion) {
		this.ubicacion = ubicacion;
		this.misNavieras = new ArrayList<Naviera>();
		this.viajes = new ArrayList<Viaje>();
		this.ordenes = new ArrayList<Orden>();
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
	
	public void trabajoCargaYDescarga(Buque buque) {
		//posible verificacion de estado arrived
		buque.actualizarEstado();
	}
	
	public void depart(Buque buque) {
		//posible verificacion de estado working
		buque.actualizarEstado();
	}
	
	public void avisarClientes() {
		
	}
	
	//CONVERTIR LISTA DE ORDENES A LISTA DE CLIENTES
	private List<Orden> filtrarLista(Viaje viaje) {
		return this.ordenes.stream().filter( v -> v.getbuque() == viaje.getBuqueViaje()).toList();
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
