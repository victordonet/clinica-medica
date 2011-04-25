package vista.controladores;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import vista.acceso.ProxyFachadaLogica;
import vista.dataobjet.DataSalario;

public class ModeloTablaLiqSalarioMed extends AbstractTableModel {

	private ProxyFachadaLogica mod;
	private Vector columnas;
	private Vector <DataSalario> datos;
	
	public ModeloTablaLiqSalarioMed (Vector <DataSalario> vec){
		super ();
		this.datos = vec;
		columnas = new Vector();
		
		this.datos = vec;
		columnas.add("id");
		columnas.add("Nombre");
		columnas.add("Apellido");
		columnas.add("Salario");
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
			System.out.println((datos.get(row)).getId());
			return (datos.get(row)).getId();
		}
		case 1: {
			System.out.println((datos.get(row)).getNombre());
			return (datos.get(row)).getNombre();
		}
		case 2: {
			System.out.println((datos.get(row)).getApellido());
			return (datos.get(row)).getApellido();
		}
		case 3: {
			System.out.println((datos.get(row)).getApellido());
			return (datos.get(row)).getSalarioMed();
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
