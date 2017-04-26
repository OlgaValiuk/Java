<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld" %>
<c:set var="lan" value="${not empty param.language ? param.language : not empty lan ? lan : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${lan}" scope="session" />
<fmt:setBundle basename="resources.pagecontent"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="label.titleTab2"  /></title>
</head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
.active {
    background-color: #4CAF50;
}
</style>
<body>
</head>
<body>
<ul>
  <li><a href="${pageContext.request.contextPath}/jsp/parser.jsp"><fmt:message key="label.tab1"/></a></li>
  <li><a class="active" href="#validation"><fmt:message key="label.tab2"/></a></li>
  <a href="${pageContext.request.contextPath}/jsp/validation.jsp?language=ru_RU"> <img src="${pageContext.request.contextPath}/images/ru_RU.png"	style="height: 25px; width: 30px;padding: 8px;"></a>
  <a href="${pageContext.request.contextPath}/jsp/validation.jsp?language=en_US"> <img src="${pageContext.request.contextPath}/images/en_US.png"	style="height: 25px; width: 30px;padding: 8px;"></a>
	
</ul>
	<h3><fmt:message key="label.actionValidation"  /></h3>
		<form name="ValidationForm" action="${pageContext.request.contextPath}/timeaction" method="post" enctype="multipart/form-data">
		<fmt:message key="label.fileXML"  />
		<input type="file" name="fileXML"> <br>
		<br>
		<input type="hidden" name="menu" value="validation" />
		<fmt:message key="label.fileXSD"  />
		<input type="file" name="fileXSD"> <br>
		<br>
		<input type="submit" value=<fmt:message key="label.upload"/>> <br> 
		<br>
		${statusXML} 
	</form>
</body>
</html>