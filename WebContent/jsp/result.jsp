<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:url var="home" action="index"></s:url>
<s:a href="%{#home}">HOME</s:a><br><br>
<% int count = (int) request.getAttribute("count"); %>
<%= count  %> &nbsp; Absentees/Tailgaters found on this day 
</body>
</html>