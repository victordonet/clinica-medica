<%@ page language="java" import="java.util.List" %>

<html>

<head>
<meta http-equiv="Content-Language" content="es">
<LINK REL="stylesheet" TYPE="text/css" HREF="estilos/estilos.css">
<script language="javascript" type="text/javascript" src="funciones/funciones.js"></script>
<title>Listado de Consultas</title>
</head>

<%
String nombre = (String) session.getValue("nombre");
List fechas = (List) session.getValue("listFechas");
List nombres = (List) session.getValue("listNombres");
List apellidos = (List) session.getValue("listApellidos");
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
					color="#FFFFFF">Bienvenido! <%=nombre%></font>
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
							<td width="27%" height="65" align="right"><a href="menuAfiliado.jsp"><img
									src="imagenes/botonMenu.jpg" alt="volver al men�" border="0">
							</a>
							</td>
							<td width="5%" height="65"></td>
							<td width="68%"><p>
									<font size="+3">Listado de Consultas</font>
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
							<td height="20" width="21%">Fecha</td>
						  <td height="20" width="37%">Nombre M&eacute;dico</td>
						  <td height="20" width="42%">Apellido M&eacute;dico</td>
					  </tr>
						<%for (int i = 0; i < fechas.size(); i++) {%>
						<tr bordercolor="#666666">
							<td height="20" width="21%"><%=fechas.get(i)%></td>
							<td height="20" width="37%"><%=nombres.get(i)%></td>
						  <td height="20" width="42%"><%=apellidos.get(i)%></td>
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
