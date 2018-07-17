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
	<h2>Choose a link from below</h2>
	<!-- i.e. /worldcup is the link -->
	<a href='worldcup'>World Cup Teams</a>
	<br/>
	<br/>
	<a href='premteams'>Premier League Teams</a>
	<br/>
	<br/>
	<a href='new'>Feedback / Comments</a>
</body>
</html>