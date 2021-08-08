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
		
		System.out.println("\n\nUsando COMPOSI��O...");
		marcas.stream()
			.map(Utilitarios.maiuscula) // usando um m�todo est�tico de outra classe
			.map(primeiraLetra) // usando express�o lambda que est� nessa classe
			.map(Utilitarios::grito) // usando refer�ncia de m�todo
			.forEach(print);
	}
}
