package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PrincipalProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscaProduto;
	private JTable tblProduto;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JButton btnNewButton = new JButton("Incluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton);
		
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
		
		tblProduto = new JTable();
		scrollPane.setViewportView(tblProduto);
	}

}
