package TerminalPortuaria.Ob2TF.Buque;

public class Departing implements EstadoBuque {

	@Override
	public void actualizarEstado(Buque buque) {
		if (GPS.distanciaEntrePuntos(buque.getPosicionActual(), buque.puertoDestino().getUbicacion()) > 1) {
			buque.avisarTerminalPortuaria(buque.getViajeActual().getpuertoOrigen());
			buque.setestadoBuque(new Outbound());
		}
		
	}

}