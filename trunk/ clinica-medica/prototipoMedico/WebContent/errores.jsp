<html>

<head>
<meta http-equiv="Content-Language" content="es">
<LINK REL="stylesheet" TYPE="text/css" HREF="estilos.css">
<script language="javascript" type="text/javascript" src="funciones.js"></script>
<title>Error</title>
</head>

<%
String msg = (String) request.getParameter("msg");
if (msg==null)
	msg="";
%>

<body class="Base" background="imagenes/fondoGrl.jpg">

	<center>

		<table align="center" width="99%">
			<tr valign="Middle" height="100%">
				<td width="36%" height="28"><font color="#FFFFFF"><script>document.write(Dias[hoy.getDay()]+", "+hoy.getDate()+" de "+Meses[hoy.getMonth()+1]+" de "+hoy.getFullYear())</script>
				</font>
				</td>
				<td width="47%" height="39">&nbsp;</td>
				<td width="9%" height="28">&nbsp;</td>
				<td width="8%" height="28">&nbsp;</td>
			</tr>
			<tr valign="Middle" height="100%">
				<td width="36%" height="39">&nbsp;</td>
				<td width="47%" height="39">&nbsp;</td>
				<td width="9%" height="39">&nbsp;</td>
				<td width="8%" height="39">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td width="36%" height="87">
					<table width="109%" height="51" h>
						<tr>
							<td width="27%" height="65">&nbsp;</td>
							<td width="5%" height="65">&nbsp;</td>
							<td width="68%"><p>
									<font size="+3">ERROR FATAL</font>
								</p></td>
						</tr>
					</table></td>
				<td width="47%" height="87">&nbsp;</td>
				<td width="9%" height="87">&nbsp;</td>
				<td width="8%" height="87">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td width="36%" height="26">&nbsp;</td>
				<td width="47%" height="26">&nbsp;</td>
				<td width="9%" height="26">&nbsp;</td>
				<td width="8%" height="26">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td width="10%" height="330">&nbsp;</td>
				<td width="10%" height="330" align="center"><font size="+1" color="#FF9900"><%=msg%></font></td>
				<td></td>
				<td width="80%" height="330">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td height="36">&nbsp;</td>
				<td>&nbsp;</td>
				<td height="36">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr height="100%">
				<td height="36">&nbsp;</td>
				<td align="center"><input type="button" name="salir" value="Salir" style="height: 25px; width: 100px" onClick="window.location='login.jsp'"></td>
				<td height="36">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</center>
</body>
</html>
