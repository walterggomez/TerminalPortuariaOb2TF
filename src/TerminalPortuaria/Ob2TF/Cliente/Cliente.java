package TerminalPortuaria.Ob2TF.Cliente;

import java.time.LocalDateTime;

import TerminalPortuaria.Ob2TF.EmpresaTransportista.Camion;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Chofer;

public abstract class Cliente
{
	protected String nombre;
	protected int codigoCliente;
	protected Chofer chofer;
	protected Camion camion; 
	protected LocalDateTime turno;
	
	abstract boolean soy(String string);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public Camion getCamion() {
		return camion;
	}

	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	
	public LocalDateTime getTurno() {
		return turno;
	}
	

}
