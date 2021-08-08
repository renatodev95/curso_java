package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStreams {

	public static void main(String[] args) {

		// criando uma referencia de método para prinln
		Consumer<String> print = System.out::print;
		Consumer<Integer> println = System.out::print;

		// #01 'Stream.of'
		Stream<String> langs = Stream.of("Java ", "Lua ", "JS\n");
		langs.forEach(print);

		// #02 a partir de um Array
		String[] maisLangs = { "Python ", "Lisp ", "Perl ", "Go\n" };
		Stream.of(maisLangs).forEach(print);

		// #03 utilizando a classe Arrays.stream
		Arrays.stream(maisLangs).forEach(print);

		// selecionando um subconjunto do array a partir dos índices
		Arrays.stream(maisLangs, 1, 2).forEach(print);

		// #04 criando streams a partir de Collections
		List<String> outrasLangs = Arrays.asList("C ", "PHP ", "Kotlin\n");
		outrasLangs.stream().forEach(print); // exibe os elementos em ordem
		outrasLangs.parallelStream().forEach(print); // exibicao nao ordenada

		// #05 criando streams com GENERATE
		// Stream.generate(() -> "a").forEach(print);

		// #06 Stream.iterate
		// gera valores infinitamente
		Stream.iterate(0, n -> n + 1).forEach(println);
	}
}
