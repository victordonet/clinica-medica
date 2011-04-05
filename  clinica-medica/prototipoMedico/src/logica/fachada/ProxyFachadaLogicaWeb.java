package logica.fachada;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.observer.IObserver;
import persistencia.dao.EspecialidadException;
import vista.dataobjet.DataEsp;
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
		int control = 1;
		
		try {
			sc.setAttribute("control", control);
			fachada = (IfachadaLogica) Naming.lookup(ruta+"logica");
			sc.setAttribute("modeloProxy", fachada);
		} catch (MalformedURLException e) {
			control = 0;
			sc.setAttribute("control", control);
			new LogicaException("Publicación del servidor incorrecta");
			e.printStackTrace();
		} catch (NotBoundException e) {
			control = 0;
			sc.setAttribute("control", control);
			new LogicaException("Error Bound Exception");
			e.printStackTrace();
		}catch (RemoteException e) {
			control = 0;
			sc.setAttribute("control", control);
			new LogicaException("Error Remote Exception");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
    
	public void addObserver(IObserver obs) throws RemoteException {
		fachada.addObserver(obs);
	}
	
	public void remObserver(IObserver obs) throws RemoteException {
		fachada.remObserver(obs);
	}

	public void notificar() throws RemoteException {
		fachada.notificar();
	}

	public void altaEspecialidades(DataEsp datEsp) throws RemoteException, PersistenciaException, EspecialidadException {
		fachada.altaEspecialidades(datEsp);
	}

	public Vector listarEspecialidades() throws PersistenciaException, RemoteException {
		return fachada.listarEspecialidades();
	}
	
	public boolean validarUsuario(String clave, String pass) throws PersistenciaException, RemoteException {
		return fachada.validarUsuario(clave, pass);
	}
}
