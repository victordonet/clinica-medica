package logica.fachada;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;
import logica.Medico;
import logica.observer.IObservable;
import excepciones.PersistenciaException;
import vista.dataobjet.DataAdmin;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataCantConsu;
import vista.dataobjet.DataCargo;
import vista.dataobjet.DataConsAfi;
import vista.dataobjet.DataConsFecha;
import vista.dataobjet.DataConsulta;
import vista.dataobjet.DataConsultas;
import vista.dataobjet.DataConsultorio;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataExamen;
import vista.dataobjet.DataMed;
import vista.dataobjet.DataReservaTurno;
import vista.dataobjet.DataSalario;
import vista.dataobjet.DataTipoExamen;
import vista.dataobjet.DataUsuario;
import vista.dataobjet.DataDisp;
import vista.dataobjet.VoMedEsp;
import vista.dataobjet.VoResumCont;
import vista.dataobjet.VoTurnosDisp;
import vista.dataobjet.VosLogin;

public interface IfachadaLogica extends IObservable{

	//AFILIADOS
	public void altaAfiliado(DataAfiliado afil) throws PersistenciaException, RemoteException;
	public void modifAfil(String idAfil, String nom, String apel, String ci, String mail, String dir, String tel, boolean fon) throws PersistenciaException, RemoteException;
	public void bajaAfil(String id) throws PersistenciaException, RemoteException;
	public Vector<DataAfiliado> listarAfiliados() throws PersistenciaException, RemoteException;
	public VosLogin getDataAfiliado(String id) throws PersistenciaException, RemoteException;
	public boolean validarAfil(String idAfil) throws PersistenciaException, RemoteException;
	public Vector<DataExamen> listarExPend(String idAfil) throws PersistenciaException, RemoteException;
	public DataAfiliado getAfiliado(String idAfil) throws PersistenciaException, RemoteException;
	public boolean cobraTimbre(String idAfil) throws PersistenciaException, RemoteException;
	
	//ADMINS-GERENTES
	public void altaAdmin(DataAdmin adm) throws PersistenciaException, RemoteException;
	public void modificarAdmin(String id, String nom, String cargo) throws PersistenciaException, RemoteException;
	public void bajaAdmin(String id) throws PersistenciaException, RemoteException;
	public Vector<DataAdmin> listarAdmin() throws PersistenciaException, RemoteException;
	public VosLogin getDataAdmin(String id) throws PersistenciaException, RemoteException;
	public boolean validarAdmin(String id) throws PersistenciaException, RemoteException;
	public void modifEx(String idAfil,Calendar fIni,int idTex,Calendar fRes) throws PersistenciaException, RemoteException;
	public Vector<VoResumCont> listarResContable(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException;
	public Vector<DataCargo> listarCargos() throws PersistenciaException, RemoteException;
	
	//CONSULTAS
	public int getCantidadConsultas(Calendar fDesde, Calendar fHasta, String idMed) throws PersistenciaException, RemoteException;
	public void altaConsultaProxMes(DataConsulta cons, String idMed) throws PersistenciaException, RemoteException;
	public Vector<VoTurnosDisp> listarConsultasDisp(String idMed) throws PersistenciaException, RemoteException;
	public void altaConsulta(DataReservaTurno dataResTurno) throws PersistenciaException, RemoteException;
	public void elimConsultasAfil(String idAfil) throws PersistenciaException, RemoteException;
	public Vector<DataConsultas> listarConsultas() throws PersistenciaException, RemoteException;
	
	//DISPONIBILIDAD
	public void altaDisponibilidad(DataDisp dataDsip) throws PersistenciaException, RemoteException;
	public void eliminarDisponibilidad(DataDisp vo) throws PersistenciaException, RemoteException;
	public int[][] obetnerDispoDiaHora() throws PersistenciaException, RemoteException;
	public boolean[][] obtenerDispoDiaHoraMedico(String idMedico)throws PersistenciaException, RemoteException;
	
	//ESPECIALIDADES
	public void altaEspecialidad(DataEsp datEsp) throws PersistenciaException, RemoteException;
	public Vector<DataEsp> listarEspecialidades() throws PersistenciaException, RemoteException;
	public DataEsp obtenerEspecialidad(int idEsp) throws PersistenciaException, RemoteException;
	public void bajaEspecialidad(int idEsp) throws PersistenciaException, RemoteException;
	
	//EXAMENES
	public void regEx(DataExamen ex, String idAfil) throws PersistenciaException, RemoteException;
	public int getCantExPagos(Calendar fini,Calendar ffin) throws PersistenciaException, RemoteException;
	public int getCantExam(Calendar fecha) throws PersistenciaException, RemoteException;
	
	//MEDICOS
 	public void altaMedico(DataMed med) throws PersistenciaException, RemoteException;
 	public void modifMedico(String id, String nom, String apell, String ci, String tel, DataEsp esp) throws PersistenciaException, RemoteException;
 	public void bajarMedico(String id) throws PersistenciaException, RemoteException;
 	public Vector<DataMed> listarMedicos() throws PersistenciaException, RemoteException;
 	public Vector<VoMedEsp> listarMedEsp(int idEsp) throws PersistenciaException, RemoteException;
 	public Medico getMedico(String id) throws PersistenciaException, RemoteException;
 	public VosLogin getDataMedico(String id) throws PersistenciaException, RemoteException;
 	public boolean validarMed(String id) throws PersistenciaException, RemoteException;
 	public Vector<DataSalario> listarSalarios(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException;
 	public Vector<DataCantConsu> listarMedPremiado(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException;
 	public VoResumCont calcSalarioTotal(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException;
 	public Vector<DataDisp> listarDispMed(String idMed) throws PersistenciaException, RemoteException;
 	public void cargaConsultasProxMes(String id) throws PersistenciaException, RemoteException;
 	public DataMed getDataMed(String id) throws PersistenciaException, RemoteException;

	//TIPO DE EXAMEN
	public void agregar(DataTipoExamen tex) throws PersistenciaException, RemoteException;
	public void modificar(DataTipoExamen tex) throws PersistenciaException, RemoteException;
	public Vector<DataTipoExamen> listarTipoEx() throws PersistenciaException, RemoteException;
	
	//TOTAL CONSULTAS
	public int getCantConsult(String idAfil) throws PersistenciaException, RemoteException;
	public int getCantConsultasPagas(Calendar fDesde,Calendar fHasta) throws PersistenciaException, RemoteException;
	public Vector<DataConsAfi> listarConsultasAfi(String id) throws PersistenciaException, RemoteException;
	public Vector<DataConsFecha> listarConsFecha(Calendar fecha) throws PersistenciaException, RemoteException;
	public void elimConsulta(String idAfi) throws PersistenciaException, RemoteException;
	
	//USUARIOS
	public void altaUsuario(DataUsuario usu) throws PersistenciaException, RemoteException;
	public boolean validarUsuario(String clave,String pass) throws PersistenciaException, RemoteException;
	public void modifContrasena(String clave, String pass) throws PersistenciaException, RemoteException;
	public String getTipo(String idUsuario)throws PersistenciaException, RemoteException;
	
	//CONSULTORIOS
	public boolean validarConsultorio(int id) throws PersistenciaException, RemoteException;
	public void altaConsultorio(DataConsultorio consultorio) throws PersistenciaException, RemoteException;
	public void bajaConsultorio(int idConsultorio) throws PersistenciaException, RemoteException;
	public Vector<DataConsultorio> listarConsultorios() throws PersistenciaException, RemoteException;
}