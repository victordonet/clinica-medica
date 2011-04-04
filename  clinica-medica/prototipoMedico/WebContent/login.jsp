<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>

<head>
<meta http-equiv="Content-Language" content="es">
<LINK REL="stylesheet" TYPE="text/css" HREF="estilos.css">
<script language="javascript" type="text/javascript" src="funciones.js"></script>
<title>Ingreso al sistema</title>
</head>

    <SCRIPT>
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
    
    <SCRIPT language="javascript" type="text/javascript">
    function validar(form) {
    	return f_msg(form.usuario, "Usuario") && f_msg(form.pass, "Contraseña");
    }
    </SCRIPT>
    
    <%
    String usu = (String) session.getValue("usu");
    if (usu==null)
        usu="";
    
    String msg = (String) request.getParameter("msg");
    if (msg==null)
        msg="";
    %>

<body class="Base" background="imagenes/login.jpg" OnLoad="document.form.usuario.focus();">
	
	<form name="form" method="get" action="ingreso.jsp" onSubmit="return validar(document.form)">
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
					<td width="8%" height="89">&nbsp;</td>
					<td width="81%" height="89">&nbsp;</td>
					<td width="11%" height="89">&nbsp;</td>
				</tr>
				<tr height="100%">
					<td width="8%" height="146">&nbsp;</td>
					<td valign="top">
						<table width="100%">
							<tr height="100%">
								<td width="27%" height="146">&nbsp;</td>
								<td width="73%" height="146">
									<table width="53%">
										<tr>
											<td width="190" height="24" align="right">Usuario:</td>
											<td width="174" align="right"><input type="text"
												name="usuario" value="<%=usu%>"  maxlength="30">
											</td>
											<td width="25">&nbsp;</td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td width="190" height="24" align="right">Contraseña:</td>
											<td width="174" align="right"><input type="password"
												name="pass"  maxlength="15"
												onKeyUp="this.form.passEncript.value = MD5(this.form.pass.value)">
											</td>
											<td width="25" align="left"><input type="submit"
												name="Submit" value=" > ">
											</td>
										</tr>
									</table>
									<table width="100%">
										<tr>
											<td width="190" height="24" align="right"></td>
											<td width="27">&nbsp;</td>
											<td><font size="+1" color="#FF9900"><%=msg%></font></td>
										</tr>
										<tr>
											<td width="190" height="24" align="right">&nbsp;</td>
											<td width="27">&nbsp;</td>
											<td><input type="hidden" name="passEncript" value=""
												size="55" />
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
	</form>
</body>
</html>
