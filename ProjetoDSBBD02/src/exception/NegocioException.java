package exception;

public class NegocioException extends Exception {
	
	public static final String ERRO_INSERCAO = "Não foi possível inserir o registro!";
	public static final String ERRO_CONVERSAO = "Não foi possível converter o valor informado!";

	public NegocioException() {
		super("Erro ocorrido no roteiro de transação");
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
	
}
