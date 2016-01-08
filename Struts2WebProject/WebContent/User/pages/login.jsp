<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head></head>
<body>

	<h1>Struts 2 Login With annotation Example</h1>
	
	<%-- 	<s:property value="username"/>  --%>
<%-- 	<s:property value="usuarioActivo"/>  --%>
<%-- 	<s:if test="%{#usuarioActivo=='ok'}"  > --%>
<%-- 		<s:property value="username"/>  --%>
<%-- 	</s:if> --%>
<%-- 	<s:else> --%>
<%-- 		<s:form action="loginActionForm"> --%>
<%-- 			<s:textfield name="username" label="Username"/> --%>
<%-- 			<s:password name="password" label="Password"/> --%>
<%-- 			<s:submit/> --%>
<%-- 		</s:form> --%>
<%-- 	</s:else> --%>

	<s:form action="loginActionForm">
		<s:textfield name="username" label="Username" />
		<s:password name="password" label="Password" />
		<s:submit />
	</s:form>


</body>
</html>