package logica.fachada;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;
import logica.AdminGen;
import logica.Afiliado;
import logica.Consulta;
import logica.Disponibilidad;
import logica.Especialidad;
import logica.Examen;
import logica.Medico;
import logica.TipoExamen;
import logica.TotConsulta;
import logica.Usuario;
import logica.observer.IObservable;
import excepciones.EspecialidadException;
import excepciones.PersistenciaException;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataMed;
import vista.dataobjet.VoDispo;
import vista.dataobjet.VosLogin;

public interface IfachadaLogica extends IObservable{

	//AFILIADOS
	public void altaAfiliado(Afiliado afil) throws PersistenciaException, RemoteException;
	public void modifAfil(String idAfil, String nom, String apel, String ci, String mail, String dir, String tel, Calendar ing, boolean fon) throws PersistenciaException, RemoteException;
	public void bajaAfil(String id) throws PersistenciaException, RemoteException;
	public Vector<Afiliado> listarAfiliados() throws PersistenciaException, RemoteException;
	public VosLogin getDataAfiliado(String id) throws PersistenciaException, RemoteException;
	public boolean validarAfil(String idAfil) throws PersistenciaException, RemoteException;
	public Vector<Examen> listarExPend(String idAfil) throws PersistenciaException, RemoteException;
	public Afiliado getAfiliado(String idAfil) throws PersistenciaException, RemoteException;
	
	//ADMINS-GERENTES
	public void altaAdmin(AdminGen adm) throws PersistenciaException, RemoteException;
	public void modificarAdmin(String id, String nom, String cargo) throws PersistenciaException, RemoteException;
	public void bajaAdmin(String id) throws PersistenciaException, RemoteException;
	public Vector<AdminGen> listarAdmin() throws PersistenciaException, RemoteException;
	public VosLogin getDataAdmin(String id) throws PersistenciaException, RemoteException;
	public boolean validarAdmin(String id) throws PersistenciaException, RemoteException;
	public void modifEx(String idAfil,Calendar fIni,int idTex,Calendar fRes) throws PersistenciaException, RemoteException;
	
	//CONSULTAS
	public int getCantidadConsultas(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException;
	public void altaconsultaProxMes(Consulta cons) throws PersistenciaException, RemoteException;
	public Vector<Consulta> listarConsultasDisp() throws PersistenciaException, RemoteException;
	public void altaConsulta(Calendar fecha, String horario, int dia, Afiliado afil, int turno, Medico med) throws PersistenciaException, RemoteException;
	
	//DISPONIBILIDAD
	public void updateDisponibilidad(VoDispo vo) throws PersistenciaException;
	
	//ESPECIALIDADES
	public void altaEspecialidad(DataEsp datEsp) throws PersistenciaException, RemoteException, EspecialidadException;
	public Vector<Especialidad> listarEspecialidades() throws PersistenciaException, RemoteException;
	public Especialidad obtenerEspecialidad(int idEsp) throws PersistenciaException, RemoteException;
	
	//EXAMENES
	public void regEx(Examen ex) throws PersistenciaException, RemoteException;
	public int getCantExPagos(Calendar fini,Calendar ffin) throws PersistenciaException, RemoteException;
	public int getCantExam(Calendar fecha) throws PersistenciaException, RemoteException;
	
	//MEDICOS
 	public void altaMedico(Medico med) throws PersistenciaException, RemoteException;
 	public void modifMedico(String id, String nom, String apell, String ci, String tel, Especialidad esp) throws PersistenciaException, RemoteException;
 	public void bajarMedico(String id) throws PersistenciaException, RemoteException;
 	public Vector<Medico> listarMedico() throws PersistenciaException, RemoteException;
 	public Vector<Medico> listarMedEsp(int idEsp) throws PersistenciaException, RemoteException;
 	public Medico getMedico(String id) throws PersistenciaException, RemoteException;
 	public VosLogin getDataMedico(String id) throws PersistenciaException, RemoteException;
 	public boolean validarMed(String id) throws PersistenciaException, RemoteException;
 	public Vector listarSalarios(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException;
 	public Vector<Medico> listarMedPremiado(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException;
 	public Vector calcSalarioTotal(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException;
 	public Vector<Disponibilidad> listarDispMed(DataMed dataMed) throws PersistenciaException, RemoteException;
 	public void cargaConsultasProxMes(String id, Calendar fecha) throws PersistenciaException, RemoteException;
	public void altaConsulta(Calendar fecha,String id,int dia, Afiliado afil, int conult) throws PersistenciaException, RemoteException;
	
	//TIPO DE EXAMEN
	public void agregar(TipoExamen tex) throws PersistenciaException, RemoteException;
	public void modificar(TipoExamen tex) throws PersistenciaException, RemoteException;
	public Vector<TipoExamen> listarTipoEx() throws PersistenciaException, RemoteException;
	
	//TOTAL CONSULTAS
	public int getCantConsult(String x) throws PersistenciaException, RemoteException;
	public int getCantConsultasPagas(Calendar fDesde,Calendar fHasta) throws PersistenciaException, RemoteException;
	public Vector<TotConsulta> listarConsultasAfi(String id) throws PersistenciaException, RemoteException;
	public Vector<TotConsulta> listarConsFecha(Calendar fecha) throws PersistenciaException, RemoteException;
	
	//USUARIOS
	public void altaUsuario(Usuario usu) throws PersistenciaException, RemoteException;
	public boolean validarUsuario(String clave,String pass) throws PersistenciaException, RemoteException;
	public void modifContrasena(String clave, String pass) throws PersistenciaException, RemoteException;
}