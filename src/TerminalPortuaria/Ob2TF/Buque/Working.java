package TerminalPortuaria.Ob2TF.Buque;

public class Working implements EstadoBuque{

	@Override
	public void actualizarEstado(Buque buque) {
		buque.setestadoBuque(new Departing());
	}

}
