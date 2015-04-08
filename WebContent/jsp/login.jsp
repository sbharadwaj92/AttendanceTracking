<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tcs.ilp.bean.User" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/font.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/default.css">
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/angular.js"></script>
<script src="<%= request.getContextPath() %>/js/custangular.js"></script>
<title>Insert title here</title>
<script>
$(document).ready(function () {
	 $("#form").submit(function () {
	    $(".submitBtn").attr("disabled", true);
	    $(".submitBtn").attr("value","Logging in...")
	    return true;
	 });
	$('#perror').delay(3000).fadeOut('slow');
});
</script>
</head>
<body>
<%

response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setHeader("Cache-Control","must-revalidate");
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility

if(session.getAttribute("empId")!=null){
response.sendRedirect(request.getContextPath()+"/jsp/home.jsp");
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
		</div>
	</div>
<% String result = (String) request.getAttribute("result"); %>
	<div class="panel panel-default" style="width: 400px; margin: 0 auto; margin-top: 3.1%;">
	  <div class="panel-heading">
    	<h3 class="panel-title">Login</h3>
  	  </div>
	  <div class="panel-body" ng-app="validationApp" ng-controller="mainController">
	  
	  
	  
    <s:form id="form" name="userForm" ng-submit="submitForm()" action="login" theme="simple">
	 	<div class="form-group" ng-class="{ 'has-error' : userForm.empId.$invalid && !userForm.empId.$pristine }">
	    	<label>Employee ID</label>
	    	<s:textfield type="number" name="empId" cssClass="form-control" ng-model="user.empId" ng-minlength="6" ng-maxlength="8" autocomplete="off" required="true"></s:textfield>
	    	<p ng-show="userForm.empId.$error.required && !userForm.empId.$pristine" class="help-block">Employee ID cannot be blank.</p>
	    	<p ng-show="userForm.empId.$error.number && !userForm.empId.$pristine" class="help-block">Invalid Employee ID.</p>
	    	<p ng-show="!userForm.empId.$error.number && userForm.empId.$error.minlength" class="help-block">Employee ID is too short.</p>
	    	<p ng-show="!userForm.empId.$error.number && userForm.empId.$error.maxlength" class="help-block">Employee ID is too long.</p>
		</div>
        <div class="form-group" ng-class="{ 'has-error' : userForm.password.$invalid && !userForm.password.$pristine }">
            <label>Password</label>
            <s:password name="password" cssClass="form-control" ng-model="user.password" required="true"></s:password>
            <p ng-show="userForm.password.$error.required  && !userForm.password.$pristine" class="help-block">Password cannot be blank.</p>
            <% if(result!=null) { %><p id="perror" style="color:#a94442;"><%= result %></p><% } %>
        </div>
        <s:submit value="Login" cssClass="btn btn-primary submitBtn" ng-disabled="userForm.$invalid"></s:submit>
    </s:form>
		
		
	  </div>
	</div>
		<div id="footer" style="margin-top:3.6%;">
		<p>&copy; 2015. All rights reserved. Developed by ILP Trivandrum</p>
	</div>
</body>
</html>