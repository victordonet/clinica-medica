package vista.controladores;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import vista.dataobjet.DataMed;

public class ModeloTablaListMed extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private Vector<String> columnas;
	private Vector<DataMed> datos;
	
	public ModeloTablaListMed(Vector<DataMed> vec){
		super();
		columnas = new Vector<String>();
		
		this.datos = vec;
		columnas.add("Identificación");
		columnas.add("Nombre");
		columnas.add("Apellido");
		columnas.add("CI");
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
			return (datos.get(row)).getId();
		}
		case 1: {
			return (datos.get(row)).getNombre();
		}
		case 2:{
			return (datos.get(row)).getApellido();
		}
		case 3:{
			return (datos.get(row)).getCi();
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
