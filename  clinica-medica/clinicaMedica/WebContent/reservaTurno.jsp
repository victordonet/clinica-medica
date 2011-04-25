<%@ page language="java" import="java.util.List" %>

<html>

<head>
<meta http-equiv="Content-Language" content="es">
<script language="javascript" type="text/javascript" src="funciones.js"></script>
<title>Reserva de Turno</title>

</head>

<%
String usu = (String) session.getValue("usu");
String nombre = (String) session.getValue("nombre");
String timbre = (String) session.getValue("timbre");
List listIdEsp = (List) session.getValue("listIdEsp");
List listNomEsp = (List) session.getValue("listNomEsp");
List listIdMed = (List) session.getValue("listMed");
List listNomMed = (List) session.getValue("listNomMed");
List consultasDisp = (List) session.getValue("listConsultas");
%>

<script>  
function cargoIdEsp(especialidad) {
	document.getElementById("idEsp").value=especialidad;
}
function cargoIdMed(medico) {
	document.getElementById("idMed").value=medico;
}
function cargaConsulta(i) {
	document.getElementById("fecha").value=<%=fechas.get(i)%>;
	document.getElementById("dia").value=<%=dias.get(i)%>;
	document.getElementById("horario").value=<%=horarios.get(i)%>;
	document.getElementById("consultorio").value=<%=consultorios.get(i)%>;
	document.getElementById("turno").value=<%=turnos.get(i)%>;
}
</script>

<LINK REL="stylesheet" TYPE="text/css" HREF="estilos.css">
<body class="Base" background="imagenes/fondoGrl.jpg">
<form name="form1" method="post" action="aplicarReserva.jsp">
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
    <td width="8%" height="39" align="right" valign="bottom"><font color="#FFFFFF">cerrar sesi&oacute;n</font></td>
</tr>
<tr height="100%">
    <td width="31%" height="87">
    <table width="101%" height="51" h>
        <tr>
            <td width="37%" height="65" align="right"><a href="menuAfiliado.jsp"><img src="imagenes/botonMenu.JPG" alt="volver al menú" border="0"></a></td>
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
                    <select name="especialidad" onChange="listarMed.jsp">
                    <%for (int i = 0; i < listIdEsp.size(); i++) {%>
                        <option value="<%=listIdEsp.get(i)%>" onClick="cargoIdEsp(this.value)"><%=listNomEsp.get(i)%></option>
                    <%}%>
                    </select>
                    <!--input type="hidden" name="idEsp"-->
                    <input type="text" name="idEsp" disabled>
                </td>
            </tr>
        	<tr>
            	<td height="20">Médico</td>
            	<td height="20">
                    <select name="medico" onFocus="" onChange="listarConsultas.jsp">
						<%for (int i = 0; i < listIdMed.size(); i++) {%>
                            <option value="<%=listIdMed.get(i)%>" onClick="cargoIdMed(this.value)"><%=listNomMed.get(i)%></option>
                        <%}%>
                    </select>
                    <!--input type="hidden" name="idMed"-->
                    <input type="text" name="idMed" disabled>
                </td>
            </tr>
        	<tr>
            	<td height="20" valign="top">Consulta</td>
            	<td height="20" valign="top">
                    <table width="100%" border="1" bordercolor="#666666" class="BaseTablas">
                        <tr bgcolor="#999999" align="center" bordercolor="#666666">
                          <td width="21%">Fecha</td>
                          <td width="22%">Dia</td>
                          <td width="24%">Horario</td>
                          <td width="22%">Consultorio</td>
                          <td width="11%">Turno</td>
                      </tr>
                      <%for (int i = 0; i < consultasDisp.size(); i++) {%>
                       <tr bordercolor="#666666" onClick="cargaConsulta(<%=i%>)">
                            <td width="21%"><%=fechas.get(i)%></td>
                          	<td width="22%"><%=dias.get(i)%></td>
                            <td width="24%"><%=horarios.get(i)%></td>
                            <td width="22%"><%=consultorios.get(i)%></td>
                            <td width="11%"><%=turnos.get(i)%></td>
                      </tr>
                      <%}%>
                    </table>
				</td>
            </tr>
        	<tr>
            	<td height="20">Cobra Timbre?</td>
           	  <td height="20"><input type="text" name="turno" size="5" value="<%=timbre%>" disabled>
            </td>
            </tr>
		</table>
        <input type="text" name="fecha" disabled>
        <input type="text" name="dia" disabled>
        <input type="text" name="horario" disabled>
        <input type="text" name="consultorio" disabled>
        <input type="text" name="turno" disabled>
    </td>
    <td>&nbsp;</td>
    <td width="8%" height="238">&nbsp;</td>
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
