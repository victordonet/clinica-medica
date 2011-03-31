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

<LINK REL="stylesheet" TYPE="text/css" HREF="estilos.css">
<body class="Base" background="imagenes/menuAfiliado.jpg">

<center>

<table align="center" width="99%">
<tr valign="Middle" height="100%">
    <td width="43%" height="20"><font color="#FFFFFF"><script>document.write(Dias[hoy.getDay()]+", "+hoy.getDate()+" de "+Meses[hoy.getMonth()+1]+" de "+hoy.getFullYear())</script></font></td>
    <td width="46%" height="20">&nbsp;</td>
    <td width="11%" height="20">&nbsp;</td>
</tr>
<tr valign="Middle" height="100%">
    <td width="43%" height="45" valign="bottom"><font color="#FFFFFF">Bienvenido! FULANITO DE TAL</font></td>
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
    <td valign="top"><input type="button" name="Listado" value="Listado de Consultas" style="height:50px; width:200px" onclick="window.location='listadoConsultas.jsp'"></td>
    <td width="11%" height="53">&nbsp;</td>
</tr>
<tr height="100%">
  <td height="91">&nbsp;</td>
  <td><br><br><input type="button" name="Reservas" value="Reservar Turno" style="height:50px; width:200px" onclick="window.location='reservaTurno.jsp'"></td>
  <td height="91">&nbsp;</td>
</tr>
</table>

</center>
</body>
</html>
