package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.GrupoProduto;
import exception.NegocioException;
import model.GrupoProdutoTableModel;
import negocio.ManipulacaoGrupoProduto;
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
		
		try {
			produtos = ManipulacaoGrupoProduto.listarGrupoProduto(conexaoBanco.getConexao());
		} catch (NegocioException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
		
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
			
			try {
				ManipulacaoGrupoProduto.deletarGrupoProduto(produtos.get(table.getSelectedRow()), conexao);
				table.setModel(new GrupoProdutoTableModel(ManipulacaoGrupoProduto.listarGrupoProduto(conexao)));
			} catch (NegocioException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
			
			}			
		
		} else
			JOptionPane.showMessageDialog(this, "Selecione um produto na tabela!");
	}	

	protected void btnAtualizar_actionPerformed(ActionEvent e, Connection conexao) {
		
		try {
			produtos = ManipulacaoGrupoProduto.listarGrupoProduto(conexao);
			
			if (table.getSelectedRow() != -1) {
				GrupoProduto produto = produtos.get(table.getSelectedRow());
				
				AtualizarGrupoProduto telaAtualizar = new AtualizarGrupoProduto(conexao,produto);	
				telaAtualizar.setLocationRelativeTo(this);
				telaAtualizar.setResizable(false);
				telaAtualizar.setModal(true);
				telaAtualizar.setVisible(true);
				
				produtos = ManipulacaoGrupoProduto.listarGrupoProduto(conexao);
				
			
			} else
				JOptionPane.showMessageDialog(this, "Selecione um produto na tabela!");
			
		} catch (NegocioException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}		
		
		table.setModel(new GrupoProdutoTableModel(produtos));		
		
	}

	protected void btnInserir_actionPerformed(ActionEvent e, Connection conexao) {
		// TODO Auto-generated method stub
		InserirGrupoProduto telaInserir = new InserirGrupoProduto(conexao);
		
		telaInserir.setLocationRelativeTo(this);
		telaInserir.setModal(true);
		telaInserir.setResizable(false);
		telaInserir.setVisible(true);
		
		try {
			table.setModel(new GrupoProdutoTableModel(ManipulacaoGrupoProduto.listarGrupoProduto(conexao)));
		} catch (NegocioException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
		
	}

}
