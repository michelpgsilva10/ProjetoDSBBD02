package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import exception.NegocioException;
import telas.InserirGrupoProduto;

public class ManipulacaoGrupoProduto {

	public static void inserir(String nome, float margem, float promocao, Connection conexao, JDialog dialog) throws NegocioException {
		PreparedStatement comando = null;			
		
		try {
			comando = conexao.prepareStatement("INSERT INTO GRUPOPRODUTO(NOME, PROMOCAO, MARGEMLUCRO) VALUES (?,?,?)");
			
			comando.setString(1, nome);
			comando.setDouble(2, promocao);
			comando.setDouble(3, margem);
			
			comando.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new NegocioException(NegocioException.ERRO_INSERCAO);
		}
	}

}
