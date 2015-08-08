package entidades;

public class RegistroBaixa {
	
	private int codigo;
	private int motivo;
	private int quantidade;
	private Produto produto;
	
	public RegistroBaixa() {
		
	}
	
	public RegistroBaixa(int codigo, int motivo, int quantidade, Produto produto) {
		super();
		this.codigo = codigo;
		this.motivo = motivo;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getMotivo() {
		return motivo;
	}

	public void setMotivo(int motivo) {
		this.motivo = motivo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}		
	
}
