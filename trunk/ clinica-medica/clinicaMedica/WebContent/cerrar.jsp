<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.topsystems.homebanking.util.*" %>
<%@ page import="java.util.*"%>
<%@ page import="topsystems.jbank.rpc.*" %>
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
String lStUsuario=(String) eb_session.getAttribute("usuario");
String url=(String) eb_session.getAttribute("url");
int puerto =((Integer) eb_session.getAttribute("puerto")).intValue();
String usuTopaz=(String) eb_session.getAttribute("usuTopaz");
String passTopaz=(String) eb_session.getAttribute("passTopaz");
ServiceConnection connection = null;
String resultado="";
try {
	connection = ServiceConnectionFactory.createSocketConnection(url,puerto);
	connection.connect(usuTopaz,passTopaz);
				
	ServiceCall serviceCall = connection.createCall("Oper4006");		
	Request req = serviceCall.createRequest();				
	//Cargo los Campos
	req.addField(new Field("TipoSolicitud", "Cierre"));
	req.addField(new Field("Usuario", lStUsuario));
	req.addField(new Field("Conectado", "N"));
	req.addField(new Field("Reintentos", "0"));
	//Obtengo datos response
	serviceCall.setProperty(ProtocolConstants.PACK_TYPE_PROPERTY, "XML");
	serviceCall.setProperty(ProtocolConstants.PACK_VERSION_PROPERTY,new Integer(1));		
	Response respon = serviceCall.invoke(req);
	DataTable datatable = respon.getDataTable();
	int i=datatable.getRowCount();
	int h=0;
	for (h = 0; h < i; h++){
		resultado=(String) datatable.getValueAt(h,0);
	}
	if(resultado.equals("OK")){
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