package util;

public class ConexaoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConexaoException(String mensagem) {
		super(mensagem);
	}
	
	public ConexaoException(Exception e) {
		super(e);
	}
}
