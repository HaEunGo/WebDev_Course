<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>영역 객체</h2>
	
	<h3>application 영역과 session 영역의 비교</h3>
	<%
		application.setAttribute("userName", "동동이");
		session.setAttribute("address", "서울특별시 강남구");
	%>
	
	<a href="scopeTest1.jsp">View Details</a>
	
	<h3>page 영역과 request 영역의 비교</h3>
	
	<a href="scopeTest2.jsp">View Details</a>
	<%
		request.setAttribute("requestScope", "requestValue");
		pageContext.setAttribute("pageScope", "pageValue");
	%>
</body>
</html>