<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head></head>
<body>
<h1>Struts 2 Annotation Example</h1>

<s:form action="result">
	<s:textfield name="userName" label="User Name"/>
	<s:password name="pwd" label="Password"/>
	<s:submit/>
</s:form>

</body>
</html>