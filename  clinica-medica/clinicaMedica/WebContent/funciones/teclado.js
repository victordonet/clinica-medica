function AsignaValor(Nombre,Valor){
    var Campo = document.getElementById(Nombre);
    if(Valor==""){
        Campo.value="";
    }else{
        if(Campo.value!=""){
            Campo.value = Campo.value + Valor;
        }else{
            Campo.value = Valor;
        }
    }
}

function randOrd(){
    return (Math.round(Math.random())-0.5);
}

function marcador(Div,Nombre,Mayus){
    var resultado = "";
    var num  = new Array('1','2','3','4','5','6','7','8','9','0');
    if (Mayus=="S"){
		var key  = new Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z');
	}else{
		var key  = new Array('a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z');
	}
    num.sort(randOrd);
    key.sort(randOrd);
    resultado = "<table cellpadding='1' cellspacing='1' width='100'>";
    var ini = 0;
    var fin = 10;
    resultado += "<tr bgcolor='#FFFFFF'>";
    for ( var n=0; n<10; ++n ){
        resultado += "<td align='center'><input type='button' onclick=\"AsignaValor('"+Nombre+"','"+num[n]+"')\" value=" + num[n] + " class='txtencabb'></td>";
    }
    resultado += "</tr>";
    for ( var i=0; i<3; ++i ){
        resultado += "<tr bgcolor='#FFFFFF'>";
        for ( var j=ini; j<fin; ++j ){
            resultado += "<td align='center'><input type='button' onclick=\"AsignaValor('"+Nombre+"','"+key[j]+"')\" value=" + key[j] + " class='txtencabb'></td>";
        }
        if(j<20){
            ini = j;
            fin = ini + 10;
        }else if(j==20){
            ini = j;
            fin = ini + 7;
        }else if(j==27){
            resultado += "<td bgcolor='#336699' colspan='4' align='center' style='cursor:pointer;' onclick=\"AsignaValor('"+Nombre+"','')\"><font face='Calibri' color='#FFFFFF' size='2'><B>Limpiar</B></font></td>";
        }
        resultado += "</tr>";
    }
    resultado += "</table><br>";
    document.form.usuario.focus();
    document.getElementById(Div).innerHTML=resultado;
}