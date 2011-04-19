package vista.controladores;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import vista.dataobjet.DataConsFecha;
import vista.dataobjet.DataDisp;
import vista.dataobjet.DataEsp;

public class ModeloTablaDisp extends AbstractTableModel {
	private Vector<String> columnas;
	private int[][] matrizDatos;
	private boolean [][] matrizDispMedico;
	private int cantConsultorios;

	public ModeloTablaDisp(int[][] matriz, boolean[][] matrizMed, int cantConsultorios){
		super ();
		columnas = new Vector<String>();
		this.cantConsultorios = cantConsultorios;
		matrizDatos = matriz;
		matrizDispMedico = matrizMed;
		columnas.add("D");
		columnas.add("L");
		columnas.add("M");
		columnas.add("M");
		columnas.add("J");
		columnas.add("V");
		columnas.add("S");
	}
	public int getColumnCount() {
		return 7;
	}

	
	public int getRowCount() {
		return 12;
	}

	
	public Object getValueAt(int row,int col){
		
		return matrizDispMedico[row][col];
//		switch (col){
//		case 0: {
//			return matrizDispMedico[row][0];
//		}
//		case 1: {
//			return matrizDispMedico[row][1];
//		}
//		case 2:{
//			return matrizDispMedico[row][2];
//		}
//		case 3:{
//			return matrizDispMedico[row][3];
//		}
//		case 4: {
//			return matrizDispMedico[row][4];
//		}
//		case 5:{
//			return matrizDispMedico[row][5];
//		}
//		case 6:{
//			return matrizDispMedico[row][6];
//		}
//
//		default: return false;
//		}
		}

    public void setValueAt(boolean v,int row,int col)
    {
        matrizDispMedico[row][col]=v;
        fireTableCellUpdated(row,col);
    }
	
	public boolean isCellEditable(int row, int col) { 
		if(matrizDatos[row][col]<cantConsultorios){
        	return true;
        }
		else{
			return false;
		}
    }

	public Class getColumnClass (int arg1){
		return getValueAt(0,arg1).getClass();
	}
	public String getColumnName (int col){
		return (String)columnas.elementAt(col);
	}
	
}
