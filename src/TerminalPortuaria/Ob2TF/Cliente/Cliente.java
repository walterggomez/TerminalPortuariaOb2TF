package TerminalPortuaria.Ob2TF.Cliente;

import java.time.LocalDateTime;

import TerminalPortuaria.Ob2TF.EmpresaTransportista.Camion;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.Chofer;

public abstract class Cliente implements Suscriptor
{
	protected String nombre;
	protected int codigoCliente;
	protected LocalDateTime turno;

	public Cliente(String nombre, int codigoCliente) {
		super();
		this.nombre = nombre;
		this.codigoCliente = codigoCliente;
	}

	public abstract boolean soy(String string);

	public String getNombre() {
		return nombre;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public LocalDateTime getTurno() {
		return turno;
	}

	public void setTurno(LocalDateTime turno) {
		this.turno = turno;
	}

	@Override
	public void recibirMail( String mensaje ) {};
	
}
