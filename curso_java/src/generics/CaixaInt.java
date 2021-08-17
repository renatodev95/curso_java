package generics;

// Resolvendo o tipo no momento da herança
public class CaixaInt extends Caixa<Integer> {

	// CaixaInt herda de Caixa, mas já com o tipo resolvido
	// então a instância de CaixaInt terá que ser do tipo Integer
}
