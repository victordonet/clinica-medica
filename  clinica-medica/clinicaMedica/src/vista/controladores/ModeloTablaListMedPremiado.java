package vista.controladores;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import vista.dataobjet.DataCantConsu;

public class ModeloTablaListMedPremiado extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private Vector<String> columnas;
	private Vector<DataCantConsu> datos;
	
	public ModeloTablaListMedPremiado(Vector<DataCantConsu> datosbase){
		super ();
		columnas = new Vector<String>();
		
		this.datos = datosbase;
		columnas.add("Medico");
		columnas.add("Cant.Consultas");		
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
			return (datos.get(row)).getNombre()+" "+(datos.get(row)).getApellido();
		}
		case 1: {
			return (datos.get(row)).getCantConsultas();
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
