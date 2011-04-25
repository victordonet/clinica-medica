<html>

<head>
<meta http-equiv="Content-Language" content="es">
<script language="javascript" type="text/javascript" src="funciones.js"></script>
<title>Menu</title>

<SCRIPT LANGUAGE="Javascript">
 function Permut (flag,img) {
    if (document.images) {
         if (document.images[img].permloaded) {
             if (flag==1) document.images[img].src = document.images[img].perm.src
             else document.images[img].src = document.images[img].perm.oldsrc
         }
    }
 }
 function preloadPermut (img,adresse) {
    if (document.images) {
         img.onload = null;
         img.perm = new Image ();
         img.perm.oldsrc = img.src;
         img.perm.src = adresse;
         img.permloaded = true;
    }
 }
</SCRIPT>

</head>

<%
String nombre = (String) session.getValue("nombre");
%>

<LINK REL="stylesheet" TYPE="text/css" HREF="estilos.css">
<body class="Base" background="imagenes/menuMedico.jpg">
<form name="form1" method="post" action="listadoConsultas.jsp">
<center>

<table align="center" width="99%">
<tr valign="Middle" height="100%">
    <td width="43%" height="22"><font color="#FFFFFF"><script>document.write(Dias[hoy.getDay()]+", "+hoy.getDate()+" de "+Meses[hoy.getMonth()+1]+" de "+hoy.getFullYear())</script></font></td>
    <td width="46%" height="22">&nbsp;</td>
    <td width="11%" height="22">&nbsp;</td>
</tr>
<tr valign="Middle" height="100%">
    <td width="43%" height="45" valign="bottom"><font color="#FFFFFF">Bienvenido! <%=nombre%></font></td>
    <td width="46%" height="45">&nbsp;</td>
    <td width="11%" height="45" align="right" valign="bottom"><font color="#FFFFFF">cerrar sesi&oacute;n</font></td>
</tr>
<tr height="100%">
    <td width="43%" height="106">&nbsp;</td>
    <td width="46%" height="106">&nbsp;</td>
    <td width="11%" height="106">&nbsp;</td>
</tr>
<tr height="100%">
    <td width="43%" height="53">&nbsp;</td>
    <td valign="top"><input type="button" name="Listado" value="Listado de Consultas" style="height:50px; width:200px" onClick="window.location='listadoConsultasMed.jsp'"></td>
    <td width="11%" height="53">&nbsp;</td>
</tr>
<tr height="100%">
  <td height="91">&nbsp;</td>
  <td>&nbsp;</td>
  <td height="91">&nbsp;</td>
</tr>
</table>

</center>
</form>
</body>
</html>
