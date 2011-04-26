<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link rel="stylesheet" type="text/css" href="demo.css">
        <Script language="JavaScript" type="text/javascript" src="teclado.js"></Script>
        <script>
        function Cargo(valor)
		{
			document.form1.Campo1.value=valor;
		}
		</script>
    </head>
<%
String usuario= (String)request.getParameter("Usuario");
%>
    <body onLoad="marcador('contenedor','campo_clave','S');" bgcolor="#0A5D9A">
    <form name="form1" method="post">
    <input type="hidden" name="usuario" value="<%=usuario%>"/>
        <div align="center" valing="center">
        <BR><BR><BR><BR><BR><BR>
        <!--img src="imagenes/bna_logo.gif" align="bottom"-->
            <table cellpadding="2" cellspacing="0" class="txtencabezado" border="1" bordercolor="">
				<tr>
                    <td width="252" bgcolor="#0A5D9A" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF">Teclado Virtual</font></b></td>
				</tr>
				<tr>
                    <td width="252" bgcolor="#F0F7F0" align="center">Clave: 
					<input type="password" id="campo_clave" name="clave" style="width:150px" readonly="true" class="caja_secure"/>
					<input type="button" name="ok" value=" Ok " onClick="location.href = 'login.jsp?Pass='+document.form1.clave.value+'&Usuario='+document.form1.usuario.value"></td>
				</tr>
                <tr>
                    <td align="center" bgcolor="#F0F7FD">
                    <input type="radio" name="Mayus" value="S" id="Mayus_0" checked onClick="marcador('contenedor','campo_clave',this.value);">May&uacute;sculas
                    <input type="radio" name="Mayus" value="N" id="Mayus_1" onClick="marcador('contenedor','campo_clave',this.value);">Min&uacute;sculas
                    </td>
                </tr>
                <tr>
                    <td align="center" bgcolor="#F0F7FD"><BR><div id="contenedor" onClick="marcador('contenedor','campo_clave',document.form1.Mayus.value);"></div></td>
                </tr>
            </table>
        </div>
    </form>
    </body>
</html>