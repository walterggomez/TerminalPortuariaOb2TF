package TerminalPortuaria.Ob2TF.Buque;

public class Working implements EstadoBuque {

	@Override
	public void actualizarEstado(Buque buque) {
		buque.setestadoBuque(new Departing());
	}

	@Override
	public boolean estoyEnEstado(String string) {
		if (string == "Working") {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double distanciaATerminal(Buque buque) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void evaluar(Buque buque) {
		// TODO Auto-generated method stub
		
	}



}
