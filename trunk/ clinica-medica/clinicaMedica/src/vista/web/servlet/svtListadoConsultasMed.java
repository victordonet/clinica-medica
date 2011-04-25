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
import vista.dataobjet.DataConsFecha;
import excepciones.PersistenciaException;

/**
 * Servlet implementation class svtAltaEspecialidad
 */
public class svtListadoConsultasMed extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IfachadaLogica mod;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svtListadoConsultasMed() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	ServletContext sc = getServletContext();
    	mod = (IfachadaLogica) sc.getAttribute("modeloProxy");
    	
    	Vector<DataConsFecha> listado = new Vector<DataConsFecha>();
    	Vector<Calendar> fechas = new Vector<Calendar>();
    	Vector<String> medicos = new Vector<String>();
    	Vector<String> afiliados = new Vector<String>();
    	Vector<Integer> consultorios = new Vector<Integer>();
    	Vector<Integer> turnos = new Vector<Integer>();
    	Calendar fecha = Calendar.getInstance();
	    try {
			listado = mod.listarConsFecha(fecha);
	    	for (int i = 0; i < listado.size(); i++) {
	    		DataConsFecha cons = listado.get(i);
	    		fechas.add(cons.getFecha());
	    		medicos.add(cons.getNomMed()+" "+cons.getApeMed());
	    		afiliados.add(cons.getNomAfi()+" "+cons.getApeAfil());
	    		consultorios.add(cons.getIdConsultorio());
	    		turnos.add(cons.getTurno());
	    	}
    		session.setAttribute("listFechas", fechas);
    		session.setAttribute("listMedicos", medicos);
    		session.setAttribute("listAfiliados", afiliados);
    		session.setAttribute("listConsultorios", consultorios);
    		session.setAttribute("listTurnos", turnos);
			response.sendRedirect("listarConsultasMed.jsp");
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
