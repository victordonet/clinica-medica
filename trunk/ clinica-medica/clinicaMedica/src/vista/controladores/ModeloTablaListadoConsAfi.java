package vista.controladores;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import vista.dataobjet.DataConsAfi;

public class ModeloTablaListadoConsAfi extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private Vector<String> columnas;
	private Vector<DataConsAfi> datos;
	
	public ModeloTablaListadoConsAfi(Vector<DataConsAfi> vec){
		super ();
		columnas = new Vector<String>();
		
		this.datos = vec;
		columnas.add("Fecha");
		columnas.add("Médico");
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
			return (datos.get(row)).getFecha().getTime();
		}
		case 1: {
			return (datos.get(row)).getNomMed()+" "+(datos.get(row)).getApeMed();
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
