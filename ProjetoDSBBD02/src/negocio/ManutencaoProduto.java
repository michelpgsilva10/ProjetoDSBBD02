package negocio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JDialog;

import exception.NegocioException;

public class ManutencaoProduto {
	public static void inserir(String nome,int estoque, float valorcompra, float promocao, float margem,float grupo, Connection conexao)throws NegocioException {
	 PreparedStatement comando = null;	
		try{
			comando = conexao.prepareStatement("INSERT INTO produto(nome,estoque,valorcompra,promocao,margemlucro,grupo) VALUES (?,?,?,?,?,?)");
			comando.setString(1, nome);
			comando.setDouble(2, estoque);
			comando.setDouble(3, valorcompra);
			comando.setDouble(4, promocao);
			comando.setDouble(5, margem);
			comando.setDouble(6, grupo);
			
			comando.executeUpdate();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new NegocioException(NegocioException.ERRO_INSERCAO);
		}
		
	
			
		
	}
	
	public static void alterar(int codigo,String nome,int estoque, float valorcompra, float promocao, float margem,float grupo, Connection conexao)throws NegocioException {
		 PreparedStatement comando = null;	
			try{
				comando = conexao.prepareStatement("UPDATE produto SET nome = ?, estoque = ?,valorcompra = ?,promocao = ?,margemlucro = ?,grupo = ?) WHERE codigo = ?");
				comando.setString(1, nome);
				comando.setDouble(2, estoque);
				comando.setDouble(3, valorcompra);
				comando.setDouble(4, promocao);
				comando.setDouble(5, margem);
				comando.setDouble(6, grupo);
				comando.setInt(7, codigo);
				
				comando.executeUpdate();
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new NegocioException(NegocioException.ERRO_INSERCAO);
			}
			
		
				
			
		}
	
	public static void alterar(int codigo, Connection conexao)throws NegocioException {
		 PreparedStatement comando = null;	
			try{
				comando = conexao.prepareStatement("DELETE FROM  produto WHERE codigo = ?");
				comando.setInt(1, codigo);
				
				comando.executeUpdate();
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new NegocioException(NegocioException.ERRO_INSERCAO);
			}
			
		
				
			
		}
	
	public static void baixaEstoqueDefeito(int codigo, String motivo,  Date data, int quantidade, Connection conexao)throws NegocioException {
		 PreparedStatement comando = null;	
			try{
				comando = conexao.prepareStatement("INSERT INTO registrobaixa (motivo,data,quatidade,produto) VALUES (?,?,?,?)");
				comando.setString(1, motivo);
				comando.setDate(2, data);
				comando.setDouble(3, quantidade);
				comando.setDouble(4, codigo);
	
				
				comando.executeUpdate();
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new NegocioException(NegocioException.ERRO_INSERCAO);
			}
	}
			
  public static String validarDados(String nome, int estoque, float compra,float margem, float promocao,int grupo){
			String menssagemErros = "";
			if(nome.length()==0){
				menssagemErros += "Nome não ser vazio";
			}
			
			if(estoque <0){
				menssagemErros += "\nEstoque não pode ser negativo";
				
			}
			
			if(compra <=0){
				menssagemErros +="\nPreço de compra deve ser maior que zero";
			}
			if(margem <0){
			   menssagemErros +="\n A margem de Lucro não pode ser negativa";
		    }
			if(promocao <0 || promocao >100){
				menssagemErros +="\n O percentual de Promoção deve ser entre 0 e 100";
			}
			return menssagemErros;
  
	
}
  
  public static void porFiltroNome(String nome, Connection conexao)throws NegocioException {
		 PreparedStatement comando = null;	
			try{
				comando = conexao.prepareStatement("SELECT * FROM produto WHERE upper(nome) like ?");
				comando.setString(1, "%"+ nome.toUpperCase() + "%");
								
				comando.executeQuery();
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new NegocioException(NegocioException.ERRO_BUSCA);
			}
			
		
				
			
		}
  
  public static void porCodigo(int codigo, Connection conexao)throws NegocioException {
		 PreparedStatement comando = null;	
			try{
				comando = conexao.prepareStatement("SELECT * FROM produto WHERE codigo = ?");
				comando.setInt(1, codigo);
								
				comando.executeQuery();
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new NegocioException(NegocioException.ERRO_BUSCA);
			}
			
		
				
			
		}
	}


