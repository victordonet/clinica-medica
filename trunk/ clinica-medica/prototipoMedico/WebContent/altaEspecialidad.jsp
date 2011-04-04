<html>

<head>
<meta http-equiv="Content-Language" content="es">
<LINK REL="stylesheet" TYPE="text/css" HREF="estilos.css">
<script language="javascript" type="text/javascript" src="funciones.js"></script>
<title>Alta de Especialidad</title>
</head>

<SCRIPT language="javascript" type="text/javascript">
function validar(form) {
return f_numeros(form.id, "Identificación") && f_msg(form.descripcion, "Descripcion") && f_numeros(form.montoBase, "Monto Base");
}
</SCRIPT>

<%
String msg = (String) request.getParameter("msg");
if (msg==null)
	msg="";
String id = (String) session.getValue("id");
if (id==null)
	id="";
String desc = (String) session.getValue("desc");
if (desc==null)
	desc="";
String monto = (String) session.getValue("monto");
if (monto==null)
	monto="";
%>

<body class="Base" background="imagenes/fondoGrl.jpg" OnLoad="document.form.id.focus();">
<form name="form" method="get" onSubmit="return validar(document.form)" action="aplicarAlta.jsp">
<center>

<table align="center" width="99%">
	<tr valign="Middle" height="100%">
		<td width="31%" height="28"><font color="#FFFFFF"><script>document.write(Dias[hoy.getDay()]+", "+hoy.getDate()+" de "+Meses[hoy.getMonth()+1]+" de "+hoy.getFullYear())</script></font></td>
		<td width="46%" height="39">&nbsp;</td>
		<td width="15%" height="28">&nbsp;</td>
		<td width="8%" height="28">&nbsp;</td>
	</tr>
	<tr valign="Middle" height="100%">
		<td width="31%" height="46" valign="bottom"><font color="#FFFFFF">Bienvenido!</font></td>
		<td width="46%" height="46">&nbsp;</td>
		<td width="15%" height="46">&nbsp;</td>
		<td width="8%" height="46" align="right" valign="bottom"><font
			color="#FFFFFF"><a href="login.jsp">cerrar sesi&oacute;n</a></font></td>
	</tr>
	<tr height="100%">
		<td width="31%" height="87">
		<table width="101%" height="51" h>
			<tr>
				<td width="37%" height="65" align="right"><a href="menu.jsp"><img
					src="imagenes/botonMenu.jpg" alt="volver al menú" border="0"></a></td>
				<td width="5%" height="65"></td>
				<td width="58%">
				<p><font size="+3">Alta Especialidad</font></p>
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
				<td width="18%" height="20">Identificaci&oacute;n</td>
				<td width="82%" height="20"><input type="text" name="id"
					value="<%=id%>" size="15" maxlength="3"></td>
			</tr>
			<tr>
				<td height="20">Descripci&oacute;n</td>
				<td height="20"><input type="text" name="descripcion"
					value="<%=desc%>" size="50" maxlength="40"></td>
			</tr>
			<tr>
				<td height="20">Monto base</td>
				<td height="20"><input type="text" name="montoBase"
					value="<%=monto%>" size="20" maxlength="15"></td>
			</tr>
		</table>
		</td>
		<td>&nbsp;</td>
		<td width="8%" height="238">&nbsp;</td>
	</tr>
	<tr height="100%">
		<td height="36">&nbsp;</td>
		<td align="right"><input type="submit" name="Submit"
			value="Aceptar" style="height: 25px; width: 100px"></td>
		<td height="36">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr height="100%">
		<td height="36">&nbsp;</td>
		<td align="center"><font size="+1" color="#FF9900"><%=msg%></font></td>
		<td height="36">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</center>
</form>
</body>
</html>
