package exception;

public class NegocioException extends Exception {
	
	public static final String ERRO_INSERCAO = "N�o foi poss�vel inserir o registro!";
	public static final String ERRO_CONVERSAO = "N�o foi poss�vel converter o valor informado!";

	public NegocioException() {
		super("Erro ocorrido no roteiro de transa��o");
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
	
}
