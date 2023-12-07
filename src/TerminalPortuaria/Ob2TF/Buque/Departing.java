
package TerminalPortuaria.Ob2TF.Buque;
import java.util.List;
import TerminalPortuaria.Ob2TF.Circuito.Viaje;
import TerminalPortuaria.Ob2TF.Cliente.Cliente;
import TerminalPortuaria.Ob2TF.Container.Container;
import TerminalPortuaria.Ob2TF.EmpresaTransportista.EmpresaTransportista;
import TerminalPortuaria.Ob2TF.Servicios.AlmacenamientoExcedente;
import TerminalPortuaria.Ob2TF.TerminalP.TerminalPortuaria;

public class Departing implements EstadoBuque 
{

	@Override
    public void actualizarEstado(Buque buque) 
	{
            buque.getViajeActual().getpuertoOrigen().enviarFacturaOrden( buque.getViajeActual() );
        	buque.setestadoBuque(new Outbound());
            buque.getViajeActual().getpuertoOrigen().darAvisoShippers( buque.getViajeActual() );
     }
     
	public double distanciaATerminal(Buque buque, TerminalPortuaria puertoGestionado) {
		return buque.getMiGps().distanciaEntrePuntos(buque.getPosicionActual(), puertoGestionado.getUbicacion());
	}
	@Override
	public void evaluar(Buque buque, TerminalPortuaria terminalPortuaria) {
		if (this.distanciaATerminal(buque,terminalPortuaria) > 1.0) {
			this.actualizarEstado(buque);
		}
		
	}




}