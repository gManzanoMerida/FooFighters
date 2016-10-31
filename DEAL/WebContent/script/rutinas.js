
function bascularMenuFlotante( iden ) {  
       $('#' + iden).slideToggle();        
}    

function setOpcion( nombreFormulario, opcion, ventana ) {
  document.forms[nombreFormulario].elements["opcionPantalla"].value = opcion;
  if ( ventana != null ) {
    document.forms[nombreFormulario].target = ventana;
  }
  else {
    document.forms[nombreFormulario].target = "_self";
//    var elem = document.getElementById( "cabComun" );
//    if ( elem!=undefined ) elem.style.backgroundImage = "url(./res/onprocess.gif)";
  }
  document.body.style.filter='alpha(opacity=40)';
  document.forms[nombreFormulario].submit();
}

//  ---------------------------------------

function multiboxClick_mosaico( fila ) {
	
	return;
	
}

function multiboxClick( fila ) {
  if ( document.getElementsByName( "clavesMarcadas" )[fila].checked ) {
    document.getElementById( "laFila" + fila ).className += "highlight";
  } else {
    var claseCss = document.getElementById( "laFila" + fila ).className;
    var noClaseCss = claseCss.replace( /(?:^|\s)highlight(?!\S)/g , '' );
    document.getElementById( "laFila" + fila ).className = noClaseCss;    
  }
 // else {
 //   if( fila%2!=0 ) {
 //     document.getElementById( "laFila" + fila ).style.background = '#efefde';
 //   } else {
  //    document.getElementById( "laFila" + fila ).style.background = '#ffffff';
  //  }
  //}
}

//---------------------------------------

function isValidEmail(txEmail) {
	//var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	var emailReg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,10})+$/;
	if( !emailReg.test( txEmail ) ) { return false; } else { return true; }
}

//  ---------------------------------------

function confirmar( texto ) {
  var name = confirm( texto );
  if ( name==true ) return true;
  else              return false;
}

//  ---------------------------------------

function recortarTexto( texto,longitud ) {
  var cadena = texto;
  if ( cadena.length > longitud ) {
    cadena = cadena.substr( 0,longitud ) + "..";
  }
  return cadena;
}

//---------------------------------------

function soloNumeros( e ) {
	var keynum = 0;
	var keychar;
	var numcheck;
	if( window.event ) {
		keynum = e.keyCode;	// IE
	} else if ( e.which ) {
		keynum = e.which;	// Netscape/Firefox/Opera
	}
	keychar = String.fromCharCode( keynum );
	numcheck = /\d/;
	//    return numcheck.test( keychar );
	if ( keynum == undefined || keynum < 32 ) {return true;} // También se admiten caracteres de control
	if ( ( numcheck.test( keychar ) ) || ( keychar == '.' ) || ( keychar == ',' ) || ( keychar == '-' ) )
		return true;
	return false;
}

//---------------------------------------

function limiteCaracteres( evt, elem, maxLen ) {
	var keynum = 0;
	if( window.event ) {
		keynum = evt.keyCode;	// IE
	} else if ( evt.which ) {
		keynum = evt.which;		// Netscape/Firefox/Opera
	}

	if ( keynum == undefined || keynum < 32 ) {return true;} // Se admiten caracteres de control

	if ( elem.value.length < maxLen ) {return true;}

	return false;
}

//---------------------------------------

function textoClave( e ) {
	  var keynum = 0;
	  var keychar;
	  var patron;
	  if( window.event ) { 		// IE
	    keynum = e.keyCode;
	  } else if ( e.which ) { 	// Netscape/Firefox/Opera
	    keynum = e.which;
	  }
	  keychar = String.fromCharCode( keynum );

	  patron =/[@._\-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVXYZ0123456789]/;

	  if (keynum == undefined) return false;
	  if (keynum == 8) return true;	// retroceso
	  if (keynum == 0) return true;	// tab
	  if (patron.test(keychar)) return true;

	  return false;
}

//---------------------------------------

