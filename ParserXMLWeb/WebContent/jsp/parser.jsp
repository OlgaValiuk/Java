<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld"%>
<c:set var="lan" value="${not empty param.language ? param.language : not empty lan ? lan : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${lan}" scope="session"/>
<fmt:setBundle basename="resources.pagecontent" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="label.titleTab1" /></title>
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
</head>
<body>
	<ul>
		<li><a class="active" href="#home"><fmt:message
					key="label.tab1" /></a></li>
		<li><a href="${pageContext.request.contextPath}/jsp/validation.jsp"><fmt:message key="label.tab2" /></a></li>
	<a href="${pageContext.request.contextPath}/jsp/parser.jsp?language=ru_RU"> <img src="${pageContext.request.contextPath}/images/ru_RU.png"	style="height: 25px; width: 30px; padding: 8px;"></a>
	<a href="${pageContext.request.contextPath}/jsp/parser.jsp?language=en_US"> <img src="${pageContext.request.contextPath}/images/en_US.png"	style="height: 25px; width: 30px; padding: 8px;"></a>
	</ul>
	<!--<ctg:info-time/> !-->
	<h3>
		<fmt:message key="label.actionParser" />
	</h3>
	<form action="timeaction" method="post" enctype="multipart/form-data">
		<fmt:message key="label.file" />
		<input type="file" name="fileName"> <br> <br>
		<input type="hidden" name="menu" value="parser" />
		<fmt:message key="label.parser" />
		<input type="radio" name="Parser" value="DOM" checked> DOM <input
			type="radio" name="Parser" value="SAX"> SAX <input
			type="radio" name="Parser" value="StAX"> StAX<br> <br>
		<input type="submit" value=<fmt:message key="label.upload"/> /> <br>
	</form>
</body>
</html>