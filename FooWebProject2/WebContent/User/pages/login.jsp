<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head></head>
<body>

	<h1>Struts 2 Login With annotation Example</h1>
	
	<!-- Si usuarioActivo no aparce pantalla de logueo -->
		<s:if test="%{usuarioActivo=='ok'}"  >
		<s:property value="username"/>:<s:property value="usuarioActivo"/> 
	</s:if>
	<s:else>
	
		<s:form action="/User/loginActionForm">
			<s:textfield name="username" label="Username"/>
			<s:password name="password" label="Password"/>
			<s:submit/>
		</s:form>
		
		<!-- si username vacio falla el logueo -->
		<s:if test="%{userNoEncontrado=='true'}">
			<s:property value="mensaje"/> 
			
			
		</s:if>
		<s:else>
			
		
		</s:else>
		
	</s:else>

<%-- 	<s:form action="/User/loginActionForm"> --%>
<%-- 		<s:textfield name="username" label="Username" /> --%>
<%-- 		<s:password name="password" label="Password" /> --%>
<%-- 		<s:submit /> --%>
<%-- 	</s:form> --%>


</body>
</html>