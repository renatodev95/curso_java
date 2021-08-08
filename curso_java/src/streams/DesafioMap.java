package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		/*
		 * 1. N�mero para string bin�ria... 6 => "110"
		 * 2. Inverter a string..."110" => "011"
		 * 3. Converter de volta para inteiro..."011" => 3
		 */

		// Convertendo n�mero em string bin�ria
		Function<Integer, String> numberToBinary = 
				n -> Integer.toBinaryString(n);

		// Invertendo string com a classe StringBuilder
		UnaryOperator<String> inverter = 
				s -> new StringBuilder(s).reverse().toString();

		// Convertendo uma string bin�ria para um n�mero inteiro na base 2
		Function<String, Integer> binaryToNumber = 
				s -> Integer.parseInt(s, 2);

		nums.stream()
		.map(numberToBinary)
		.map(inverter)
		.map(binaryToNumber)
		.forEach(System.out::println);
	}
}
