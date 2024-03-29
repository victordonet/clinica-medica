package vista.controladores;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import vista.acceso.ProxyFachadaLogica;
import vista.dataobjet.DataAdmin;

public class ModeloTablaListAdmin extends AbstractTableModel {
	
	private ProxyFachadaLogica mod;
	private Vector columnas;
	private Vector <DataAdmin> datos;
	
	public ModeloTablaListAdmin (Vector <DataAdmin> vec){
		super ();
		this.datos = vec;
		columnas = new Vector();
		
		this.datos = vec;
		columnas.add("id");
		columnas.add("Nombre");
//		columnas.add("Cargo");
//		columnas.add("Estado");

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
//		case 2:{
//			System.out.println((datos.get(row)).getCargo());
//			Vector<DataCargo> vec = new Vector<DataCargo>();
//			try {
//				vec = mod.listarCargos();
//			} catch (RemoteException e) {
//				JOptionPane.showMessageDialog(null,"Error de conexion con el server");
//				e.printStackTrace();
//			} catch (PersistenciaException e) {
//				JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
//				e.printStackTrace();
//			}
//			int cargo = (datos.get(row)).getCargo();
//			String nomCargo = "";
//			for(int i=0; i< vec.size(); i++){
//				if((vec.get(i)).getIdCargo()== cargo){
//					nomCargo = (vec.get(i)).getDescripcion();
//				}
//			}
//			return nomCargo;
//			//return (datos.get(row)).getCargo();
//		}
//		case 3: {
//			System.out.println((datos.get(row)).getEstado());
//			return (datos.get(row)).getEstado();
//		}
//		
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
