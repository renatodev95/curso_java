package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter2 {

	public static void main(String[] args) {

		Produto p1 = new Produto("SSD", 169.90, 0.33, 0);
		Produto p2 = new Produto("Processador", 1689.90, 0.25, 0);
		Produto p3 = new Produto("Headset", 479.90, 0.40, 0);
		Produto p4 = new Produto("Smart TV", 3699.00, 0.32, 0);
		Produto p5 = new Produto("GPU", 10699.90, 0.20, 40.00);
		Produto p6 = new Produto("Videogame", 2548.90, 0.30, 0);
		Produto p7 = new Produto("Celular", 2500.00, 0.30, 60.50);

		List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5, p6, p7);

		Predicate<Produto> superPromocao = p -> p.getDesconto() >= 0.3;
		Predicate<Produto> freteGratis = p -> p.getFrete() == 0;
		Function<Produto, String> chamadaPromocional = 
				p -> "Aproveite! " + p.getNome() + " por R$" + String.format("%.2f", p.getPreco());
						
		produtos.stream()
			.filter(superPromocao)
			.filter(freteGratis)
			.map(chamadaPromocional)
			.forEach(System.out::println);
	}
}
