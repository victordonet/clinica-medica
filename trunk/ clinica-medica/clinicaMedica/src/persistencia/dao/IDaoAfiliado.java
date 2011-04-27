package persistencia.dao;

import java.util.Vector;

import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataExamen;
import vista.dataobjet.VosLogin;
import excepciones.PersistenciaException;

public interface IDaoAfiliado {

	public void altaAfiliado(Transaccion trn, DataAfiliado afil) throws PersistenciaException;
	public void modifAfil(Transaccion trn,String idAfil, String nom, String apel, String ci, String mail, String dir, String tel, boolean fon, String estado) throws PersistenciaException;
	public void bajaAfil(Transaccion trn, String id) throws PersistenciaException;
	public Vector<DataAfiliado> listarAfiliados(Transaccion trn, String estado)throws PersistenciaException;
	public VosLogin getDataAfiliado(Transaccion trn, String id) throws PersistenciaException;
	public boolean validarAfil(Transaccion trn, String idAfil) throws PersistenciaException;
	public Vector<DataExamen> listarExPend(Transaccion trn, String idAfil) throws PersistenciaException;
	public DataAfiliado getAfiliado(String idAfil, Transaccion trn) throws PersistenciaException;
	
}
