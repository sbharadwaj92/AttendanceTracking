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
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/bootstrap-datepicker3.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/font.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/default.css">
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap-datepicker.js"></script>
<script src="<%= request.getContextPath() %>/js/jquery-data-table.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.js"></script>
<script src="<%= request.getContextPath() %>/js/custom.js"></script>
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
	<s:url var="home" action="index"></s:url>
	<s:a href="%{#home}">HOME</s:a><br><br>
	



	<form class="form-inline" id="form" action="getRecords" style="width: 300px; margin:0 auto;">
		<div class="form-group inner-addon left-addon col-md-2" id="sandbox-container">
			<i class="glyphicon glyphicon-calendar"></i>
			<input type="text" name="date1" class="form-control" placeholder="dd-mm-yyyy" autocomplete="off" required />
		</div>&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary submitBtn" style="padding:left:10%;">Submit</button>
	</form>



	
		<div id="footer" style="margin-top:10%;">
		<p>&copy; 2015. All rights reserved. Developed by ILP Trivandrum</p>
	</div>
</body>
</html>