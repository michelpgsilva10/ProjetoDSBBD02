package model;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entidades.Produto;

public class EstoqueProdutoTableModel implements TableModel {

	private ArrayList<Produto> produtos; 
	public EstoqueProdutoTableModel(ArrayList<Produto>produtos){
		super();
		this.produtos = produtos;
	}
	
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		
		switch(columnIndex){
		case 0: return Integer.class;
		case 1: return String.class;
		case 2: return Integer.class;
		default: return null;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex){
		case 0: return "Código";
		case 1: return "Nome";
		case 2: return "Estoque";
		default: return null;
		}
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return produtos.size();
		
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex){
		case 0: return produtos.get(rowIndex).getCodigo();
		case 1: return produtos.get(rowIndex).getNome();
		case 2: return produtos.get(rowIndex).getEstoque();
		default: return null;
		}
		
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex){
		case 0: produtos.get(rowIndex).setCodigo((Integer)aValue);break;
		case 1: produtos.get(rowIndex).setNome((String)aValue);break;
		case 2: produtos.get(rowIndex).setEstoque((Integer)aValue);break;
		}
		
	}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

}
