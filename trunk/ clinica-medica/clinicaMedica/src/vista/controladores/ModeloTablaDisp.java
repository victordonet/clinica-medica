package vista.controladores;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaDisp extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
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
		}

    public void setValueAt(Object v,int row,int col)
    {
        matrizDispMedico[row][col]=(Boolean) v;
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
	public boolean[][] getMatrizDispMedico() {
		return matrizDispMedico;
	}
	
}
