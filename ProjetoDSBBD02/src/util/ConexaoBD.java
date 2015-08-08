package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBD {
	
	private Connection conexao;

	public ConexaoBD() {
		Connection conexao;
		String url = "jdbc:postgresql://192.168.200.46:5432/grupo4";

		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url, "grupo4", "grupo4");
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
