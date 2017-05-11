<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<form name="registerForm" method="post" action="${pageContext.request.contextPath}/controller">
		<input type="hidden" name="command" value="register" /> 
		Create login:
		<br /> 
		<input type="text" name="login" value="" /> 
		<br />
		Create password:
		<br /> 
		<input type="password" name="password" value="" /> 
		<br />
		Enter email:
		<br /> 
		<input type="text" name="email" value="" /> 
		<br />
		<input type="submit" value="Submit" />
		<br />
		<a href="${pageContext.request.contextPath}/jsp/login.jsp?">Back</a>
	</form>
	<hr />
</body>
</html>
