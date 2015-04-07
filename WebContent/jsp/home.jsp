<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/bootstrap.css">
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.js"></script>
<sj:head />
</head>
<body>
	<s:url var="add" action="addTrainee"></s:url>
	<s:a href="%{#add}">ADD TRAINEE</s:a><br><br>
	<s:url var="readA" action="dailyAbsentees"></s:url>
	<s:a href="%{#readA}">VIEW DAILY ABSENTEES</s:a><br><br>
	<s:url var="readT" action="dailyTailGaters"></s:url>
	<s:a href="%{#readT}">VIEW DAILY TAILGATERS</s:a><br><br>
	<s:url var="readT" action="absenteesMoreThanTwo"></s:url>
	<s:a href="%{#readT}">VIEW ABSENTEES ABSENT FOR MORE THAN 2 DAYS</s:a><br><br>
	<s:url var="readBT" action="absenteesbtTwoDates"></s:url>
	<s:a href="%{#readBT}">VIEW ABSENTEES BETWEEN TWO DATES</s:a><br><br>
</body>
</html>