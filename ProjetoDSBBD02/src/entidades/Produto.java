package entidades;

import validacao.Validacao;

public class Produto {
	private int codigo;
	
	@Validacao(requerido = true)
	private String nome;
	
	@Validacao(requerido = true)
	private int estoque;
	
	@Validacao(requerido = true)
	private float precoCompra;
	
	@Validacao(requerido = true)
	private float margemLucro;
	
	private float promocao;
	
	@Validacao(requerido = true)
	private GrupoProduto grupoProduto;
	
	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	public Produto() {
		
	}
	
	public Produto(int codigo, String nome, int estoque, float precoCompra, float margemLucro, float promocao, GrupoProduto grupoProduto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.estoque = estoque;
		this.precoCompra = precoCompra;
		this.margemLucro = margemLucro;
		this.promocao = promocao;
		this.grupoProduto = grupoProduto;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getEstoque() {
		return estoque;
	}
	
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public float getPrecoCompra() {
		return precoCompra;
	}
	
	public void setPrecoCompra(float precoCompra) {
		this.precoCompra = precoCompra;
	}
	
	public float getMargemLucro() {
		return margemLucro;
	}
	
	public void setMargemLucro(float margemLucro) {
		this.margemLucro = margemLucro;
	}
	
	public float getPromocao() {
		return promocao;
	}
	
	public void setPromocao(float promocao) {
		this.promocao = promocao;
	}	
	
}
