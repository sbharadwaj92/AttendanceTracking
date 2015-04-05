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
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.js"></script>
<script>
$(document).ready(function () {
    $("#form").submit(function () {
        $(".submitBtn").attr("disabled", true);
        return true;
    });
});
</script>
<sj:head />
<style>
</style>
</head>
<body>
<s:url var="home" action="index"></s:url>
<s:a href="%{#home}">HOME</s:a><br><br>

    <s:form id="form" action="getRecords" theme="simple">
      <sj:datepicker name="date1" displayFormat="dd-mm-yy" label="Select a Date" required="true"/>
		<s:submit value="Submit" cssClass="btn btn-primary submitBtn"/>
    </s:form>
    

</body>
</html>