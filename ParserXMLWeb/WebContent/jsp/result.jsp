<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
th {
    text-align: left;
}
</style>
</head>
<body>
<form action = "index.jsp">
<input type ="submit" name = "button" value="back"/>
</form>
 <h2>${requestScope.message}</h2>
<TABLE>
<tr>
    <th rowspan="2">Item</th>
    <th rowspan="2">Name</th>
    <th rowspan="2">Origin</th>
    <th rowspan="2">Soil</th>
    <th rowspan="2">Multiplying</th>
    <th colspan="3">Visual</th>
    <th colspan="3">Growing</th>
  </tr>
<tr>
    <th>Stalk Colour</th>
    <th>Leaf Colour</th>
    <th>Avg Size Meters</th>
    <th>Temperature</th>
    <th>Lightning</th>
    <th>Water ML Week</th>
  </tr>
<c:forEach items="${flowers}" var="flower" varStatus="status">
  <tr>
  	<td><c:out value="${flower.item}"/></td>
    <td><c:out value="${flower.name}"/></td>
	<td><c:out value="${flower.origin}"/></td>
	<td><c:out value="${flower.soil}"/></td>
	<td><c:out value="${flower.multiplying}"/></td>
	<td><c:out value="${flower.visual.stalkColour}"/></td>
	<td><c:out value="${flower.visual.leafColour}"/></td>
	<td><c:out value="${flower.visual.avgSizeMeters}"/></td>
	<td><c:out value="${flower.growing.temperature}"/></td>
	<td><c:out value="${flower.growing.lighting}"/></td>
	<td><c:out value="${flower.growing.waterMLWeek}"/></td>
  </tr>
</c:forEach>
</TABLE>
 </body>
</html>