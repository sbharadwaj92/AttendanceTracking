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
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.js"></script>
</head>
<body>
	<s:url var="readT" action="absenteesMoreThanTwo"></s:url>
	<s:a href="%{#readT}">BACK</s:a><br><br>
	
	<s:if test="%{getdList()!=null}">	
		<table border="1">
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
</body>
</html>