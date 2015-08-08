package exception;

public class NegocioException extends Exception {
	
	public static final String ERRO_INSERCAO = "N�o foi poss�vel inserir o registro!";
	public static final String ERRO_CONVERSAO = "N�o foi poss�vel converter o valor informado!";
	public static final String ERRO_BUSCA = "N�o foi poss�vel retornar os dados da pesquisa";
	public static final String ERRO_ATUALIZACAO = "N�o foi poss�vel atualizar o registro";
	public static final String ERRO_DELECAO = "N�o foi poss�vel deletar o resgistro";

	public NegocioException() {
		super("Erro ocorrido no roteiro de transa��o");
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
	
}
