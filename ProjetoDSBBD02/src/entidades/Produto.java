package entidades;

public class Produto {
	private int codigo;
	private String nome;
	private int estoque;
	private float precoCompra;
	private float margemLucro;
	private float promocao;
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
