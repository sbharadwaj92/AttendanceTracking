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
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/font.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/default.css">
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.js"></script>
<sj:head />
</head>
<body>
<%

response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setHeader("Cache-Control","must-revalidate");
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility

if(session.getAttribute("empId")==null)
{
	response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
	return;
}
else if((Long)session.getAttribute("loginCount")==1)
{
	response.sendRedirect(request.getContextPath()+"/jsp/changePassword.jsp");
}
%>
<div id="wrapper">
		<div id="header-wrapper">
			<div id="header" class="container">
				<div id="logo">
					<h1>
						<a href="#">Attendance Tracking System</a>
					</h1>
					<p>Developed by ILP Trivandrum</p>
				</div>

			</div>
			<div id="menu" class="container">

				<br>
				<ul>
					<li><s:url var="create" action="home" namespace="/"></s:url> <s:a
							href="%{#create}">HOME PAGE</s:a></li>
					<li><s:url var="create" action="absent" namespace="/"></s:url>
						<s:a href="%{#create}">ABSENTEES</s:a></li>
					<li><s:url var="create" action="tailgators" namespace="/"></s:url>
						<s:a href="%{#create}">TAILGATORS</s:a></li>
					<li><s:url var="create" action="faculty" namespace="/"></s:url>
						<s:a href="%{#create}">FACULTY</s:a></li>
					<li><s:url var="create" action="user" namespace="/"></s:url> <s:a
							href="%{#create}">USER CONTROL</s:a></li>
					<li><s:url var="create" action="logout" namespace="/"></s:url>
						<s:a href="%{#create}">LOGOUT</s:a></li>
				</ul>
			</div>
		</div>
	</div>

<%= session.getAttribute("loginCount")  %>
	Welcome, <s:property value="#session.empName"/><br><br>
	<s:property value="#session.empId"/><br><br>
	<s:url var="addFTM" action="addUser"></s:url>
	<s:a href="%{#addFTM}">ADD FACILITATION TEAM MEMBER</s:a><br><br>
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
	
	<s:url var="loggingOut" action="logout"></s:url>
	<s:a href="%{#loggingOut}">LOG OUT</s:a><br><br>
	
	
		<div id="footer" style="margin-top:10%;">
		<p>&copy; 2015. All rights reserved. Developed by ILP Trivandrum</p>
	</div>
</body>
</html>