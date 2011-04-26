<html>

<head>
<meta http-equiv="Content-Language" content="es">
<LINK REL="stylesheet" TYPE="text/css" HREF="estilos/estilos.css">
<title>Home</title>

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

<body class="Base" background="imagenes/inicio.jpg">

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
				<td width="8%" height="91">&nbsp;</td>
				<td width="81%" height="91">&nbsp;</td>
				<td width="11%" height="91">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td width="8%" height="146">&nbsp;</td>
				<td valign="top">
					<table width="100%">
						<tr height="100%">
							<td width="27%" height="146">&nbsp;</td>
							<td width="73%" height="146">
								<div>
									<p>Somos una Instituci&oacute;n de Servicios
										M&eacute;dicos, comprometidos en brindar el mejor servicio
										hacia la salud humana.</p>
									<p>Nuestra Instituci&oacute;n crece al comp&aacute;s de la
										satisfacci&oacute;n de sus afiliados, fortalecida por el
										servicio que ofrece y la caracteriza: una atención
										m&eacute;dica coordinada que demuestra gran rigor profesional
										y excelencia en la elecci&oacute;n de los centros
										asistenciales que cubren la internaci&oacute;n de los
										pacientes, además de la coordinaci&oacute;n asistencial
										entrela emergencia m&eacute;dica y el m&eacute;dico de
										cabecera.</p>
								</div></td>
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
