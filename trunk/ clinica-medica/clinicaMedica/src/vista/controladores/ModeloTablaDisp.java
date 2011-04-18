package vista.controladores;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import vista.dataobjet.DataConsFecha;
import vista.dataobjet.DataDisp;
import vista.dataobjet.DataEsp;

public class ModeloTablaDisp extends AbstractTableModel {
	private Vector<String> columnas;
	private Vector<DataDisp> datos;

	public ModeloTablaDisp(Vector<DataDisp> vec){
		super ();
		columnas = new Vector<String>();
		
		this.datos = vec;
		columnas.add("D");
		columnas.add("L");
		columnas.add("M");
		columnas.add("M");
		columnas.add("J");
		columnas.add("V");
		columnas.add("S");
	}
	public int getColumnCount() {
		return columnas.size();
	}

	
	public int getRowCount() {
		if (datos.size()!=0)
			return datos.size();
		else
			return 0;
	}

	
	public Object getValueAt(int row, int col) {
		for (DataDisp dispo : datos){
			switch (dispo.getDia()){
			case 0: switch (dispo.getHorario()){
					case 1: 
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					case 10:
					case 11:
					case 12:
					case 13:
					case 14:
					case 15:
					case 16:
					case 17:
					case 18:	
					case 19:
					case 20:
					case 21:
					case 22:	
			}
			}
		}
		return col;
		
//		switch (col){
//		case 0: {
//			case 
//			return (datos.get(row));
//		}
//		case 1: {
//			return (datos.get(row)).getNomMed()+" "+(datos.get(row)).getApeMed();
//		}
//		case 2:{
//			return (datos.get(row)).getNomAfi()+" "+(datos.get(row)).getApeAfil();
//		}
//		case 3:{
//			return (datos.get(row)).getIdConsultorio();
//		}
//		case 4:{
//			return (datos.get(row)).getTurno();
//		}
//		default: return null;
//		}
	}

}
