package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Produto;
import exception.NegocioException;
import model.ProdutoTableModel;
import negocio.ManutencaoProduto;
import util.ConexaoBD;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PrincipalProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscaProduto;
	private JTable tblProduto;
	private ArrayList<Produto> produtos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalProduto frame = new PrincipalProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalProduto() {
		ConexaoBD conexao = new ConexaoBD();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblProduto = new JLabel("Produto:");
		panel.add(lblProduto);
		
		txtBuscaProduto = new JTextField();
		panel.add(txtBuscaProduto);
		txtBuscaProduto.setColumns(20);
		
		JButton btnBuscar = new JButton("Filtrar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnBuscar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnInserir = new JButton("Incluir");		
		panel_1.add(btnInserir);		
		
		JButton btnAlterar = new JButton("Alterar");
		panel_1.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		panel_1.add(btnExcluir);
		
		JSeparator separator = new JSeparator();
		panel_1.add(separator);
		
		JButton btnSair = new JButton("Sair");
		panel_1.add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		try {
			produtos = ManutencaoProduto.listarProduto(conexao.getConexao());
		} catch (NegocioException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
		
		tblProduto = new JTable();
		tblProduto.setModel(new ProdutoTableModel(produtos));
		scrollPane.setViewportView(tblProduto);
		
		btnInserir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnInserir_actionPerformed(e, conexao.getConexao());
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAlterar_actionPerformed(e, conexao.getConexao());
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSair_actionPerformed(e);
			}
		});
	}

	protected void btnAlterar_actionPerformed(ActionEvent e, Connection conexao) {
		// TODO Auto-generated method stub
		if (tblProduto.getSelectedRow() != -1) {
			AlterarProduto altProduto = new AlterarProduto(conexao, produtos.get(tblProduto.getSelectedRow()));
			
			altProduto.setModal(true);
			altProduto.setResizable(false);
			altProduto.setLocationRelativeTo(this);
			altProduto.setVisible(true);
			
			try {
				tblProduto.setModel(new ProdutoTableModel(ManutencaoProduto.listarProduto(conexao)));
			} catch (NegocioException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}			
		} else
			JOptionPane.showMessageDialog(this, "Selecione um registro da tabela");		
		
	}

	protected void btnSair_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}

	protected void btnInserir_actionPerformed(ActionEvent e, Connection conexao) {
		// TODO Auto-generated method stub
		InserirProduto inserirProduto = new InserirProduto(conexao);
		inserirProduto.setLocationRelativeTo(this);
		//inserirProduto.setResizable(false);
		inserirProduto.setModal(true);
		inserirProduto.setVisible(true);
		
		try {
			tblProduto.setModel(new ProdutoTableModel(ManutencaoProduto.listarProduto(conexao)));
		} catch (NegocioException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
	}

}
