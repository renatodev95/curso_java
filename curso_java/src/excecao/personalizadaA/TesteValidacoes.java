package excecao.personalizadaA;

import excecao.Aluno;

public class TesteValidacoes {

	public static void main(String[] args) {

		try {
			Aluno aluno = new Aluno("Ana", 7);
			Validar.aluno(aluno);
			
			Validar.aluno(null);
		} catch (StringVaziaException e) {	// tratamento simplificado
			System.out.println(e.getMessage());
		} catch (NumeroForaIntervaloException | IllegalArgumentException e) { // tratamento composto de exceções
			System.out.println(e.getMessage());
		}

		// Ao chegar até esta sentença sabemos que os erros foram tratados
		System.out.println("Fim!");
	}
}
