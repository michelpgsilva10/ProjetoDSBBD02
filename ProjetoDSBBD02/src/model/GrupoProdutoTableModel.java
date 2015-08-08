package model;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entidades.GrupoProduto;

public class GrupoProdutoTableModel implements TableModel {
	
	private ArrayList<GrupoProduto> produtos; 
	
	public GrupoProdutoTableModel(ArrayList<GrupoProduto> produtos) {
		super();
		this.produtos = produtos;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0: return Integer.class;
		case 1: return String.class;
		case 2: return Double.class;
		case 3: return Double.class;
		default: return null;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0: return "Código";
		case 1: return "Nome";
		case 2: return "Promoção";
		case 3: return "Margem Lucro";
		default: return null;
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return getProdutos().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0: return getProdutos().get(rowIndex).getCodigo();
		case 1: return getProdutos().get(rowIndex).getNome();
		case 2: return getProdutos().get(rowIndex).getPromocao();
		case 3: return getProdutos().get(rowIndex).getMargemLucro();
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
		switch (columnIndex) {
		case 0: getProdutos().get(rowIndex).setCodigo((Integer) aValue); break;
		case 1: getProdutos().get(rowIndex).setNome((String) aValue); break;
		case 2: getProdutos().get(rowIndex).setPromocao((Float) aValue); break;
		case 3: getProdutos().get(rowIndex).setMargemLucro((Float) aValue); break;
		}
		
	}

	public ArrayList<GrupoProduto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<GrupoProduto> produtos) {
		this.produtos = produtos;
	}
	
}
