package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Map {

	public static void main(String[] args) {
		
		Consumer<String> print = System.out::print;
		
		List<String> marcas = Arrays.asList("BMW ", "Audi ", "Honda ");
		marcas.stream().map(m -> m.toUpperCase()).forEach(print);
		
		//UnaryOperator<String> maiuscula = n -> n.toUpperCase();
		UnaryOperator<String> primeiraLetra = n -> n.substring(0, 1);
		//UnaryOperator<String> grito = n -> n + "!!! ";
		
		System.out.println("\n\nUsando COMPOSIÇÃO...");
		marcas.stream()
			.map(Utilitarios.maiuscula) // usando um método estático de outra classe
			.map(primeiraLetra) // usando expressão lambda que está nessa classe
			.map(Utilitarios::grito) // usando referência de método
			.forEach(print);
	}
}
