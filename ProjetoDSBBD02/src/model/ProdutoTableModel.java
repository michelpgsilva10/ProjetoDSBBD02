package model;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entidades.GrupoProduto;
import entidades.Produto;

public class ProdutoTableModel implements TableModel {

	private ArrayList<Produto> produtos;
	
	public ProdutoTableModel(ArrayList<Produto> produtos) {
		setProdutos(produtos);
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
		case 2: return Integer.class;
		case 3: return Float.class;
		case 4: return Float.class;
		case 5: return Float.class;
		case 6: return String.class;
		case 7: return Float.class;
		default: return null;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0: return "Código";
		case 1: return "Nome";
		case 2: return "Estoque";
		case 3: return "Compra";
		case 4: return "Margem";
		case 5: return "Promoção";
		case 6: return "Grupo";
		case 7: return "Venda";
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
		float margemLucro = getProdutos().get(rowIndex).getPrecoCompra() + (getProdutos().get(rowIndex).getPrecoCompra() * getProdutos().get(rowIndex).getMargemLucro() / 100);
		margemLucro -= margemLucro * getProdutos().get(rowIndex).getPromocao() / 100;
		
		switch (columnIndex) {
		case 0: return getProdutos().get(rowIndex).getCodigo();
		case 1: return getProdutos().get(rowIndex).getNome();
		case 2: return getProdutos().get(rowIndex).getEstoque();
		case 3: return getProdutos().get(rowIndex).getPrecoCompra();
		case 4: return getProdutos().get(rowIndex).getMargemLucro();
		case 5: return getProdutos().get(rowIndex).getPromocao();
		case 6: return getProdutos().get(rowIndex).getGrupoProduto().toString();
		case 7: return margemLucro;
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
		float margemLucro = getProdutos().get(rowIndex).getPrecoCompra() + (getProdutos().get(rowIndex).getPrecoCompra() * getProdutos().get(rowIndex).getMargemLucro()) / 100;
		margemLucro = margemLucro * getProdutos().get(rowIndex).getPromocao() / 100;
		
		switch (columnIndex) {
		case 0: getProdutos().get(rowIndex).setCodigo((Integer) aValue);
		case 1: getProdutos().get(rowIndex).setNome((String) aValue);
		case 2: getProdutos().get(rowIndex).setEstoque((Integer) aValue);
		case 3: getProdutos().get(rowIndex).setPrecoCompra((Float) aValue);
		case 4: getProdutos().get(rowIndex).setMargemLucro((Float) aValue);
		case 5: getProdutos().get(rowIndex).setPromocao((Float) aValue);
		case 6: getProdutos().get(rowIndex).setGrupoProduto((GrupoProduto) aValue);
		}
		
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}	

}
