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
	
</head>


<body>
	<h2>Your comments</h2>	
	<table id="wctable" class="table table-hover table-bordered table-responsive fulltable">
		<tr>
			<th>Name</th><th>Comment(s)</th><th>Mod Comment(s)</th>
		</tr>
		<c:forEach items="${comments}" var="comments">
			<tr>
			<td>${comments.name}</td>
			<td>${comments.comments}</td>
			<td>${comments.modcomments}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/' />">Home</a>
</body>
</html>