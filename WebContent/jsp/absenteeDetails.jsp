<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date, com.tcs.ilp.bean.Day , java.util.ArrayList, java.text.SimpleDateFormat"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<s:url var="readT" action="absenteesMoreThanTwo"></s:url>
	<s:a href="%{#readT}">BACK</s:a><br><br>
	
	<s:if test="%{getdList()!=null}">	
		<table class="table table-bordered table-hover" style="width:100px">
			<tr>
				<th>DATE</th>
			</tr>
				<s:iterator value="%{getdList()}">
			<tr>
				<td><s:date name="curDate" format="dd-MMM-yyyy" /></td>
			</tr>
			</s:iterator>
		</table>
	</s:if>
		<div id="footer" style="margin-top:10%;">
		<p>&copy; 2015. All rights reserved. Developed by ILP Trivandrum</p>
	</div>
</body>
</html>