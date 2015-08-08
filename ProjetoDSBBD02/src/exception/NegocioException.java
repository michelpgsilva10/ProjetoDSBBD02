package exception;

public class NegocioException extends Exception {

	public NegocioException() {
		super("Erro ocorrido no roteiro de transa��o");
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
	
}
