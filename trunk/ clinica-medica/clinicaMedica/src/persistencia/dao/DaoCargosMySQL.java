package persistencia.dao;

import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataCargo;
import excepciones.PersistenciaException;

public class DaoCargosMySQL implements IDaoCargos {

	@Override
	public Vector<DataCargo> listarCargos(Transaccion trn) throws PersistenciaException, RemoteException {
		Vector<DataCargo> resultado = new Vector<DataCargo>();
		try {
			PreparedStatement pst = trn.preparedStatement("Select * from Cargos");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				int id = rst.getInt("Id");
				String descripcion = rst.getString("Descripcion");
				DataCargo dataCar = new DataCargo(id, descripcion);
				resultado.add(dataCar);
			}
			rst.close();
			pst.close();
			return resultado;
		} catch (SQLException e) {
			throw new PersistenciaException("Error de conexion con la base de datos");
		}
	}

}

