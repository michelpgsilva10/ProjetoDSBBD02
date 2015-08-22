package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.sql.ConnectionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import negocio.ManipulacaoGrupoProduto;
import model.GrupoProdutoComboBoxModel;
import entidades.GrupoProduto;
import entidades.Produto;
import exception.NegocioException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AlterarProduto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtEstoque;
	private JTextField txtMargemLucro;
	private JTextField txtCompra;
	private JTextField txtPromocao;
	private JComboBox cmbGrupoProduto;
	private JButton btnSair;
	private JButton btnSalvar;

	/**
	 * Create the dialog.
	 */
	public AlterarProduto(Connection conexao, Produto produto) {
		setBounds(100, 100, 450, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{117, 304, 0};
		gbl_contentPanel.rowHeights = new int[] {31, 31, 31, 31, 31, 31, 31, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			{
				JLabel lblCdigo = new JLabel("C\u00F3digo");
				lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(lblCdigo);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			{
				txtCodigo = new JTextField();
				txtCodigo.setColumns(10);
				txtCodigo.setText(Integer.toString(produto.getCodigo()));
				txtCodigo.setEnabled(false);
				
				panel.add(txtCodigo);
				
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			{
				JLabel lblNome = new JLabel("Nome");
				lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(lblNome);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			{
				txtNome = new JTextField();
				txtNome.setColumns(20);
				txtNome.setText(produto.getNome());
				
				panel.add(txtNome);				
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 2;
			contentPanel.add(panel, gbc_panel);
			{
				JLabel label = new JLabel("Estoque");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(label);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 2;
			contentPanel.add(panel, gbc_panel);
			{
				txtEstoque = new JTextField();
				txtEstoque.setColumns(10);
				txtEstoque.setText(Integer.toString(produto.getEstoque()));
				
				panel.add(txtEstoque);				
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 3;
			contentPanel.add(panel, gbc_panel);
			{
				JLabel lblMargemLucro = new JLabel("Compra");
				lblMargemLucro.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(lblMargemLucro);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 3;
			contentPanel.add(panel, gbc_panel);
			{
				txtCompra = new JTextField();
				txtCompra.setColumns(10);
				txtCompra.setText(Float.toString(produto.getPrecoCompra()));
				
				panel.add(txtCompra);				
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 4;
			contentPanel.add(panel, gbc_panel);
			{
				JLabel lblMargemLucro_1 = new JLabel("Margem Lucro");
				lblMargemLucro_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(lblMargemLucro_1);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 4;
			contentPanel.add(panel, gbc_panel);
			{
				txtMargemLucro = new JTextField();
				txtMargemLucro.setColumns(10);
				txtMargemLucro.setText(Float.toString(produto.getMargemLucro()));
				
				panel.add(txtMargemLucro);
				
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 5;
			contentPanel.add(panel, gbc_panel);
			{
				JLabel lblPromoo = new JLabel("Promo\u00E7\u00E3o");
				lblPromoo.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(lblPromoo);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 5;
			contentPanel.add(panel, gbc_panel);
			{
				txtPromocao = new JTextField();
				txtPromocao.setColumns(10);
				txtPromocao.setText(Float.toString(produto.getPromocao()));
				
				panel.add(txtPromocao);				
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 0, 5);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 6;
			contentPanel.add(panel, gbc_panel);
			{
				JLabel lblGrupoProduto = new JLabel("Grupo Produto");
				lblGrupoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(lblGrupoProduto);
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 6;
			contentPanel.add(panel, gbc_panel);
			{
				cmbGrupoProduto = new JComboBox();
				try {
					ArrayList<GrupoProduto> listaGrupoProduto = ManipulacaoGrupoProduto.listarGrupoProduto(conexao);
					GrupoProduto grupoProduto = null;
					
					cmbGrupoProduto.setModel(new GrupoProdutoComboBoxModel(listaGrupoProduto));					
					cmbGrupoProduto.getModel().setSelectedItem(produto.getGrupoProduto());
										
				} catch (NegocioException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
				
				panel.add(cmbGrupoProduto);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSair = new JButton("Sair");				
				buttonPane.add(btnSair);
				getRootPane().setDefaultButton(btnSair);
			}
			{
				btnSalvar = new JButton("Salvar");
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnSalvar.setActionCommand("Cancel");
				buttonPane.add(btnSalvar);
			}
		}
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btnSair_actionPerformed(arg0);
			}
		});
		
	}

	protected void btnSair_actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.dispose();
	}	

}
