package vista.web.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.fachada.IfachadaLogica;
import vista.dataobjet.DataReservaTurno;
import vista.dataobjet.VoTurnosDisp;
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
    	
		String id = (String) session.getAttribute("usuario");
		String esp = (String) session.getAttribute("idEsp");
		int idEsp;
		if(esp==null){
			esp="";
			idEsp = 0;
	    }else{
	    	idEsp = Integer.parseInt(esp);
	    }
	    String idMed = (String) session.getAttribute("idMed");
		if(idMed==null){
			idMed="";
	    }
	    String timbre = (String) session.getAttribute("timbre");
	    VoTurnosDisp vo = (VoTurnosDisp) session.getAttribute("dataConsulta");
		if(vo==null){
			vo = new VoTurnosDisp(null, "", "", 0, 0);
	    }
	    System.out.println("id="+id);
	    System.out.println("esp="+esp);
	    System.out.println("idEsp="+idEsp);
	    System.out.println("idMed="+idMed);
	    System.out.println("timbre="+timbre);
	    System.out.println("conultorio="+vo.getIdConsultorio());
	    
	    if (id.trim()=="" || idEsp==0 || idMed.trim()=="" || timbre.trim()=="" || vo.getIdConsultorio()==0){
	    	String msg = "ERROR: Debe cargar todos los campos del formulario.";
	    	response.sendRedirect("reservaTurno.jsp?msg="+msg);
	    }else{
	    	try{
		    	int dia = 0;
		    	String diaSem = vo.getDia();
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
				String horario = vo.getHorario();
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
				DataReservaTurno dataResTurno = new DataReservaTurno(vo.getFecha(), dia, hora, id, vo.getIdConsultorio(), idMed, vo.getTurno());
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
