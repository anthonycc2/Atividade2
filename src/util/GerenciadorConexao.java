package util;

import java.sql.Connection;

import util.ConexaoException;

public interface GerenciadorConexao {
	
	/**
	 * Estabelece uma conexao com o BD
	 * @return Objeto de conex�o
	 * @throws ConexaoException
	 */
	public Connection conectar() throws ConexaoException;
	
	/**
	 * Encerra a conexao c com o BD
	 * @param c Objeto de conex�o
	 * @throws ConexaoException
	 */
	public void desconectar(Connection c) throws ConexaoException;
}
