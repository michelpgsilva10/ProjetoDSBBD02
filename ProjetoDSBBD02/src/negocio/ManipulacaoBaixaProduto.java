package negocio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Produto;
import entidades.GrupoProduto;
import entidades.RegistroBaixa;
import exception.NegocioException;

public class ManipulacaoBaixaProduto {

	public static void Insert_RegistroBaixa(String motivo, Date data, int quantidade, int codigo, Connection conexao) throws NegocioException {
		PreparedStatement comando = null;
		//String erro = validarDados(motivo, data, quantidade,codigo);
		//if (!erro.isEmpty()) {
		//	throw new NegocioException(erro);
		//}

		try {
			comando = conexao.prepareStatement("INSERT INTO REGISTROBAIXA(motivo, data, quantidade,produto) VALUES (?,?,?,?)");

			comando.setString(1, motivo);
			comando.setDate(2, data);
			comando.setInt(3, quantidade);
			comando.setInt(4, codigo);

			comando.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new NegocioException(NegocioException.ERRO_INSERCAO);
		}
	}

 public static  void BaixaEstoque_Atualiza(Produto codigo, Connection conexao) throws NegocioException {
		PreparedStatement comando = null;

		try {
			comando = conexao.prepareStatement("UPDATE PRODUTO" + " SET ESTOQUE=? WHERE CODIGO=?");

			comando.setInt(1, Produto.getEstoque());
			comando.setInt(2, Produto.getCodigo());
			comando.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new NegocioException(NegocioException.ERRO_ATUALIZACAO);
		}
	}

	public static ArrayList<Produto> listarProduto(Connection conexao) throws NegocioException {

		PreparedStatement comando = null;
		ArrayList<Produto> produto = new ArrayList<Produto>();
		Produto itemProduto;

		try {
			comando = conexao.prepareStatement("SELECT * FROM produto ORDER BY nome");

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				itemProduto = new Produto();

				itemProduto.setCodigo(resultado.getInt("codigo"));
				itemProduto.setNome(resultado.getString("nome"));
				itemProduto.setEstoque(resultado.getInt("Estoque"));
				itemProduto.setPrecoCompra(resultado.getFloat("precoCompra"));
				itemProduto.setMargemLucro(resultado.getFloat("margemlucro"));

				produto.add(itemProduto);
			}
			resultado.close();
		} catch (SQLException se) {
			throw new NegocioException(NegocioException.ERRO_BUSCA);
		}

		return produto;
	}

	
	//public static String validarDados(String nome, float promocao, float margemLucro) {
	//	String menssagemErros = "";
	// (nome.length() == 0) {
	//		menssagemErros += "Nome não ser vazio";
	//	}

	//	if (margemLucro < 0) {
	//		menssagemErros += "\n A margem de Lucro não pode ser negativa";
	//	}
	//	if (promocao < 0 || promocao > 100) {
	//		menssagemErros += "\n O percentual de Promoção deve ser entre 0 e 100";
	//	}
	//	return menssagemErros;

//	}
	

}
