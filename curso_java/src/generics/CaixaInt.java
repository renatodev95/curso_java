package generics;

// Resolvendo o tipo no momento da heran�a
public class CaixaInt extends Caixa<Integer> {

	// CaixaInt herda de Caixa, mas j� com o tipo resolvido
	// ent�o a inst�ncia de CaixaInt ter� que ser do tipo Integer
}
