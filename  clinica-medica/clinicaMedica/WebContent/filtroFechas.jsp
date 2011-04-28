<html>

<head>
<meta http-equiv="Content-Language" content="es">
<LINK REL="stylesheet" TYPE="text/css" HREF="estilos/datepickercontrol_mozilla.css">
<LINK REL="stylesheet" TYPE="text/css" HREF="estilos/estilos.css">
<script language="javascript" type="text/javascript" src="funciones/funciones.js"></script>
<script language="javascript" type="text/javascript" src="funciones/datepickercontrol.js"></script>
<title>Alta de Especialidad</title>
</head>

<SCRIPT language="javascript" type="text/javascript">
	DatePickerControl.onSelect = function(inputid)
	{
		 input = document.getElementById(inputid);
	}

	function validar(form) {
		return f_msg(form.DPC_calendar1, "Fecha Desde") && f_msg(form.DPC_calendar2, "Fecha Hasta");
	}
</SCRIPT>

<%
String nombre = (String) session.getValue("nombre");

String msg = (String) request.getParameter("msg");
if (msg==null)
	msg="";
%>

<body class="Base" background="imagenes/fondoGrl.jpg" OnLoad="document.form.DPC_calendar1.focus();">
<form name="form" method="get" onSubmit="return validar(document.form)" action="listadoConsultasMed.jsp">
    <input type="hidden" id="DPC_TODAY_TEXT" value="Hoy">
    <input type="hidden" id="DPC_BUTTON_TITLE" value="Abrir calendario...">
    <input type="hidden" id="DPC_MONTH_NAMES" value="['Enero', 'Febrero', 'Marso', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Setiembre', 'Octubre', 'Noviembre', 'Diciembre']">
    <input type="hidden" id="DPC_DAY_NAMES" value="['Dom', 'Lun', 'Mar', 'Mier', 'Jue', 'Vie', 'Sab']">
    <input type="hidden" id="DPC_BUTTON_POSITION" value="out">
    <input type="hidden" id="DPC_WEEK_NUMBER" value="true">
<center>

<table align="center" width="99%">
	<tr valign="Middle" height="100%">
		<td width="31%" height="28"><font color="#FFFFFF"><script>document.write(Dias[hoy.getDay()]+", "+hoy.getDate()+" de "+Meses[hoy.getMonth()+1]+" de "+hoy.getFullYear())</script></font></td>
		<td width="46%" height="39">&nbsp;</td>
		<td width="15%" height="28">&nbsp;</td>
		<td width="8%" height="28">&nbsp;</td>
	</tr>
	<tr valign="Middle" height="100%">
		<td width="31%" height="46" valign="bottom"><font color="#FFFFFF">Bienvenido! <%=nombre%></font></td>
		<td width="46%" height="46">&nbsp;</td>
		<td width="15%" height="46">&nbsp;</td>
		<td width="8%" height="46" align="right" valign="bottom"><a href="cerrar.jsp"><font color="#FFFFFF">cerrar sesi&oacute;n</font></a></td>
	</tr>
	<tr height="100%">
		<td width="31%" height="87">
		<table width="101%" height="51" h>
			<tr>
				<td width="37%" height="65" align="right"><a href="menuMedico.jsp"><img
					src="imagenes/botonMenu.jpg" alt="volver al menú" border="0"></a></td>
				<td width="5%" height="65"></td>
				<td width="58%">
				<p><font size="+3">Filtro de fechas</font></p>
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
		<br><br>
		<table width="100%">
			<tr>
				<td width="18%" height="20">Fecha Desde</td>
				<td width="82%" height="20"><input type="text" id="DPC_calendar1" name="fechaDesde" size="8" maxlength="10" class="dateDefault">&nbsp;</td>
			</tr>
			<tr>
				<td height="20">Fecha Hasta</td>
				<td height="20"><input type="text" id="DPC_calendar2" name="fechaHasta" size="8" maxlength="10" class="dateDefault">&nbsp;</td>
			</tr>
		</table>
		<br>
		<font size="+1" color="#FF9900"><%=msg%></font>
		</td>
		<td></td>
		<td width="8%" height="238">&nbsp;</td>
	</tr>
	<tr height="100%">
		<td height="36">&nbsp;</td>
		<td align="center"><input type="submit" name="Submit"
			value="Aceptar" style="height: 25px; width: 100px"></td>
		<td height="36">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</center>
</form>
</body>
</html>
