<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Date , java.text.SimpleDateFormat" %>
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
<s:url var="home" action="index"></s:url>
<s:a href="%{#home}">HOME</s:a><br><br>

    <s:form id="form" theme="simple" action="getTailgaters">
      <sj:datepicker id="date0" name="date1" displayFormat="dd-mm-yy" label="Select a Date" />
		<s:submit value="submit" name="submit" />
    </s:form>
        
    <s:if test="%{getaList()!=null}">
        <% Date date = (Date) request.getAttribute("date"); 
       SimpleDateFormat sd = new SimpleDateFormat ("dd-MMM-yyyy");	%>
    		<table border="1">
				<thead>
					<tr>
						<th>EMP ID</th>
						<th>EMP NAME</th>
						<th>DATE</th>
						<th>LG NAME</th>
						<th>BATCH NAME</th>
						<th>PROJECT</th>
						<th>LOCATION</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="%{getaList()}">
					<tr>
						<td><s:property value="empId" /></td>
						<td><s:property value="empName" /></td>
						<td><%= sd.format(date) %></td>
						<td><s:property value="batchName" /></td>
						<td><s:property value="batchName" /></td>
						<td><s:property value="project" /></td>
						<td><s:property value="location" /></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:if>
</body>
</html>