<%@ page language="java" import="java.util.List" %>

<html>

<head>
<meta http-equiv="Content-Language" content="es">
<LINK REL="stylesheet" TYPE="text/css" HREF="estilos.css">
<script language="javascript" type="text/javascript" src="funciones.js"></script>
<title>Listado de Especialidades</title>
</head>

<%
List codigos = (List) session.getValue("listCodigos");
List descripciones = (List) session.getValue("listDesc");
List montos = (List) session.getValue("listMontos");
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
				<td width="36%" height="39" valign="bottom"><font
					color="#FFFFFF">Bienvenido!</font>
				</td>
				<td width="47%" height="39">&nbsp;</td>
				<td width="9%" height="39">&nbsp;</td>
				<td width="8%" height="39" align="right" valign="bottom"><font
					color="#FFFFFF"><a href="login.jsp">cerrar sesi&oacute;n</a>
				</font>
				</td>
			</tr>
			<tr height="100%">
				<td width="36%" height="87">
					<table width="109%" height="51" h>
						<tr>
							<td width="27%" height="65" align="right"><a href="menu.jsp"><img
									src="imagenes/botonMenu.jpg" alt="volver al men�" border="0">
							</a>
							</td>
							<td width="5%" height="65"></td>
							<td width="68%"><p>
									<font size="+3">Listado de Especialidades</font>
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
				<td width="36%" height="330">&nbsp;</td>
				<td width="47%" height="330" valign="top">
					<table width="100%" border="1" bordercolor="#666666"
						class="BaseTablas">
						<tr bgcolor="#999999" align="center" bordercolor="#666666">
							<td height="20" width="15%">Identificaci&oacute;n</td>
							<td height="20" width="65%">Descripci&oacute;n</td>
							<td height="20" width="20%">Monto base</td>
						</tr>
						<%for (int i = 0; i < codigos.size(); i++) {%>
						<tr bordercolor="#666666">
							<td height="20" width="15%"><%=codigos.get(i)%></td>
							<td height="20" width="65%"><%=descripciones.get(i)%></td>
							<td height="20" width="20%"><%=montos.get(i)%></td>
						</tr>
						<%}%>
					</table></td>
				<td>&nbsp;</td>
				<td width="8%" height="330">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td height="36">&nbsp;</td>
				<td>&nbsp;</td>
				<td height="36">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>

	</center>
</body>
</html>
