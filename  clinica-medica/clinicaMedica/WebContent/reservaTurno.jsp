<%@page import="java.util.Calendar"%>
<%@page import="vista.dataobjet.VoTurnosDisp"%>
<%@ page language="java" import="java.util.List" %>
<%@ page language="java" import="java.util.Vector" %>

<html>

<head>
<meta http-equiv="Content-Language" content="es">
<LINK REL="stylesheet" TYPE="text/css" HREF="estilos/estilos.css">
<script language="javascript" type="text/javascript" src="funciones/funciones.js"></script>
<title>Reserva de Turno</title>
</head>

<%
String usu = (String) session.getAttribute("usuario");
String nombre = (String) session.getAttribute("nombre");
String esp = (String) session.getAttribute("idEsp");
int idEsp;
if(esp==null){
	esp="0";
	idEsp = 0;
}else{
	idEsp = Integer.parseInt(esp);
}
String idMed = (String) session.getAttribute("idMed");
if(idMed==null){
	idMed="0";
}
String timbre = (String) session.getAttribute("timbre");
List listIdEsp = (List) session.getValue("listIdEsp");
List listNomEsp = (List) session.getValue("listNomEsp");
List listIdMed = (List) session.getValue("listIdMed");
List listNomMed = (List) session.getValue("listNomMed");
Vector<VoTurnosDisp> consultasDisp = (Vector) session.getValue("listConsultas");
String msg = (String) request.getParameter("msg");
if (msg==null)
	msg="";
%>

<script>
function validar(form) {
	return f_numeros(form.afiliado, "Nro.afiliado") && f_numeros(form.idEsp, "Especialidad") && f_numeros(form.idMed, "Medico") && f_msg(form.idCons, "Consulta") && f_msg(form.timbre, "Timbre");
}

function cargoIdEsp(valor) {
	window.location='listarMedEsp.jsp?idEsp='+valor;
}

function cargoIdMed(valor) {
	window.location='listarConsultasDisp.jsp?idMed='+valor;
}

</script>

<LINK REL="stylesheet" TYPE="text/css" HREF="estilos.css">
<body class="Base" background="imagenes/fondoReserva.jpg">
<form name="form" method="get" action="aplicarReserva.jsp">
<center>

<table align="center" width="99%">
<tr valign="Middle" height="100%">
    <td width="31%" height="28"><font color="#FFFFFF"><script>document.write(Dias[hoy.getDay()]+", "+hoy.getDate()+" de "+Meses[hoy.getMonth()+1]+" de "+hoy.getFullYear())</script></font></td>
    <td width="46%" height="39">&nbsp;</td>
    <td width="15%" height="28">&nbsp;</td>
    <td width="8%" height="28">&nbsp;</td>
</tr>
<tr valign="Middle" height="100%">
    <td width="31%" height="39" valign="bottom"><font color="#FFFFFF">Bienvenido! <%=nombre%></font></td>
    <td width="46%" height="39">&nbsp;</td>
    <td width="15%" height="39">&nbsp;</td>
    <td width="8%" height="39" align="right" valign="bottom"><a href="cerrar.jsp"><font color="#FFFFFF">cerrar sesi&oacute;n</font></a></td>
</tr>
<tr height="100%">
    <td width="31%" height="87">
    <table width="101%" height="51">
        <tr>
            <td width="37%" height="65" align="right"><a href="menuAfiliado.jsp"><img src="imagenes/botonMenu.jpg" alt="volver al men�" border="0" onclick="<%session.setAttribute("dataConsulta", null);%>"></a></td>
            <td width="5%" height="65"></td>
            <td width="58%"><p><font size="+3">Reserva de Turno</font></p>
            </td>
        </tr>
    </table>
    </td>
    <td width="46%" height="87">&nbsp;</td>
    <td width="15%" height="87">&nbsp;</td>
    <td width="8%" height="87">&nbsp;</td>
</tr>
<tr height="100%">
    <td width="31%" height="26">&nbsp;</td>
    <td width="46%" height="26">&nbsp;</td>
    <td width="15%" height="26">&nbsp;</td>
    <td width="8%" height="26">&nbsp;</td>
