<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 	<script type="text/javascript" src="./script/rutinas.js"></script> -->
	<%-- <title>${cfgPantalla.tituloPantalla}</title> --%>

<title>Deal</title>
 	<!-- The styles -->    
    <link id="bs-css" href="./bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet">
	
	<style>	
	header { 
		background-color: transparent;
		overflow: hidden;
		width: 100%;  
	}
	header .logo, header .login{
		float: left;
		padding: 25px;
	}
	header,img {
	  width: 30%;
	  height: 30%;
	}
	header,h1 {color:blue;}
	header,h2 {color:blue;}
	header,h3 {color:blue;}
	
	
	#header{
		padding:5px;
		overflow: hidden;
		width: 100%;  
		border-bottom-width: 2px;
	}	
	#header .logo{
		float: left;
		padding-left: 25px;
	}
	#header .login{
		float: right;
		padding-top: 15px;
	}
	#header .navbar{
		background-color:#BBB6B6; 
		border-top: .4em solid #444;"
	}
	
	#flotante .login-href{
		align: top;
	}

	nav {
		text-align: center;
		width: 100%; 
		height: 60%;
		padding: 5px;
		background-color: #BBB6B6;
	}
	nav,img {
		height: 70%;
 		max-width: auto; 
	}
	
	#selector{ 
		overflow: hidden;
		width: 100%;  
 		text-align: center; 
 		padding: 5px;
	}
	#selector .quieres{
		color:blue;
		float: left;
		padding: 5px;
		margin: auto 1.5em;
	}
	#button-quieres,button{
		color:blue;
	}
	
	#selector .handshake{
		float: left;
		padding: 5px;
		margin: auto 1.5em;
	}
	#button-ofreces,button{
		color:red;
	}
	
	#selector .ofreces {
		color:red;
		float: left;
		padding: 5px;
		margin: auto 1.5em;
	}
	
	footer {	
		padding: 5px;
	}
	footer .navbar{
		background-color:#BBB6B6;
		border-bottom: .4em solid #444;
	}
	</style>
</head>

<body>
	<div id="header">

	<div class="navbar">    
    <div class="container">
    
		<div   class="logo">
			<a href="index.jsp">
				<span class="logo-icono">
     				<IMG SRC="./images/deal-logo.jpg"  BORDER=0 ALT="Deal" > 
				</span>
			</a>
		</div> 
		
		<div  class="login" >
<%-- 			<html:form action="#"> --%>
				<a href="#" class="login-href">Login...</a>
				<a href="index2.jsp">index2</a>
				<a href="index3.jsp">index3</a>
<%-- 			</html:form> --%>
		</div>
		
		 <div class="navbar-collapse collapse" id="#laBarraMenus" style="height: 0px;">  
			<ul class="dropdown-menu"  role="menu">
				<li class="dropdown"> 
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">Español</a>
				</li>
				<li class="dropdown"> 
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">English</a>
				</li>
			</ul>
		</div>
		
		</div>
		</div>
		
	</div>
	
	<nav class="fondo">
		<span>
 			<IMG SRC="./images/madrid-city.jpg"  BORDER=0 ALT="Deal"  >
 			<IMG SRC="./images/urb1.jpg"  BORDER=0 ALT="Deal"  > 
 			<IMG SRC="./images/urb2.jpg"  BORDER=0 ALT="Deal"  > 
		</span>
	</nav>
	
	<section>
		<div id="selector" class="row">
			<div class="col-xs-6 col-sm-4">
				<button id="button-quieres">Quieres</button>
			</div>
			<div class="col-xs-6 col-sm-4">
				<IMG SRC="./images/handshake.jpg"  BORDER=0 ALT="Deal"  > 
			</div>
			<div class="col-xs-6 col-sm-4">
				<button id="button-ofreces">Ofreces</button>
			</div>
		</div>
	</section>
	
	<footer>
		<div class="navbar" >    
	    <div class="container">
	    
	    </div>
	    </div>
	</footer>
</body>
</html>