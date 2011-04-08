package persistencia.dao;

import java.util.Calendar;
import java.util.Vector;
import excepciones.PersistenciaException;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataMed;
import vista.dataobjet.VoResumCont;
import vista.dataobjet.VosLogin;
import logica.Afiliado;
import logica.Especialidad;
import logica.Medico;

public interface IDaoMedico {

 	public void altaMedico(Transaccion trn, DataMed med) throws PersistenciaException;
 	public void modifMedico(Transaccion trn, String id, String nom, String apell, String ci, String tel, DataEsp esp)  throws PersistenciaException;
 	public void bajarMedico(Transaccion trn, String id) throws PersistenciaException;
 	public Vector listarMedicos(Transaccion trn) throws PersistenciaException;
 	public Vector listarMedEsp(int idEsp,Transaccion trn) throws PersistenciaException;
 	public Medico getMedico(Transaccion trn, String id) throws PersistenciaException;
 	public VosLogin getDataMedico(Transaccion trn, String id) throws PersistenciaException;
 	public boolean validarMed(Transaccion trn, String id) throws PersistenciaException;
 	public Vector listarSalarios(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException;
 	public Vector listarMedPremiado(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException;
 	public VoResumCont calcSalarioTotal(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException;
 	public Vector listarDispMed(DataMed dataMed,Transaccion trn) throws PersistenciaException;
 	public void cargaConsultasProxMes(Transaccion trn, String id, Calendar fecha) throws PersistenciaException;
 	public Vector listarConsultasDisp(Transaccion trn) throws PersistenciaException;
	public void altaConsulta(Transaccion trn, Calendar fecha, String idMed, int dia, DataAfiliado afil, int consult, int turno, int horario, boolean timbre) throws PersistenciaException;
	
}
