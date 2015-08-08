package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.NegocioException;
import negocio.ManipulacaoGrupoProduto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

public class InserirGrupoProduto extends JDialog {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPromocao;
	private JTextField txtMargemLucro;

	/**
	 * Create the frame.
	 */
	public InserirGrupoProduto(Connection conexao) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 325, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		panel.add(btnSalvar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
		flowLayout_2.setHgap(20);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_5);
		
		JLabel lblNome = new JLabel("Nome");
		panel_5.add(lblNome);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_3.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3);
		
		txtNome = new JTextField();
		panel_3.add(txtNome);
		txtNome.setColumns(12);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setHgap(20);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_6);
		
		JLabel lblPromoo = new JLabel("Promo\u00E7\u00E3o");
		panel_6.add(lblPromoo);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_4);
		
		txtPromocao = new JTextField();
		txtPromocao.setColumns(10);
		panel_4.add(txtPromocao);
		
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2);
		
		JLabel lblMargemDeLucro = new JLabel("Margem de Lucro");
		panel_2.add(lblMargemDeLucro);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_7);
		
		txtMargemLucro = new JTextField();
		panel_7.add(txtMargemLucro);
		txtMargemLucro.setColumns(12);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSalvar_actionPerformed(e, conexao);
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
		
		try {
			ManipulacaoGrupoProduto.inserir(txtNome.getText(), Float.parseFloat(txtPromocao.getText()), Float.parseFloat(txtMargemLucro.getText()), conexao);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		} catch (NegocioException e2) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}
		
	}

}
