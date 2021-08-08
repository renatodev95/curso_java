package streams;

public class Produto {

	final private String nome;
	final private double preco;
	final private double desconto;
	final private double frete;

	public Produto(String nome, double preco, double desconto, double frete) {
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		this.frete = frete;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public double getFrete() {
		return frete;
	}

	public double getDesconto() {
		return desconto;
	}
}