function EnmascaraDouble( valor, numDecimales ) {
  // Ejemplo en un jsp:
  // <td class="tbceldadetalle"style="text-align: right;">
  //        <script type="text/javascript">EnmascaraDouble( "${CadaFilaBean.hd_OUFMVA}",2 );</script>&nbsp;
  // </td>
  var i, j, neg, c1, c2, c3, r, arrayCad, num = new Number( valor );
  if ( isNaN( num ) ) {
    document.write( valor );
    return;
  }

  sepGrupo = ".";
  sepDecimal = ",";

  arrayCad = num.toFixed( numDecimales ).toString().split( "." );
  c1 = arrayCad[0];
  if ( c1==undefined ) c1 = "";
  c2 = arrayCad[1];
  if ( c2==undefined ) c2 = "";
  c3 = "";
  neg = ( c1.charAt( 0 )=='-' )?true:false;
  if ( neg ) c1 = c1.substr( 1 );
  for( j=-1,i=c1.length;i>=0;c3=c1.charAt( i-- )+c3,j++ )if( j>2 ){
    c3=sepGrupo+c3;
    j=0;
  }
  if ( neg ) c3 = "-" + c3;
  if ( numDecimales==0 ) r = c3;
  else                 r = c3+sepDecimal+c2;
  if( r==( "0"+sepDecimal+"00" ) ) r = "";
  document.write( r );
  return;
}

//---------------------------------------

function noCerosInt( num )    {
  if( num=="0" )  document.write( "<br/>" );
  else document.write( num );
}

//  ---------------------------------------

function noCerosDouble( num ) {
  if( num=="0.0" )document.write( "<br/>" );
  else document.write( num );
}

//  ---------------------------------------

function noCerosDoubleTruncaDecimales( num,dec ) {
  var f;
  if( num=="0.0" )document.write( "<br/>" );
  else {
    idx = num.lastIndexOf( "." );
    if ( idx>-1 ) {
      tmp = num.slice( 0,idx+1+dec );
      wDec = ( tmp.length-1 )-( tmp.lastIndexOf( "." ) );
      if ( ( dec-wDec )>0 ) {
        for ( f=0;f<( dec-wDec );f++ ) tmp += "0";
      }
      document.write( tmp );
    }
    else {
      document.write( num );
    }
  }
}

//---------------------------------------

function isIntro( e ) {
	  var keynum = 0;
	  if( window.event ) {	// IE
		    keynum = e.keyCode;
	  } else if( e.which ) {// Netscape/Firefox/Opera
		    keynum = e.which;
	  }
      e.preventDefault();
	  if ( keynum==13 ) { 
		  return true; 
	  }
	  return false;
}
//  ---------------------------------------

function saltaSiEsIntro( e,nameSgte ) {
	  // Por ejemplo:
	  //    <input name="e1" tabindex="1" type="text" onkeypress="return saltaSiEsIntro(event,'e2')" />
	  //    <input name="e2" tabindex="2" type="text" onkeypress="return saltaSiEsIntro(event,'e3')" />
	  //    <input name="e3" tabindex="3" type="text" onkeypress="return saltaSiEsIntro(event,'e4')" />
	  //    <input name="e4" tabindex="4" type="text" onkeypress="return saltaSiEsIntro(event,'e1')" />
	  var keynum = 0;
	  var eSgte,lista = null;
	  if( window.event ) {	// IE
	    keynum = e.keyCode;
	  } else if( e.which ) {	// Netscape/Firefox/Opera
	    keynum = e.which;
	  }
	  if ( keynum==13 ) {
	    lista =  window.document.getElementsByName( nameSgte );
	    if ( lista != null ) {
	        eSgte = lista[0];
	        if ( eSgte != null ) {
	            eSgte.focus();
	          if ( eSgte.type == "text" ) {
	              eSgte.select();
	          }
	        }
	        // alert( "Saltar a " + eSgte.name );
	    }
	  }
	  return true;
}

//  ---------------------------------------

function IsNumeric( valor ) {
  var x;
  var log=valor.length;
  var sw="S";
  for ( x=0; x<log; x++ ) {
    v1=valor.substr( x,1 );
    v2 = parseInt( v1 );
    //Compruebo si es un valor numérico
    if ( isNaN( v2 ) ) {
      sw= "N";
    }
  }
  if ( sw=="S" ) {
    return true;
  }
  else {
    return false;

  }
}

//  ---------------------------------------

