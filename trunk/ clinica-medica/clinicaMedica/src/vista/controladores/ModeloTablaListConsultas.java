package vista.controladores;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import vista.dataobjet.DataConsFecha;

public class ModeloTablaListConsultas extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private Vector<String> columnas;
	private Vector<DataConsFecha> datos;
	
	public ModeloTablaListConsultas(Vector<DataConsFecha> datosbase){
		super ();
		columnas = new Vector<String>();
		
		this.datos = datosbase;
		columnas.add("Medico");
		//columnas.add("Horario");
		columnas.add("Turno");
		columnas.add("Consultorio");		
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
			System.out.println((datos.get(row)).getNomMed());
			return (datos.get(row)).getNomMed();
		}
		case 1: {
			System.out.println((datos.get(row)).getTurno());
			return (datos.get(row)).getTurno();
		}
		case 2:{
			System.out.println((datos.get(row)).getIdConsultorio());
			return (datos.get(row)).getIdConsultorio();
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
