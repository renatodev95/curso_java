package generics;

public class CaixaTeste {

	public static void main(String[] args) {
		
		/*
		 * Classes genéricas são classes na qual, tem funções e/ou métodos que são
		 * bastantes usadas na aplicação, pois com isso, você não precisa reescrever
		 * essa função/método várias vezes, basta escrever uma única vez e depois
		 * importar a classe genérica.
		 */
		
		Caixa<String> caixaA = new Caixa<>();
		caixaA.guardar("segredo!");
		
		String coisaA = caixaA.abrir();
		System.out.println(coisaA);
		
		Caixa<Double> caixaB = new Caixa<>();
		caixaB.guardar(3.1415);
		
		Double coisaB = caixaB.abrir();
		System.out.println(coisaB);
	}
}
