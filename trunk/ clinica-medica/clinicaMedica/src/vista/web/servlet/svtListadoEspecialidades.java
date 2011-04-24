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

import logica.fachada.IfachadaLogica;
import vista.dataobjet.DataEsp;
import excepciones.PersistenciaException;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	ServletContext sc = getServletContext();
    	mod = (IfachadaLogica) sc.getAttribute("modeloProxy");
    	
    	Vector<DataEsp> listadoDataEsp = new Vector<DataEsp>();
    	Vector<Integer> codigos = new Vector<Integer>();
    	Vector<String> descripciones = new Vector<String>();
    	Vector<Double> montos = new Vector<Double>();
	    try {
			listadoDataEsp = mod.listarEspecialidades();
	    	for (int i = 0; i < listadoDataEsp.size(); i++) {
	    		DataEsp esp = listadoDataEsp.get(i);
	    		codigos.add(esp.getCodigo());
	    		descripciones.add(esp.getDescripcion());
	    		montos.add(esp.getMontoBase());
	    	}
    		session.setAttribute("listCodigos", codigos);
    		session.setAttribute("listDesc", descripciones);
    		session.setAttribute("listMontos", montos);
			response.sendRedirect("listarEspecialidades.jsp");
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
