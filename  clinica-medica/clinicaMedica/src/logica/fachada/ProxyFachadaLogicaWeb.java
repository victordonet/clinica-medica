package logica.fachada;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.AdminGen;
import logica.Afiliado;
import logica.Consulta;
import logica.Especialidad;
import logica.Examen;
import logica.Medico;
import logica.TipoExamen;
import logica.Usuario;
import logica.observer.IObserver;
import persistencia.transacciones.Transaccion;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataMed;
import vista.dataobjet.VoDispo;
import vista.dataobjet.VosLogin;
import excepciones.EspecialidadException;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class ProxyFachadaLogicaWeb extends HttpServlet implements IfachadaLogica {
	private IfachadaLogica fachada;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProxyFachadaLogicaWeb() {}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		ServletContext sc = config.getServletContext();
		String ruta = config.getInitParameter("SERVER-RMI");

		 try {
			fachada = (IfachadaLogica) Naming.lookup(ruta+"logica");
			sc.setAttribute("modeloProxy", fachada);
		} catch (MalformedURLException e) {
			new LogicaException("Publicación del servidor incorrecta");
			e.printStackTrace();
		} catch (NotBoundException e) {
			new LogicaException("Error Bound Exception");
			e.printStackTrace();
		}catch (RemoteException e) {
			new LogicaException("Error Remote Exception");
			e.printStackTrace();
		}
	}

	//SERVLET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
    
	//GENERALES
	public void addObserver(IObserver obs) throws RemoteException {
		fachada.addObserver(obs);
	}
	public void remObserver(IObserver obs) throws RemoteException {
		fachada.remObserver(obs);
	}
	public void notificar() throws RemoteException {
		fachada.notificar();
	}
	
	//AFILIADOS
	public void altaAfiliado(Afiliado afil)throws PersistenciaException, RemoteException {
		fachada.altaAfiliado(afil);
	}
	public void modifAfil(String idAfil, String nom, String apel, String ci, String mail, String dir, String tel, Calendar ing, boolean fon) throws PersistenciaException, RemoteException {
		fachada.modifAfil(idAfil, nom, apel, ci, mail, dir, tel, ing, fon);
	}
	public void bajaAfil(String id)throws PersistenciaException, RemoteException {
		fachada.bajaAfil(id);
	}
	public Vector listarAfiliados()throws PersistenciaException, RemoteException {
		return fachada.listarAfiliados();
	}
	public VosLogin getDataAfiliado(String id)throws PersistenciaException, RemoteException {
		return fachada.getDataAfiliado(id);
	}
	public boolean validarAfil(String idAfil)throws PersistenciaException, RemoteException {
		return fachada.validarAfil(idAfil);
	}
	public Vector listarExPend(String idAfil)throws PersistenciaException, RemoteException {
		return fachada.listarExPend(idAfil);
	}
	public Afiliado getAfiliado(String idAfil)throws PersistenciaException, RemoteException {
		return fachada.getAfiliado(idAfil);
	}
	
	//ADMIN-GERENTE
	public void altaAdmin(AdminGen adm) throws PersistenciaException, RemoteException {
		fachada.altaAdmin(adm);
	}
	public void modificarAdmin(String id, String nom, String cargo) throws PersistenciaException, RemoteException {
		fachada.modificarAdmin(id, nom, cargo);
	}
	public void bajaAdmin(String id) throws PersistenciaException, RemoteException {
		fachada.bajaAdmin(id);
	}
	public Vector listarAdmin() throws PersistenciaException, RemoteException {
		return fachada.listarAdmin();
	}
	public VosLogin getDataAdmin(String id) throws PersistenciaException, RemoteException {
		return fachada.getDataAdmin(id);
	}
	public boolean validarAdmin(String id) throws PersistenciaException, RemoteException {
		return fachada.validarAdmin(id);
	}
	public void modifEx(String idAfil,Calendar fIni,int idTex,Calendar fRes) throws PersistenciaException, RemoteException {
		fachada.modifEx(idAfil, fIni, idTex, fRes);
	}
	
	//CONSULTAS
	public int getCantidadConsultas(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException {
		return fachada.getCantidadConsultas(fDesde, fHasta);
	}
	public void altaconsultaProxMes(Consulta cons) throws PersistenciaException, RemoteException {
		fachada.altaconsultaProxMes(cons);
	}
	public Vector listarConsultasDisp() throws PersistenciaException, RemoteException {
		return fachada.listarConsultasDisp();
	}
	public void altaConsulta(Calendar fecha, String horario, int dia, Afiliado afil, int turno, Medico med) throws PersistenciaException, RemoteException {
		fachada.altaConsulta(fecha, horario, dia, afil, turno, med);
	}
	
	//DISPONIBILIDAD
	public void updateDisponibilidad(VoDispo vo) throws PersistenciaException {
		fachada.updateDisponibilidad(vo);
	}
	
	//ESPECIALIDADES
	public void altaEspecialidad(DataEsp datEsp) throws RemoteException, PersistenciaException, EspecialidadException {
			fachada.altaEspecialidades(datEsp);
	}
	public Vector listarEspecialidades() throws PersistenciaException, RemoteException {
		return fachada.listarEspecialidades();
	}
	public Especialidad obtenerEspecialidad(int idEsp) throws PersistenciaException, RemoteException {
		return fachada.obtenerEspecialidad(idEsp);
	}
	
	//EXAMENES
	public void regEx(Examen ex) throws PersistenciaException, RemoteException {
		fachada.regEx(ex);
	}
	public int getCantExPagos(Calendar fini,Calendar ffin) throws PersistenciaException, RemoteException {
		return fachada.getCantExPagos(fini, ffin);
	}
	public int getCantExam(Calendar fecha) throws PersistenciaException, RemoteException {
		return fachada.getCantExam(fecha);
	}
	
	//MEDICOS
	public void altaMedico(Medico med)  throws PersistenciaException, RemoteException {
		fachada.altaMedico(med);
	}
 	public void modifMedico(String id, String nom, String apell, String ci, String tel, Especialidad esp)  throws PersistenciaException, RemoteException {
 		fachada.modifMedico(id, nom, apell, ci, tel, esp);
 	}
 	public void bajarMedico(String id)  throws PersistenciaException, RemoteException {
 		fachada.bajarMedico(id);
 	}
 	public Vector listarMedico()  throws PersistenciaException, RemoteException {
 		return fachada.listarMedico();
 	}
 	public Vector listarMedEsp(int idEsp)  throws PersistenciaException, RemoteException {
 		return fachada.listarMedEsp(idEsp);
 	}
 	public Medico getMedico(String id)  throws PersistenciaException, RemoteException {
 		return fachada.getMedico(id);
 	}
 	public VosLogin getDataMedico(String id)  throws PersistenciaException, RemoteException {
 		return fachada.getDataMedico(id);
 	}
 	public boolean validarMed(String id)  throws PersistenciaException, RemoteException {
 		return fachada.validarMed(id);
 	}
 	public Vector listarSalarios(Calendar fDesde, Calendar fHasta)  throws PersistenciaException, RemoteException {
 		return fachada.listarSalarios(fDesde, fHasta);
 	}
 	public Vector listarMedPremiado(Calendar fDesde, Calendar fHasta)  throws PersistenciaException, RemoteException {
 		return fachada.listarMedPremiado(fDesde, fHasta);
 	}
 	public Vector calcSalarioTotal(Calendar fDesde, Calendar fHasta)  throws PersistenciaException, RemoteException {
 		return fachada.calcSalarioTotal(fDesde, fHasta);
 	}
 	public Vector listarDispMed(DataMed dataMed)  throws PersistenciaException, RemoteException {
 		return fachada.listarDispMed(dataMed);
 	}
 	public void cargaConsultasProxMes(String id, Calendar fecha)  throws PersistenciaException, RemoteException {
 		fachada.cargaConsultasProxMes(id, fecha);
 	}
	public void altaConsulta(Calendar fecha,String id,int dia, Afiliado afil, int conult)  throws PersistenciaException, RemoteException {
		fachada.altaConsulta(fecha, id, dia, afil, conult);
	}
	
	//TIPO DE EXAMEN
	public void agregar(TipoExamen tex) throws PersistenciaException, RemoteException {
		fachada.agregar(tex);
	}
	public void modificar(TipoExamen tex) throws PersistenciaException, RemoteException {
		fachada.modificar(tex);
	}
	public Vector listarTipoEx() throws PersistenciaException, RemoteException {
		return fachada.listarTipoEx();
	}
	
	//TOTAL CONSULTAS
	public int getCantConsult(String x) throws PersistenciaException, RemoteException {
		return fachada.getCantConsult(x);
	}
	public int getCantConsultasPagas(Calendar fDesde,Calendar fHasta) throws PersistenciaException, RemoteException {
		return fachada.getCantConsultasPagas(fDesde, fHasta);
	}
	public Vector listarConsultasAfi(String id) throws PersistenciaException, RemoteException {
		return fachada.listarConsultasAfi(id);
	}
	public Vector listarConsFecha(Calendar fecha) throws PersistenciaException, RemoteException {
		return fachada.listarConsFecha(fecha);
	}
	
	//USUARIOS
	public void altaUsuario(Usuario usu) throws PersistenciaException, RemoteException {
		fachada.altaUsuario(usu);
	}
	public boolean validarUsuario(String clave,String pass) throws PersistenciaException, RemoteException {
		return fachada.validarUsuario(clave, pass);
	}
	public void modifContrasena(String clave, String pass) throws PersistenciaException, RemoteException {
		fachada.modifContrasena(clave, pass);
	}
}
