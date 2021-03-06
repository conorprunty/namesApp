<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Origilols</title>

	<link type="text/css" href="<c:url value='/resources/css/style.css' />" rel="stylesheet" />
	<script src="<c:url value='/resources/js/sorttable.js' />" type="text/javascript"></script>
	
</head>


<body>
	<h2>Premier League Teams</h2>	
	<table class="sortable" id ="tablestyle">
		<tr>
			<th>Name</th><th>LolName</th>
		</tr>
		<c:forEach items="${teams}" var="teams">
			<tr>
			<td>${teams.name}</td>
			<td>${teams.newName}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/' />">Back</a>
</body>
</html>