var formateafecha_primerslap=false;
var formateafecha_segundoslap=false;
function formateafecha( fecha ) {
  var lng = fecha.length;
  var dia;
  var mes;
  var ano;

  if ( ( lng>=2 ) && ( formateafecha_primerslap==false ) ) {
    dia=fecha.substr( 0,2 );
    if ( ( IsNumeric( dia )==true ) && ( dia<=31 ) && ( dia!="00" ) ) {
      fecha=fecha.substr( 0,2 )+"/"+fecha.substr( 3,7 );
      formateafecha_primerslap=true;
    }
    else {
      fecha="";
      formateafecha_primerslap=false;
    }
  }
  else
  {
    dia=fecha.substr( 0,1 );
    if ( IsNumeric( dia )==false )
    {
      fecha="";
    }
    if ( ( lng<=2 ) && ( formateafecha_primerslap=true ) ) {
      fecha=fecha.substr( 0,1 );
      formateafecha_primerslap=false;
    }
  }
  if ( ( lng>=5 ) && ( formateafecha_segundoslap==false ) )
  {
    mes=fecha.substr( 3,2 );
    if ( ( IsNumeric( mes )==true ) &&( mes<=12 ) && ( mes!="00" ) ) {
      fecha=fecha.substr( 0,5 )+"/"+fecha.substr( 6,4 );
      formateafecha_segundoslap=true;
    }
    else {
      fecha=fecha.substr( 0,3 );
      ;
      formateafecha_segundoslap=false;
    }
  }
  else {
    if ( ( lng<=5 ) && ( formateafecha_segundoslap=true ) ) {
      fecha=fecha.substr( 0,4 );
      formateafecha_segundoslap=false;
    }
  }
  if ( lng>=7 )
  {
    ano=fecha.substr( 6,4 );
    if ( IsNumeric( ano )==false ) {
      fecha=fecha.substr( 0,6 );

    }
    else {
      if ( lng==10 ){
        if ( ( ano==0 ) || ( ano<1900 ) || ( ano>2100 ) ) {
          fecha=fecha.substr( 0,6 );

        }
      }
    }
  }

  if ( lng>=10 ) {
    fecha=fecha.substr( 0,10 );
    dia=fecha.substr( 0,2 );
    mes=fecha.substr( 3,2 );
    ano=fecha.substr( 6,4 );
    // Año no viciesto y es febrero y el dia es mayor a 28
    if ( ( ano%4 != 0 ) && ( mes ==02 ) && ( dia > 28 ) ) {
      fecha=fecha.substr( 0,2 )+"/";

    }
  }
  return ( fecha );
}

//  ---------------------------------------

function Click_Selector( oSelector ) {
  var i;
  // Es un TD y apela a su TR y de éste a su TABLE:
  var oContainer = oSelector.parentElement.parentElement;
  // Para el TABLE dado, obtener todos sus "Ocultables" del nivel del selector:
  var oObject = oContainer.all.item( "X" + oSelector.id.substr( 1 ) );
  if ( oObject != null ){
    if ( oObject.length != null ){
      for ( i = 0; i < oObject.length; i++ ){
        Click_Selector_Toggle( oSelector,oObject( i ) );
      }
    }
    else {
      Click_Selector_Toggle( oSelector,oObject );
    }
  }
  return;
}

//  ---------------------------------------

function Click_Selector_Toggle( oSelector,oObject ) {
  if ( oObject.style.display == "none" ) {
    oObject.style.display = "block";
    if ( oSelector.childNodes( 0 ).tagName == "IMG" ){
      oSelector.childNodes( 0 ).src = "./res/guionAbierto.bmp";
    }
  }
  else {
    oObject.style.display = "none";
    if ( oSelector.childNodes( 0 ).tagName == "IMG" ){
      oSelector.childNodes( 0 ).src = "./res/guionCerrado.bmp";
    }
  }
}

//  ---------------------------------------

function mouseOver( imagen ){
  imagen.src ="./res/ver_abierto.bmp";
}

//  ---------------------------------------

function mouseOut( imagen ){
  imagen.src ="./res/ver_cerrado.gif";
}

//  ---------------------------------------

function mouseOverChg( imagen ){
  imagen.src ="./res/cambiar_abierto.gif";
}

//  ---------------------------------------

function mouseOutChg( imagen ){
  imagen.src ="./res/cambiar_cerrado.gif";
}

//  ---------------------------------------

function mouseOverGen( elemimagen, txImagen ) {
  elemimagen.src = txImagen;

}

//  ---------------------------------------

function mouseOutGen( elemimagen, txImagen ) {
  elemimagen.src = txImagen;

}

//  ---------------------------------------

function getNumPagina() {
  var p = prompt( "Introduzca número de página","1" );
  return ( isNaN( p ) )?parseInt( "1" ):parseInt( p );
}

//  ---------------------------------------

function setFilaInicioGrid( fila ) {
  //        document.getElementsByName( 'filaInicioGrid' )( 0 ).value = fila;
  //        setOpcion( 0, '', null );
  //////////////////////////////////////////////////////////////////////
  // ¡ CUIDADO!, ESTA SUPONIENDO QUE SIEMPRE ES EL ÚLTIMO 'form' DEL 'document'
  //////////////////////////////////////////////////////////////////////
  document.forms[document.forms.length-1].elements["filaInicioGrid"].value = fila;
  setOpcion( document.forms[document.forms.length-1].name, 'REPROCESAR', null );
  //////////////////////////////////////////////////////////////////////
}

