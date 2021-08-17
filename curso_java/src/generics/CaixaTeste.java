package generics;

public class CaixaTeste {

	public static void main(String[] args) {
		
		/*
		 * Classes gen�ricas s�o classes na qual, tem fun��es e/ou m�todos que s�o
		 * bastantes usadas na aplica��o, pois com isso, voc� n�o precisa reescrever
		 * essa fun��o/m�todo v�rias vezes, basta escrever uma �nica vez e depois
		 * importar a classe gen�rica.
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
