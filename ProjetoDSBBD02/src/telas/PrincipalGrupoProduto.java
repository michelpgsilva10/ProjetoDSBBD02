package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.GrupoProduto;
import model.GrupoProdutoTableModel;
import util.ConexaoBD;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class PrincipalGrupoProduto extends JFrame {
	private JTable table;
	private JScrollPane scrollPane;
	private ArrayList<GrupoProduto> produtos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGrupoProduto frame = new PrincipalGrupoProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// jura

	/**
	 * Create the frame.
	 */
	public PrincipalGrupoProduto() {
		ConexaoBD conexaoBanco = new ConexaoBD();
		
		produtos = listarProdutos(conexaoBanco.getConexao());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnInserir = new JButton("Inserir");
		panel.add(btnInserir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		panel.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		panel.add(btnDeletar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		panel.add(btnPesquisar);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new GrupoProdutoTableModel(produtos));
		scrollPane.setViewportView(table);
		
		btnInserir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnInserir_actionPerformed(e, conexaoBanco.getConexao());
				
			}
		});
		
		btnAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAtualizar_actionPerformed(e, conexaoBanco.getConexao());
			}
		});
		
		btnDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDeletar_actionPerformed(e, conexaoBanco.getConexao());
			}
		});
		
		btnPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnPesquisar_actionPerformed(e,conexaoBanco.getConexao());
			}
		});
		
	}

	protected void btnPesquisar_actionPerformed(ActionEvent e, Connection conexao) {
		// TODO Auto-generated method stub
		PesquisarGrupoProduto pesquisatela = new PesquisarGrupoProduto(conexao);
		pesquisatela.setModal(true);
		pesquisatela.setLocationRelativeTo(this);
		pesquisatela.setVisible(true);
		
	}

	protected void btnDeletar_actionPerformed(ActionEvent e, Connection conexao) {
		// TODO Auto-generated method stub
		
		if (table.getSelectedRow() != -1) {
		
		int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o produto \"" + produtos.get(table.getSelectedRow()).getNome() + "\"");
		
		if (JOptionPane.YES_OPTION == resposta) {
			PreparedStatement comando = null;
			try {
				comando = conexao.prepareStatement("DELETE FROM GRUPOPRODUTO WHERE CODIGO = ?");
				comando.setInt(1, produtos.get(table.getSelectedRow()).getCodigo());
				comando.executeUpdate();
				
				JOptionPane.showMessageDialog(this, "Registro apagado com sucesso");
				
				table.setModel(new GrupoProdutoTableModel(listarProdutos(conexao)));
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}
		
		} else
			JOptionPane.showMessageDialog(this, "Selecione um produto na tabela!");
	}	

	protected void btnAtualizar_actionPerformed(ActionEvent e, Connection conexao) {
		
		produtos = listarProdutos(conexao);
		
		if (table.getSelectedRow() != -1) {
			GrupoProduto produto = produtos.get(table.getSelectedRow());
			
			AtualizarGrupoProduto telaAtualizar = new AtualizarGrupoProduto(conexao,produto);	
			telaAtualizar.setLocationRelativeTo(this);
			telaAtualizar.setResizable(false);
			telaAtualizar.setModal(true);
			telaAtualizar.setVisible(true);
		} else
			JOptionPane.showMessageDialog(this, "Selecione um produto na tabela!");
		
		produtos = listarProdutos(conexao);
		
		table.setModel(new GrupoProdutoTableModel(produtos));
		
		
	}

	protected void btnInserir_actionPerformed(ActionEvent e, Connection conexao) {
		// TODO Auto-generated method stub
		InserirGrupoProduto telaInserir = new InserirGrupoProduto(conexao);
		
		telaInserir.setLocationRelativeTo(this);
		telaInserir.setModal(true);
		telaInserir.setResizable(false);
		telaInserir.setVisible(true);
		
		table.setModel(new GrupoProdutoTableModel(listarProdutos(conexao)));
		
	}

	public ArrayList<GrupoProduto> listarProdutos(Connection conexao) {
		PreparedStatement comando = null;
		ArrayList<GrupoProduto> produtos = new ArrayList<GrupoProduto>();
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
				
				produtos.add(itemProduto);
			}
			resultado.close();						
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro na Busca!!!");
		}
		
		return produtos;
	}

}
