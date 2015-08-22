package model;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entidades.GrupoProduto;

public class GrupoProdutoComboBoxModel implements ComboBoxModel {
	
	private ArrayList<GrupoProduto> grupoProduto;
	private GrupoProduto itemGrupo;
	
	public GrupoProdutoComboBoxModel(ArrayList<GrupoProduto> grupoProduto) {
		this.grupoProduto = grupoProduto;
		itemGrupo = null;
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return grupoProduto.get(arg0);
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
		return itemGrupo;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		itemGrupo = (GrupoProduto) anItem;		
	}

}
