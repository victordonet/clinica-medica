package vista.web.servlet;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.fachada.IfachadaLogica;
import vista.dataobjet.DataConsAfi;
import excepciones.PersistenciaException;

/**
 * Servlet implementation class svtAltaEspecialidad
 */
public class svtListadoConsultasAf extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IfachadaLogica mod;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svtListadoConsultasAf() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	ServletContext sc = getServletContext();
    	mod = (IfachadaLogica) sc.getAttribute("modeloProxy");
    	
    	String id = (String) sc.getAttribute("usuario");
    	
    	Vector<DataConsAfi> listado = new Vector<DataConsAfi>();
    	Vector<Calendar> fechas = new Vector<Calendar>();
    	Vector<String> nombres = new Vector<String>();
    	Vector<String> apellidos = new Vector<String>();
	    try {
			listado = mod.listarConsultasAfi(id);
	    	for (int i = 0; i < listado.size(); i++) {
	    		DataConsAfi cons = listado.get(i);
	    		fechas.add(cons.getFecha());
	    		nombres.add(cons.getNomMed());
	    		apellidos.add(cons.getApeMed());
	    	}
    		session.setAttribute("listFechas", fechas);
    		session.setAttribute("listNombres", nombres);
    		session.setAttribute("listApellidos", apellidos);
			response.sendRedirect("listarConsultasAf.jsp");
		} catch (PersistenciaException e) {
			String msg = "ERROR: No se pudo acceder a la información almacenada.";
			request.setAttribute("msg", msg);
	    	response.sendRedirect("errores.jsp");
			e.printStackTrace();
		}catch (RemoteException e) {
			String msg = "ERROR: No se pudo acceder al servidor.";
			request.setAttribute("msg", msg);
	    	response.sendRedirect("errores.jsp");
			e.printStackTrace();
		}
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
