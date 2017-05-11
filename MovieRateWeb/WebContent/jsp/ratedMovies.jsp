<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Rated Movies</title>
</head>
<body>
	<h3>Welcome</h3>
	<hr />
	${userLogin}, hello!
	<hr />
	${userRate}
	<form name="logoutForm" method="post" action="${pageContext.request.contextPath}/controller">
		<input type="hidden" name="command" value="logout" /> 
		<input type="submit" value="Logout" />
	</form>
	<a href="${pageContext.request.contextPath}/jsp/main.jsp">Not Rated Movies</a>
	<TABLE>
		<c:forEach items="${moviesRated}" var="movie" varStatus="status">
			<tr>
				<th ROWSPAN=2>${movie.movieName}</th>
				<td width="400">Description: <c:out value="${movie.movieDesc} " /> 
				     <br>Year:<c:out value="${movie.movieYear}" />
				     <br>Rate:<c:out value="${movie.movieRate}" />
				     <TABLE>
				    <c:forEach items="${movie.movieRecalls}" var="recall" varStatus="status">
				    <tr>
				     <td><c:out value="${recall.userLogin} " /> 
				     <td><c:out value="${recall.rate} " /> 
				     <td><c:out value="${recall.comment} " /> 
				     </tr>
				    </c:forEach>
				    </TABLE>
				   </td>
			</tr>
			<tr>
				<td><form name="rateForm" method="post" action="${pageContext.request.contextPath}/controller">
						<input type="hidden" name="movieID" value="${movie.movieID}" />
						<input type="hidden" name="userID" value="${userID}" />
					</form></td>
			</tr>
		</c:forEach>
	</TABLE>
</body>
</html>