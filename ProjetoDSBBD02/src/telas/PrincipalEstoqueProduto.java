package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.GrupoProduto;
import entidades.Produto;
import exception.NegocioException;
import model.EstoqueProdutoTableModel;
import model.ProdutoTableModel;
import negocio.ManutencaoProduto;
import util.ConexaoBD;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PrincipalEstoqueProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable table;
	private ArrayList<Produto> produtos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalEstoqueProduto frame = new PrincipalEstoqueProduto();
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
	public PrincipalEstoqueProduto() {
		ConexaoBD conexaoBanco = new ConexaoBD();
		
		try{
			produtos = ManutencaoProduto.listarProduto(conexaoBanco.getConexao());
		}catch (NegocioException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Produto:");
		panel.add(lblNewLabel);
		
		txtFiltro = new JTextField();
		panel.add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ConexaoBD conexaoBanco = new ConexaoBD();
				btnFiltrar_actionPerformed(arg0, conexaoBanco.getConexao());
				
				
				
			}
		});
		panel.add(btnFiltrar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnBaixarVencimento = new JButton("Baixar (Vencimento)");
		panel_1.add(btnBaixarVencimento);
		
		JButton btnBaixarDefeito = new JButton("Baixar (Defeito)");
		panel_1.add(btnBaixarDefeito);
		
		JButton btnSair = new JButton("Sair");
		panel_1.add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new EstoqueProdutoTableModel(produtos));
		scrollPane.setViewportView(table);
	
	}

	protected void btnFiltrar_actionPerformed(ActionEvent arg0, Connection conexao) {
		// TODO Auto-generated method stub
		String nome = txtFiltro.getText();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		try{
			produtos = ManutencaoProduto.porFiltarNome(nome,conexao);
			table.setModel(new EstoqueProdutoTableModel(produtos));
		}catch (NegocioException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
	}

}
