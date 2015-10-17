<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
<jsp:include page="WEB-INF/css/signin.css"/>
<jsp:include page="WEB-INF/css/BasicTemplate.css"/>
<%@include file="WEB-INF/pages/template/header.jsp" %>
<%@include file="WEB-INF/pages/template/body3.jsp" %>
<script  type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script  type="text/javascript" src="js/validation.js"></script>


<body>
	<div >
	<form method="post" action="./createuser">
		<div id="userdetails">
            <div id="userdiv">
            <span>Please Fill Up The  Form</span><br/>
                <label>Username</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="inputbox" name="username" id="uname"/>
                <label>Password</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="password" class="inputbox" name="password" id="pass"/><br/>
                <label>Confirm Password</label>
               
                <input type="password" class="inputbox" name=cfmpassword"/><br/>
              </div>
            <div id="userlowdiv">
                <input type="submit" id="#createuser" class="button" value="Create" id="cmnpass">
                </div>
            </div>
	</form>
</div>

<%@include file="WEB-INF/pages/template/footer.jsp" %>