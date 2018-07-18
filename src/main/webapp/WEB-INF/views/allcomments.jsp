<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Origlols</title>
	<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Comments </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Name</th>
				        <th>Comments</th>
				        <th>Mod Comments</th>
				        <th>Moderated</th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${allcomments}" var="allcomments">
					<tr>
						<td>${allcomments.name}</td>
						<td>${allcomments.comments}</td>
						<td>${allcomments.modcomments}</td>
						<td>${allcomments.moderated}</td>
							<td><a href="<c:url value='/admin/edit-comments-${allcomments.id}' />" class="btn btn-success custom-width">Edit</a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
   	</div>
</body>
</html>