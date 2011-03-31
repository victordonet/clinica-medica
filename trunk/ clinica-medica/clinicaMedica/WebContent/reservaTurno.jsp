<html>

<head>
<meta http-equiv="Content-Language" content="es">
<script language="javascript" type="text/javascript" src="funciones.js"></script>
<title>Reserva de Turno</title>

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
<body class="Base" background="imagenes/fondoGrl.jpg">
<form name="form1" method="post" action="menuAfiliado.jsp">
<center>

<table align="center" width="99%">
<tr valign="Middle" height="100%">
    <td width="31%" height="28"><font color="#FFFFFF"><script>document.write(Dias[hoy.getDay()]+", "+hoy.getDate()+" de "+Meses[hoy.getMonth()+1]+" de "+hoy.getFullYear())</script></font></td>
    <td width="46%" height="39">&nbsp;</td>
    <td width="15%" height="28">&nbsp;</td>
    <td width="8%" height="28">&nbsp;</td>
</tr>
<tr valign="Middle" height="100%">
    <td width="31%" height="39" valign="bottom"><font color="#FFFFFF">Bienvenido! FULANITO DE TAL</font></td>
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
           	  <td width="82%" height="20"><input type="text" name="Afiliado" size="15" disabled></td>
          </tr>
        	<tr>
            	<td height="20">Especialidad</td>
            	<td height="20"><input type="text" name="Especialidad"></td>
            </tr>
        	<tr>
            	<td height="20">Médico</td>
            	<td height="20"><input type="text" name="Medico"></td>
            </tr>
        	<tr>
            	<td height="20" valign="top">Consulta</td>
            	<td height="20" valign="top">
                    <table width="100%" border="1" bordercolor="#666666" class="BaseTablas">
                        <tr bgcolor="#999999" align="center" bordercolor="#666666">
                            <td height="20">Campo1</td>
                            <td height="20">Campo2</td>
                            <td height="20">Campo3</td>
                            <td height="20">Campo4</td>
                        </tr>
                        <tr bordercolor="#666666">
                            <td height="69"></td>
                            <td height="69"></td>
                            <td height="69"></td>
                            <td height="69"></td>
                      </tr>
                    </table>
                </td>
            </tr>
        	<tr>
            	<td height="20">Nro. Turno</td>
            	<td height="20"><input type="text" name="Turno" size="5" disabled></td>
            </tr>
        	<tr>
            	<td height="20">Cobra Timbre?</td>
            	<td height="20"><input type="text" name="Timbre" size="5" disabled></td>
            </tr>
		</table>
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
