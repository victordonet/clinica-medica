package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAdmin;
import vista.dataobjet.DataExamen;
import vista.dataobjet.VosLogin;

public interface IDaoAdmGen {

	public void altaAdmin(Transaccion trn, DataAdmin adm) throws PersistenciaException;
	public void modificarAdmin(Transaccion trn, String id, String nom, String cargo) throws PersistenciaException;
	public void bajaAdmin(Transaccion trn, String id) throws PersistenciaException;
	public Vector<DataAdmin> listarAdmin(Transaccion trn) throws PersistenciaException;
	public VosLogin getDataAdmin(Transaccion trn, String id) throws PersistenciaException;
	public boolean validarAdmin(Transaccion trn, String id) throws PersistenciaException;
	public void modifEx(Transaccion trn,String idAfil,Calendar fIni,int idTex,Calendar fRes) throws PersistenciaException;
	public Vector<DataExamen> listarExPend(Transaccion trn,String idAdmin) throws PersistenciaException;
	
}
