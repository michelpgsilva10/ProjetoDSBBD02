package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidades.GrupoProduto;
import exception.NegocioException;
import model.GrupoProdutoTableModel;

public class ManipulacaoGrupoProduto {

	public static void inserir(String nome, float margem, float promocao, Connection conexao) throws NegocioException {
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
	
	public static void alterar(GrupoProduto grupoProduto, Connection conexao) throws NegocioException {
		PreparedStatement comando = null;
		
			
		try{
		comando = conexao.prepareStatement("UPDATE GRUPOPRODUTO"
					+ " SET NOME=?,PROMOCAO=?,MARGEMLUCRO=? WHERE CODIGO=?");
			
			comando.setString(1, grupoProduto.getNome());
			comando.setDouble(2, grupoProduto.getMargemLucro());
			comando.setDouble(3, grupoProduto.getPromocao());
			comando.setInt(4, grupoProduto.getCodigo());
			comando.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new NegocioException(NegocioException.ERRO_ATUALIZACAO); 
		}
	}
	
	public static ArrayList<GrupoProduto> listarGrupoProduto(Connection conexao) throws NegocioException {
		
		PreparedStatement comando = null;
		ArrayList<GrupoProduto> grupoProdutos = new ArrayList<GrupoProduto>();
		GrupoProduto itemProduto;

		try {
			comando = conexao.prepareStatement("SELECT * FROM grupoproduto ORDER BY nome");

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				itemProduto = new GrupoProduto();
				
				itemProduto.setCodigo(resultado.getInt("codigo"));
				itemProduto.setNome(resultado.getString("nome"));
				itemProduto.setPromocao(resultado.getFloat("promocao"));
				itemProduto.setMargemLucro(resultado.getFloat("margemlucro"));
				
				grupoProdutos.add(itemProduto);
			}
			resultado.close();						
		} catch (SQLException se) {
			throw new NegocioException(NegocioException.ERRO_BUSCA);
		}
		
		return grupoProdutos;
	}
	
	public static void deletarGrupoProduto( GrupoProduto grupoProduto, Connection conexao) throws NegocioException
	{
		PreparedStatement comando = null;
		try {
			comando = conexao.prepareStatement("DELETE FROM GRUPOPRODUTO WHERE CODIGO = ?");
			comando.setInt(1, grupoProduto.getCodigo());
			comando.executeUpdate();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new NegocioException(NegocioException.ERRO_DELECAO);
		}
		
	}

}
