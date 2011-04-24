package vista.controladores;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import vista.dataobjet.VoResumCont;

public class ModeloTablaListResumenCont extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private Vector<String> columnas;
	private Vector<VoResumCont> datos;
	
	public ModeloTablaListResumenCont(Vector<VoResumCont> vec){
		super();
		columnas = new Vector<String>();
		
		this.datos = vec;
		columnas.add("Descripción");
		columnas.add("Valor");
	}

	public int getRowCount() {
		if (datos.size()!=0)
			return datos.size();
		else
			return 0;
	}

	public int getColumnCount() {
		return columnas.size();
	}
	
	public Object getValueAt(int row, int col) {
		switch (col){
		case 0: {
			return (datos.get(row)).getDescripcion();
		}
		case 1: {
			return (datos.get(row)).getValor();
		}
		default: return null;
		}
	}
	
	public Class getColumnClass (int arg1){
		return getValueAt(0,arg1).getClass();
	}

	public String getColumnName (int col){
		return (String)columnas.elementAt(col);
	}
}
