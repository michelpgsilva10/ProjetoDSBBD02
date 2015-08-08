package exception;

public class NegocioException extends Exception {
	
	public static final String ERRO_INSERCAO = "Não foi possível inserir o registro!";
	public static final String ERRO_CONVERSAO = "Não foi possível converter o valor informado!";
	public static final String ERRO_BUSCA = "Não foi possível retornar os dados da pesquisa";
	public static final String ERRO_ATUALIZACAO = "Não foi possível atualizar o registro";
	public static final String ERRO_DELECAO = "Não foi possível deletar o resgistro";

	public NegocioException() {
		super("Erro ocorrido no roteiro de transação");
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
	
}
