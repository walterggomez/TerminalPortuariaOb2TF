package TerminalPortuaria.Ob2TF.Cliente;

public class Shipper extends Cliente {

	public Shipper(String nombre, int codigoCliente) {
		super(nombre, codigoCliente);
	}

	@Override
	public boolean soy(String string) {
		if (string == "Shipper") {
			return true;
		}
		else {
			return false;
		}
	}
	
}
