package entities;


public class Product {
	
	private String produto ;
	private Integer quantidade;
	private Double precoUnitario;
	
	public Product(String produto, Integer quantidade, Double precoUnitario) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public double total() {
		return quantidade * precoUnitario;
	}	
}
