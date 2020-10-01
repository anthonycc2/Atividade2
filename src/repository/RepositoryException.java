package repository;

public class RepositoryException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepositoryException(String mensagem) {
		super(mensagem);
	}
	
	public RepositoryException(Exception e) {
		super(e);
	}
}
