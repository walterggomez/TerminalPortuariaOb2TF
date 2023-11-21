package TerminalPortuaria.Ob2TF.Buque;

public class Departing implements EstadoBuque {

	@Override
	public void actualizarEstado(Buque buque) {
		if (buque.getMiGps().distanciaEntrePuntos(buque.getPosicionActual(),
				buque.puertoDestino().getUbicacion()) > 1) {
			buque.avisarTerminalPortuaria(buque.getViajeActual().getpuertoOrigen());
			buque.setestadoBuque(new Outbound());
		}

	}

	@Override
	public boolean estoyEnEstado(String string) {
		if (string == "Departing") {
			return true;
		} else {
			return false;
		}
	}

}