package oo.encapsulamento;

public class Pessoa {

	private String nome;
	private String sobrenome;
	private int idade;

	public Pessoa(String nome, String sobrenome, int idade) {
		setNome(nome);
		setSobrenome(sobrenome);
		setIdade(idade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getNomeCompleto() {
		return getNome() + " " + getSobrenome();
	}

	// Getter
	public int getIdade() {
		return idade;
	}

	// Setter
	public void setIdade(int newIdade) {
		newIdade = Math.abs(newIdade);
		if (newIdade >= 0 && newIdade <= 120) {
			this.idade = newIdade;
		}
	}

	public String toString() {
		return "Olá eu sou o " + getNome() + " e tenho " + getIdade() + " anos!";
	}

}
