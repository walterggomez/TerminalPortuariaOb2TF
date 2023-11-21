package TerminalPortuaria.Ob2TF.Cliente;

public class Shipper extends Cliente {

	@Override
	boolean soy(String string) {
		if (string == "Shipper") {
			return true;
		}
		else {
			return false;
		}
	}
	
}
