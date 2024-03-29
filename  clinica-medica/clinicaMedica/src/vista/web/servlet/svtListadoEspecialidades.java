package vista.web.servlet;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import excepciones.PersistenciaException;
import logica.fachada.IfachadaLogica;
import vista.dataobjet.DataEsp;

/**
 * Servlet implementation class svtAltaEspecialidad
 */
public class svtListadoEspecialidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IfachadaLogica mod;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svtListadoEspecialidades() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	ServletContext sc = getServletContext();
    	mod = (IfachadaLogica) sc.getAttribute("modeloProxy");
    	String id = (String) session.getAttribute("usuario");
    	
    	Vector<DataEsp> listadoDataEsp = new Vector<DataEsp>();
    	Vector<Integer> codigos = new Vector<Integer>();
    	Vector<String> descripciones = new Vector<String>();
	    try {
			listadoDataEsp = mod.listarEspecialidades();
	    	for (int i = 0; i < listadoDataEsp.size(); i++) {
	    		DataEsp esp = listadoDataEsp.get(i);
	    		codigos.add(esp.getCodigo());
	    		descripciones.add(esp.getDescripcion());
	    	}
	    	boolean tim = mod.cobraTimbre(id);
	    	if(tim){
	    		session.setAttribute("timbre", "S");
	    	}else{
	    		session.setAttribute("timbre", "N");
	    	}
    		session.setAttribute("listIdEsp", codigos);
    		session.setAttribute("listNomEsp", descripciones);
			response.sendRedirect("reservaTurno.jsp");
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
