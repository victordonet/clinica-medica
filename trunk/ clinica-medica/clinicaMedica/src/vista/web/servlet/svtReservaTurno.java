package vista.web.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.fachada.IfachadaLogica;
import vista.dataobjet.DataMed;
import vista.dataobjet.DataReservaTurno;
import excepciones.PersistenciaException;

/**
 * Servlet implementation class svtAltaEspecialidad
 */
public class svtReservaTurno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IfachadaLogica mod;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svtReservaTurno() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	ServletContext sc = getServletContext();
    	mod = (IfachadaLogica) sc.getAttribute("modeloProxy");
    	
		String id = request.getParameter("afiliado");
	    int indexEsp = Integer.parseInt(request.getParameter("especialidad"));
	    int indexMed = Integer.parseInt(request.getParameter("medico"));
	    String fecha = request.getParameter("fecha");
	    String diaSem = request.getParameter("dia");
	    String horario = request.getParameter("horario");
	    int consultorio = Integer.parseInt(request.getParameter("consultorio"));
	    int turno = Integer.parseInt(request.getParameter("turno"));
	    String timbre = request.getParameter("timbre");

	    if (id.trim()=="" || indexEsp==0 || indexMed==0 || fecha.isEmpty() || diaSem.trim()=="" || horario.trim()=="" || consultorio==0 || turno==0){
	    	String msg = "ERROR: Debe cargar todos los campos del formulario.";
	    	session.setAttribute("id", id);
	    	session.setAttribute("esp", indexEsp);
	    	session.setAttribute("medico", indexMed);
	    	session.setAttribute("timbre", timbre);
	    	response.sendRedirect("reservaTurno.jsp?msg="+msg);
	    }else{
	    	try{
	    		Vector<DataMed> vMed = mod.listarMedicos();
	    		String idMed = vMed.get(indexMed).getId();
	    		Date date = new Date(fecha);
	    		Calendar fechaRes = Calendar.getInstance();
	    		fechaRes.setTime(date);
		    	int dia = 0;
				if(diaSem.equals("Domingo")) {
					dia = 1;}
				if(diaSem.equals("Lunes")) {
					dia = 2;}
				if(diaSem.equals("Martes")) {
					dia = 3;}
				if(diaSem.equals("Miércoles")) {
					dia = 4;}
				if(diaSem.equals("Jueves")) {
					dia = 5;}
				if(diaSem.equals("Viernes")) {
					dia = 6;}
				if(diaSem.equals("Sábado")) {
					dia = 7;}
				int hora = 0;
				if(horario.equals("00 a 02")) {
					hora = 1;}
				if(horario.equals("02 a 04")) {
					hora = 2;}
				if(horario.equals("04 a 06")) {
					hora = 3;}
				if(horario.equals("06 a 08")) {
					hora = 4;}
				if(horario.equals("08 a 10")) {
					hora = 5;}
				if(horario.equals("10 a 12")) {
					hora = 6;}
				if(horario.equals("12 a 14")) {
					hora = 7;}
				if(horario.equals("14 a 16")) {
					hora = 8;}
				if(horario.equals("16 a 18")) {
					hora = 9;}
				if(horario.equals("18 a 20")) {
					hora = 10;}
				if(horario.equals("20 a 22")) {
					hora = 11;}
				if(horario.equals("22 a 24")) {
					hora = 12;}
				//String idMed = vMEsp.get(selecMed).getId();
				DataReservaTurno dataResTurno = new DataReservaTurno(fechaRes, dia, hora, id, consultorio, idMed, turno);
				mod.altaConsulta(dataResTurno);
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
