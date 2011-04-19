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

	public ModeloTablaDisp(int[][] matriz, int cantConsultorios){
		super ();
		columnas = new Vector<String>();
		this.cantConsultorios = cantConsultorios;
		matrizDatos = matriz;
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
		}

    public void setValueAt(boolean v,int f,int c)
    {
        matrizDispMedico[f][c]=v;
        fireTableCellUpdated(f,c);
    }
	
	public boolean isCellEditable(int row, int col) { 
        
		if(matrizDatos[row][col]<cantConsultorios){
        	return true;
        }
		else{
			return false;
		}
    }
	
}
