package model;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entidades.GrupoProduto;

public class GrupoProdutoComboBoxModel implements ComboBoxModel {
	
	private ArrayList<GrupoProduto> grupoProduto;
	private GrupoProduto itemGrupo = null;
	
	public GrupoProdutoComboBoxModel(ArrayList<GrupoProduto> grupoProduto) {
		setGrupoProduto(grupoProduto);
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getElementAt(int arg0) {
		// TODO Auto-generated method stub
		setItemGrupo(grupoProduto.get(arg0));
		return getItemGrupo();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return grupoProduto.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return getItemGrupo();
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		setItemGrupo((GrupoProduto) anItem);		
	}

	public ArrayList<GrupoProduto> getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(ArrayList<GrupoProduto> grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	public GrupoProduto getItemGrupo() {
		return itemGrupo;
	}

	public void setItemGrupo(GrupoProduto itemGrupo) {
		this.itemGrupo = itemGrupo;
	}

}
