package TerminalPortuaria.Ob2TF.Circuito;

import java.time.LocalDate;

import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Viaje
{
	Buque buqueViaje;
	LocalDate fechaDeSalida;
	TerminalPortuaria puertoOrigen;
	TerminalPortuaria puertoDestino;
	
	
	public Buque getBuqueViaje() {
		return buqueViaje;
	}
	public void setBuqueViaje(Buque buqueViaje) {
		this.buqueViaje = buqueViaje;
	}
	public LocalDate getFechaDeSalida() {
		return fechaDeSalida;
	}
	public void setFechaDeSalida(LocalDate fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}
	public TerminalPortuaria getPuertoOrigen() {
		return puertoOrigen;
	}
	public void setPuertoOrigen(TerminalPortuaria puertoOrigen) {
		this.puertoOrigen = puertoOrigen;
	}
	public TerminalPortuaria getPuertoDestino() {
		return puertoDestino;
	}
	public void setPuertoDestino(TerminalPortuaria puertoDestino) {
		this.puertoDestino = puertoDestino;
	}
	
	
	
	
}
