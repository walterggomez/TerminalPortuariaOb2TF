package TerminalPortuaria.Ob2TF.Cliente;

public class Consignee extends Cliente{

	@Override
	boolean soy(String string) {
		if (string == "Consignee") {
			return true;
		}
		else {
			return false;
		}
	}

}
