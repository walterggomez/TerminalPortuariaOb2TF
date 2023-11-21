package TerminalPortuaria.Ob2TF.Orden;

import java.time.LocalDateTime;

import TerminalPortuaria.Ob2TF.Buque.Buque;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Container.Container;

public class OrdenExportacion extends Orden
{


	
	
	public OrdenExportacion(Cliente cliente, Viaje viaje, Container container, Buque buque, LocalDateTime fecha) {
		super(cliente, viaje, container, buque);
		this.fechaYHoraDeEntrega = fecha;
	}

	public LocalDateTime getFechaYHoraDeEntrega() {
		return fechaYHoraDeEntrega;
	}
}
