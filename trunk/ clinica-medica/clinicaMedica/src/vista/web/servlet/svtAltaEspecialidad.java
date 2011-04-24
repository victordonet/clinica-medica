package vista.web.servlet;

import java.io.IOException;

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
public class svtAltaEspecialidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IfachadaLogica mod;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svtAltaEspecialidad() {
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
    	
		String identificacion = request.getParameter("id");
	    String descripcion = request.getParameter("descripcion");
	    String montoBase = request.getParameter("montoBase");

	    if (identificacion.trim()=="" || descripcion.trim()=="" || montoBase.trim()==""){
	    	String msg = "ERROR: Debe cargar todos los campos del formulario.";
	    	session.setAttribute("id", identificacion);
	    	session.setAttribute("desc", descripcion);
	    	session.setAttribute("monto", montoBase);
	    	response.sendRedirect("altaEspecialidad.jsp?msg="+msg);
	    }else{
			int id = Integer.parseInt(identificacion);
			String desc = descripcion;
		    double monto = Double.parseDouble(montoBase);
		    DataEsp datEsp = new DataEsp(id, desc, monto);
		    try {
				mod.altaEspecialidad(datEsp);
			} catch (PersistenciaException e) {
				String msg = "ERROR: No se pudo acceder a la información almacenada.";
		    	response.sendRedirect("errores.jsp?msg"+msg);
				e.printStackTrace();
			}
			
			response.sendRedirect("menu.jsp");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
