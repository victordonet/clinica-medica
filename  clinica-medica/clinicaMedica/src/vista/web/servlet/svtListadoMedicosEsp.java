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
import vista.dataobjet.VoMedEsp;

/**
 * Servlet implementation class svtAltaEspecialidad
 */
public class svtListadoMedicosEsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IfachadaLogica mod;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svtListadoMedicosEsp() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	ServletContext sc = getServletContext();
    	mod = (IfachadaLogica) sc.getAttribute("modeloProxy");
    	int idEsp = Integer.parseInt((String) request.getParameter("idEsp"));
    	Vector<VoMedEsp> listadoDataMed = new Vector<VoMedEsp>();
    	Vector<String> codigos = new Vector<String>();
    	codigos.add("0");
    	Vector<String> nombres = new Vector<String>();
    	nombres.add("Seleccione Médico");
	    try {
	    	listadoDataMed = mod.listarMedEsp(idEsp);
	    	for (int i = 0; i < listadoDataMed.size(); i++) {
	    		VoMedEsp med = listadoDataMed.get(i);
	    		codigos.add(med.getId());
	    		nombres.add(med.getNombre()+" "+med.getApellido());
	    	}
    		session.setAttribute("listIdMed", codigos);
    		session.setAttribute("listNomMed", nombres);
    		session.setAttribute("idEsp", idEsp+"");
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
