package TerminalPortuaria.Ob2TF.Buque;

public class Outbound implements EstadoBuque {

	@Override
	public void actualizarEstado(Buque buque) {
		if (buque.getMiGps().distanciaEntrePuntos(buque.getPosicionActual(),
				buque.puertoDestino().getUbicacion()) < 50) 
		{
			buque.avisarTerminalPortuaria(buque.getViajeActual().getpuertoDestino(), buque.getViajeActual().getConsignees(), "Su carga está llegando");
			buque.setestadoBuque(new Inbound());
        	buque.getViajeActual().unsubscribe(buque.getViajeActual().getConsignees(), 
        			buque.puertoOrigen().buscarOrdenPorBuqueYViaje(buque.getViajeActual(), buque).getCliente());
		}
	}

	@Override
	public boolean estoyEnEstado(String string) 
	{
		if (string == "Outbound") 
		{
			return true;
		} else 
		{
			return false;
		}
	}
}
