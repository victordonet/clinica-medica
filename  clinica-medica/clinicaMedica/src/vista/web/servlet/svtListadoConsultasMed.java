package vista.web.servlet;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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
    	String idMed = (String) session.getAttribute("usuario");
		//Fecha Desde
    	String fDesde = request.getParameter("fechaDesde");	
	    Calendar fechaD = Calendar.getInstance();
	    int ano = Integer.parseInt(fDesde.substring(6, 10));
	    int mes = Integer.parseInt(fDesde.substring(3, 5));
	    int dia = Integer.parseInt(fDesde.substring(0, 2));
	    fechaD.set(ano, mes-1, dia);
		//Fecha Hasta	    
	    String fHasta = request.getParameter("fechaHasta");
	    Calendar fechaH = Calendar.getInstance();
	    ano = Integer.parseInt(fHasta.substring(6, 10));
	    mes = Integer.parseInt(fHasta.substring(3, 5));
	    dia = Integer.parseInt(fHasta.substring(0, 2));
	    fechaH.set(ano, mes-1, dia);

	    if(fechaD.getTimeInMillis()>fechaH.getTimeInMillis()){
			String msg = "La Fecha Hasta no puede ser menor que la Fecha Desde.";
			request.setAttribute("msg", msg);
	    	response.sendRedirect("filtroFechas.jsp?msg="+msg);
		}else{
		    Vector<DataConsFecha> listado = new Vector<DataConsFecha>();
	    	Vector<String> fechas = new Vector<String>();
	    	Vector<String> afiliados = new Vector<String>();
	    	Vector<Integer> consultorios = new Vector<Integer>();
	    	Vector<Integer> turnos = new Vector<Integer>();
	    	
		    try {
				listado = mod.listarConsFechasMed(fechaD, fechaH, idMed);
				Calendar fecha = Calendar.getInstance();
		    	for (int i = 0; i < listado.size(); i++) {
		    		DataConsFecha cons = listado.get(i);
		    		fecha = cons.getFecha();	
		    		fechas.add(fecha.get(Calendar.DATE)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR));
		    		afiliados.add(cons.getNomAfi()+" "+cons.getApeAfil());
		    		consultorios.add(cons.getIdConsultorio());
		    		turnos.add(cons.getTurno());
		    	}
	    		session.setAttribute("listFechas", fechas);
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
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
