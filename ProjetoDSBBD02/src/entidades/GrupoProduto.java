package entidades;

public class GrupoProduto {
	private int codigo;
	private String nome;
	private float margemLucro;
	private float promocao;
	
	public GrupoProduto() {
		
	}
	
	public GrupoProduto(int codigo, String nome, float margemLucro, float promocao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.margemLucro = margemLucro;
		this.promocao = promocao;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome();
	}
	
	
}
