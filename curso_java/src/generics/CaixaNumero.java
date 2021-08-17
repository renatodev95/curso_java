package generics;

public class CaixaNumero<N extends Number> extends Caixa<N> {
	// Criando restrições com relação aos tipos que CaixaNumero
	// poderá conter, N está herdando da classe Number, dessa forma,
	// o tipo resolvido em Caixa deverá ser o mesmo que está herdando
	// de Number, no caso o N.
	
	
}
