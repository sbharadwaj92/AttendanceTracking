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
	<s:url var="home" action="index"></s:url>
	<s:a href="%{#home}">HOME</s:a><br><br>
	
	<form class="form-inline" id="form" action="getRecords">
		<div class="form-group inner-addon left-addon col-md-2" id="sandbox-container">
			<i class="glyphicon glyphicon-calendar"></i>
			<input type="text" name="date1" class="form-control" placeholder="dd-mm-yyyy" autocomplete="off" required />
		</div>&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary submitBtn">Submit</button>
	</form>
	
</body>
</html>