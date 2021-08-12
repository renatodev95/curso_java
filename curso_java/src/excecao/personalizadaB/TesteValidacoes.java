package excecao.personalizadaB;

import excecao.Aluno;

public class TesteValidacoes {

	public static void main(String[] args) {

		try {
			Aluno aluno = new Aluno("Ana", 7);
			Validar.aluno(aluno);
			
		} catch (StringVaziaException e) {	// tratamento simplificado
			System.out.println(e.getMessage());
		} catch (NumeroForaIntervaloException | IllegalArgumentException e) { // tratamento composto de exceções
			System.out.println(e.getMessage());
		}

		try {
			Validar.aluno(null);
		} catch (StringVaziaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumeroForaIntervaloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Ao chegar até esta sentença sabemos que os erros foram tratados
		System.out.println("Fim!");
	}
}