//  ---------------------------------------

////////////////////////////////////////////////////////
function mostrarOcultar( iden ) {
 bascularMenuFlotante(iden);
}

 function mostrarOcultarAlLado(e,iden){
       bascularMenuFlotante(iden);
    }

//  ---------------------------------------

 function getIdioma() {
		var idioma = "es-ES";
		if (navigator.language) {
			idioma = navigator.language;
		} else {
			idioma = navigator.browserLanguage;	// IE
		}	
		return idioma.split("-")[0];
	}

//---------------------------------------

function convertImgToBase64( idImg ){
		/*
		 * SOLO HTML 5 *
		 Supported input formats
		 image/png
		 image/jpeg
		 image/jpg
		 image/gif
		 image/bmp
		 image/tiff
		 image/x-icon
		 image/svg+xml
		 image/webp
		 image/xxx

		 Supported output formats
		 image/png
		 image/jpeg
		 image/webp (chrome)	 
		 */
		var img    = document.getElementById( idImg );
	    var canvas = document.createElement('CANVAS');
		var ctx    = canvas.getContext("2d");
		canvas.height = img.height;
	    canvas.width  = img.width;
		ctx.drawImage(img,0,0);
	    return canvas.toDataURL( 'image/png' );
 	}	

//---------------------------------------

function cvtMills2FechaHora(mills){
	var d = new Date(mills); 
	return( d.getFullYear() + "/" + padLeft((d.getMonth()+1),2) + "/" + padLeft(d.getDate(),2) + "&nbsp;&nbsp;&nbsp;" + padLeft(d.getHours(),2) + ":" + padLeft(d.getMinutes(),2) + ":" + padLeft(d.getSeconds(),2) + "," + padLeft(d.getMilliseconds(),3) );
}

function cvtMills2FechaHora_CORTO(mills){
	var d = new Date(mills); 
	return( d.getFullYear() + "/" + padLeft((d.getMonth()+1),2) + "/" + padLeft(d.getDate(),2) + "&nbsp;" + padLeft(d.getHours(),2) + ":" + padLeft(d.getMinutes(),2) );
}

//---------------------------------------

function padLeft(nr, ancho, str){
//console.log(padLeft(23,5,'>>'));  //=> '>>>>>>23'
	return Array(ancho-String(nr).length+1).join(str||'0')+nr;
}

//---------------------------------------
// MEJOR USAR jQuery !!
//  No usar esta funciones de aquí
//---------------------------------------
function PostAjax( datosPost, eDestino ) {
  var xmlhttp;
  ////////////
  if ( window.XMLHttpRequest ) {
    // IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
  }
  else {
    // IE6, IE5
    xmlhttp=new ActiveXObject( "Microsoft.XMLHTTP" );
  }
  ////////////
  xmlhttp.onreadystatechange = function() {
    if ( xmlhttp.readyState==4 && xmlhttp.status==200 ) {
      eDestino.innerHTML = xmlhttp.responseText;
    }
  };
  ////////////
  xmlhttp.open( "POST","./AjaxServlet",true );
  xmlhttp.setRequestHeader( "Content-type","application/x-www-form-urlencoded" );
  xmlhttp.send( datosPost );
}

function PostAjax_SetValue( datosPost, eDestino, valueOK) {
  var xmlhttp;
  ////////////
  if ( window.XMLHttpRequest ) {
    // IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
  }
  else {
    // IE6, IE5
    xmlhttp=new ActiveXObject( "Microsoft.XMLHTTP" );
  }
  ////////////
if (eDestino!=null && eDestino!=undefined){
    xmlhttp.onreadystatechange = function() {
        if ( xmlhttp.readyState==4 && xmlhttp.status==200 ) {
              if (xmlhttp.responseText=="OK") eDestino.value=valueOK;
            }
    };
}
  ////////////
  xmlhttp.open( "POST","./AjaxServlet",true );
  xmlhttp.setRequestHeader( "Content-type","application/x-www-form-urlencoded" );
  xmlhttp.send( datosPost );
}

//  ---------------------------------------

