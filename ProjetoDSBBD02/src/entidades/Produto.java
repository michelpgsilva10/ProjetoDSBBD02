package entidades;

import validacao.Validacao;
import validacao.ValidacaoTableModel;

public class Produto {
	
	private int codigo;
	
	@Validacao(requerido = true)
	private String nome;
	
	private int estoque;
	
	private float precoCompra;
	
	private float margemLucro;
	
	private float promocao;
	
	@Validacao(requerido = true)
	private GrupoProduto grupoProduto;

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
	
	@ValidacaoTableModel(nome = "Código", posicao = 0)
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@ValidacaoTableModel(nome = "Nome", posicao = 1)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ValidacaoTableModel(nome = "Estoque", posicao = 2)
	public int getEstoque() {
		return estoque;
	}
	
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	@ValidacaoTableModel(nome = "Compra", posicao = 3)
	public float getPrecoCompra() {
		return precoCompra;
	}
	
	public void setPrecoCompra(float precoCompra) {
		this.precoCompra = precoCompra;
	}
	
	@ValidacaoTableModel(nome = "Margem de Lucro", posicao = 4)
	public float getMargemLucro() {
		return margemLucro;
	}
	
	public void setMargemLucro(float margemLucro) {
		this.margemLucro = margemLucro;
	}
	
	@ValidacaoTableModel(nome = "Promocao", posicao = 5)
	public float getPromocao() {
		return promocao;
	}
	
	public void setPromocao(float promocao) {
		this.promocao = promocao;
	}	
	
	@ValidacaoTableModel(nome = "Grupo Produto", posicao = 6)
	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}
	
	@ValidacaoTableModel(nome = "Venda", posicao = 7)
	public float getValorVenda() {
		float valorVenda = getPrecoCompra() + (getPrecoCompra() * getMargemLucro() / 100);
		valorVenda -= margemLucro * getPromocao() / 100;
		
		return valorVenda;
	}
	
}
