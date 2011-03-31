<html>

<head>
<meta http-equiv="Content-Language" content="es">
<LINK REL="stylesheet" TYPE="text/css" HREF="estilos.css">
<script language="javascript" type="text/javascript" src="funciones.js"></script>
<title>Menu</title>
</head>

<%
String nombre = (String) session.getValue("nombre");
if (nombre==null)
	nombre="";
%>

<body class="Base" background="imagenes/menu.jpg">

	<center>

		<table align="center" width="99%">
			<tr valign="Middle" height="100%">
				<td width="43%" height="20"><font color="#FFFFFF"><script>document.write(Dias[hoy.getDay()]+", "+hoy.getDate()+" de "+Meses[hoy.getMonth()+1]+" de "+hoy.getFullYear())</script>
				</font>
				</td>
				<td width="46%" height="20">&nbsp;</td>
				<td width="11%" height="20">&nbsp;</td>
			</tr>
			<tr valign="Middle" height="100%">
				<td width="43%" height="45" valign="bottom"><font
					color="#FFFFFF">Bienvenido!&nbsp;<%=nombre%></font>
				</td>
				<td width="46%" height="45">&nbsp;</td>
				<td width="11%" height="45" align="right" valign="bottom"><font
					color="#FFFFFF"><a href="login.jsp">cerrar sesi&oacute;n</a>
				</font>
				</td>
			</tr>
			<tr height="100%">
				<td width="43%" height="106">&nbsp;</td>
				<td width="46%" height="106">&nbsp;</td>
				<td width="11%" height="106">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td width="43%" height="53">&nbsp;</td>
				<td valign="top"><input type="button" name="Listado"
					value="Listado de Especialidades"
					style="height: 50px; width: 200px"
					onClick="window.location='listadoEspecialidades.jsp'">
				</td>
				<td width="11%" height="53">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td height="91">&nbsp;</td>
				<td><br>
				<br>
				<input type="button" name="Alta" value="Alta de Especialidad"
					style="height: 50px; width: 200px"
					onClick="window.location='altaEspecialidad.jsp'">
				</td>
				<td height="91">&nbsp;</td>
			</tr>
		</table>

	</center>
</body>
</html>
