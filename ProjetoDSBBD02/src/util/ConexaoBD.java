package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBD {
	
	private Connection conexao;

	public ConexaoBD() {
		Connection conexao;
		String url = "jdbc:postgresql://localhost:5433/DSBBD";

		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url, "postgres", "15109");
			JOptionPane.showMessageDialog(null, "Conexão estabelecida");
			this.setConexao(conexao);

		} catch (ClassNotFoundException cnf) {
			JOptionPane.showMessageDialog(null, "Driver não encontrado - " + cnf.getMessage());
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Banco não encontrado - " + sqle.getMessage());
		}
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}	

}
