package persistencia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import persistencia.transacciones.Transaccion;
import excepciones.PersistenciaException;

public class DaoTotConsultaMySQL implements IDaoTotConsulta {

	
	public int getCantConsult(Transaccion trn, String idAfi) throws PersistenciaException{
		PreparedStatement pst;
		int cantidadConsulta = 0;
		pst = trn.preparedStatement("select count (idafiliado) from consultas where idafiliado = ?");
		try {
			pst.setString (1, idAfi);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				cantidadConsulta = rst.getInt("idafiliado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage());
		}
		return cantidadConsulta;
	}

	@Override
	public int getCantConsultasPagas(Transaccion trn, Calendar fDesde,
			Calendar fHasta) throws PersistenciaException {
		PreparedStatement pst;
		int cantidadConsulta = 0;
		pst = trn.preparedStatement("select count (idafiliado) from consultas where fehca between ? and ? and timbre = 'S'");
		Date desde = new java.sql.Date(fDesde.getTimeInMillis());
		Date hasta = new java.sql.Date(fHasta.getTimeInMillis());
		
		try {
			pst.setDate (1,desde);
			pst.setDate (2,hasta);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				cantidadConsulta = rst.getInt("idafiliado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage());
		}
		return cantidadConsulta;
	}

	@Override
	public Vector listarConsultasAfi(Transaccion trn, String id)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector listarConsFecha(Transaccion trn, Calendar fecha)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void elimConsulta(Transaccion trn, String idAfi)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

}
