package Entities;

public class Produto {
	
	private String nome;
	private Double preco;
	private Integer quant;
	
	public Produto(String nome, Double preco, Integer quant) {
		
		this.nome = nome;
		this.preco = preco;
		this.quant = quant;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}
	
	public double total() {
		return preco * quant;
	}
	
	
	
	

}
