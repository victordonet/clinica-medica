package vista.controladores;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import vista.dataobjet.DataConsFecha;

public class ModeloTablaListadoConsultas extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private Vector<String> columnas;
	private Vector<DataConsFecha> datos;
	
	public ModeloTablaListadoConsultas(Vector<DataConsFecha> vec){
		super ();
		columnas = new Vector<String>();
		
		this.datos = vec;
		columnas.add("Fecha");
		columnas.add("Médico");
		columnas.add("Afiliado");
		columnas.add("Consultorio");
		columnas.add("Turno");
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
		case 2:{
			return (datos.get(row)).getNomAfi()+" "+(datos.get(row)).getApeAfil();
		}
		case 3:{
			return (datos.get(row)).getIdConsultorio();
		}
		case 4:{
			return (datos.get(row)).getTurno();
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
