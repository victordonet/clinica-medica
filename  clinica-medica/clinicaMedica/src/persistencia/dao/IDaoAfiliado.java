package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.VosLogin;
import logica.Afiliado;

public interface IDaoAfiliado {

	public void altaAfiliado(Transaccion trn, Afiliado afil) throws PersistenciaException;
	public void modifAfil(Transaccion trn,String idAfil, String nom, String apel, String ci, String mail, String dir, String tel, Calendar ing, boolean fon) throws PersistenciaException;
	public void bajaAfil(Transaccion trn, String id) throws PersistenciaException;
	public Vector listarAfiliados(Transaccion trn)throws PersistenciaException;
	public VosLogin getDataAfiliado(Transaccion trn, String id) throws PersistenciaException;
	public boolean validarAfil(Transaccion trn, String idAfil) throws PersistenciaException;
	public Vector listarExPend(Transaccion trn, int idAfil) throws PersistenciaException;
	public Afiliado getAfiliado(String idAfil, Transaccion trn) throws PersistenciaException;
	
}
