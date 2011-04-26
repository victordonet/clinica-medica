<html>

<head>
<meta http-equiv="Content-Language" content="es">
<LINK REL="stylesheet" TYPE="text/css" HREF="estilos/estilos.css">
<title>Atenci&oacute;n al Socio</title>

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

<body class="Base" background="imagenes/atencionSocio.jpg">

	<center>

		<table align="center" width="100%">
			<tr valign="Middle" height="100%">
				<td width="8%" height="86">&nbsp;</td>
				<td width="81%" height="86">&nbsp;</td>
				<td width="11%" height="86">&nbsp;</td>
			</tr>
				<tr valign="Middle" height="100%">
					<td width="8%" height="47" align="right"></td>
					<td width="81%" height="47"><a href="index.jsp" target="_self"
						onMouseover="Permut(1,'IMG1');" onMouseout="Permut(0,'IMG1');">
						<img src="imagenes/QuienesSomos_1.jpg" border=0 name="IMG1"
							onload="preloadPermut(this,'imagenes/QuienesSomos_2.jpg');"
							alt="ir a Quienes Somos?"></a><a href="nuestraInst.jsp" target="_self"
						onMouseover="Permut(1,'IMG2');" onMouseout="Permut(0,'IMG2');"><IMG
							SRC="imagenes/NuestraInstitucion_1.jpg" border=0 NAME="IMG2"
							onLoad="preloadPermut(this,'imagenes/NuestraInstitucion_2.jpg');"
							alt="ir a Nuestra Institucion"></a><a href="policlinicos.jsp" target="_self"
						onMouseover="Permut(1,'IMG3');" onMouseout="Permut(0,'IMG3');"><IMG
							SRC="imagenes/Policlinicos_1.jpg" border=0 NAME="IMG3"
							onLoad="preloadPermut(this,'imagenes/Policlinicos_2.jpg');"
							alt="ir a Policlinicos"></a><a href="atencion.jsp" target="_self"
						onMouseover="Permut(1,'IMG4');" onMouseout="Permut(0,'IMG4');"><IMG
							SRC="imagenes/AtencionSocio_1.jpg" border=0 NAME="IMG4"
							onLoad="preloadPermut(this,'imagenes/AtencionSocio_2.jpg');"
							alt="ir a Atencion al Cliente"></a><a href="login.jsp" target="_self" onMouseover="Permut(1,'IMG5');"
						onMouseout="Permut(0,'IMG5');"><IMG SRC="imagenes/Login_1.jpg"
							border=0 NAME="IMG5" onLoad="preloadPermut(this,'imagenes/Login_2.jpg');"
							alt="ingresar al sistema"></a>
					</td>
				<td width="11%" height="40">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td width="8%" height="127">&nbsp;</td>
				<td width="81%" height="127">&nbsp;</td>
				<td width="11%" height="127">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td width="8%" height="146">&nbsp;</td>
				<td valign="top">
					<table width="100%">
						<tr height="100%">
							<td width="37%" height="146">&nbsp;</td>
							<td width="63%" height="146">
								<table>
									<tr>
										<td><img src="imagenes/tel.jpg" alt="tel&eacute;fono">
										</td>
										<td>de 9:00 a 18:00<br> +5982 915 0103 / 0208</td>
									</tr>
									<tr>
										<td><img src="imagenes/mail.jpg" alt="e-mail">
										</td>
										<td><a href="mailto:info@mvdinterviene.com.uy">info@medical.com.uy</a>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
				<td width="11%" height="146">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td height="146">&nbsp;</td>
				<td valign="top">&nbsp;</td>
				<td height="146">&nbsp;</td>
			</tr>
		</table>

	</center>
</body>
</html>
