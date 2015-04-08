<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		</div>
	</div>
<% String result = (String) request.getAttribute("result"); %>
	<div class="panel panel-default" style="width: 400px; margin: 0 auto; margin-top: 3.1%;">
	  <div class="panel-heading">
    	<h3 class="panel-title">Change Password</h3>
  	  </div>
	  <div class="panel-body" ng-app="validationApp" ng-controller="mainController">
	  
	  
	  
    <s:form id="form" name="userForm" ng-submit="submitForm()" action="changePwd" theme="simple">
        <div class="form-group" ng-class="{ 'has-error' : userForm.password1.$invalid && !userForm.password1.$pristine }">
            <label>Current Password</label>
            <s:password name="password1" cssClass="form-control" ng-model="user.password1" required="true"></s:password>
            <p ng-show="userForm.password1.$error.required  && !userForm.password1.$pristine" class="help-block">Current Password cannot be blank.</p>
        </div>
        <div class="form-group" ng-class="{ 'has-error' : userForm.password2.$invalid && !userForm.password2.$pristine }">
            <label>New Password</label>
            <s:password name="password2" id="pw2" cssClass="form-control" ng-model="user.password2" required="true"></s:password>
            <p ng-show="userForm.password2.$error.required  && !userForm.password2.$pristine" class="help-block">New Password cannot be blank.</p>
        </div>
        <div class="form-group" ng-class="{ 'has-error' : userForm.password3.$invalid && !userForm.password3.$pristine }">
            <label>Confirm New Password</label>
            <s:password name="password3" cssClass="form-control" ng-model="user.password3" pw-check="pw2" required="true"></s:password>
            <p ng-show="userForm.password3.$error.required  && !userForm.password3.$pristine" class="help-block">Confirm New Password cannot be blank.</p>
        </div>
        <s:submit value="Submit" cssClass="btn btn-primary submitBtn" ng-disabled="userForm.$invalid"></s:submit>
    </s:form>
		
		
	  </div>
	</div>
		<div id="footer" style="margin-top:3.6%;">
		<p>&copy; 2015. All rights reserved. Developed by ILP Trivandrum</p>
	</div>


</body>
</html>