</tr>
<tr height="100%">
    <td width="31%" height="238">&nbsp;</td>
    <td width="46%" height="238" valign="top">
<table width="100%">
        	<tr>
            	<td width="18%" height="20">Nro.Afiliado</td>
           	  <td width="82%" height="20"><input type="text" name="afiliado" size="15" value="<%=usu%>" disabled></td>
          </tr>
        	<tr>
            	<td height="20">Especialidad</td>
            	<td height="20">
                    <select name="especialidad" onChange="cargoIdEsp(this.value)">
                    <%for (int i = 0; i < listIdEsp.size(); i++) {
                    	int idLista = (Integer) listIdEsp.get(i); 
                    	if (idLista==idEsp){
                    	%>
                        	<option value="<%=idLista%>" selected><%=listNomEsp.get(i)%></option>
                    <%}else{%>    	
                        	<option value="<%=idLista%>"><%=listNomEsp.get(i)%></option>
                    	<%}
                    }%>
                    </select>
                    <input type="hidden" name="idEsp" value="<%=idEsp%>">
                </td>
            </tr>
        	<tr>
            	<td height="20">M�dico</td>
            	<td height="20">
                    <select name="medico" onChange="cargoIdMed(this.value)">
						<% if (listIdMed!=null){
							for (int i = 0; i < listIdMed.size(); i++) {
	                    	String idLista = (String) listIdMed.get(i).toString(); 
	                    	if (idLista.equals(idMed)==true){%>
                            <option value="<%=idLista%>" selected><%=listNomMed.get(i)%></option>
                    	<%}else{%>    	
                        	<option value="<%=idLista%>"><%=listNomMed.get(i)%></option>
                        <%}
						}
					}%>
                    </select>
                    <input type="hidden" name="idMed" value="<%=idMed%>">
                </td>
            </tr>
        	<tr>
            	<td height="20" valign="top">Consulta</td>
            	<td height="20" valign="top">
                    <table width="100%" border="1" bordercolor="#666666" class="BaseTablas">
                        <tr bgcolor="#999999" align="center" bordercolor="#666666">
                          <td width="21%">Seleccion</td>
                          <td width="21%">Fecha</td>
                          <td width="22%">Dia</td>
                          <td width="24%">Horario</td>
                          <td width="22%">Consultorio</td>
                          <td width="11%">Turno</td>
                      </tr>
                      <%if (consultasDisp!=null){
                      for (int i = 0; i < consultasDisp.size(); i++) { 
                    	  VoTurnosDisp vo = consultasDisp.get(i);%>
                       <tr onClick="cargaConsulta()">
                       		<td width="22%"><input type="radio" name="radio" value="<%=i%>" checked></td>
                            <td width="21%"><%=vo.getFecha().get(Calendar.DATE)+"/"+(vo.getFecha().get(Calendar.MONTH)+1)+"/"+vo.getFecha().get(Calendar.YEAR)%></td>
                          	<td width="22%"><%=vo.getDia()%></td>
                            <td width="24%"><%=vo.getHorario()%></td>
                            <td width="22%"><%=vo.getIdConsultorio()%></td>
                            <td width="11%"><%=vo.getTurno()%></td>
                      </tr>
                      <%}}%>
                    </table>
				</td>
            </tr>
        	<tr>
            	<td height="20">Cobra Timbre?</td>
           	  <td height="20"><input type="text" name="timbre" size="1" value="<%=timbre%>" disabled>
            </td>
            </tr>
		</table>
    </td>
    <td>&nbsp;</td>
    <td width="8%" height="238">&nbsp;</td>
</tr>
<tr height="100%">
  <td height="36">&nbsp;</td>
  <td align="center"><font size="+1" color="#FF9900"><%=msg%></font></td>
  <td height="36">&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr height="100%">
  <td height="36">&nbsp;</td>
  <td align="right"><input type="submit" name="Submit" value="Agendar" style="height:25px; width:100px"></td>
  <td height="36">&nbsp;</td>
  <td>&nbsp;</td>
</tr>
</table>

</center>
</form>
</body>
</html>
