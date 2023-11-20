package TerminalPortuaria.Ob2TF.Buque;

public class Outbound implements EstadoBuque{

	@Override
	public void actualizarEstado(Buque buque) {
		if (buque.getMiGps().distanciaEntrePuntos(buque.getPosicionActual(), buque.puertoDestino().getUbicacion()) < 50) {
			buque.avisarTerminalPortuaria(buque.getViajeActual().getpuertoDestino());
			buque.setestadoBuque(new Inbound());
		}
	}

}
