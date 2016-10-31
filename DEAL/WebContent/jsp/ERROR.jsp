<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html locale="true">
    <head>
<!--         <link rel="stylesheet" type="text/css" href="./res/estilos.css" /> -->
        <title>Error</title>
    </head>
    <body>
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color='red'">
                ERROR:Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <h3><html:errors property="error"/></h3>
        &nbsp;&nbsp;&nbsp;
        <fieldset style="width: 300px; text-align: left;">
            <legend>&nbsp;Acciones posibles&nbsp;</legend>
            &nbsp;&nbsp;&nbsp;<a href="javascript:history.back();">Volver atrás</a>
            &nbsp;&nbsp;&nbsp;<a href="./Logon.jsp">Volver a conectarse</a>
        </fieldset>
    </body>
</html:html>
