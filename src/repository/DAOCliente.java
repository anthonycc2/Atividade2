package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basica.Cliente;
import util.ConexaoException;
import util.GerenciadorConexao;
import util.GerenciadorConexaoMysql;

public class DAOCliente {
	private GerenciadorConexao ger;

	public Cliente consulta(Cliente cliente) throws ConexaoException, RepositoryException {
		ger = GerenciadorConexaoMysql.getInstancia();
		Connection c = ger.conectar();

		Cliente aux = null;
		String sql = "SELECT id, nome, email, cpf FROM clientes WHERE cpf=? OR email=?";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getEmail());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				aux = new Cliente();
				aux.setId(rs.getInt("id"));
				aux.setCpf(rs.getString("cpf"));
				aux.setNome(rs.getString("nome"));
				aux.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			ger.desconectar(c);
		}
		return aux;
	}

	public void inserir(Cliente cliente) throws ConexaoException, RepositoryException {
		ger = GerenciadorConexaoMysql.getInstancia();
		Connection c = ger.conectar();
		String sql = "INSERT INTO clientes (nome, email, cpf) VALUES(?,?,?)";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getCpf());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			ger.desconectar(c);
		}
	}

	//@Override
	public void excluir(Cliente cliente) throws ConexaoException, RepositoryException {
		ger = GerenciadorConexaoMysql.getInstancia();
		Connection c = ger.conectar();
		String sql = "DELETE FROM clientes WHERE id=?";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, cliente.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			ger.desconectar(c);
		}
	}

	//@Override
	public void alterar(Cliente cliente) throws ConexaoException, RepositoryException {
		ger = GerenciadorConexaoMysql.getInstancia();
		Connection c = ger.conectar();
		String sql = "UPDATE clientes SET nome=?, email=?, cpf=? WHERE id=?";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getCpf());
			pstm.setInt(4, cliente.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			ger.desconectar(c);
		}
	}

	//@Override
	public List<Cliente> listarTudo() throws ConexaoException, RepositoryException {
		ger = GerenciadorConexaoMysql.getInstancia();
		Connection c = ger.conectar();

		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Cliente aux = null;
		String sql = "SELECT id, nome, email, cpf FROM clientes";
		try {
			Statement pstm = c.createStatement();
			ResultSet rs = pstm.executeQuery(sql);
			while (rs.next()) {
				aux = new Cliente();
				aux.setId(rs.getInt("id"));
				aux.setCpf(rs.getString("cpf"));
				aux.setNome(rs.getString("nome"));
				aux.setEmail(rs.getString("email"));
				lista.add(aux);
			}
		} catch (SQLException e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			ger.desconectar(c);
		}
		return lista;
	}
}
