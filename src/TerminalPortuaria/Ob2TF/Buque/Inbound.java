package TerminalPortuaria.Ob2TF.Buque;

public class Inbound implements EstadoBuque {

	@Override
	public void actualizarEstado(Buque buque) 
	{
		if (buque.getPosicionActual() == buque.puertoDestino().getUbicacion()) {
			buque.setestadoBuque(new Arrived());
		}
	}

	@Override
	public boolean estoyEnEstado(String string) {
		if (string == "Inbound") {
			return true;
		} else {
			return false;
		}
	}

}
