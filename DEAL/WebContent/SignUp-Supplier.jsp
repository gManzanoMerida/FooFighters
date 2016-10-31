<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--         <link rel="stylesheet" type="text/css" href="./res/estilos.css" /> -->
        <script type="text/javascript" src="./script/rutinas.js"></script>
        <script type="text/javascript" src="./script/md5.js"></script>
        <title>SignUp-Customer</title>
	   <style type="text/css">
		body {
			background: url(./images/DealFrontLogon.jpg) no-repeat center top fixed;
		}
		</style>
	</head>

	<body>
	<div id="content" style="margin-left: 40%;    margin-top: 10%;    background-color: transparent;">
        <html:form action="/Logon_A.do" style="margin: 20px 20px;" focus="logon_USR" onsubmit="document.getElementsByName('logon_PWD')[0].value=MD5(document.getElementsByName('logon_PWD')[0].value);">
            <html:errors property="error"/>
            <fieldset style="width: 200px; background-color: rgba(255,255,255,0.5);border-radius:10px;padding:10px;">
                <br/>
                <table cellpadding="2" cellspacing="5" border="0">
                    <tr><td>Usuario   </td><td><html:text     property="logon_USR" styleClass="caja" maxlength="50" size="50"/></td></tr>
                    <tr><td>Contraseña</td><td><html:password property="logon_PWD" styleClass="caja" maxlength="50" size="50"/></td></tr>
                    <tr><td colspan="2" style="text-align: right;"><html:submit value="Iniciar aplicación"/></td></tr>
                </table>
                &nbsp;&nbsp;(<bean:message key="configuracion.verJDB"/>) Modo <bean:message key="configuracion.modo"/>.
                <br/><br/>
            </fieldset>
        </html:form>
       </div>
	</body>
</html>
