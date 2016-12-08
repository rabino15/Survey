<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questionaire</title>
</head>
<body>
<h1>Questionaire</h1>
	<form action="Response" method="get">
	<table>	
		<tbody>
	 	<c:forEach var="question" items="${questions}" varStatus="status" begin="0" end="9" step="1">
	 		<tr><td>${question[0]}</td></tr>
	 		<tr><td><input type="radio" name="Q${status.count}" value="A">${question[1]}</td></tr>
	 		<tr><td><input type="radio" name="Q${status.count}" value="B">${question[2]}</td></tr>
	 		<tr><td><input type="radio" name="Q${status.count}" value="C">${question[3]}</td></tr>
	 		<tr><td><input type="radio" name="Q${status.count}" value="D">${question[4]}</td></tr>
	 	</c:forEach>
	 	</tbody>
	</table>
	<input type="submit">
	</form>
</body>
</html>