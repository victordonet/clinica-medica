package vista.web.servlet;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import excepciones.PersistenciaException;
import logica.fachada.IfachadaLogica;

/**
 * Servlet implementation class svtLogin
 */
public class svtIngreso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IfachadaLogica mod = null;

    /**
     * Default constructor. 
     */
 	public void init(){
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	ServletContext sc = getServletContext();
    	
    	int control = (Integer) sc.getAttribute("control");
	    if(control==0){
	    	String msg = "ERROR: No se encontro el servidor.";
	    	response.sendRedirect("errores.jsp?msg"+msg);
	    }else{	    
	    	mod = (IfachadaLogica) sc.getAttribute("modeloProxy");
	    	String usu = request.getParameter("usuario");
	    	String pass = request.getParameter("passEncript");
		    boolean usuOk = false;
		    
		    if (usu.trim()=="" || pass.trim()==""){
		    	String msg = "ERROR: Debe cargar todos los campos del formulario.";
		    	session.setAttribute("usu", usu);
		    	response.sendRedirect("login.jsp?msg="+msg);
		    }else {
				try {
					usuOk = mod.validarUsuario(usu, pass);
					if(usuOk){
				    	session.setAttribute("nombre", usu);
				    	response.sendRedirect("menu.jsp");	
					} else {
				    	String msg = "ERROR: Usuario o Contraseña invalido.";
				    	session.setAttribute("usu", usu);
				    	response.sendRedirect("login.jsp?msg="+msg);
					}
				} catch (PersistenciaException e) {
					String msg = "ERROR: No se pudo acceder a la información almacenada.";
			    	response.sendRedirect("errores.jsp?msg"+msg);
					e.printStackTrace();
				} catch (RemoteException e) {
					String msg = "ERROR: No se pudo acceder al servidor.";
			    	response.sendRedirect("errores.jsp?msg"+msg);
					e.printStackTrace();
				}
		    }
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
