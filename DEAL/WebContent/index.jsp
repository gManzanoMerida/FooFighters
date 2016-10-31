<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./images/favicon1.jpg">

    <title>Deal!</title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="./bootstrap-3.3.5-dist/css/carousel.css" rel="stylesheet">
    <style type="text/css">
    .carousel-caption {
    	color: white;
    	text-shadow: black 0.1em 0.1em 0.2em;
    	background-color: rgba(51, 122, 183, 0.4); /* Color white with alpha 0.9*/
    }
/*     h3 { */
/*      	background-color: rgba(51, 122, 183, 0.4); /* Color white with alpha 0.9*/ */

/*     	color: white; */
/*     	text-shadow: black 0.1em 0.1em 0.2em; */
/*     } */
    </style>
  </head>
<!-- NAVBAR
================================================== -->
  <body>
    <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
        	<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> 
						<span class="icon-bar"></span> <span class="icon-bar"></span> 
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Deal</a>
				</div>

				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						                <li class="active"><a href="Logon.jsp">login</a></li>
						<li><a href="#about"><bean:message key="index.about"/></a></li>
						<li><a href="#contact">Contact</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul>
						</li>
					</ul>

				<div id="navbar" class="navbar-collapse collapse">
					 <html:form   styleClass="navbar-form navbar-right"
					 action="/Logon_A.do"   focus="logon_USR" 
					 onsubmit="document.getElementsByName('logon_PWD')[0].value=MD5(document.getElementsByName('logon_PWD')[0].value);" >
					 
						<div class="form-group">
<!-- 							<input type="text" placeholder="Email" class="form-control"> -->
							<html:text  property="logon_USR" value="Email" styleClass="form-control"/>
						</div>
						<div class="form-group">
<!-- 							<input type="password" placeholder="Password" class="form-control"> -->
							<html:password property="logon_PWD" value="Password" styleClass="form-control"/>
						</div>
						<button type="submit" class="btn btn-success">Sign in</button>
					</html:form>
				</div>
				<!--/.navbar-collapse -->

			</div>
			</div>
          
        </nav>

      </div>
    </div>


    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="./images/madrid-city1_1.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>¿Que necesitas?</h1>
              <p><h3>...un piso en alquiler o venta, un coche...? solo tienes que darte de alta gratis y decirnos lo que quieres, 
                 ya no tienes que buscar, ellos te encuentran a ti!
                </h3>
                </p>
             
              <div class="row">
      			 <div class="col-lg-6" >
         		     <p><a class="btn btn-lg btn-primary" href="SignUp-Customer.jsp" role="button">Sign up today</a></p>
         	     </div>
              	 <div class="col-lg-6">
              	 	<p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
              	 </div>
              </div>
              
            </div>
          </div>
        </div>
        
        <div class="item">
          <img class="second-slide" src="./images/barcelona5.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>¿Que ofreces?</h1>
              <p><h3>Alquilas o vendes tu casa? ¿Trabajas en una inmobiliaria o concesionario? 
              date de alta gratis y encuentra clientes. </h3>
              </p>
              
               <div class="row">
      			 <div class="col-lg-6" >
         		     <p><a class="btn btn-lg btn-primary" href="SignUp-Supplier.jsp" role="button">Sign up today</a></p>
         	     </div>
              	 <div class="col-lg-6">
              	 	<p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
              	 </div>
              </div>
              
            </div>
          </div>
        </div>
        
        <div class="item">
           <img class="first-slide" src="./images/cartel-publicidad.jpg" alt="First slide" style="display: block;">
           <div class="container">
            <div class="carousel-caption">
<!--               <h1>Mira los ultimos anuncios</h1> -->
<!--               <p></p> -->
<!--               <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p> -->
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-circle" src="./images/busco1.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2>Quiero...</h2>
          <p>
          	Un piso en regimen de aquiler. 500€ como maximo. 60mts cuadrados minimo. 2 habitaciones, 1 baño.
          	Calefacción y aire acondicionado. Garaje y ascensor. En la zona de Tetuan. <a href="#">Contacto</a>.
          </p>
<!--           <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p> -->
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
          <h2>Necesito</h2>
          <p>
          	Un Chalet en venta. Mínimo 3 habitaciones, 2 baños y garaje.
          	Calefacción y aire acondicionado. En la zona de Villaverde o Fuenlabrada. Max 300.000€ <a href="#">Contacto</a>.
		</p>
<!--           <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p> -->
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
<!--           <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p> -->
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->


      <!-- START THE FEATURETTES -->

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <!-- /END THE FEATURETTES -->


      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="./bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
