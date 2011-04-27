<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.*"%>
<html>
<head>
    <META HTTP-EQUIV="Expires" CONTENT="-1">
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
    <script languaje="javascript" type="text/javascript"> 
        function Cerrar_Sesion_Ir_Inicio() {
            window.history.go(1); 
            document.form.action = "ingreso.jsp"; 
            document.form.submit(); 
        } 
    </script>
</head>
<%
		HttpSession eb_session = request.getSession();
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		response.setDateHeader("Expires", 0);
		eb_session.invalidate();
		
		//response.sendRedirect("ingreso.jsp");
		%>
		<body bgcolor="#0A5D9A" onLoad="Cerrar_Sesion_Ir_Inicio()">
		<form name="form">
		<table width="100%" bgcolor="#0A5D9A">
		  <tr> 
			<td width="15%" height="100%">
			<div align="center"><img src="imagenes/bna_logo.gif" align="bottom"></div>
			</td>
		  </tr>
			<tr>
			<td width="15%" height="40">
			<div align="center">
				<b><font face="Verdana" size="2" color="#FFFFFF">Cerrando sesi&oacute;n.</font></b>
			</div></td>
		  </tr>
		</table>
		</form>
		</body>
		<%
	}else{
		response.sendRedirect("error.jsp");
	}
} catch (Exception f) {
	System.out.println(f.toString()); 
	response.sendRedirect("error.jsp");
}
%>
</html>