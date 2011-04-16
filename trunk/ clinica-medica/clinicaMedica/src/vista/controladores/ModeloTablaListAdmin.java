package vista.controladores;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import excepciones.PersistenciaException;

import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

import vista.dataobjet.DataAdmin;
import vista.dataobjet.DataCargo;
import vista.dataobjet.DataEsp;

public class ModeloTablaListAdmin extends AbstractTableModel {
	
	private ProxyFachadaLogica mod;
	private Vector columnas;
	private Vector <DataAdmin> datos;
	
	public ModeloTablaListAdmin (ProxyFachadaLogica mode){
		super ();
		mod = mode;
		columnas = new Vector();
		
		try {
			this.datos = mod.listarAdmin();
			columnas.add("id");
			columnas.add("Nombre");
			columnas.add("Cargo");
			columnas.add("Estado");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		System.out.println("pasa fede");
		switch (col){
		case 0: {
			System.out.println((datos.get(row)).getId());
			return (datos.get(row)).getId();
		}
		case 1: {
			System.out.println((datos.get(row)).getNombre());
			return (datos.get(row)).getNombre();
		}
		case 2:{
			System.out.println((datos.get(row)).getCargo());
			Vector<DataCargo> vec = new Vector<DataCargo>();
			try {
				vec = mod.listarCargos();
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(null,"Error de conexion con el server");
				e.printStackTrace();
			} catch (PersistenciaException e) {
				JOptionPane.showMessageDialog(null,"Error al intentar acceder a la persistencia");
				e.printStackTrace();
			}
			int cargo = (datos.get(row)).getCargo();
			String nomCargo = "";
			for(int i=0; i< vec.size(); i++){
				if((vec.get(i)).getIdCargo()== cargo){
					nomCargo = (vec.get(i)).getDescripcion();
				}
			}
			return nomCargo;
		}
		case 3: {
			System.out.println((datos.get(row)).getEstado());
			return (datos.get(row)).getEstado();
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
