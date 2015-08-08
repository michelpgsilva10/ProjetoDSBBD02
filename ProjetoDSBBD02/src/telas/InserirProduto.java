package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InserirProduto dialog = new InserirProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InserirProduto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {162, 266};
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
					panel_1.add(txtNome);
					txtNome.setColumns(30);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					txtEstoque = new JTextField();
					panel_1.add(txtEstoque);
					txtEstoque.setColumns(15);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					txtCompra = new JTextField();
					panel_1.add(txtCompra);
					txtCompra.setColumns(15);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					txtMargemLucro = new JTextField();
					panel_1.add(txtMargemLucro);
					txtMargemLucro.setColumns(15);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					txtPromocao = new JTextField();
					panel_1.add(txtPromocao);
					txtPromocao.setColumns(15);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1);
				{
					JComboBox cmbGrupoProduto = new JComboBox();
					panel_1.add(cmbGrupoProduto);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
