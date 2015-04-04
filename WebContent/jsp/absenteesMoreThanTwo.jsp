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

	<s:if test="%{getAbList()!=null}">
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
				<s:iterator value="%{getAbList()}">
					<tr>		
						<td><s:property value="empId"/></td>
						<td><s:property value="empName"/></td>
						<td><s:property value="lgName"/></td>
						<td><s:property value="batchName"/></td>
						<td><s:property value="project"/></td>
						<td>
							<s:url var="view" action="viewDetails">
								<s:param name="empId" value="empId"></s:param>
							</s:url> <s:a href="%{#view}" label="Update"><s:property value="count"/></s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:if>
</body>
</html>


