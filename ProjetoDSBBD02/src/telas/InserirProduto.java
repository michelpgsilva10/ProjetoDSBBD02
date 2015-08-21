package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.GrupoProduto;
import exception.NegocioException;
import model.GrupoProdutoComboBoxModel;
import negocio.ManipulacaoGrupoProduto;
import negocio.ManutencaoProduto;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

public class InserirProduto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtEstoque;
	private JTextField txtCompra;
	private JTextField txtMargemLucro;
	private JTextField txtPromocao;
	private JComboBox cmbGrupoProduto;
	private JButton btnSalvar;	
	private JButton btnSair;

	/**
	 * Create the dialog.
	 */
	public InserirProduto(Connection conexao) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {162, 265};
		gbl_contentPanel.rowHeights = new int[] {0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{1.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridheight = 2;
			gbc_panel.insets = new Insets(0, 0, 0, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			panel.setLayout(new GridLayout(6, 1, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setHgap(15);
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					JLabel lblNome = new JLabel("Nome");
					lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
					panel_1.add(lblNome);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setHgap(15);
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					JLabel lblEstoque = new JLabel("Estoque");
					lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblEstoque.setHorizontalAlignment(SwingConstants.LEFT);
					panel_1.add(lblEstoque);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				flowLayout.setHgap(15);
				panel.add(panel_1);
				{
					JLabel lblCompra = new JLabel("Compra");
					lblCompra.setFont(new Font("Tahoma", Font.PLAIN, 12));
					panel_1.add(lblCompra);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setHgap(15);
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					JLabel lblPromoo = new JLabel("Margem Lucro");
					lblPromoo.setFont(new Font("Tahoma", Font.PLAIN, 12));
					panel_1.add(lblPromoo);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				flowLayout.setHgap(15);
				panel.add(panel_1);
				{
					JLabel lblMargemLucro = new JLabel("Promo\u00E7\u00E3o");
					lblMargemLucro.setFont(new Font("Tahoma", Font.PLAIN, 12));
					panel_1.add(lblMargemLucro);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setHgap(15);
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					JLabel lblGrupoProduto = new JLabel("Grupo Produto");
					lblGrupoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblGrupoProduto.setHorizontalAlignment(SwingConstants.LEFT);
					panel_1.add(lblGrupoProduto);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridheight = 2;
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			panel.setLayout(new GridLayout(6, 1, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					txtNome = new JTextField();
					txtNome.setColumns(22);
					panel_1.add(txtNome);				
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					txtEstoque = new JTextField();
					txtEstoque.setColumns(10);
					panel_1.add(txtEstoque);					
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					txtCompra = new JTextField();
					txtCompra.setColumns(10);
					panel_1.add(txtCompra);					
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					txtMargemLucro = new JTextField();
					txtMargemLucro.setColumns(10);
					panel_1.add(txtMargemLucro);					
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					txtPromocao = new JTextField();
					txtPromocao.setColumns(10);
					panel_1.add(txtPromocao);					
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					cmbGrupoProduto = new JComboBox();
					try {
						cmbGrupoProduto.setModel(new GrupoProdutoComboBoxModel(ManipulacaoGrupoProduto.listarGrupoProduto(conexao)));						
					} catch (NegocioException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e.getMessage());
					}
					panel_1.add(cmbGrupoProduto);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSair = new JButton("Sair");				
				buttonPane.add(btnSair);				
			}
			{
				btnSalvar = new JButton("Salvar");
				buttonPane.add(btnSalvar);
				getRootPane().setDefaultButton(btnSalvar);
				
				
			}
		}
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSalvar_actionPerformed(e, conexao);
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

	protected void btnSair_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}

	protected void btnSalvar_actionPerformed(ActionEvent e, Connection conexao) {
		// TODO Auto-generated method stub
		String msgErros;
		
		try {
			msgErros = ManutencaoProduto.validarDados(txtNome.getText(), Integer.parseInt(txtEstoque.getText()), Float.parseFloat(txtCompra.getText()),
					  Float.parseFloat(txtPromocao.getText()), Float.parseFloat(txtMargemLucro.getText()), 
					  ((GrupoProduto) cmbGrupoProduto.getSelectedItem()).getCodigo());
			
			if (msgErros.equals("")) {			
				ManutencaoProduto.inserir(txtNome.getText(), Integer.parseInt(txtEstoque.getText()), Float.parseFloat(txtCompra.getText()),
										  Float.parseFloat(txtPromocao.getText()), Float.parseFloat(txtMargemLucro.getText()), 
										  ((GrupoProduto) cmbGrupoProduto.getSelectedItem()).getCodigo(), conexao);
				
				JOptionPane.showMessageDialog(this, "Registro inserido com sucesso!");
				limparCamposCadastroProduto();
			} else
				throw new NegocioException(msgErros);
				
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		} catch (NegocioException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
	}
	
	private void limparCamposCadastroProduto() {
		txtNome.setText("");
		txtEstoque.setText("");
		txtCompra.setText("");
		txtMargemLucro.setText("");
		txtPromocao.setText("");
		cmbGrupoProduto.setSelectedIndex(0);
		
		txtNome.requestFocus();
	}

}
