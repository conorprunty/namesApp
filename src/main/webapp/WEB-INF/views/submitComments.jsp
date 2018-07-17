<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Feedback</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Feedback / Comments</h2>
  
    <form:form method="POST" modelAttribute="comments">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="name">Name: </label> </td>
                <td><form:input path="name" id="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="comments">Comments: </label> </td>
                <td><form:input path="comments" id="comments"/></td>
                <td><form:errors path="comments" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td>
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
            <form:input type="hidden" path="moderated" id="moderated" value="N"/>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/' />">Homepage</a>
</body>
</html>
