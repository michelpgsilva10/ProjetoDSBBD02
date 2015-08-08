package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.GrupoProduto;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class AtualizarGrupoProduto extends JDialog {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtPromocao;
	private JTextField txtMargemLucro;


	public AtualizarGrupoProduto(Connection conexao, GrupoProduto produto) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 325, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		panel.add(btnSalvar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setHgap(15);
		panel_1.add(panel_4);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		panel_4.add(txtCodigo);		
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setHgap(15);
		panel_1.add(panel_2);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		panel_2.add(txtNome);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Promo\u00E7\u00E3o");
		panel_6.add(lblNewLabel_2);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setHgap(15);
		panel_1.add(panel_7);
		
		txtPromocao = new JTextField();
		txtPromocao.setColumns(10);
		panel_7.add(txtPromocao);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		
		JLabel lblNewLabel_3 = new JLabel("Margem de Lucro");
		panel_8.add(lblNewLabel_3);
		
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setHgap(15);
		panel_1.add(panel_9);
		
		txtMargemLucro = new JTextField();
		txtMargemLucro.setColumns(10);
		panel_9.add(txtMargemLucro);		
		
		txtCodigo.setText(Integer.toString(produto.getCodigo()));
		txtCodigo.setEditable(false);
		txtNome.setText(produto.getNome().trim());
		txtPromocao.setText(Double.toString(produto.getPromocao()));
        txtMargemLucro.setText(Double.toString(produto.getMargemLucro()));
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSalvar_actionPerformed(e,conexao);
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnCancelar_actionPerformed(e);
			}
		});
	}


	protected void btnCancelar_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}


	protected void btnSalvar_actionPerformed(ActionEvent e, Connection conexao) {
		// TODO Auto-generated method stub
		PreparedStatement comando = null;
		String nome = txtNome.getText();
		int codigo = Integer.parseInt(txtCodigo.getText());
		double promocao = Double.parseDouble(txtPromocao.getText());
		double margemLucro = Double.parseDouble(txtMargemLucro.getText());		
		
		try {
			comando = conexao.prepareStatement("UPDATE GRUPOPRODUTO"
					+ " SET NOME=?,PROMOCAO=?,MARGEMLUCRO=? WHERE CODIGO=?");
			System.out.println(comando.getWarnings());
			
			comando.setString(1, nome);
			comando.setDouble(2, promocao);
			comando.setDouble(3, margemLucro);
			comando.setInt(4, codigo);
			comando.executeUpdate();
			
			JOptionPane.showMessageDialog(this, "Registro atualizado com sucesso");
			
		    //this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    this.dispose();
		    System.out.println("TEste");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Não foi possível atualizar");
		}
		
		
	}

}
