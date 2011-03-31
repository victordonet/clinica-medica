package persistencia.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;
import java.util.Hashtable;

import logica.Afiliado;
import persistencia.transacciones.Transaccion;
import excepciones.PersistenciaException;

public class DaoAfiliadoMySQL implements IDaoAfiliado {

	@Override
	public void altaAfiliado(Transaccion trn, Afiliado afil) throws PersistenciaException {

		System.out.println("Insertando afiliado: "+ afil.getId());
		PreparedStatement pst;

		try {
			pst = trn.preparedStatement("insert into Afiliados values (?,?,?,?,?,?,?,?,?,?)");
			pst.setString (1, afil.getId());
			pst.setString(2, afil.getNombre());
			pst.setString(3, afil.getApellido());
			pst.setString(4, afil.getCi());
			pst.setString(5, afil.getMail());
			pst.setString(6, afil.getDir());
			pst.setString(7, afil.getTel());
			Date dt = new Date(afil.getFecha().getTimeInMillis());
			pst.setDate(8, dt);
			pst.setBoolean(9, afil.isFonasa());
			pst.setString(10, afil.getEstado());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException("Error de conexion con la base de datos");
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifAfil(Transaccion trn, String idAfil, String nom,
			String apel, String ci, String mail, String dir, String tel,
			Calendar ing, boolean fon) throws PersistenciaException {
		
		System.out.println("Modificando afiliado: "+ idAfil);
		PreparedStatement pst;
		pst = trn.preparedStatement("update Afiliados set id=?, nombre=?, apellido=?, ci=?, mail=?, direccion=?, telefono=?, fechaingreso=?, fonasa=?, estado=?");
		pst.setString (1, idAfil);
		pst.setString(2, nom);
		pst.setString(3, apel);
		pst.setString(4, ci);
		pst.setString(5, mail);
		pst.setString(6, dir);
		pst.setString(7, tel);
		
		pst.setString(8, ing);
		pst.setBoolean(9, afil.isFonasa());
		pst.setString(10, afil.getEstado());
		pst.executeUpdate();

	}

	@Override
	public void bajaAfil(Transaccion trn, String id)
			throws PersistenciaException {
		// TODO Auto-generated method stub

	}

	@Override
	public Hashtable listarAfiliados(Transaccion trn)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarAfil(Transaccion trn, String idAfil)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Hashtable listarExPend(Transaccion trn, int idAfil)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Afiliado getAfiliado(String idAfil, Transaccion trn)
			throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}
