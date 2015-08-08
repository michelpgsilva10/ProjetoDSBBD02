package exception;

public class NegocioException extends Exception {

	public NegocioException() {
		super("Erro ocorrido no roteiro de transação");
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
	
}
