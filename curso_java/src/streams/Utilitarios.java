package streams;

import java.util.function.UnaryOperator;

public class Utilitarios {

	private Utilitarios() {
	}

	public final static UnaryOperator<String> maiuscula = 
			n -> n.toUpperCase();

	public final static UnaryOperator<String> primeiraLetra = 
			n -> n.substring(0, 1);

	public final static String grito(String n) {
		return n + "!!! ";
	}
}
