package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entidades.GrupoProduto;
import model.GrupoProdutoTableModel;

public class PesquisarGrupoProduto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public PesquisarGrupoProduto(Connection conexao) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		ArrayList<GrupoProduto> produtos = new ArrayList<GrupoProduto>();

				JPanel panel = new JPanel();
				contentPanel.add(panel, BorderLayout.NORTH);
	
				JLabel lblProduto = new JLabel("Produto");
				panel.add(lblProduto);
		
		
				textField = new JTextField();
				panel.add(textField);
				textField.setColumns(10);
		
			
				JButton btnPesquisar = new JButton("Pesquisar");
				panel.add(btnPesquisar);
			
	
		
				JScrollPane scrollPane = new JScrollPane();
				contentPanel.add(scrollPane, BorderLayout.CENTER);
				
				table = new JTable();
				table.setModel(new GrupoProdutoTableModel(produtos));
				scrollPane.setViewportView(table);
			
		
		
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
			
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				btnPesquisar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						btnPesquisar_actionPerformed(e,conexao);
					}
				});
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						cancelButton_actionPerformed(e);
						
					}
				});
		
	}

	protected void cancelButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}

	protected void btnPesquisar_actionPerformed(ActionEvent e,Connection conexao) {
		// TODO Auto-generated method stub
		PreparedStatement comando = null;
		String nome = textField.getText();
		ArrayList<GrupoProduto> produtos = new ArrayList<GrupoProduto>();
		
		try {
			comando = conexao.prepareStatement("SELECT * FROM GRUPOPRODUTO"
					+ " WHERE UPPER(NOME) LIKE ? ");
			System.out.println(comando.getWarnings());
			
			comando.setString(1, "%" + nome.toUpperCase() + "%");
			ResultSet resultado = comando.executeQuery();
			GrupoProduto itemProduto;
			while (resultado.next()) {
				itemProduto = new GrupoProduto();
				
				itemProduto.setCodigo(resultado.getInt("codigo"));
				itemProduto.setNome(resultado.getString("nome"));
				itemProduto.setPromocao(resultado.getFloat("promocao"));
				itemProduto.setMargemLucro(resultado.getFloat("margemlucro"));
				
				produtos.add(itemProduto);
			}
			resultado.close();
			table.setModel(new GrupoProdutoTableModel(produtos));
			
		
		    System.out.println("TEste");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
	}
	

}
