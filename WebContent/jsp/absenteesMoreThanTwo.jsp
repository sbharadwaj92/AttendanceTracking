<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList , com.tcs.ilp.bean.Trainee" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/bootstrap.css">
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.js"></script>
</head>
<body>
<s:url var="home" action="index"></s:url>
<s:a href="%{#home}">HOME</s:a><br><br>

<%	ArrayList<Integer> count = (ArrayList<Integer>) request.getAttribute("cList");
	ArrayList<Trainee> aList = (ArrayList<Trainee>) request.getAttribute("aList"); %>
	
<% if(aList!=null && count!=null) { %>
    		<table border="1">
				<thead>
					<tr>
						<th>EMP ID</th>
						<th>EMP NAME</th>
						<th>LG NAME</th>
						<th>BATCH NAME</th>
						<th>PROJECT</th>
						<th>NO OF DAYS ABSENT</th>
					</tr>
				</thead>
				<tbody>
					<%for(int i=0;i<count.size();i++) { %>
						<tr>		
							<td><%= aList.get(i).getEmpId() %></td>
							<td><%= aList.get(i).getEmpName() %></td>
							<td><%= aList.get(i).getLgName() %></td>
							<td><%= aList.get(i).getBatchName() %></td>
							<td><%= aList.get(i).getProject() %></td>
							<td>
								<a href="<%=request.getContextPath()%>/viewDetails.action?empId=<%= aList.get(i).getEmpId() %>"><%= count.get(i) %></a>
							</td>
						</tr>
					<% } %>
				</tbody>
			</table>
<% } %>
</body>
</html>