<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>NotRated Movies</title>
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
	<a href="${pageContext.request.contextPath}/jsp/ratedMovies.jsp">Rated Movies</a>
	<TABLE>
		<c:forEach items="${moviesNotRated}" var="movie" varStatus="status">
			<tr>
				<th ROWSPAN=2>${movie.movieName}</th>
				<td width="100">Description: <c:out value="${movie.movieDesc} " /> 
				     <br>Year:<c:out value="${movie.movieYear}" />
				   </td>
			</tr>
			<tr>
				<td><form name="rateForm" method="post" action="${pageContext.request.contextPath}/controller">
						<input type="hidden" name="movieID" value="${movie.movieID}" />
						<input type="hidden" name="userID" value="${userID}" />
						<input type="hidden" name="command" value="recall" /> 
						<p>
						Rate: <input type="text" name="rate" value="" />
						</p>
						<p>
						<textarea name="comment" cols="40" rows="3">Comment...</textarea>
						</p>
						<input type="submit" value="Submit"> <input type="reset" value="Clear">
					</form></td>
			</tr>
		</c:forEach>
	</TABLE>
</body>
</html>