<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Origilols</title>

	<link type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet" />
	<link type="text/css" href="<c:url value='/resources/css/style.css' />" rel="stylesheet" />
	<script src="<c:url value='/resources/js/filtertable.js' />" type="text/javascript"></script>
	
</head>


<body>
	<h2>World Cup Teams</h2>
	<br/>	
	<input type="text" id="nameCheck" onkeyup="filterTable()" placeholder="Find by name...">
	<br/>
	<br/>
	<table id="wctable" class="table table-hover table-bordered table-responsive fulltable">
		<tr>
			<th>Name</th><th>LolName</th>
		</tr>
		<c:forEach items="${teams}" var="teams">
		<!-- the var="teams" here is just
		used within the loop, so in this case
		it's where teams comes from within
		<td>${teams.name}</td>. 
		However, the teams in items="${teams}"
		comes from the map used in the AppController
		and how it gets all the values -->
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