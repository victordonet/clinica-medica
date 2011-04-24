package vista.controladores;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import vista.dataobjet.DataEsp;

public class ModeloTablaListEsp extends AbstractTableModel {
	
	private Vector columnas;
	private Vector <DataEsp> datos;
	
	public ModeloTablaListEsp (Vector datosbase){
		super ();
		columnas = new Vector();
		
		this.datos = datosbase;
		columnas.add("id");
		columnas.add("Especialidad");
		columnas.add("Monto base");		
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
			return (datos.get(row)).getCodigo();
		}
		case 1: {
			return (datos.get(row)).getDescripcion();
		}
		case 2:{
			return (datos.get(row)).getMontoBase();
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