function ProxyAjax_combo_AR_d_IN_ES( caso, IN, ES, IdDestino ) {
    ////////////
    var eDestino = document.getElementById( IdDestino );
    var datosPost = "INNER=" + escape(eDestino.innerHTML);
    datosPost += "&CASO=" + caso;
    datosPost += "&IN=" + IN;
    datosPost += "&ES=" + ES;
    eDestino.innerHTML = "<span style='color:red;'>cargando...</span>";
    ////////////
    PostAjax( datosPost, eDestino );
    //////////////////////////////////////////
}

//  ---------------------------------------

function ProxyAjax_combo_ZN_d_IN_ES_AR( caso, IN, ES, AR, IdDestino ) {
    ////////////
    var eDestino = document.getElementById( IdDestino );
    var datosPost = "INNER=" + escape(eDestino.innerHTML);
    datosPost += "&CASO=" + caso;
    datosPost += "&IN=" + IN;
    datosPost += "&ES=" + ES;
    datosPost += "&AR=" + AR;
    eDestino.innerHTML = "<span style='color:red;'>cargando...</span>";
    ////////////
    PostAjax( datosPost, eDestino );
    //////////////////////////////////////////
}

//  ---------------------------------------

function ProxyAjax_combo_SZ_d_IN_ES_AR_ZN( caso, IN, ES, AR, ZN, IdDestino ) {
    ////////////
    var eDestino = document.getElementById( IdDestino );
    var datosPost = "INNER=" + escape(eDestino.innerHTML);
    datosPost += "&CASO=" + caso;
    datosPost += "&IN=" + IN;
    datosPost += "&ES=" + ES;
    datosPost += "&AR=" + AR;
    datosPost += "&ZN=" + ZN;
    eDestino.innerHTML = "<span style='color:red;'>cargando...</span>";
    ////////////
    PostAjax( datosPost, eDestino );
    //////////////////////////////////////////
}

//  ---------------------------------------
function ProxyAjax_mapaMosaicoSZ_IN_ES_ZN( caso, IN, ES, ZN, IdDestino ) {
    ////////////
    var eDestino = document.getElementById( IdDestino );
    var datosPost = "INNER=" + escape(eDestino.innerHTML);
    datosPost += "&CASO=" + caso;
    datosPost += "&IN=" + IN;
    datosPost += "&ES=" + ES;
    datosPost += "&ZN=" + ZN;
    eDestino.innerHTML = "<span style='color:red;'>cargando...</span>";
    ////////////
    PostAjax( datosPost, eDestino );
    //////////////////////////////////////////
}

function ProxyAjax_mapaMosaicoSZ_IN_ES_AR( caso, IN, ES, AR, IdDestino ) {
    ////////////
    var eDestino = document.getElementById( IdDestino );
    var datosPost = "INNER=" + escape(eDestino.innerHTML);
    datosPost += "&CASO=" + caso;
    datosPost += "&IN=" + IN;
    datosPost += "&ES=" + ES;
    datosPost += "&AR=" + AR;
    eDestino.innerHTML = "<span style='color:red;'>cargando...</span>";
    ////////////
    PostAjax( datosPost, eDestino );
    //////////////////////////////////////////
}

function ProxyAjax_mapaMosaicoSZ_IN_ES_AR_ZN( caso, IN, ES, AR, ZN, IdDestino ) {
    ////////////
    var eDestino = document.getElementById( IdDestino );
    var datosPost = "INNER=" + escape(eDestino.innerHTML);
    datosPost += "&CASO=" + caso;
    datosPost += "&IN=" + IN;
    datosPost += "&ES=" + ES;
    datosPost += "&AR=" + AR;
    datosPost += "&ZN=" + ZN;
    eDestino.innerHTML = "<span style='color:red;'>cargando...</span>";
    ////////////
    PostAjax( datosPost, eDestino );
    //////////////////////////////////////////
}

//  ---------------------------------------
function ProxyAjax_guardarPE(PeKey, values, IdDestino, valueOK ) {
    ////////////
    var eDestino = document.getElementById( IdDestino );
    var datosPost = "";
    datosPost += "CASO=05";
    datosPost += "&KEY=" + PeKey.replace(";","^");
    datosPost += "&VALUES=" + values;
    ////////////
    PostAjax_SetValue( datosPost, eDestino, valueOK );
    //////////////////////////////////////////
}
function ProxyAjax_eliminarPE(PeKey, IdDestino, valueOK ) {
    ////////////
    var eDestino = document.getElementById( IdDestino );
    var datosPost = "";
    datosPost += "CASO=06";
    datosPost += "&KEY=" + PeKey.replace(";","^");
    ////////////
    PostAjax_SetValue( datosPost, eDestino, valueOK );
    //////////////////////////////////////////
}

//  ---------------------------------------

